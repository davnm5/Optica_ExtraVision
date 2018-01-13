/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_eliminacion {
    @FXML private AnchorPane P_eliminar,submenu;
    @FXML private MenuItem m_clientes,m_proveedores,aceptar;
    private boolean entrada_salida=false;
    private int contador=0;
    private ObservableList names = FXCollections.observableArrayList();
    private ObservableList data = FXCollections.observableArrayList();
    private ObservableList datos_lista = FXCollections.observableArrayList();
    private ListView list;
    
    
    
    
    
     @FXML
    public void initialize() {
        list= new ListView(data);
        list.setLayoutX(155);
        list.setLayoutY(85);
        list.setPrefSize(295,297);
        list.setEditable(true);
        list.setId("lista");
        P_eliminar.getChildren().add(list);
    }
    
    @FXML private void clientes(){
        reestablecer();
        System.out.println("EN CLIENTES");
        names.removeAll(names);
        names.add("JOSE DAVID NEIRA MARTRUS");
        names.add("DAMIAN RODRIGO DIAZ PEREZ");
        list.setCellFactory(ComboBoxListCell.forListView(names));   
    }
    
    
    @FXML private void proveedores(){
        reestablecer();
        System.out.println("EN PROVEEDORES");
        names.removeAll(names);
        names.add("RODRIGO CARLOS SUAREZ JOUVIN");
        names.add("MATIAS JOSE PEREZ GARCIA");
        list.setCellFactory(ComboBoxListCell.forListView(names));   
    }
    
    
    
    @FXML private void salir() throws IOException{
       AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.P_eliminar.getChildren().setAll(pane); 
        
        
    }
    
    
    
    @FXML private void eliminar_todo(){
    
    datos_lista=list.getItems();
    HashSet<String> set = new HashSet<String>();
    for(int i=0;i<datos_lista.size();i++){
        if(!datos_lista.get(i).equals("VACIO")){
           set.add((String) datos_lista.get(i));  
    }
    }
    
    confirmar(set);
    for (String s: set){
        System.out.println("REGISTRO A ELIMINAR:"+s);
    }
    
    }
    
    
    @FXML private void reestablecer(){
    data.removeAll(data);
    for (int i = 0; i<20; i++) {
            data.add("VACIO");
        }
    list.setItems(data);
    }
    
 private void mostrar_mensaje(String texto1,String texto2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(texto1);
                alert.setHeaderText(null);
                alert.setContentText(texto2);
                alert.showAndWait();
    
    }
private void confirmar(HashSet s){
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("CONFIRMACION DE ACCION");
alert.setHeaderText("LA SIGUIENTE ACCION SERÁ IRREVERSIBLE");
alert.setContentText("ESTA SEGURO QUE DESEA ELIMINAR ESTOS "+s.size() +" REGISTROS");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    reestablecer();
    
} else {
   
}

}


}
