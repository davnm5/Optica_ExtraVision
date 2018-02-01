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
public class Controlador_Web{


@FXML private AnchorPane web;



@FXML 
private void initialize(){
 Browser a=new Browser();
 web.getChildren().addAll(a);
}


 @FXML
    private void atras(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.web.getChildren().setAll(pane);
    }

}
