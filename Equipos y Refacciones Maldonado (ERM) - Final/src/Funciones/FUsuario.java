package Funciones;

import Frames.FrmCliente;
import Frames.FrmUsuario;
import Datos.DUsuario;
import ConexionesBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FUsuario {

    private Conexion mysql = new Conexion(); //Instanciando la clase Conexion
    private Connection cn = mysql.conectar();
    private String SQL = ""; //Sentencia SQL    
    public Integer totalRegistros; // Obtener los registros

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"Id_Usuario", "Nombre",
            "Usuario", "Contraseña", "Telefono","Estado", "Tipo"};
        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        SQL = "SELECT Id_Usuario, Nombre, Usuario, Contrasenia, "
                + "Telefono , Estado, Tipo FROM "
                + "Usuario WHERE Nombre LIKE '%" + buscar + "%' ORDER BY Id_Usuario DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registros[0] = rs.getString("Id_Usuario");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Usuario");
                registros[3] = rs.getString("Contrasenia");
                registros[4] = rs.getString("Telefono");
                registros[5] = rs.getString("Estado");
                registros[6] = rs.getString("Tipo");                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    /**
     * *Cierre Funcion Mostrar**
     */
    
    /**
     * Cierre Funcion Mostrar
     *
     * @param datos
     */
    
    public boolean insertar(DUsuario datos) {

        SQL = "INSERT INTO Usuario (Id_Usuario,Nombre,Usuario,Contrasenia,Telefono,Estado,Tipo)"
                + " VALUES (null,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);            

            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getUsuario());
            pst.setString(3, datos.getContraseña());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getEstado());
            pst.setString(6, datos.getTipo());            

            int N = pst.executeUpdate();            

            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//Cierre Función Insertar


    public boolean editar(DUsuario datos) {

        SQL = "UPDATE Usuario SET Nombre = ?,Usuario = ?,"
                + "Contrasenia = ?,Telefono = ?,Estado = ?,Tipo = ? WHERE Id_Usuario = ? ";
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);            

            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getUsuario());
            pst.setString(3, datos.getContraseña());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getEstado());
            pst.setString(6, datos.getTipo()); 
            pst.setInt(7, datos.getId_Usuario());
            
            int N = pst.executeUpdate();            

            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//Cierre Función Editar


    public boolean eliminar(DUsuario datos) {

        SQL = "DELETE FROM Usuario WHERE Id_Usuario = ?";        
        try {
            PreparedStatement pst = cn.prepareStatement(SQL);            

            pst.setInt(1, datos.getId_Usuario());            

            int N = pst.executeUpdate();            

            if (N != 0 ) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    } //Cierre Función Eliminar

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"Id_Usuario", "Nombre",
            "Usuario", "Contraseña", "Telefono","Estado", "Tipo"};
        String[] registro = new String[7];      

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        SQL = "SELECT Id_Usuario , Nombre , Usuario ,"
                + "Contrasenia , Telefono , Estado , Tipo FROM Usuario "
                + "WHERE Usuario ='" + login + "' "
                + " AND Contrasenia ='" + password + "' AND Estado = 'Activo'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registro[0] = rs.getString("Id_Usuario");
                registro[1] = rs.getString("Nombre");
                registro[2] = rs.getString("Usuario");
                registro[3] = rs.getString("Contrasenia");
                registro[4] = rs.getString("Telefono");
                registro[5] = rs.getString("Estado");
                registro[6] = rs.getString("Tipo");                

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public int contarUsuarios() {

        SQL = "SELECT COUNT(*)AS cantidadUsuarios FROM Usuario";

        try {
            int codigo_venta = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                codigo_venta = rs.getInt("cantidadUsuarios");
            }
            return codigo_venta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public int verificarLogin() {
        String login = FrmUsuario.txtLogin.getText();
        SQL = "SELECT COUNT(Usuario) AS Usuario FROM Usuario WHERE Usuario = " + login;

        try {
            int loginResultante = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                loginResultante = rs.getInt("Usuario");
            }
            return loginResultante;
        } catch (Exception e) {
            return 0;
        }
    }
}