package Datos;

import java.sql.Date;

public class DHistorialStock {
    
    private int Cod_Historial;
    private String Cod_ProductoFK;
    private int Id_UsuarioFK;
    private String Descripcion;
    private String Referencia;
    private int Cantidad_Nva;
    private Date Fecha;
    
    public DHistorialStock(){
    
    }

    public DHistorialStock(int Cod_Historial, String Cod_ProductoFK, int Id_UsuarioFK, String Descripcion, String Referencia, int Cantidad_Nva, Date Fecha) {
        this.Cod_Historial = Cod_Historial;
        this.Cod_ProductoFK = Cod_ProductoFK;
        this.Id_UsuarioFK = Id_UsuarioFK;
        this.Descripcion = Descripcion;
        this.Referencia = Referencia;
        this.Cantidad_Nva = Cantidad_Nva;
        this.Fecha = Fecha;
    }

    public int getCod_Historial() {
        return Cod_Historial;
    }

    public void setCod_Historial(int Cod_Historial) {
        this.Cod_Historial = Cod_Historial;
    }

    public String getCod_ProductoFK() {
        return Cod_ProductoFK;
    }

    public void setCod_ProductoFK(String Cod_ProductoFK) {
        this.Cod_ProductoFK = Cod_ProductoFK;
    }

    public int getId_UsuarioFK() {
        return Id_UsuarioFK;
    }

    public void setId_UsuarioFK(int Id_UsuarioFK) {
        this.Id_UsuarioFK = Id_UsuarioFK;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public int getCantidad_Nva() {
        return Cantidad_Nva;
    }

    public void setCantidad_Nva(int Cantidad_Nva) {
        this.Cantidad_Nva = Cantidad_Nva;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }  
}