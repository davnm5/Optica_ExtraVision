
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optica_extravision;


import DB.Gestionar_Base;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author creditos
 */
public class Optica_ExtraVision extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("OPTICA EXTRA VISION");
        stage.getIcons().add(new Image("Media/icono.png"));
        
        Parent root = FXMLLoader.load(getClass().getResource("/Componentes/principal.fxml"));
        Gestionar_Base.conectar();
        Gestionar_Base.mostrar();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
