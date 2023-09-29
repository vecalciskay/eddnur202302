package redes.servidorweb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorWebSimple {
    private final int puerto;

    public ServidorWebSimple(int puerto) {
        this.puerto = puerto;
    }

    public static void main(String[] args) {
        ServidorWebSimple servidor = new ServidorWebSimple(8080);
        servidor.start();
    }

    /**
     * En este metodo se abre un socketserver en el puerto indicado
     * y se espera una conexion. Una vez que se da la conexion se llama
     * a otra clase pasandole esta conexion para que se haga carga de la
     * petición y se devuelva la respuesta.
     */
    private void start() {
        ServerSocket socketServer = null;
        try {
            socketServer = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto " + puerto);
            while (true) {
                // Se espera una conexion
                Socket clt = socketServer.accept();
                // Se crea un objeto de la clase que se encarga de procesar la peticion
                ProcesadorPeticion procesadorPeticion = new ProcesadorPeticion(clt);
                // Se procesa la peticion
                procesadorPeticion.procesarPeticion();
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            try {
                socketServer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
