package dao.conexion;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConexionArchivo {
    private String nombreArchivo;
    private String nombreDao;
    private final String ruta = "E:/work/Dropbox/Personal/Programming/javaprojects/eddnur202302/practicos/";

    public ConexionArchivo(String nombreDao) {
        this.nombreDao = nombreDao;
        this.nombreArchivo = "bd" + nombreDao + ".txt";
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }


    public Path getPathArchivo() {
        return Paths.get(ruta + nombreArchivo);
    }
}
