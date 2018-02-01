/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Entidades.Brigadas;
import Entidades.Lunas;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author creditos
 */
public class DB_Brigadas {
    
     public static void registrar_brigadas(Brigadas a)
{
            Gestionar_Base.crearprocedimiento("{call registrar_brigadas(?,?,?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosInt(1,a.getIdBrigada());
            Gestionar_Base.asignarparametrosDate(2,a.getFecha());
            Gestionar_Base.asignarparametrosString(3,a.getHora_inicio());
            Gestionar_Base.asignarparametrosString(4,a.getHora_fin());
            Gestionar_Base.asignarparametrosInt(5,a.getN_pacientes());  
            Gestionar_Base.asignarparametrosString(6,a.getLugar());
            Gestionar_Base.asignarparametrosInt(7,a.getIdVendedor());
            Gestionar_Base.asignarparametrosInt(8,a.getIdOptometra());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar();
} 
    
      public static ArrayList obtener_brigadas(Date fecha){
  
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_brigadas(?)}");
            Gestionar_Base.asignarparametrosDate(1,fecha);
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Brigadas d;
            d= new Brigadas(r.getDate("fecha"),r.getString("hora_inicio"),r.getString("hora_fin"),r.getInt("numero_pacientes"),r.getString("lugar"));
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
