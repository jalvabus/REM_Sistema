package ConexionesBD;

import java.sql.*;

public class Conexion2 {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    // Constructor
    private Conexion2() {

        String url = "jdbc:mysql://127.0.0.1/Inventario_ERM";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "root";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    } // Fin constructor

    // Métodos
    public static Connection getConnection() {
        if (conn == null) {
            new Conexion2();
        }
        return conn;
    } // Fin getConnection
}