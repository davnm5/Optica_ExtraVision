/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;


/**
 *
 * @author creditos
 */
public class Brigadas {
 
    private String lugar;
    private Date fecha;
    private String hora_inicio,hora_fin;
    private int idVendedor,idOptometra,idBrigada,n_pacientes;

    public Brigadas(String lugar,Date fecha, String hora_inicio, String hora_fin,int idVendedor, int idOptometra, int idBrigada, int n_pacientes) {
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.idVendedor = idVendedor;
        this.idOptometra = idOptometra;
        this.idBrigada = idBrigada;
        this.n_pacientes = n_pacientes;
    }

    public Brigadas(Date fecha,String hora_inicio, String hora_fin, int n_pacientes,String lugar) {
        this.fecha=fecha;
        this.lugar = lugar;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.n_pacientes = n_pacientes;
    }

    

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

  
    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdOptometra() {
        return idOptometra;
    }

    public void setIdOptometra(int idOptometra) {
        this.idOptometra = idOptometra;
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    public int getN_pacientes() {
        return n_pacientes;
    }

    public void setN_pacientes(int n_pacientes) {
        this.n_pacientes = n_pacientes;
    }
    
    
    
    
    
}
