/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author creditos
 */
public class Ventas {
    private String descripcion,cedula;
    private int idVendedor,idLentes,idCompra;
    private float total;
    private Date fecha;

    public Ventas(String descripcion, String cedula, int idVendedor, int idLentes, int idCompra, float total,Date f) {
        this.descripcion = descripcion;
        this.cedula = cedula;
        this.idVendedor = idVendedor;
        this.idLentes = idLentes;
        this.idCompra = idCompra;
        this.total = total;
        this.fecha=f;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdLentes() {
        return idLentes;
    }

    public void setIdLentes(int idLentes) {
        this.idLentes = idLentes;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
    
    
    
}
