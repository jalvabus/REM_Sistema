package FuncionesYDatosModificados;

public class DDetalle_Venta1 {
    
    private int Cod_Detalle;
    private long Cantidad_Detalle;
    private String Cod_ProductoFK ;
    private long Precio_Venta; 
    private int Id_VentaFK;
    private String Factura;
    private String Tipo_Pago;
    private float Tipo_Cambio;
    private long Subtotal;    
    
    public DDetalle_Venta1() {
        
    }

    public DDetalle_Venta1(int Cod_Detalle, long Cantidad_Detalle, String Cod_ProductoFK, long Precio_Venta, int Id_VentaFK, String Factura, String Tipo_Pago, float Tipo_Cambio, long Subtotal) {
        this.Cod_Detalle = Cod_Detalle;
        this.Cantidad_Detalle = Cantidad_Detalle;
        this.Cod_ProductoFK = Cod_ProductoFK;
        this.Precio_Venta = Precio_Venta;
        this.Id_VentaFK = Id_VentaFK;
        this.Factura = Factura;
        this.Tipo_Pago = Tipo_Pago;
        this.Tipo_Cambio = Tipo_Cambio;
        this.Subtotal = Subtotal;
    }

    public int getCod_Detalle() {
        return Cod_Detalle;
    }

    public void setCod_Detalle(int Cod_Detalle) {
        this.Cod_Detalle = Cod_Detalle;
    }

    public long getCantidad_Detalle() {
        return Cantidad_Detalle;
    }

    public void setCantidad_Detalle(long Cantidad_Detalle) {
        this.Cantidad_Detalle = Cantidad_Detalle;
    }

    public String getCod_ProductoFK() {
        return Cod_ProductoFK;
    }

    public void setCod_ProductoFK(String Cod_ProductoFK) {
        this.Cod_ProductoFK = Cod_ProductoFK;
    }

    public long getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(long Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public int getId_VentaFK() {
        return Id_VentaFK;
    }

    public void setId_VentaFK(int Id_VentaFK) {
        this.Id_VentaFK = Id_VentaFK;
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

    public long getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(long Subtotal) {
        this.Subtotal = Subtotal;
    }
}