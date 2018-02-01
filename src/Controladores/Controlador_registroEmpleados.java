/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Empleados;
import DB.DB_Empresas;
import DB.DB_Proveedores;
import Entidades.Empleados;
import Entidades.Empresas;
import Entidades.Proveedores;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_registroEmpleados {
    
    @FXML
    private TextField nombres, apellidos, telefono, direccion,sueldo, mail;
    @FXML
    private AnchorPane empleados;
    @FXML
    private ComboBox c_tipo;
    private String tipo;
    private ArrayList<Empleados> datos = new ArrayList();
    
    
    
    @FXML
    public void initialize() {
        c_tipo.getItems().removeAll(c_tipo.getItems());
        datos = DB_Empresas.obtener_Empresas();
        c_tipo.getItems().addAll("OPTOMETRA","VENDEDOR");
        

    }

    @FXML
    private void atras_Empleados(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.empleados.getChildren().setAll(pane);
    }

    @FXML private void registrar_empleados() {
        String b;
        b = telefono.getText();
        if (!"".equals(sueldo.getText()) && !"".equals(nombres.getText()) && !"".equals(apellidos.getText()) && !"".equals(b) && !"".equals(direccion.getText()) && !"".equals(mail.getText())) {
            if (b.length() >= 7 && b.length() <= 10) {
                Empleados nuevo;
                 nuevo = new Empleados(0,nombres.getText(),mail.getText(),apellidos.getText(), direccion.getText(),telefono.getText(),
                       tipo,Float.parseFloat(sueldo.getText()));
                DB_Empleados.registrar_empleado(nuevo);
                mostrar_mensaje("REGISTRO EXITOSO","EL EMPLEADO FUE REGISTRADO CORRECTAMENTE");
            } else {
                mostrar_mensaje("ERROR","TELEFONO INCORRECTO");
            }
            

        } else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
     }
    
    @FXML 
    private void seleccionar_tipo(){
        tipo=(String)c_tipo.getValue();
        System.out.println(tipo);
        
    }
    
    private void mostrar_mensaje(String texto1, String texto2) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(texto1);
        alert.setHeaderText(null);
        alert.setContentText(texto2);
        alert.showAndWait();

    }    
    
    
}
