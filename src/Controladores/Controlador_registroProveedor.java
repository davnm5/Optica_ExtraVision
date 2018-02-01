/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Clientes;
import DB.DB_Empresas;
import DB.DB_Proveedores;
import Entidades.Clientes;
import Entidades.Proveedores;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_registroProveedor {
    
    @FXML private AnchorPane proveedores;
    @FXML private TextField nombres,apellidos,direccion,mail,comision,telefono;
    
    
    
    
    
    
     @FXML private void registrar_proveedores() {
        String b;
        b = telefono.getText();
        if (!"".equals(comision.getText()) && !"".equals(nombres.getText()) && !"".equals(apellidos.getText()) && !"".equals(b) && !"".equals(direccion.getText()) && !"".equals(mail.getText())) {
            if (b.length() >= 7 && b.length() <= 10) {
                Proveedores nuevo;
                 nuevo = new Proveedores(nombres.getText(), apellidos.getText(), direccion.getText(),mail.getText(),
                       Float.parseFloat(comision.getText()),0,b);
                DB_Proveedores.registrar_Proveedores(nuevo);
                mostrar_mensaje("REGISTRO EXITOSO","LA VENTA FUE REGISTRADA CORRECTAMENTE");
            } else {
                mostrar_mensaje("ERROR","TELEFONO INCORRECTO");
            }
            

        } else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
     }
        
      @FXML
    private void atras_proveedores(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.proveedores.getChildren().setAll(pane);
    }
    private void mostrar_mensaje(String texto1,String texto2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(texto1);
                alert.setHeaderText(null);
                alert.setContentText(texto2);
                alert.showAndWait();
    
    }
   
}
