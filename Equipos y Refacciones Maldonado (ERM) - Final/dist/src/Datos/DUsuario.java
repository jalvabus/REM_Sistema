package Datos;

public class DUsuario {
    
    private int Id_Usuario ;
    private String Nombre;
    private String Usuario;
    private String Contraseña;
    private String Telefono;
    private String Estado;
    private String Tipo;    
    
    public DUsuario() {
        
    }

    public DUsuario(int Id_Usuario, String Nombre, String Usuario, String Contraseña, String Telefono, String Estado, String Tipo) {
        this.Id_Usuario = Id_Usuario;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.Tipo = Tipo;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }    
}