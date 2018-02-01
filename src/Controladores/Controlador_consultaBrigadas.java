/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Brigadas;
import Entidades.Brigadas;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_consultaBrigadas {
    
    @FXML private AnchorPane brigadas;
    @FXML private TextField hora_inicio,hora_fin,n_pacientes,lugar;
    private ArrayList<Brigadas> datos=new ArrayList();
    @FXML private DatePicker fecha;
    private int n=0;
    
       @FXML
    private void atras_brigadas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consultas_R.fxml"));
        this.brigadas.getChildren().setAll(pane);

    }
    
    
    @FXML
    private void consultar_brigada() {
        Date t=Date.valueOf(fecha.getValue());
        datos = DB_Brigadas.obtener_brigadas(t);
        for (int i = 0; i < datos.size(); i++) {
            if (t.equals(datos.get(i).getFecha())){
                
                hora_inicio.setText(datos.get(i).getHora_inicio());
                hora_fin.setText(datos.get(i).getHora_fin());
                lugar.setText(datos.get(i).getLugar());
                n_pacientes.setText(String.valueOf(datos.get(i).getN_pacientes()));
                n=1;
            }
        }
        if(n==0){
        mostrar_mensaje("INFORMACION","NO HAY BRIGADAS PARA ESA FECHA");
        
        
        }

    }
    
    private void mostrar_mensaje(String texto1,String texto2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(texto1);
                alert.setHeaderText(null);
                alert.setContentText(texto2);
                alert.showAndWait();
    
    }
    
    
}
