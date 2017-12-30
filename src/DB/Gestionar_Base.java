
package DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Gestionar_Base {
    public static Connection con;
    private static CallableStatement procedimiento;

    
    public static void conectar() {
         try {
             int port = 3306;
             String host = "localhost";
             String db = "optica";
             String usuario = "root";
             String password = "david";
             String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);
             
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, usuario, password);
             
             System.out.println("conectado a la base de datos");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
         }


}
    
    public static void cerrar()
    {
        try {
            con.close();
            System.out.println("desconectado");
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
    }
    
    
     public static void insertar(String registro)
{
    conectar();
        try {
            Statement enviar=con.createStatement();
            enviar.execute(registro);
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
cerrar();
}
 
    public static ResultSet consultas(String registro)
  {
 
ResultSet resultado=null;
Statement enviar;
conectar();
        try {
            enviar=con.createStatement();
            resultado=(ResultSet) enviar.executeQuery(registro);
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        
return resultado;

  }
    

   public static void actualizar(String registro)
{
     Statement enviar;
    conectar();
    
        try {
            enviar=con.createStatement();
            enviar.executeUpdate(registro);
           
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
       

}  
   
  public static void crearprocedimiento(String sp)
{
       conectar();
        try {
            procedimiento=con.prepareCall(sp);
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
  public static void ejecutarprocedimiento()
{
        try {
           procedimiento.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
  public static void asignarparametrosString(int posicion,String argumento)
{
        try {
            procedimiento.setString(posicion, argumento);
        } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
   
public static void asignarparametrosInt(int posicion,int argumento)
{
        try {
           procedimiento.setInt(posicion, argumento);
          } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public static void asignarparametrosFloat(int posicion,float argumento)
{
        try {
            procedimiento.setFloat(posicion, argumento);
           } catch (SQLException ex) {
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public static ResultSet obtenerprocedmiento(){ 
    ResultSet resultado=null;
        try {
            resultado=procedimiento.getResultSet();
          } catch (SQLException ex) { 
            Logger.getLogger(Gestionar_Base.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    return resultado;
    
}
    

}
