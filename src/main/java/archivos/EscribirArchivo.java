package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirArchivo {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\Vladimir\\ejemplo.txt");
        PrintWriter salida =
                new PrintWriter(new FileWriter(f));
        salida.println("Hola mundo!!!");
        salida.flush();

        salida.close();
        System.out.println("Archivo ejemplo.txt escrito");
    }
}
