/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author creditos
 */
public class Armazones {
    
    private String marca;
    private String descripcion;
    private float precio;
    private int cantidad,idProveedor,idArmazon;
    
    public Armazones(String marca, String descripcion, float precio, int cantidad, int idProveedor) {
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idProveedor = idProveedor;
    }


    public Armazones(int id, String s, float f) {
        this.marca=s;
        this.precio=f;
        this.idArmazon=id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getIdArmazon() {
        return idArmazon;
    }

    public void setIdArmazon(int idArmazon) {
        this.idArmazon = idArmazon;
    }
    
    
    
    
    
    
    
    
    
}

