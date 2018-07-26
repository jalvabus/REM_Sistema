package FuncionesYDatosModificados;

import ConexionesBD.Conexion;
import FramesModificados.FrmVentaDetalle1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FDetalle_Venta1 {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";    
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String cod_venta) {

        DefaultTableModel modelo;
        String[] titulos
                = {"COD DETALLE", "Código Producto", "Nombre Producto ",
                    "Precio Venta", "Cantidad Vendida",
                    "ID VENTA", "Existencia", "Sub Total"};
        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Cod_Detalle ,Cod_ProductoFK,"
                + "(SELECT Nombre_Producto FROM Producto WHERE Cod_ProductoFK = Cod_Producto)AS productoNom, "
                + "Replace(Format(Precio_Venta, 0), ',', '.') AS Precio_Venta ,Cantidad_Detalle, Id_VentaFK ,"
                + "(SELECT Existencia FROM Producto WHERE Cod_ProductoFK=Cod_Producto)As "
                + "Existencia , Replace(Format(Subtotal, 0), ',', '.') AS Subtotal FROM Detalle_Venta WHERE Id_VentaFK = '" + cod_venta + "' ORDER BY Cod_Detalle ASC ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Cod_Detalle");
                registros[1] = rs.getString("Cod_ProductoFK");
                registros[2] = rs.getString("productoNom");
                registros[3] = rs.getString("Precio_Venta");
                registros[4] = rs.getString("Cantidad_Detalle");
                registros[5] = rs.getString("Id_VentaFK");
                registros[6] = rs.getString("Existencia");
                registros[7] = rs.getString("Subtotal");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DDetalle_Venta1 datos) {

        sSQL = "INSERT INTO Detalle_Venta (Cantidad_Detalle,Cod_ProductoFK,Id_VentaFk"
                + ",Precio_Venta,Subtotal,Factura,Tipo_Pago,Tipo_Cambio) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setLong(1, datos.getCantidad_Detalle());
            pst.setString(2, datos.getCod_ProductoFK());
            pst.setInt(3, datos.getId_VentaFK());
            pst.setLong(4, datos.getPrecio_Venta());
            pst.setLong(5, datos.getSubtotal());
            pst.setString(6, datos.getFactura());
            pst.setString(7, datos.getTipo_Pago());
            pst.setFloat(8, datos.getTipo_Cambio());


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

    public boolean eliminar(DDetalle_Venta1 datos) {

        sSQL = "DELETE FROM Detalle_Venta WHERE Cod_Detalle = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, datos.getCod_Detalle());
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

    public long selecProd() {
        
        String codigo = (FrmVentaDetalle1.txtCod_producto.getText());
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
    }//cierre funcion */

    public String SelectNombre() {
        String codigo = (FrmVentaDetalle1.txtCod_producto.getText());
        sSQL = "SELECT Nombre_Producto FROM Producto WHERE Cod_Producto = " + codigo;
        try {
            String nombre = "";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                nombre = rs.getString("Nombre_Producto");
            }
            return nombre;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }//cierre funcion */

    public int selecStock() {
        String codigo = (FrmVentaDetalle1.txtCod_producto.getText());
        sSQL = "SELECT Existencia FROM Producto WHERE Cod_Producto = " + codigo;
        try {
            int stock = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                stock = rs.getInt("Existencia");
            }
            return stock;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion */

    public long selectPrecio() {
        String codigo = (FrmVentaDetalle1.txtCod_producto.getText());
        sSQL = "SELECT Precio_Venta FROM Producto WHERE Cod_Producto = " + codigo;
        try {
            long precio_producto = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                precio_producto = rs.getLong("Precio_Venta");
            }
            return precio_producto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion

    public long selectPrecioCompra() {
        String codigo = (FrmVentaDetalle1.txtCod_producto.getText());
        sSQL = "SELECT Precio_Compra FROM Producto WHERE Cod_Producto = " + codigo;
        try {
            long precio_productoCompra = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                precio_productoCompra = rs.getLong("Precio_Compra");
            }
            return precio_productoCompra;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion

    public boolean insertarDetalle(DDetalle_Venta1 datos) {

        sSQL = "INSERT INTO Detalle_Venta (Cantidad_Detalle,Cod_ProductoFK,Precio_Venta,"
                + "Id_VentaFK ,Factura,Tipo_Pago,Tipo_Cambio,"
                + "Subtotal,SubPrecio_Compra,Precio_Compra) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setLong(1, datos.getCantidad_Detalle());
            pst.setString(2, datos.getCod_ProductoFK());
            pst.setLong(3, datos.getPrecio_Venta());
            pst.setInt(4, datos.getId_VentaFK());
            pst.setLong(5, datos.getSubtotal());
            
            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El código ingresado no existe en el registro del sistema.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion
}