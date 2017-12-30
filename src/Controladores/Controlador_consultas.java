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
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_consultas {

    @FXML
    private TableColumn c_nombres, c_apellidos, c_telefono, c_direccion;
    @FXML
    private AnchorPane clientes_empresa;
    @FXML
    private ComboBox c_empresa;
    @FXML
    private Label prueba;
    @FXML
    private TableView<Clientes> tabla;
    private ObservableList<Clientes> data;

    @FXML
    private void atras_Consultas_Clientes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consultas_R.fxml"));
        this.clientes_empresa.getChildren().setAll(pane);

    }

    @FXML
    public void initialize() {
        System.out.println("ENTRA");
        tabla = new TableView<>();
        tabla.setLayoutX(124);
        tabla.setLayoutY(160);
        tabla.setPrefWidth(404);
        tabla.setPrefHeight(195);
        c_nombres = new TableColumn("Nombres");
        c_apellidos = new TableColumn("Apellidos");
        c_direccion = new TableColumn("Direccion");
        c_telefono = new TableColumn("Telefono");
        c_nombres.setMinWidth(105);
        c_apellidos.setMinWidth(105);
        c_direccion.setMinWidth(110);
        c_telefono.setMinWidth(84);
        clientes_empresa.getChildren().addAll(tabla);
        tabla.setEditable(true);
        data = FXCollections.observableArrayList();
        c_nombres.setCellValueFactory(new PropertyValueFactory<Clientes, String>("nombre"));
        c_apellidos.setCellValueFactory(new PropertyValueFactory<Clientes, String>("apellido"));
        c_direccion.setCellValueFactory(new PropertyValueFactory<Clientes, String>("direccion"));
        c_telefono.setCellValueFactory(new PropertyValueFactory<Clientes, Integer>("telefono"));
        
        tabla.setItems(data);
        tabla.getColumns().addAll(c_nombres, c_apellidos, c_direccion, c_telefono);
        c_empresa.getItems().removeAll(c_empresa.getItems());
        ArrayList<Empresas> datos = new ArrayList();
        datos = DB_Empresas.obtener_Empresas();
        System.out.println(datos.get(0).getNombre());
        for (int i = 0; i < datos.size(); i++) {
            c_empresa.getItems().add(datos.get(i).getNombre());
        }
    }

    @FXML
    private void cargar_clientes() {
        data.clear();
        ArrayList<Clientes> clientes = new ArrayList();
        clientes = DB_Clientes.obtener_clientes((String) c_empresa.getValue());
        for (int i = 0; i < clientes.size(); i++) {
            data.add(clientes.get(i));
        }
    }

}
