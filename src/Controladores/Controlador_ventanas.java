package Controladores;

import Entidades.Clientes;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author creditos
 */
public class Controlador_ventanas implements Initializable {

    @FXML
    private TextField usuario;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane inicio, submenu, registros, proveedores, consultasR;

    @FXML
    private void ingresar(ActionEvent event) throws IOException {

        if (usuario.getText().equals("root") && password.getText().equals("sql")) {

            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
            this.inicio.getChildren().setAll(pane);

            System.out.println("Ingreso Correcto");
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR DE INGRESO");
            alert.setHeaderText("NO ES POSIBLE CONFIRMAR SU INGRESO");
            alert.setContentText("VERIFIQUE SU USUARIO Y CONTRASEÑA");

            alert.showAndWait();
        }
    }

    @FXML
    private void consultas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consultas_R.fxml"));
        this.submenu.getChildren().setAll(pane);
    }

    @FXML
    private void atras_Consultas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.consultasR.getChildren().setAll(pane);
    }
    
    @FXML
    private void b_empleados(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/empleados.fxml"));
        this.registros.getChildren().setAll(pane);
    }


    @FXML
    private void b_proveedores(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/proveedores.fxml"));
        this.registros.getChildren().setAll(pane);
    }

    @FXML
    private void b_clientes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/clientes.fxml"));
        this.registros.getChildren().setAll(pane);
    }

    @FXML
    private void registrar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.submenu.getChildren().setAll(pane);
    }

    @FXML
    private void b_productos(ActionEvent event) throws IOException {
        mostrar_opciones();

    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/principal.fxml"));
        this.submenu.getChildren().setAll(pane);
    }

    private void mostrar_opciones() throws IOException {
        ArrayList<String> choices = new ArrayList<>();
        choices.add("LENTES");
        choices.add("PAR_LUNAS");
        choices.add("ARMAZONES");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("LENTES", choices);
        dialog.setTitle("SELECCION DE PRODUCTOS");
        dialog.setHeaderText("PRODUCTOS");
        dialog.setContentText("SELECCIONE EL PRODUCTO QUE DESEA REGISTRAR");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if ("LENTES".equals(result.get())) {
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/lentes.fxml"));
                this.registros.getChildren().setAll(pane);
            }
            if ("PAR_LUNAS".equals(result.get())) {
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/par_lunas.fxml"));
                this.registros.getChildren().setAll(pane);
            }

            if ("ARMAZONES".equals(result.get())) {
                AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/armazon.fxml"));
                this.registros.getChildren().setAll(pane);
            }
        }

    }

    @FXML
    private void atras(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.registros.getChildren().setAll(pane);
    }

    @FXML
    private void atras_Proveedores(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/registros.fxml"));
        this.proveedores.getChildren().setAll(pane);
    }

    @FXML
    private void consultar_clientes(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consulta_clientes.fxml"));
        this.consultasR.getChildren().setAll(pane);
    }
    @FXML
    private void consultar_proveedores(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consulta_proveedores.fxml"));
        this.consultasR.getChildren().setAll(pane);
    }
   
    @FXML
    private void consultar_productos(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consultar_productos.fxml"));
        this.consultasR.getChildren().setAll(pane);
    }
    
     @FXML
    private void consultar_brigadas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/consulta_brigadas.fxml"));
        this.consultasR.getChildren().setAll(pane);
    }
    @FXML
    private void eliminar(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/P_eliminar.fxml"));
        this.submenu.getChildren().setAll(pane);
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

      @FXML
    private void b_brigadas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/brigadas.fxml"));
        this.registros.getChildren().setAll(pane);
    }
    
     @FXML
    private void web(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/pagina_web.fxml"));
        this.submenu.getChildren().setAll(pane);
    }
    
    @FXML
    private void b_ventas(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/ventas.fxml"));
        this.registros.getChildren().setAll(pane);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
