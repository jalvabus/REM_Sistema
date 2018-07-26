package FuncionesYDatosModificados;

import ConexionesBD.Conexion;
import FramesModificados.FrmMostrarVentas1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FVenta1 {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar() {

        DefaultTableModel modelo;

        String[] titulos = {"Número Venta",
            "Fecha ", "Total", "Id Usuario",
            "Usuario", "Id Cliente", "Cliente", "Comprobante", "Factura", "Descuento"};

        String[] registros = new String[10];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Id_Venta , Fecha_Venta , Replace(Format(Total_Venta, 0), ',', '.') AS Total_Venta  , Id_UsuarioFK,"
                + "(SELECT Nombre FROM Usuario WHERE Id_Usuario = Id_UsuarioFK)"
                + "AS usuarioNom,Id_ClienteFK ,"
                + "(SELECT Razon_Social FROM Cliente WHERE Id_Cliente = Id_ClienteFK)"
                + "AS clienteNom ,Tipo_Comprobante,No_Factura,Descuento FROM Venta ORDER BY Id_Venta DESC";
        
        /*sSQL2 = "SELECT Id_Venta, Fecha_Venta, Replace(Format(Total_Venta, 0), ',', '.') AS Total_Venta , Id_UsuarioFK,"
                + "(SELECT Nombre FROM Usuario WHERE Id_Usuario = Id_UsuarioFK)"
                + "AS usuarioNom,Id_ClienteFK,"
                + "(SELECT Razon_Social FROM Cliente WHERE Id_Cliente = Id_ClienteFK)"
                + "AS clienteNom ,Tipo_Comprobante,No_Factura,Descuento FROM Venta ORDER BY Id_Venta DESC";*/

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                
                registros[0] = rs.getString("Id_Venta");
                registros[1] = rs.getString("Id_UsuarioFK");
                registros[4] = rs.getString("usuarioNom");
                registros[2] = rs.getString("Id_ClienteFK");
                registros[3] = rs.getString("Fecha_Venta");
                registros[4] = rs.getString("Tipo_Comprobante");
                registros[5] = rs.getString("Factura");
                registros[6] = rs.getString("Tipo_Pago");
                registros[7] = rs.getString("Tipo_Cambio");
                registros[8] = rs.getString("Total_Venta");                
                
                /*registros[0] = rs.getString("Id_Venta");
                registros[1] = rs.getString("Fecha_Venta");
                registros[2] = rs.getString("Total_Venta");
                registros[3] = rs.getString("Id_UsuarioFK");
                registros[4] = rs.getString("usuarioNom");
                registros[5] = rs.getString("Id_ClienteFK");
                registros[6] = rs.getString("clienteNom");
                registros[7] = rs.getString("Tipo_Comprobante");
                registros[8] = rs.getString("No_Factura");
                registros[9] = rs.getString("Descuento");*/
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(DVenta1 datos) {

        sSQL = "INSERT INTO Venta "
                + "(Fecha_Venta,Total_Venta,Id_UsuarioFK,Id_ClienteFK,Tipo_Comprobante,Factura,Tipo_Pago,Tipo_Cambio)"
                + "values(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setDate(1, datos.getFecha_Venta());
            pst.setLong(2, datos.getTotal_Venta());
            pst.setInt(3, datos.getId_UsuarioFK());
            pst.setInt(4, datos.getId_ClienteFK());
            pst.setString(5, datos.getTipo_Comprobante());
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

    public boolean editar(DVenta1 datos) {
        sSQL = "UPDATE Venta SET Fecha_Venta = ?, "
                + "Total_Venta = ? , Id_UsuarioFK = ?  , Id_ClienteFK = ? ,"
                + " Tipo_Comprobante =?,No_Factura=? , Descuento=? WHERE Id_Venta = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setDate(1, datos.getFecha_Venta());
            pst.setLong(2, datos.getTotal_Venta());
            pst.setInt(3, datos.getId_UsuarioFK());
            pst.setInt(4, datos.getId_ClienteFK());
            pst.setString(5, datos.getTipo_Comprobante());

            
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

    public boolean eliminar(DVenta1 datos) {
        sSQL = "DELETE FROM Venta WHERE Id_Venta = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getId_Venta());
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
    
      public boolean RestaurarProd(DVenta1 datos) {
          
        int codigo = Integer.parseInt(FrmMostrarVentas1.txtCod_venta.getText());
        
    /*******AL ELIMINAR UNA VENTA VUELVEN LOS PRODUCTOS AL STOCK ANTERIOR***********/
        
        sSQL2 = "SELECT Cod_ProductoFK,sum(Cantidad_Detalle) AS Cantidad_Detalle1,"
                + "(SELECT Existencia FROM Producto WHERE Cod_Producto = Cod_ProductoFK) "
                + "AS Existencia FROM Detalle_Venta WHERE Id_VentaFK =" + codigo + " GROUP"
                + "BY Cod_ProductoFK";
        try {
            String codigo_producto;
            int cantidad_detalle = 0;
            int stock = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL2);
            while (rs.next()) {
                codigo_producto = rs.getString("Cod_ProductoFK");
                cantidad_detalle = rs.getInt("Cantidad_Detalle1");
                stock = rs.getInt("Existencia");

               stock = stock + cantidad_detalle;
                
                DProducto1 datos2 = new DProducto1();
                FProducto1 funcion2 = new FProducto1();
                
                datos2.setCod_Producto(codigo_producto);
                datos2.setExistencia(stock);
                funcion2.ModificarStockProductos(datos2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        /**************** TERMINO FUNCIÓN DE VOLVER PRODUCTOS *****************/
        
        sSQL = "DELETE FROM Venta WHERE Id_Venta = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, datos.getId_Venta());
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
      
    /************************* FUNCIONES ADICIONALES **************************/
      
    public DefaultTableModel Buscar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"Número Venta",
            "Fecha ", "Total", "Id Usuario",
            "Usuario", "Id Cliente", "Cliente", "Comprobante", "Factura", "Descuento"};

        String[] registros = new String[10];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Id_Venta , Fecha_Venta , Replace(Format(Total_Venta, 0), ',', '.') AS Total_Venta  ,"
                + "Id_UsuarioFK, (SELECT Nombre FROM Persona "
                + "WHERE Id_Usuario = Id_UsuarioFK) AS usuarioNom,"
                + "Id_ClienteFK , (SELECT  Razon_Social FROM Cliente"
                + "WHERE Id_Cliente = Id_ClienteFK) AS clienteNom ,Tipo_Comprobante,No_Factura,Descuento FROM Venta WHERE"
                + " (SELECT Razon_Social FROM Cliente WHERTE Id_Cliente = Id_ClienteFK)"
                + " LIKE '%" + buscar + "%' AND Id_UsuarioFK = "
                + "(SELECT Id_Usuario FROM Usuario WHERE Id_Usuario = Id_UsuarioFK )"
                + " ORDER BY Id_Venta DESC ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Id_Venta");
                registros[1] = rs.getString("Fecha_Venta");
                registros[2] = rs.getString("Total_Venta");
                registros[3] = rs.getString("Id_UsuarioFK");
                registros[4] = rs.getString("usuarioNom");
                registros[5] = rs.getString("Id_ClienteFK");
                registros[6] = rs.getString("clienteNom");
                registros[7] = rs.getString("Tipo_Comprobante");
                registros[8] = rs.getString("No_Factura");
                registros[9] = rs.getString("Descuento");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public int BuscarCodigoVenta() {

        sSQL = "SELECT Id_Venta FROM Venta ORDER BY Id_Venta DESC LIMIT 1 ";

        try {
            int codigo_venta = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                codigo_venta = rs.getInt("Id_Venta");
            }
            return codigo_venta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public boolean Total(DVenta1 datos) {

        sSQL = "UPDATE Venta SET Total_Venta = ? WHERE Id_Venta = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setLong(1, datos.getTotal_Venta());
            pst.setInt(2, datos.getId_Venta());

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

    public boolean Pago(DVenta1 datos) {

        sSQL = "UPDATE Venta SET Pago = ? WHERE Id_Venta = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(2, datos.getId_Venta());

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

    public int BuscarNfacturas() {

        sSQL = "SELECT COUNT(*) as Nfactura FROM Venta WHERE Tipo_Comprobante ='Factura'";

        try {
            int Nfactura = 0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                Nfactura = rs.getInt("Nfactura");
            }
            return Nfactura;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
}