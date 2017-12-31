/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Entidades.Clientes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author creditos
 */
public class DB_Clientes {
    
    
    public static ArrayList obtener_clientes(String a)
          {
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_clientes(?)}");
            Gestionar_Base.asignarparametrosString(1,a);
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Clientes d;
            d= new Clientes(r.getString("nombre"),r.getString("apellido"),r.getString("direccion"),
                    r.getString("cedula"),r.getString("telefono"),r.getInt("Empresa_idEmpresa"),r.getString("mail"));
            arreglo.add(d);
            System.out.println("nombre:"+r.getString("nombre"));
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
    
      
  public static void registrar_clientes(Clientes a)
{
            Gestionar_Base.crearprocedimiento("{call registrar_pacientes(?,?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosString(1,a.getNombre());
            Gestionar_Base.asignarparametrosString(2,a.getApellido());
            Gestionar_Base.asignarparametrosString(3,a.getDireccion());
            Gestionar_Base.asignarparametrosString(4,a.getCedula());
            Gestionar_Base.asignarparametrosString(5,a.getTelefono());  
            Gestionar_Base.asignarparametrosInt(6,a.getIdEmpresa());
            Gestionar_Base.asignarparametrosString(7,a.getMail());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar();
}
    
    
}
