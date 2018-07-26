package Datos;

public class DProveedor {
    
   private int Id_Proveedor;
    private String Razon_Social;
    private String Contacto;
    private String Telefono;
    private String Correo;
    private String Direccion;
    
    public DProveedor() {
    
    }

    public DProveedor(int Id_Proveedor, String Razon_Social, String Contacto, String Telefono, String Correo, String Direccion) {
        this.Id_Proveedor = Id_Proveedor;
        this.Razon_Social = Razon_Social;
        this.Contacto = Contacto;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
    }

    public int getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(int Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }   
}