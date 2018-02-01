/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Empresas;
import DB.DB_Proveedores;
import Entidades.Clientes;
import Entidades.Empresas;
import Entidades.Proveedores;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_consultaProveedores {

    @FXML private AnchorPane proveedores_consulta;
    @FXML private ComboBox c_proveedores;
    @FXML private TextField nombres, apellidos, telefono, mail, comision, direccion;
    private ArrayList<Proveedores> datos=new ArrayList();
    @FXML
    public void initialize() {

        c_proveedores.getItems().removeAll(c_proveedores.getItems());
        datos = DB_Proveedores.obtener_Proveedores();
        System.out.println(datos.get(0).getNombres());
        for (int i = 0; i < datos.size(); i++) {
            c_proveedores.getItems().add(datos.get(i).getNombres() + " " + datos.get(i).getApellidos());
        }
    }

    @FXML
    private void cargar_proveedores() {
        datos = DB_Proveedores.obtener_Proveedores();
        for (int i = 0; i < datos.size(); i++) {
            if (c_proveedores.getValue().equals(datos.get(i).getNombres() + " " + datos.get(i).getApellidos())) {
                nombres.setText(datos.get(i).getNombres());
                apellidos.setText(datos.get(i).getApellidos());
                direccion.setText(datos.get(i).getDireccion());
                telefono.setText(datos.get(i).getTelefono());
                comision.setText(String.valueOf(datos.get(i).getComision()));
                mail.setText(datos.get(i).getMail());
            }
        }

    }

    @FXML
    private void atras_proveedores(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consultas_R.fxml"));
        this.proveedores_consulta.getChildren().setAll(pane);

    }

}
