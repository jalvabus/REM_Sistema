package Funciones;

import ConexionesBD.Conexion;
import Datos.DAlmacen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FAlmacen {

    private Conexion mysql = new Conexion(); //Instanciando la clase conexion
    private Connection cn = mysql.conectar();
    private String sSQL = ""; //Sentencia SQL
    public Integer totalRegistros; // Obtener los registros
 
    
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Código", "Nombre","Descripción"};

        String[] registros = new String[3];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM Almacen WHERE Nombre_Almacen LIKE '%" + buscar + "%' ORDER BY Cod_Almacen DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);         

            while (rs.next()) {
                registros[0] = rs.getString("Cod_Almacen");
                registros[1] = rs.getString("Nombre_Almacen");
                registros[2] = rs.getString("Descripcion");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }            
            cn.close();
            return modelo;             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertar(DAlmacen datos) {
        sSQL = "INSERT INTO Almacen (Nombre_Almacen,Descripcion) VALUES (?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getNombre_Almacen());
            pst.setString(2, datos.getDescripcion());

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
    }/*CIERRE FUNCION INSERTAR*/

    public boolean editar(DAlmacen datos) {
        sSQL = "UPDATE Almacen SET Nombre_Almacen = ?,Descripcion = ? WHERE Cod_Almacen = ? ";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
           
            pst.setString(1, datos.getNombre_Almacen());
            pst.setString(2, datos.getDescripcion());
            pst.setInt(3, datos.getCod_Almacen());

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
    }/*CIERRE FUNCION EDITAR*/

    public boolean eliminar(DAlmacen datos) {
        sSQL = "DELETE FROM Almacen WHERE Cod_Almacen = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, datos.getCod_Almacen());
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
    }     
}