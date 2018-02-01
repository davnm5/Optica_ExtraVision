/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Entidades.Brigadas;
import Entidades.Ventas;

/**
 *
 * @author creditos
 */
public class DB_Ventas {
 

     public static void registrar_ventas(Ventas a)
{
            Gestionar_Base.crearprocedimiento("{call registrar_ventas(?,?,?,?,?,?,?)}");
            Gestionar_Base.asignarparametrosInt(1,a.getIdCompra());
            Gestionar_Base.asignarparametrosDate(2,a.getFecha());
            Gestionar_Base.asignarparametrosInt(3,a.getIdLentes());
            Gestionar_Base.asignarparametrosFloat(4,a.getTotal());
            Gestionar_Base.asignarparametrosString(5,a.getDescripcion());  
            Gestionar_Base.asignarparametrosInt(6,a.getIdVendedor());
            Gestionar_Base.asignarparametrosString(7,a.getCedula());
            Gestionar_Base.ejecutarprocedimiento();
            Gestionar_Base.cerrar();
}     
    
    
    
    
    
    
}
