/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Productos;
import DB.DB_Proveedores;
import Entidades.Lentes;
import Entidades.Proveedores;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_ConsultaProductos {
    
    
    @FXML private AnchorPane lentes;
    @FXML private ComboBox c_lentes;
    @FXML private TextField marca,descripcion,cantidad,precio,tipo;
    private ArrayList<Lentes> datos = new ArrayList();
    
    @FXML private void cargar_lentes(){
        
        datos = DB_Productos.obtener_lentes((String)c_lentes.getValue());
        for (int i = 0; i < datos.size(); i++) {
          System.out.println("select:"+c_lentes.getValue());
            String s=(String)datos.get(i).getMarca() + "-" + datos.get(i).getTipo()+"#"+datos.get(i).getIdLente();
            System.out.println("s:"+s);
            if (c_lentes.getValue().equals(s)){
                
                marca.setText(datos.get(i).getMarca());
                precio.setText(String.valueOf(datos.get(i).getPrecio()));
                cantidad.setText(String.valueOf(datos.get(i).getCantidad()));
                tipo.setText(datos.get(i).getTipo());
                descripcion.setText(datos.get(i).getD_armazon()+"\t"+datos.get(i).getD_lunas());
            }
        }

    }
    
    
    
    
    @FXML
    public void initialize() {

        c_lentes.getItems().removeAll(c_lentes.getItems());
        
        datos = DB_Productos.obtener_lentes();
        for (int i = 0; i < datos.size(); i++) {
            c_lentes.getItems().add(datos.get(i).getMarca()+"-"+datos.get(i).getTipo()+"#"+datos.get(i).getIdLente());
        }
    }
    
    
     @FXML private void atras_lentes() throws IOException{
       AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.lentes.getChildren().setAll(pane); 
        
        
    }
    
    
    
}
