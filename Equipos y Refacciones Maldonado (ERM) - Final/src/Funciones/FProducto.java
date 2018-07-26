package Funciones;

import ConexionesBD.Conexion;
import Datos.DProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FProducto {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Código", "Proveedor",
                    "Número Parte", "Descripción", "Precio Venta",
                    "Precio Compra", "Existencia",
                    "Ubicación"};

        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Cod_Producto,Proveedor,Nombre_Producto,Descripcion,Replace(Format(Precio_Venta, 0), ',', '.') As Precio_Venta , Replace(Format(Precio_Compra, 0), ',', '.') AS Precio_Compra ,Existencia,(SELECT Nombre_Almacen FROM Almacen WHERE Cod_Almacen = Cod_AlmacenFK) AS Nombre_Almacen FROM Producto WHERE Descripcion LIKE '%" + buscar + "%' ORDER BY Cod_Producto DESC";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Cod_Producto");
                registros[1] = rs.getString("Proveedor");                
                registros[2] = rs.getString("Nombre_Producto");
                registros[3] = rs.getString("Descripcion");
                registros[4] = rs.getString("Precio_Venta");
                registros[5] = rs.getString("Precio_Compra");
                registros[6] = rs.getString("Existencia");
                registros[7] = rs.getString("Nombre_Almacen");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(DProducto datos,String nombre) {

        sSQL = "INSERT INTO Producto (Cod_Producto,Proveedor"
                + ",Nombre_Producto,Descripcion,Precio_Venta,Precio_Compra,Existencia,Cod_AlmacenFK)"
                + " VALUES (?,?,?,?,?,?,?,"
                + "(SELECT Cod_Almacen FROM Almacen WHERE Nombre_Almacen LIKE '%" + nombre + "%'))";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getCod_Producto());
            pst.setString(2, datos.getProveedor());
            pst.setString(3, datos.getNombre_Producto());
            pst.setString(4, datos.getDescripcion());
            pst.setLong(5, datos.getPrecio_Venta());
            pst.setLong(6, datos.getPrecio_Compra());            
            pst.setInt(7, datos.getExistencia());           
            
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

    }//cierre funcion

    public boolean editar(DProducto datos, String nombre) {

        sSQL = "UPDATE Producto SET Proveedor = ?, Nombre_Producto = ?, Descripcion = ?  , Precio_Venta = ? , Precio_Compra = ? , Existencia = ? , Cod_AlmacenFK =(SELECT Cod_Almacen FROM Almacen WHERE Nombre_Almacen LIKE '%" + nombre + "%' LIMIT 1) WHERE Cod_Producto =? ";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getProveedor());
            pst.setString(2, datos.getNombre_Producto());
            pst.setString(3, datos.getDescripcion());
            pst.setLong(4, datos.getPrecio_Venta());
            pst.setLong(5, datos.getPrecio_Compra());            
            pst.setInt(6, datos.getExistencia());

            pst.setString(7, datos.getCod_Producto());

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

    }//cierre funcion

    public boolean eliminar(DProducto datos) {
        sSQL = "DELETE FROM Producto WHERE Cod_Producto = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, datos.getCod_Producto());
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

    }//cierre funcion

    /**
     * ***** FUNCION STOCK ****
     */
    public boolean ModificarStockProductos(DProducto datos) {

        sSQL = "UPDATE Producto SET Existencia = ? WHERE Cod_Producto = ?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getExistencia());

            pst.setString(2, datos.getCod_Producto());

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

    public long productoIgual(long codigo) {

        sSQL = "SELECT Cod_Producto FROM Producto WHERE Cod_Producto = " + codigo;

        try {
            long cod = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cod = rs.getLong("Cod_Producto");
            }
            return cod;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public DefaultTableModel mostrarExportar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Código", "Proveedor",
                    "Número Parte", "Descripción", "Precio Venta",
                    "Precio Compra", "Existencia"};

        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Cod_Producto , Proveedor , Nombre_Producto , Descripcion , Precio_Venta ,  Precio_Compra , Existencia FROM Producto WHERE Descripcion LIKE '%" + buscar + "%' ORDER BY Cod_Producto DESC";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Cod_Producto");
                registros[1] = rs.getString("Proveedor");                
                registros[2] = rs.getString("Nombre_Producto");
                registros[3] = rs.getString("Descripcion");
                registros[4] = rs.getString("Precio_Venta");
                registros[5] = rs.getString("Precio_Compra");
                registros[6] = rs.getString("Existencia");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public ArrayList<String> llenar_combo() {
        ArrayList<String> lista = new ArrayList<String>();
        sSQL = "SELECT Nombre_Almacen FROM Almacen";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("Nombre_Almacen"));              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
}