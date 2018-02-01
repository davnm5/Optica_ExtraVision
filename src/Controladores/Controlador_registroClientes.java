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
import javafx.event.ActionEvent;
import javafx.event.EventType;
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
public class Controlador_registroClientes {

    @FXML
    private TextField nombres, apellidos, telefono, direccion, cedula, mail;
    @FXML
    private AnchorPane clientes;
    @FXML
    private ComboBox empresas;
    private ArrayList<Empresas> datos = new ArrayList();
    private int idEmpresa=-1;

    @FXML
    private void registrar_clientes() {
        String a, b;
        a = cedula.getText();
        b = telefono.getText();
        if (!"".equals(a) && !"".equals(nombres.getText()) && !"".equals(apellidos.getText()) && !"".equals(b) && !"".equals(direccion.getText()) && !"".equals(mail.getText())&&idEmpresa!=-1) {
            if (a.length() == 10 && b.length() >= 7 && b.length() <= 10) {
                Clientes nuevo = new Clientes(nombres.getText(), apellidos.getText(), direccion.getText(), a, b, idEmpresa, mail.getText());
                DB_Clientes.registrar_clientes(nuevo);
                mostrar_mensaje("REGISTRO EXITOSO","EL CLIENTE FUE REGISTRADO CORRECTAMENTE");
            } else {
                mostrar_mensaje("ERROR","CEDULA O TELEFONO INCORRECTOS");
            }
            

        } else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
    }

    @FXML
    private void atras_Clientes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.clientes.getChildren().setAll(pane);
    }

    @FXML
    public void initialize() {
        empresas.getItems().removeAll(empresas.getItems());
        datos = DB_Empresas.obtener_Empresas();
        for (int i = 0; i < datos.size(); i++) {
            empresas.getItems().add(datos.get(i).getNombre());
        }

    }
    
    private void mostrar_mensaje(String texto1,String texto2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(texto1);
                alert.setHeaderText(null);
                alert.setContentText(texto2);
                alert.showAndWait();
    
    }
    @FXML
    private void seleccionar_empresa() {

        for (int i = 0; i < datos.size(); i++) {
            if (empresas.getValue().equals(datos.get(i).getNombre())) {
                idEmpresa = datos.get(i).getIdEmpresa();
            }
        }

    }
}
