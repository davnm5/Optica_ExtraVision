/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DB.DB_Brigadas;
import DB.DB_Empleados;
import Entidades.Brigadas;
import Entidades.Empleados;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_registroBrigadas {
    
    @FXML private AnchorPane brigadas;
    private Spinner<Integer> pacientes,hora,minuto,hora_fin,minuto_fin;
    @FXML private TextField lugar;
    @FXML ComboBox c_vendedor,c_optometra;
    @FXML private DatePicker fecha;
    private int idVendedor=-1,idOptometra=-1;
    private final int n=100,h=24,min=59;
    private ArrayList<Empleados> datos=new ArrayList();
    private ArrayList<Empleados> data=new ArrayList();
    
    
    @FXML private void atras_brigadas() throws IOException{
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.brigadas.getChildren().setAll(pane);
    
    }
    
    @FXML public void initialize(){
    pacientes = new Spinner<Integer>();hora=new Spinner<Integer>();
    minuto=new Spinner<Integer>();hora_fin=new Spinner<Integer>();minuto_fin=new Spinner<Integer>();
    SpinnerValueFactory<Integer> v1 =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,n,10);
    SpinnerValueFactory<Integer> v2 =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,h,12);
    SpinnerValueFactory<Integer> v3 =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,min,0);
    SpinnerValueFactory<Integer> v4 =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,h,12);
    SpinnerValueFactory<Integer> v5 =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,min,0);
    
       hora.setValueFactory(v2);hora.setLayoutX(235);hora.setLayoutY(146);
       minuto.setValueFactory(v3);minuto.setLayoutX(300);minuto.setLayoutY(146);
       hora_fin.setValueFactory(v4);hora_fin.setLayoutX(235);hora_fin.setLayoutY(184);
       minuto_fin.setValueFactory(v5);minuto_fin.setLayoutX(300);minuto_fin.setLayoutY(184);
       pacientes.setValueFactory(v1);pacientes.setLayoutX(235);pacientes.setLayoutY(224);
       hora.setPrefSize(52,25);
       minuto.setPrefSize(52,25);
       hora_fin.setPrefSize(52,25);
       minuto_fin.setPrefSize(52,25);
       pacientes.setPrefSize(52,25);
       brigadas.getChildren().addAll(pacientes,hora,minuto,hora_fin,minuto_fin);
       
       c_vendedor.getItems().removeAll(c_vendedor.getItems());
        datos= DB_Empleados.obtener_vendedores();
        for (int i = 0; i < datos.size(); i++) {
            c_vendedor.getItems().add(datos.get(i).getNombres() + " " + datos.get(i).getApellidos());
        }
       c_optometra.getItems().removeAll(c_optometra.getItems());
        data= DB_Empleados.obtener_optometras();
        for (int i = 0; i < data.size(); i++) {
            c_optometra.getItems().add(data.get(i).getNombres() + " " + data.get(i).getApellidos());
        }
    
    }
    
    
    @FXML private void seleccionar_optometra(){
    for (int i = 0; i < data.size(); i++) {
                    if (c_optometra.getValue().equals(data.get(i).getNombres()+" "+data.get(i).getApellidos())) {
                idOptometra = data.get(i).getIdEmpleado();
               
            }
        }
            System.out.println("idO:"+idOptometra);
    }
    
    @FXML private void seleccionar_vendedor(){
  for (int i = 0; i < datos.size(); i++) {
            if (c_vendedor.getValue().equals(datos.get(i).getNombres()+" "+datos.get(i).getApellidos())) {
                idVendedor = datos.get(i).getIdEmpleado();
            }
            System.out.println("idV:"+idVendedor);
  }   }
    @FXML private void registrar_brigadas(){
        String a=lugar.getText();
        if(!"".equals(a)){
        Date t=Date.valueOf(fecha.getValue());
        
        if (!"".equals(String.valueOf(t))&&!"".equals(a)&&idVendedor!=-1&&idOptometra!=-1) {
                Date f=Date.valueOf(fecha.getValue());
                String h_inicio=String.valueOf(hora.getValue())+":"+String.valueOf(minuto.getValue()+":00");
                String h_fin=String.valueOf(hora_fin.getValue())+":"+String.valueOf(minuto_fin.getValue()+":00");

                Brigadas nuevo = new Brigadas(lugar.getText(),f,h_inicio,h_fin,idVendedor,idOptometra,0,pacientes.getValue());
                DB_Brigadas.registrar_brigadas(nuevo);
                mostrar_mensaje("REGISTRO EXITOSO","LA BRIGADA FUE REGISTRADA CORRECTAMENTE");
            } 
            

       else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
        }
    
        }
        else {
            mostrar_mensaje("CAMPOS VACIOS","DEBE COMPLETAR LOS CAMPOS OBLIGATORIOS");
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
