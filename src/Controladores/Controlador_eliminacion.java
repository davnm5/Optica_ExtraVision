package Controladores;

import DB.DB_Clientes;
import DB.DB_Proveedores;
import Entidades.Clientes;
import Entidades.Proveedores;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.CheckTreeView;

/**
 *
 * @author creditos
 */
public class Controlador_eliminacion {
    @FXML private AnchorPane P_eliminar,submenu;
    private boolean cl=false,pr=false,lt=false,l=false,ar=false,delete=true;
    private CheckTreeView tree;
    private CheckBoxTreeItem<String> items;
    private ObservableList<TreeItem> datos;
    private ArrayList<Clientes> clientes = new ArrayList();
    private ArrayList<Proveedores>proveedores = new ArrayList();
    
    @FXML
    public void initialize() {
        items = new CheckBoxTreeItem<String>("REGISTROS");
        items.setExpanded(true);
        tree= new CheckTreeView<>(items);
        tree.setLayoutX(134);tree.setLayoutY(110);tree.setPrefSize(379,258);
        tree.getCheckModel().getCheckedItems().addListener(new ListChangeListener<TreeItem<String>>() {
      public void onChanged(ListChangeListener.Change<? extends TreeItem<String>> c) {
          datos=(ObservableList<TreeItem>)tree.getCheckModel().getCheckedItems();
          
          
      }
 });
        P_eliminar.getChildren().add(tree);
    }
    
    @FXML private void clientes(){
        
        if(!cl){
            initialize();
            items.setValue(items.getValue()+" - CLIENTES");
           
           clientes = DB_Clientes.obtener_clientes();
        for (int i = 0; i <clientes.size(); i++) {
           items.getChildren().add(new CheckBoxTreeItem<String>(clientes.get(i).getNombre_c()+" "+clientes.get(i).getApellido_c()));
                      
        }
        
        cl=true;pr=false;
        }
 
    }
    
    @FXML private void proveedores(){
     if(!pr){
           initialize();
           items.setValue(items.getValue()+" - PROVEEDORES");
           proveedores = DB_Proveedores.obtener_Proveedores();
        for (int i = 0; i <proveedores.size(); i++) {
           items.getChildren().add(new CheckBoxTreeItem<String>(proveedores.get(i).getNombres()+" "+proveedores.get(i).getApellidos()));
                      
        }
        
        pr=true;cl=false;
        }
          
    }
    
    @FXML private void lentes(){}
    @FXML private void armazones(){}
    @FXML private void lunas(){}
    @FXML private void ventas(){}
    @FXML private void brigadas(){}
    
    @FXML private void salir() throws IOException{
       AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/Componentes/submenu.fxml"));
        this.P_eliminar.getChildren().setAll(pane); 
        
        
    }
    
    
    private LinkedList obtener_idCliente(){
        LinkedList<Clientes> lista_id=new LinkedList();
    for(int i=0;i<datos.size();i++){
    for(int j=0;j<clientes.size();j++){
        String cadena=clientes.get(j).getNombre_c()+" "+clientes.get(j).getApellido_c();
        if(cadena.equals(datos.get(i).getValue())){
            System.out.println(clientes.get(j).getId());
            lista_id.add(clientes.get(j));       
    }
    }
    }
    return lista_id;
    }
    
    private LinkedList obtener_idProveedor(){
        LinkedList<Proveedores> lista_id=new LinkedList();
    for(int i=0;i<datos.size();i++){
    for(int j=0;j<proveedores.size();j++){
        String cadena=proveedores.get(j).getNombres()+" "+proveedores.get(j).getApellidos();
        if(cadena.equals(datos.get(i).getValue())){
            System.out.println(proveedores.get(j).getIdProveedor());
            lista_id.add(proveedores.get(j));       
    }
    }
    }
    return lista_id;
    }
    
    
    
    
   
@FXML private void eliminar_todo(){
            if(cl){
            LinkedList<Clientes> lista_id=new LinkedList();
            lista_id=obtener_idCliente();
            confirmar();
            if(!delete){
            DB_Clientes.eliminar_clientes(lista_id);
            reestablecer();
            }
            delete=true;
            }
            
            if(pr){
            LinkedList<Proveedores> lista_id=new LinkedList();
            lista_id=obtener_idProveedor();
            confirmar();
            if(!delete){
            DB_Proveedores.eliminar_proveedores(lista_id);
            reestablecer();
            }
            delete=true;
            }
            
            
            
            
            
            
    }
    
    
    private void reestablecer(){
      CheckBoxTreeItem<String> aux=new CheckBoxTreeItem<>();
      
      for(int i=0;i<datos.size();i++){
            aux=(CheckBoxTreeItem<String>)datos.get(i);
            System.out.println("valor:"+aux.getValue()+"size:"+datos.size());
            items.getChildren().remove(aux);
      }
      datos.remove(aux);
    }
    
 private void mostrar_mensaje(String texto1,String texto2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(texto1);
                alert.setHeaderText(null);
                alert.setContentText(texto2);
                alert.showAndWait();
    
    }
private void confirmar(){
if(delete){
Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("CONFIRMACION DE ACCION");
alert.setHeaderText("LA SIGUIENTE ACCION SERÁ IRREVERSIBLE");
int n=datos.size();
alert.setContentText("CANTIDAD DE REGISTROS A ELIMINAR: "+n);

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    delete=false;  
} 

}


}

}
