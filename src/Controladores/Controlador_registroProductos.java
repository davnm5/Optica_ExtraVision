/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_registroProductos {
    @FXML private AnchorPane lentes,par_Lunas;
    
    
        @FXML
     private void regresar_lentes(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
      this.lentes.getChildren().setAll(pane);
     } 
     
     @FXML
     private void regresar_lunas(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
      this.par_Lunas.getChildren().setAll(pane);
     } 
     
     
     
    
}


