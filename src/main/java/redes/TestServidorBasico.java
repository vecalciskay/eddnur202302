package redes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServidorBasico {
    public static void main(String[] args) throws Exception {
        ServerSocket srv =  new ServerSocket(7394);
        System.out.println("Listo para escuchar en puerto 7394");
        Socket clt = srv.accept();
        System.out.println("Alguien se conecto y ahora tenemos un socket de comunicaion");
        BufferedReader entrada =
                new BufferedReader(new InputStreamReader(clt.getInputStream()));
        System.out.println("Creo objeto de entrada con socket");
        PrintWriter salida =
                new PrintWriter(clt.getOutputStream());
        System.out.println("Creo objeto de salida con socket");
        String linea = entrada.readLine();
        while(!linea.equals("FIN")) {
            System.out.println("<<< " + linea);
            salida.println("OK");
            salida.flush();
            System.out.println(">>> OK");
            linea = entrada.readLine();
        }
        clt.close();
        srv.close();
        System.out.println("Cerrado todo y comunicacion concluida");
    }
}
