/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Clientes;
import DB.DB_Empleados;
import DB.DB_Productos;
import DB.DB_Ventas;
import Entidades.Clientes;
import Entidades.Empleados;
import Entidades.Lentes;
import Entidades.Ventas;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_registroVentas {
    
    @FXML private AnchorPane ventas;
    @FXML private ComboBox c_paciente,c_vendedor,c_lente;
    @FXML private TextField total,descripcion;
    private ArrayList<Clientes> datos= new ArrayList();
    private ArrayList<Empleados> data= new ArrayList();
    private ArrayList<Lentes> list= new ArrayList();
    private String cedula;
    private int idLente=-1,idVendedor=-1;
    @FXML private DatePicker fecha; 
    
    @FXML
    private void seleccionar_paciente() {

        for (int i = 0; i < datos.size(); i++) {
            if (c_paciente.getValue().equals(datos.get(i).getNombre_c()+" "+datos.get(i).getApellido_c())) {
                cedula = datos.get(i).getId();
            }
        }

    }
    
    @FXML public void initialize(){
    
    c_vendedor.getItems().removeAll(c_vendedor.getItems());
        data= DB_Empleados.obtener_vendedores();
        for (int i = 0; i < data.size(); i++) {
            c_vendedor.getItems().add(data.get(i).getNombres()+ " " + data.get(i).getApellidos());
        }
     c_paciente.getItems().removeAll(c_paciente.getItems());   
        datos= DB_Clientes.obtener_clientes();
        for (int i = 0; i < datos.size(); i++) {
            c_paciente.getItems().add(datos.get(i).getNombre_c()+ " " + datos.get(i).getApellido_c());
        }
        
     c_lente.getItems().removeAll(c_lente.getItems());
        list = DB_Productos.obtener_lentes();
        for (int i = 0; i < list.size(); i++) {
            c_lente.getItems().add(list.get(i).getMarca()+"-"+list.get(i).getTipo()+"#"+list.get(i).getIdLente());
        }
    
    }
    
    @FXML private void atras_brigadas() throws IOException{
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.ventas.getChildren().setAll(pane);
    
    }
    
    @FXML private void registrar_ventas(){
    
    String a=descripcion.getText();
    String b=total.getText();
        if(!"".equals(a)&&!"".equals(b)){
        Date t=Date.valueOf(fecha.getValue());
        if (!"".equals(String.valueOf(t))&&idVendedor!=-1&&idLente!=-1&&!"".equals(cedula)) {
                Date f=Date.valueOf(fecha.getValue());
   
                Ventas nuevo = new Ventas(a,cedula,idVendedor,idLente,0,Float.parseFloat(b),f);
                DB_Ventas.registrar_ventas(nuevo);
                mostrar_mensaje("REGISTRO EXITOSO","EL CLIENTE FUE REGISTRADO CORRECTAMENTE");
            } 
            

       else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
        }
        else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
    
    }
    
    
private void mostrar_mensaje(String texto1,String texto2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(texto1);
                alert.setHeaderText(null);
                alert.setContentText(texto2);
                alert.showAndWait();
    
    }
    
    
    
    @FXML private void seleccionar_lente(){
     for (int i = 0; i < list.size(); i++) {
            if (c_lente.getValue().equals(list.get(i).getMarca()+"-"+list.get(i).getTipo()+"#"+list.get(i).getIdLente())) {
                idLente= list.get(i).getIdLente();
            }
        }

    }
    @FXML private void seleccionar_vendedor(){
      for (int i = 0; i < data.size(); i++) {
            if (c_vendedor.getValue().equals(data.get(i).getNombres()+" "+data.get(i).getApellidos())) {
                idVendedor = data.get(i).getIdEmpleado();
            }
    }
    
    
}



}


