package ConexionesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public String db = "Inventario_ERM";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = null;

    public Conexion() {
        
    }

    public Connection conectar() {
        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }
}

/*
    public String Inventario; // = "Inventario_ERM";
    public String url; // = "jdbc:mysql://127.0.0.1/" + db;
    public String user; // = "root";
    public String pass; // = "root";

    public Conexion() {
        Inventario = "Inventario_ERM";
        user = "root";
        pass = null;
        url = "jdbc:mysql://localhost/" + Inventario;        
    }

    public Connection conectar() {
        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return link;
    }
}*/