package dao.capaDao;

import basedatos.Empleado;
import dao.conexion.ConexionArchivo;
import listas.ListaDoble;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmpleadoDaoArchivo implements EmpleadoDao {
    @Override
    public ListaDoble<Empleado> get() {
        ConexionArchivo conexion = new ConexionArchivo("Empleado");
        Path p = conexion.getPathArchivo();
        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lineas == null)
            return null;

        ListaDoble<Empleado> empleados = new ListaDoble<>();
        for (String linea : lineas) {
            String[] datos = linea.split(";");
            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            double sueldo = Double.parseDouble(datos[2]);
            Empleado o = new Empleado(id, nombre,"", sueldo);
            empleados.insertar(o);
        }

        return empleados;
    }

    @Override
    public Empleado get(int id) {
        return null;
    }

    @Override
    public void update(Empleado o) {

    }

    @Override
    public void insertar(Empleado o) {

    }
}
