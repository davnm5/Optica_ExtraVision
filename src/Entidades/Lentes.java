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
public class Lentes {
    
    private String descripcion,tipo,marca,d_armazon,d_lunas;
    private float precio;
    private int cantidad,idLunas,idArmazon,idLente;

    public Lentes(String descripcion, float precio, int cantidad, int idLunas, int idArmazon, int idLente) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idLunas = idLunas;
        this.idArmazon = idArmazon;
        this.idLente = idLente;
    }

    public String getD_armazon() {
        return d_armazon;
    }

    public void setD_armazon(String d_armazon) {
        this.d_armazon = d_armazon;
    }

    public String getD_lunas() {
        return d_lunas;
    }

    public void setD_lunas(String d_lunas) {
        this.d_lunas = d_lunas;
    }

    public Lentes(int idLente,String tipo, String marca) {
        this.tipo = tipo;
        this.marca = marca;
        this.idLente = idLente;
    }
    
    public Lentes(int idLente,String descripcion,float precio,int cantidad,String marca,String tipo,String d_armazon,String d_lunas){
    this.idLente=idLente;
    this.descripcion=descripcion;
    this.precio=precio;
    this.cantidad=cantidad;
    this.marca=marca;
    this.tipo=tipo;
    this.d_armazon=d_armazon;
    this.d_lunas=d_lunas;     
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public int getIdLunas() {
        return idLunas;
    }

    public void setIdLunas(int idLunas) {
        this.idLunas = idLunas;
    }

    public int getIdArmazon() {
        return idArmazon;
    }

    public void setIdArmazon(int idArmazon) {
        this.idArmazon = idArmazon;
    }

    public int getIdLente() {
        return idLente;
    }

    public void setIdLente(int idLente) {
        this.idLente = idLente;
    }





}