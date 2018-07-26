package Datos;

public class DDetalle_Venta {

    private int Cod_Detalle;
    private long Cantidad_Detalle;
    private String Cod_ProductoFK ;
    private long Precio_Venta; 
    private int Id_VentaFK;
    private long Subtotal;
    private long SubPrecio_Compra;
    private long Precio_Compra;
    
    public DDetalle_Venta() {
        
    }

    public DDetalle_Venta(int Cod_Detalle, long Cantidad_Detalle, String Cod_ProductoFK, long Precio_Venta, int Id_VentaFK, long Subtotal, long SubPrecio_Compra, long Precio_Compra) {
        this.Cod_Detalle = Cod_Detalle;
        this.Cantidad_Detalle = Cantidad_Detalle;
        this.Cod_ProductoFK = Cod_ProductoFK;
        this.Precio_Venta = Precio_Venta;
        this.Id_VentaFK = Id_VentaFK;
        this.Subtotal = Subtotal;
        this.SubPrecio_Compra = SubPrecio_Compra;
        this.Precio_Compra = Precio_Compra;
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

    public long getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(long Subtotal) {
        this.Subtotal = Subtotal;
    }

    public long getSubPrecio_Compra() {
        return SubPrecio_Compra;
    }

    public void setSubPrecio_Compra(long SubPrecio_Compra) {
        this.SubPrecio_Compra = SubPrecio_Compra;
    }

    public long getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(long Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }    
}