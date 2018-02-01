
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
public class Empleados {
  
    private String nombres,mail,apellidos,direccion,telefono,tipo;
    private float sueldo;
    private int id,idEmpleado;

    public Empleados(int id,String nombres, String mail, String apellidos, String direccion, String telefono, String tipo, float sueldo) {
        this.nombres = nombres;
        this.mail = mail;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.sueldo = sueldo;
        this.id=id;
    }

    public Empleados(String nombres, String apellidos, String tipo, int i) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo = tipo;
        this.idEmpleado = i;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
