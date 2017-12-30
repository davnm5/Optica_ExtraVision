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
  private SimpleIntegerProperty telefono;
  private SimpleIntegerProperty cedula;
          
  public Clientes(String a,String b,String c ,int d,int e){
  this.nombre=new SimpleStringProperty(a);
  this.apellido=new SimpleStringProperty(b);
  this.direccion=new SimpleStringProperty(c);
  this.cedula=new SimpleIntegerProperty(d);
  this.telefono=new SimpleIntegerProperty(e);
  }  

    public String getNombre() {
        return nombre.get();
    }
    public int getCedula() {
        return cedula.get();
    }

    public void setCedula(int cedula) {
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

    public int getTelefono() {
        return telefono.get();
    }

    public void setTelefono(int telefono) {
        this.telefono.set(telefono);
    }
    
  
    
    
}
