package FuncionesYDatosModificados;
 
import java.sql.Date;

public class DVenta1 {
    
    private int Id_Venta;
    private int Id_UsuarioFK;
    private int Id_ClienteFK;
    private Date Fecha_Venta ;
    private String Tipo_Comprobante;
    private String Factura;
    private String Tipo_Pago;
    private float Tipo_Cambio;
    private long Total_Venta ;
   
    public DVenta1() {
       
    }

    public DVenta1(int Id_Venta, int Id_UsuarioFK, int Id_ClienteFK, Date Fecha_Venta, String Tipo_Comprobante, String Factura, String Tipo_Pago, float Tipo_Cambio, long Total_Venta) {
        this.Id_Venta = Id_Venta;
        this.Id_UsuarioFK = Id_UsuarioFK;
        this.Id_ClienteFK = Id_ClienteFK;
        this.Fecha_Venta = Fecha_Venta;
        this.Tipo_Comprobante = Tipo_Comprobante;
        this.Factura = Factura;
        this.Tipo_Pago = Tipo_Pago;
        this.Tipo_Cambio = Tipo_Cambio;
        this.Total_Venta = Total_Venta;
    }

    public int getId_Venta() {
        return Id_Venta;
    }

    public void setId_Venta(int Id_Venta) {
        this.Id_Venta = Id_Venta;
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

    public Date getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(Date Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public String getTipo_Comprobante() {
        return Tipo_Comprobante;
    }

    public void setTipo_Comprobante(String Tipo_Comprobante) {
        this.Tipo_Comprobante = Tipo_Comprobante;
    }

    public String getFactura() {
        return Factura;
    }

    public void setFactura(String Factura) {
        this.Factura = Factura;
    }

    public String getTipo_Pago() {
        return Tipo_Pago;
    }

    public void setTipo_Pago(String Tipo_Pago) {
        this.Tipo_Pago = Tipo_Pago;
    }

    public float getTipo_Cambio() {
        return Tipo_Cambio;
    }

    public void setTipo_Cambio(float Tipo_Cambio) {
        this.Tipo_Cambio = Tipo_Cambio;
    }

    public long getTotal_Venta() {
        return Total_Venta;
    }

    public void setTotal_Venta(long Total_Venta) {
        this.Total_Venta = Total_Venta;
    }
}