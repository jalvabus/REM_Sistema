package Datos;
 
import java.sql.Date;

public class DVenta {

    private int Id_Venta;
    private Date Fecha_Venta ;
    private long Total_Venta ;
    private int Id_UsuarioFK;
    private int Id_ClienteFK;
    private String Tipo_Comprobante;
    private long No_Factura;
    private long Pago;
    private int Descuento;
    
    public DVenta() {
       
    }

    public DVenta(int Id_Venta, Date Fecha_Venta, long Total_Venta, int Id_UsuarioFK, int Id_ClienteFK, String Tipo_Comprobante, long No_Factura, long Pago, int Descuento) {
        this.Id_Venta = Id_Venta;
        this.Fecha_Venta = Fecha_Venta;
        this.Total_Venta = Total_Venta;
        this.Id_UsuarioFK = Id_UsuarioFK;
        this.Id_ClienteFK = Id_ClienteFK;
        this.Tipo_Comprobante = Tipo_Comprobante;
        this.No_Factura = No_Factura;
        this.Pago = Pago;
        this.Descuento = Descuento;
    }

    public int getId_Venta() {
        return Id_Venta;
    }

    public void setId_Venta(int Id_Venta) {
        this.Id_Venta = Id_Venta;
    }

    public Date getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(Date Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public long getTotal_Venta() {
        return Total_Venta;
    }

    public void setTotal_Venta(long Total_Venta) {
        this.Total_Venta = Total_Venta;
    }

    public int getId_UsuarioFK() {
        return Id_UsuarioFK;
    }

    public void setId_UsuarioFK(int Id_UsuarioFK) {
        this.Id_UsuarioFK = Id_UsuarioFK;
    }

    public int getId_ClienteFK() {
        return Id_ClienteFK;
    }

    public void setId_ClienteFK(int Id_ClienteFK) {
        this.Id_ClienteFK = Id_ClienteFK;
    }

    public String getTipo_Comprobante() {
        return Tipo_Comprobante;
    }

    public void setTipo_Comprobante(String Tipo_Comprobante) {
        this.Tipo_Comprobante = Tipo_Comprobante;
    }

    public long getNo_Factura() {
        return No_Factura;
    }

    public void setNo_Factura(long No_Factura) {
        this.No_Factura = No_Factura;
    }

    public long getPago() {
        return Pago;
    }

    public void setPago(long Pago) {
        this.Pago = Pago;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }    
}