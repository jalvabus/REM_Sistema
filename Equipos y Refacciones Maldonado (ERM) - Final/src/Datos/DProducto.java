package Datos;

public class DProducto {

    private String Cod_Producto;
    private String Proveedor;
    private String Nombre_Producto;
    private String Descripcion;
    private long Precio_Venta;
    private long Precio_Compra;       
    private int Existencia;    
    
    public DProducto() {
        
    }

    public DProducto(String Cod_Producto, String Proveedor, String Nombre_Producto, String Descripcion, long Precio_Venta, long Precio_Compra, /*String Ubicacion_Almacen,*/ int Existencia) {
        this.Cod_Producto = Cod_Producto;
        this.Proveedor = Proveedor;
        this.Nombre_Producto = Nombre_Producto;
        this.Descripcion = Descripcion;
        this.Precio_Venta = Precio_Venta;
        this.Precio_Compra = Precio_Compra;        
        this.Existencia = Existencia;
    }

    public String getCod_Producto() {
        return Cod_Producto;
    }

    public void setCod_Producto(String Cod_Producto) {
        this.Cod_Producto = Cod_Producto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public long getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(long Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public long getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(long Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }    
}