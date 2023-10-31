package archivos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeerArchivo {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\Vladimir\\ejemplo.txt");
        BufferedReader entrada =
                new BufferedReader(new FileReader(f));

        String linea = entrada.readLine();
/*
        Path p = Paths.get("E:\\Vladimir\\ejemplo.txt");
        List<String> lineas = Files.readAllLines(p);
        */

        System.out.println(linea);
    }
}
