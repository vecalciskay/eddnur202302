package redes.servidorweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redes.servidorweb.sesiones.ListaDeSesiones;
import redes.servidorweb.sesiones.Sesion;

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesadorPeticion {
    private static final Logger logger = LogManager.getLogger(ProcesadorPeticion.class);
    public static final String CRLF = "\r\n";
    private final Socket client;

    public ProcesadorPeticion(Socket client) {
        this.client = client;
    }

    public void procesarPeticion() {
        Thread thread = new Thread(() -> {
            try {
                // Se crea un objeto de la clase que se encarga de procesar la peticion
                procesarPeticionThread();
            } catch (Exception e) {
                logger.error("Error en el servidor: {}",e.getMessage());
            }
        });

        thread.start();
    }

    private void procesarPeticionThread() {
        logger.info("Comienza a atender la peticion web");

        BufferedReader bufIn;
        DataOutputStream bufOut;

        try {
            bufIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufOut = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            logger.error("No se pudo crear el socket con el cliente", e);
            return;
        }

        try {
            String line = bufIn.readLine();
            if (line == null) {
                logger.warn("Hizo un readline pero no obtuvo nada, sale del procesador");
                return;
            }
            logger.info("<--- {}", line);
            while (bufIn.ready()) {
                String otrasLineas = bufIn.readLine();
                logger.info("<--- {}", otrasLineas);
            }
            logger.info("Del cliente se leyó la linea del protocolo Http: {}", line);
            String regexGet = "^GET\\s\\/([a-z0-9]+)\\/([a-z0-9-]+).+$";
            Pattern pattern = Pattern.compile(regexGet);
            Matcher matcher = pattern.matcher(line);

            if (!matcher.find()) {
                logger.warn("No es un comando GET, entonces no se procesa");
                return;
            }
            String cmdGet = matcher.group(1);
            String cmdArgumentos = matcher.group(2);

            ComandoServidorWeb cmd = null;
            if (cmdGet.startsWith("s")) {
                String idsesion = cmdGet;
                Sesion buscarSesionId = new Sesion(idsesion);
                ListaDeSesiones sesiones = ListaDeSesiones.obtenerInstancia();
                Sesion objSesion = sesiones.getSesiones().buscar(buscarSesionId);
                if (objSesion == null) {
                    objSesion = sesiones.crearSesion(idsesion);
                }

                cmd = BuilderComandoServidorWeb.crear(objSesion, cmdArgumentos);
                cmd.ejecutar();

                objSesion.insertarComando(cmd);
            }
            else {
                cmd = BuilderComandoServidorWeb.crear(cmdGet);
                cmd.ejecutar();
            }


            if (cmd.esResultadoTexto()) {
                enviarTexto(cmd.getResultadoTexto(), bufOut);
            } else {
                enviarArchivo(cmd.getResultadoImagen(), bufOut);
            }

        } catch (Exception e) {
            logger.error("No se pudo crear la respuesta para el cliente", e);
        } finally {

            try {
                bufOut.flush();
                bufOut.close();
                bufIn.close();
                client.close();
            } catch (Exception q) {
                logger.error("No se pudo cerrar los sockets", q);
            }
        }
    }

    private void enviarArchivo(byte[] resultadoImagen, DataOutputStream out) {
        try {
            String statusLine = "HTTP/1.1 200 OK";
            String contentType = "Content-Type: image/png";

            logger.info("---> {}", statusLine);
            logger.info("---> {}", contentType);

            out.writeBytes(statusLine);
            out.writeBytes(CRLF);
            out.writeBytes(contentType);
            out.writeBytes(CRLF);

            // Empieza el archivo aca
            out.writeBytes(CRLF);

            ByteArrayInputStream fis = new ByteArrayInputStream(resultadoImagen);
            byte[] buffer = new byte[4096];
            int bytes;
            while((bytes = fis.read(buffer)) != -1) {
                out.write(buffer,0, bytes);
                logger.info("---> Se envían {} bytes", bytes);
            }
            logger.info("---> Se envio todo");
            fis.close();

        } catch (Exception e) {
            logger.error("No se pudo enviar: {}", e.getMessage());
        }
    }

    private void enviarTexto(String resultadoTexto, DataOutputStream out) {
        PrintWriter bufOut = new PrintWriter(out);
        bufOut.println("HTTP/1.1 200 OK");
        bufOut.println();
        bufOut.println(resultadoTexto);
        bufOut.flush();
        bufOut.close();
    }
}
