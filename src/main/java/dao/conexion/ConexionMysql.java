package dao.conexion;

import java.sql.*;

public class ConexionMysql {
    private final String server = "localhost";
    private final int port = 6603;
    private final String database = "edd";
    private final String user  = "root";
    private final String password = "krane345";
    private Connection conn;

    private static ConexionMysql instance = null;

    public static ConexionMysql getInstance() {
        if (instance == null) {
            instance = new ConexionMysql();
        }
        return instance;
    }

    private ConexionMysql() {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.exit(0);
        }*/
    }

    public void abrirConexion() {

        try {
            if (conn != null && !conn.isClosed()) {
                return;
            }
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
    }

    public ResultSet ejecutarConsulta(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Paso 3. Consulta ejecutada");
            return rs;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }

        return null;
    }

    public void cerrarConexion() {
        /*
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        */
    }

    public void ejecutarUpdate(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Consulta ejecutada");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
}
