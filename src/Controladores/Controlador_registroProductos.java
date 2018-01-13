/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Empresas;
import DB.DB_Productos;
import DB.DB_Proveedores;
import Entidades.Armazones;
import Entidades.Empresas;
import Entidades.Lentes;
import Entidades.Lunas;
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
public class Controlador_registroProductos {

    @FXML
    private AnchorPane lentes, par_Lunas,armazon;
    @FXML
    private ComboBox proveedores,c_lunas,c_armazones;
    @FXML
    private TextField marca,tipo,descripcion, precio, cantidad;
    private ArrayList<Proveedores> datos = new ArrayList();
    private ArrayList<Lunas> data = new ArrayList();
    private ArrayList<Armazones> list = new ArrayList();
    private int idProveedor=-1,idLunas=-1,idArmazon=-1;
    
    
    @FXML
    private void atras_lentes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.lentes.getChildren().setAll(pane);
    }

    @FXML
    private void atras_lunas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.par_Lunas.getChildren().setAll(pane);
    }

    @FXML
    private void atras_armazon(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.armazon.getChildren().setAll(pane);
    }

    @FXML
    private void registrar_armazon(ActionEvent event) throws IOException {
        if (!"".equals(descripcion.getText()) && !"".equals(precio.getText()) && !"".equals(cantidad.getText()) && !"".equals(marca.getText())&&idProveedor!=-1) {

            Armazones nuevo;
            nuevo = new Armazones(marca.getText(), descripcion.getText(), Float.parseFloat(precio.getText()),
                    Integer.parseInt(cantidad.getText()),idProveedor);

            DB_Productos.registrar_armazones(nuevo);
            mostrar_mensaje("REGISTRO EXITOSO", "EL ARMAZON FUE REGISTRADO CORRECTAMENTE");
        }
        else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }

    }
    
    
    @FXML 
    private void registrar_lunas(){
      if (!"".equals(descripcion.getText()) && !"".equals(precio.getText()) && !"".equals(cantidad.getText()) && !"".equals(marca.getText())&&idProveedor!=-1) {

            Lunas nuevo;
            nuevo = new Lunas(descripcion.getText(),Float.parseFloat(precio.getText()),Integer.parseInt(cantidad.getText()),tipo.getText(),0,idProveedor);
            DB_Productos.registrar_lunas(nuevo);
            mostrar_mensaje("REGISTRO EXITOSO", "LA LUNA FUE REGISTRADO CORRECTAMENTE");
        }
        else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }

    }
    
    
    @FXML 
    private void registrar_lentes(){
        if (!"".equals(descripcion.getText()) && !"".equals(precio.getText()) && !"".equals(cantidad.getText())&&idLunas!=-1&&idArmazon!=-1) {

            Lentes nuevo;
            nuevo = new Lentes(descripcion.getText(),Float.parseFloat(precio.getText()),
                 Integer.parseInt(cantidad.getText()),idLunas,idArmazon,0);

            DB_Productos.registrar_lentes(nuevo);
            mostrar_mensaje("REGISTRO EXITOSO", "EL LENTE FUE REGISTRADO CORRECTAMENTE");
        }
        else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
    }
    
    

    @FXML
    public void initialize() {
        proveedores.getItems().removeAll(proveedores.getItems());
        c_lunas.getItems().removeAll(c_lunas.getItems());
        c_lunas.getItems().addAll("MONOFOCALES","BIFOCALES","LECTURA","ANTIREFLEJO");
        c_armazones.getItems().removeAll(c_armazones.getItems());
        datos = DB_Proveedores.obtener_Proveedores();
        for (int i = 0; i < datos.size(); i++) {
            proveedores.getItems().add(datos.get(i).getNombres() + " " + datos.get(i).getApellidos());
        }
        data=DB_Productos.obtener_lunas();
        for (int i = 0; i < data.size(); i++) {
            c_lunas.getItems().add(data.get(i).getTipo()+ " " + data.get(i).getDescripcion());
        }
        
        list=DB_Productos.obtener_armazones();
        for (int i = 0; i < list.size(); i++) {
            c_armazones.getItems().add(list.get(i).getMarca()+" "+list.get(i).getPrecio());
        }
        
        
    }

    @FXML
    private void obtener_proveedores() {

        for (int i = 0; i < datos.size(); i++) {
            if (proveedores.getValue().equals(datos.get(i).getNombres()+" "+datos.get(i).getApellidos())) {
                 idProveedor= datos.get(i).getIdProveedor();
            }
        }

    }
   @FXML
    private void obtener_lunas(){
        for (int i = 0; i < data.size(); i++) {
            if (c_lunas.getValue().equals(data.get(i).getTipo()+" "+data.get(i).getDescripcion())) {
                 idLunas= data.get(i).getIdLunas();
            }
        }
        
    }
    
    @FXML
    private void obtener_armazones(){
        for (int i = 0; i < list.size(); i++) {
            if (c_armazones.getValue().equals(list.get(i).getMarca()+" "+list.get(i).getPrecio())) {
                 idArmazon= list.get(i).getIdArmazon();
            }
        }
        
    }
    
    
    
    private void mostrar_mensaje(String texto1, String texto2) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(texto1);
        alert.setHeaderText(null);
        alert.setContentText(texto2);
        alert.showAndWait();

    }

}
