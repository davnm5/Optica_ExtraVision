
package Entidades;

public class Lunas {
    
    private String descripcion,tipo;
    private float precio;
    private int cantidad,idProveedor,idLunas;

    public Lunas(String descripcion, float precio, int cantidad,String tipo, int idLunas, int idProveedor) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idLunas = idLunas;
        this.idProveedor = idProveedor;
        this.idLunas = idLunas;
        this.tipo=tipo;
    }
 

    public Lunas(int idLunas,String descripcion, String tipo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idLunas = idLunas;
    }


    public String getDescripcion() {
        return descripcion;
    }
    

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdLunas() {
        return idLunas;
    }

    public void setIdLunas(int idLunas) {
        this.idLunas = idLunas;
    }
    
    
    
    
}
