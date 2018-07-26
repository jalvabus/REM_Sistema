package Datos;
 
public class DCliente {

    private int Id_Cliente;
    private String Razon_Social;
    private String No_Estacion;
    private String Contacto;
    private String Telefono;
    private String Correo;
    private String Direccion; 

    public DCliente() {
        
    }

    public DCliente(int Id_Cliente, String Razon_Social, String No_Estacion, String Contacto, String Telefono, String Correo, String Direccion) {
        this.Id_Cliente = Id_Cliente;
        this.Razon_Social = Razon_Social;
        this.No_Estacion = No_Estacion;
        this.Contacto = Contacto;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String Razon_Social) {
        this.Razon_Social = Razon_Social;
    }

    public String getNo_Estacion() {
        return No_Estacion;
    }

    public void setNo_Estacion(String No_Estacion) {
        this.No_Estacion = No_Estacion;
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