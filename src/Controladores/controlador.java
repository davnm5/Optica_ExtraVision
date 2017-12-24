/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class controlador implements Initializable {
    @FXML private TextField usuario;
    @FXML private PasswordField password;
    @FXML private AnchorPane inicio,submenu,registros,clientes,proveedores,consultasR;

      
    
    
   
    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        
        if(usuario.getText().equals("")&&password.getText().equals("")){
               
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.inicio.getChildren().setAll(pane);
    
            
            System.out.println("Ingreso Correcto");
        }
        else{
            System.out.println("Ingreso Incorrecto");
        }
        }
        
    
        @FXML
    private void consultas(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/consultas_R.fxml"));
        this.submenu.getChildren().setAll(pane);
    }
    
       @FXML
     private void atras_Consultas(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
      this.consultasR.getChildren().setAll(pane);
     }
    
    
    @FXML
    private void b_proveedores(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/proveedores.fxml"));
        this.registros.getChildren().setAll(pane);
    }
    
    
    @FXML
    private void b_clientes(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/clientes.fxml"));
        this.registros.getChildren().setAll(pane);
    }
    
    
    @FXML
    private void registrar(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.submenu.getChildren().setAll(pane);
    }
    
   
    
    @FXML
     private void regresar(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/principal.fxml"));
      this.submenu.getChildren().setAll(pane);
     }
     
     
 
     @FXML
     private void atras(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
      this.registros.getChildren().setAll(pane);
     }
     
     @FXML
     private void atras_Clientes(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
      this.clientes.getChildren().setAll(pane);
     }
     @FXML
     private void atras_Proveedores(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
      this.proveedores.getChildren().setAll(pane);
     }
     
        
   @FXML
    private void consultar_clientes(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/consulta_clientes.fxml"));
        this.consultasR.getChildren().setAll(pane);
    }

   
    @FXML
     private void salir(ActionEvent event) {
        System.exit(0);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
