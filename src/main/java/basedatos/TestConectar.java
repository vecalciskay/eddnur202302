package basedatos;

import java.sql.*;

public class TestConectar {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Paso 1. Cargo el driver ");
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.exit(0);
        }

        Connection conn = null;
        try {
            String server = "localhost";
            int port = 0;
            String database = "empresa";
            String user  = "root";
            String password = "root";

            String stringDeConexion = "jdbc:mysql://" + server;
            if (port != 0) {
                stringDeConexion += ":" + port;
            }
            stringDeConexion += "/" + database +
                    "?user=" + user + "&password=" + password;
            conn = DriverManager.getConnection(stringDeConexion);

            System.out.println("Paso 2. Conexion ok");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            System.exit(0);
        }

        String query = "SELECT * FROM empleados";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Paso 3. Consulta ejecutada");
            while (rs.next()) {
                Integer ci_id = rs.getInt("ci_id");
                String nombre = rs.getString("snombre");
                String apellido = rs.getString("sappaterno");
                Double salario = rs.getDouble("nsalario");
                /*System.out.println("ciId:" + ci_id);
                System.out.println("nombre:" + nombre);
                System.out.println("apellido:" + apellido);
                System.out.println("salario:" + salario);
                System.out.println("");*/

                Empleado emp = new Empleado(ci_id, nombre, apellido, salario);
                System.out.println(emp);
            }
            rs.close();

            conn.close();
            System.out.println("Paso 4. Cierra conexion");
        } catch(Exception ex) {

        }
    }
}
