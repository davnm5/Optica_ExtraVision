/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Clientes;
import Entidades.Clientes;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_ventanas implements Initializable {
    @FXML private TextField usuario;
    @FXML private PasswordField password;
    @FXML private AnchorPane inicio,submenu,registros,proveedores,consultasR;
    

   
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
    private void b_productos(ActionEvent event) throws IOException {
     mostrar_opciones();
        
    }
    
    @FXML
     private void regresar(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/principal.fxml"));
      this.submenu.getChildren().setAll(pane);
     }
     
  private void mostrar_opciones() throws IOException{
     ArrayList<String> choices = new ArrayList<>();
choices.add("LENTES");
choices.add("PAR_LUNAS");

ChoiceDialog<String> dialog = new ChoiceDialog<>("LENTES",choices);
dialog.setTitle("SELECCION DE PRODUCTOS");
dialog.setHeaderText("PRODUCTOS");
dialog.setContentText("SELECCIONE EL PRODUCTO QUE DESEA REGISTRAR");

Optional<String> result = dialog.showAndWait();
if (result.isPresent()){
    if("LENTES".equals(result.get())){
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/lentes.fxml"));
        this.registros.getChildren().setAll(pane);
    }
    if("PAR_LUNAS".equals(result.get())){
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/par_lunas.fxml"));
        this.registros.getChildren().setAll(pane);
    }
     
}
     
     }
     
 
     @FXML
     private void atras(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
      this.registros.getChildren().setAll(pane);
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