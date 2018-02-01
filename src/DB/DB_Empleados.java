/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Entidades.Armazones;
import Entidades.Clientes;
import Entidades.Empleados;
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
public class DB_Empleados {
    
    
      public static void registrar_empleado(Empleados a)
{
            Gestionar_Base.crearprocedimiento("{call registrar_empleado(?,?,?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosInt(1,a.getId());
            Gestionar_Base.asignarparametrosString(2,a.getNombres());
            Gestionar_Base.asignarparametrosString(3,a.getApellidos());
            Gestionar_Base.asignarparametrosString(4,a.getMail());
            Gestionar_Base.asignarparametrosString(5,a.getTelefono());  
            Gestionar_Base.asignarparametrosString(6,a.getDireccion());
            Gestionar_Base.asignarparametrosString(7,a.getTipo());
            Gestionar_Base.asignarparametrosFloat(8,a.getSueldo());
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
  
  public static ArrayList obtener_vendedores(){
  
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_vendedores()}");
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Empleados d;
            d= new Empleados(r.getString("nombre"),r.getString("apellido"),"vendedor",r.getInt("idVendedor"));
            arreglo.add(d);
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
  
    public static ArrayList obtener_optometras(){
  
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_optometras()}");
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Empleados d;
            d= new Empleados(r.getString("nombre"),r.getString("apellido"),"optometra",r.getInt("idOptometra"));
            arreglo.add(d);
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
    
}
