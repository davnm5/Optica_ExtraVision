/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author creditos
 */
public class Clientes {
  
  private SimpleStringProperty nombre;
  private SimpleStringProperty apellido;
  private SimpleStringProperty direccion;
  private SimpleStringProperty telefono;
  private SimpleStringProperty cedula;
  private int idEmpresa;
  private String mail;
  
  public Clientes(String a,String b,String c ,String d,String e,int id,String mail){
  this.nombre=new SimpleStringProperty(a);
  this.apellido=new SimpleStringProperty(b);
  this.direccion=new SimpleStringProperty(c);
  this.cedula=new SimpleStringProperty(d);
  this.telefono=new SimpleStringProperty(e);
  this.idEmpresa=id;
  this.mail=mail;
  }  
     public int getIdEmpresa(){
     return this.idEmpresa;
     } 
     
     public void setIdEmpresa(int id){
        this.idEmpresa=id;
}
    public String getNombre() {
        return nombre.get();
    }
    public String getCedula() {
        return cedula.get();
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }
  public void setMail(String mail){
  this.mail=mail;
}
  public String getMail(){
  return this.mail;
  }
    
    
}
