package dao.capaDao;

import basedatos.Empleado;
import dao.conexion.ConexionMysql;
import listas.ListaDoble;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta es una clase DAO que se encarga de la capa de acceso a datos de la tabla
 * personas y transforma cada tupla a la clase Empleado. Es parte de la
 * implementación del patrón DAO.
 */
public class EmpleadoDaoMysql implements EmpleadoDao {
    private ConexionMysql conexion;
    public EmpleadoDaoMysql() {
        conexion = ConexionMysql.getInstance();
    }

    public void insertar(Empleado empleado) {
        conexion.abrirConexion();
        String query = "INSERT INTO personas (id, nombre, altura) VALUES (" +
                empleado.getCi_id() + ", '" +
                empleado.getNombre() + "', '" +
                empleado.getApellido() + "', " +
                empleado.getSalario() + ")";
        conexion.ejecutarUpdate(query);
    }

    public void update(Empleado obj) {
        conexion.abrirConexion();
        String query = "UPDATE personas SET " +
                "nombre = '" + obj.getNombre() + "', " +
                "altura = " + obj.getSalario() + " " +
                "WHERE id = " + obj.getCi_id();
        conexion.ejecutarUpdate(query);
    }

    public Empleado get(int id) {
        conexion.abrirConexion();
        String query = "SELECT * FROM personas WHERE id = " + id;
        Empleado empleado = null;
        try {
            ResultSet rs = conexion.ejecutarConsulta(query);
            if (rs.next()) {
                Integer ci_id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Double salario = rs.getDouble("altura");
                empleado = new Empleado(ci_id, nombre, "", salario);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
        return empleado;
    }

    public ListaDoble<Empleado> get() {
        conexion.abrirConexion();
        String query = "SELECT * FROM personas";
        ListaDoble<Empleado> empleados = new ListaDoble<>();
        try {
            ResultSet rs = conexion.ejecutarConsulta(query);
            while (rs.next()) {
                Integer ci_id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Double salario = rs.getDouble("altura");
                Empleado emp = new Empleado(ci_id, nombre, "", salario);
                empleados.insertar(emp);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
        return empleados;
    }
}
