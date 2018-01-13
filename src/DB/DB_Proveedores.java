/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Entidades.Armazones;
import Entidades.Empresas;
import Entidades.Proveedores;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author creditos
 */
public class DB_Proveedores {
   
    public static ArrayList obtener_Proveedores()
          {
            ArrayList arreglo=new ArrayList();
            ResultSet r;
            Gestionar_Base.crearprocedimiento("{call obtener_proveedores()}");
            Gestionar_Base.ejecutarprocedimiento();
            r=Gestionar_Base.obtenerprocedmiento();
        try {
            while(r.next())
            {
            Proveedores d;
            d= new Proveedores(r.getString("nombre"),r.getString("apellidos"),r.getString("direccion"),r.getString("mail")
            ,r.getFloat("comision"),r.getInt("idProveedor"),r.getString("telefono"));
            arreglo.add(d);
                
            }
            
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gestionar_Base.cerrar();
        return arreglo;
    }
    
    public static void registrar_Proveedores(Proveedores a)
{
            Gestionar_Base.crearprocedimiento("{call registrar_proveedores(?,?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosInt(1,a.getIdProveedor());
            Gestionar_Base.asignarparametrosString(2,a.getNombres());
            Gestionar_Base.asignarparametrosString(3,a.getApellidos());
            Gestionar_Base.asignarparametrosString(4,a.getTelefono());
            Gestionar_Base.asignarparametrosString(5,a.getMail());  
            Gestionar_Base.asignarparametrosFloat(6,a.getComision());
            Gestionar_Base.asignarparametrosString(7,a.getDireccion());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar();
}
    
    
    
}
