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
    
    private String descripcion;
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