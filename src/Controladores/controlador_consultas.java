/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Clientes;
import DB.DB_Empresas;
import Entidades.Clientes;
import Entidades.Empresas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class controlador_consultas {
    @FXML private TextField nombres_c, apellidos_c,telefono_c,direccion_c;
    @FXML private AnchorPane clientes_empresa;
    @FXML private ComboBox c_empresa;
    @FXML private Label prueba;
    

   
    
    
    @FXML
     private void atras_Consultas_Clientes(ActionEvent event) throws IOException {
      AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/Componentes/consultas_R.fxml"));
      this.clientes_empresa.getChildren().setAll(pane);
      
     }
     
@FXML
public void initialize() {

    c_empresa.getItems().removeAll(c_empresa.getItems());
    ArrayList<Empresas> datos= new ArrayList();
        datos=DB_Empresas.obtener_Empresas();
        System.out.println(datos.get(0).getNombre());
        for(int i=0;i<datos.size();i++){
        c_empresa.getItems().add(datos.get(i).getNombre());
        }
}

    
    @FXML
    private void cargar_clientes(){
    ArrayList<Clientes> clientes= new ArrayList();
    clientes=DB_Clientes.obtener_clientes((String)c_empresa.getValue());
    System.out.println(clientes.size());
    for(int i=0;i<clientes.size();i++){
       System.out.println(clientes.get(i).getNombre());
    nombres_c.setText(clientes.get(i).getNombre());
    
    apellidos_c.setText(clientes.get(i).getApellido());
    telefono_c.setText(String.valueOf(clientes.get(i).getTelefono()));
    direccion_c.setText(clientes.get(i).getDireccion());
       
    }
    }

}
    
   
    

