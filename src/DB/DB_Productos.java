/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Entidades.Armazones;
import Entidades.Clientes;
import Entidades.Empresas;
import Entidades.Lentes;
import Entidades.Lunas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author creditos
 */
public class DB_Productos {
    
    
         
  public static void registrar_armazones(Armazones a)
{
            Gestionar_Base.crearprocedimiento("{call registrar_armazones(?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosString(1,a.getDescripcion());
            Gestionar_Base.asignarparametrosString(2,a.getMarca());
            Gestionar_Base.asignarparametrosFloat(3,a.getPrecio());
            Gestionar_Base.asignarparametrosInt(4,a.getCantidad());
            Gestionar_Base.asignarparametrosInt(5,0);  
            Gestionar_Base.asignarparametrosInt(6,a.getIdProveedor());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar();
}
  
  public static void registrar_lunas(Lunas a) {
        Gestionar_Base.crearprocedimiento("{call registrar_lunas(?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosInt(1,a.getIdLunas());
            Gestionar_Base.asignarparametrosFloat(2,a.getPrecio());
            Gestionar_Base.asignarparametrosString(3,a.getTipo());
            Gestionar_Base.asignarparametrosInt(6,a.getCantidad());
            Gestionar_Base.asignarparametrosString(5,a.getDescripcion());  
            Gestionar_Base.asignarparametrosInt(4,a.getIdProveedor());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar(); 
    }
  
  public static void registrar_lentes(Lentes a){
     Gestionar_Base.crearprocedimiento("{call registrar_lentes(?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosInt(1,a.getIdLente());
            Gestionar_Base.asignarparametrosFloat(2,a.getPrecio());
            Gestionar_Base.asignarparametrosInt(3,a.getIdLunas());
            Gestionar_Base.asignarparametrosInt(4,a.getIdArmazon());
            Gestionar_Base.asignarparametrosString(5,a.getDescripcion());  
            Gestionar_Base.asignarparametrosInt(6,a.getCantidad());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar();  
  }
    
  public static ArrayList obtener_lunas(){
  
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_lunas()}");
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Lunas d;
            d= new Lunas(r.getInt("idLunas"),r.getString("descripcion"),r.getString("tipo"));
            arreglo.add(d);
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
  
  public static ArrayList obtener_armazones(){
  
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_armazones()}");
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Armazones d;
            d= new Armazones(r.getInt("idArmazon"),r.getString("marca"),r.getFloat("precio"));
            arreglo.add(d);
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
  
  
    public static ArrayList obtener_lentes(){
  
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_lentes()}");
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Lentes d;
            d= new Lentes(r.getInt("idLente"),r.getString("tipo"),r.getString("marca"));
            arreglo.add(d);
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
    
     
    public static ArrayList obtener_lentes(String a)
          {
            
            String s[]=a.split("#");
            ArrayList<Lentes> arreglo=new ArrayList();
            System.out.println(s[1]);
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call descripcion_lentes(?)}");
            Gestionar_Base.asignarparametrosInt(1,Integer.parseInt(s[1]));
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Lentes d;
            d= new Lentes(r.getInt("idLente"),r.getString("descripcion"),r.getFloat("precio"),r.getInt("cantidad"),r.getString("marca"),
                    r.getString("tipo"),r.getString("descripcion_armazon"),r.getString("descripcion_lunas"));
            arreglo.add(d);
            System.out.println("tipo"+arreglo.get(0).getTipo());
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
  
  }
    
    
  
