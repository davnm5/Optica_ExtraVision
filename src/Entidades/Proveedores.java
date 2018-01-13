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
public class Proveedores {
    private String nombres;
    private String apellidos;
    private String direccion;
    private String mail;
    private float comision;
    private int idProveedor;
    private String telefono;

    public Proveedores(String nombres, String apellidos, String direccion, String mail, float comision, int idProveedor, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.mail = mail;
        this.comision = comision;
        this.idProveedor = idProveedor;
        this.telefono = telefono;
    }
    
   
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
