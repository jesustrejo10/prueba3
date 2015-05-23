/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Trejo
 */
public class Util {
 
    public static String Consultar_PK(String Tabla, String NombreClave) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Clave="1";
        int conta = 0;
        JOptionPane.showConfirmDialog(null, "Antes");
         ResultSet Valores= st.executeQuery("SELECT MAX("+NombreClave+") FROM "+Tabla);
        JOptionPane.showConfirmDialog(null, "DESPUES");
         
         while (Valores.next()){
                    Clave=Valores.getString(1);
                    conta++;
                }
          JOptionPane.showMessageDialog(null,"el conta DEVUELTA ES:"+Integer.toString(conta));
          if (conta >=1)
            return Clave;
          else
            return ("0");
         
      }
   
    public static String Consultar_PK_EDIFICIO(String Tabla, String NombreClave) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Clave="1";
        int conta = 0;
       // JOptionPane.showConfirmDialog(null, "Antes");
         ResultSet Valores= st.executeQuery("SELECT MAX(EDI_CLAVE) FROM EDIFICIO");
        //JOptionPane.showConfirmDialog(null, "DESPUES");
         
         while (Valores.next()){
                    Clave=Valores.getString(1);
                    conta++;
                }
          JOptionPane.showMessageDialog(null,"el conta DEVUELTA ES:"+Integer.toString(conta));
          if (conta >=1)
            return Clave;
          else
            return ("0");
         
      }
    
    public static String Consultar_PK_EdificioConRif(String Rif) throws SQLException {
         ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        ResultSet Valores= st.executeQuery("SELECT EDI_CLAVE FROM EDIFICIO WHERE EDI_RIF ='"+Rif+"'  ");
            while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"AQUIII");
                    String Clave=Valores.getString(1);
                    return (Clave);
                }
        return ("false");
    }
    
    
    
    
    public static String Consultar_PK_EdificioConClaveJunta(Integer ClaveJunta) throws SQLException {
         ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        ResultSet Valores= st.executeQuery("SELECT JC_FK_EDIFICIO FROM  JUNTACONDOMINIO WHERE JC_CLAVE ="+ClaveJunta+"");
            while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"AQUIII");
                    String Clave=Valores.getString(1);
                    return (Clave);
                }
        return ("false");
    }
    
   
    
     public static String Consultar_PK_USUARIO(String Tabla, String NombreClave) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Clave="1";
        int conta = 0;
        //JOptionPane.showConfirmDialog(null, "Antes");
         ResultSet Valores= st.executeQuery("SELECT MAX(USU_CLAVE)  FROM USUARIO");
        //JOptionPane.showConfirmDialog(null, "DESPUES");
         
         while (Valores.next()){
                    Clave=Valores.getString(1);
                    conta++;
                }
         // JOptionPane.showMessageDialog(null,"el conta DEVUELTA ES:"+Integer.toString(conta));
          if (conta >=1)
            return Clave;
          else
            return ("0");
         
      }
    
   
    
    public static String Consultar_PKPorNombre(String Tabla, String NombreClave, String ABuscar , String AComparar) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
         ResultSet Valores= st.executeQuery("SELECT ("+NombreClave+") FROM "+Tabla+" WHERE ( '"+ABuscar+"' = "+AComparar+" ) ");
            while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"AQUIII");
                    String Clave=Valores.getString(1);
                    return (Clave);
                }
        return ("false");
     }
    public static String Consultar_PKPorNombreMunicipios(String Tabla, String NombreClave, String ABuscar , String AComparar, String ClaveForanea) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        ResultSet Valores= st.executeQuery("SELECT ("+NombreClave+") FROM "+Tabla+" WHERE ( '"+ABuscar+"' = "+AComparar+" )  and (LUG_TIPO = 'Municipio') and (LUG_FK_LUGAR = "+ClaveForanea+")");
            while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"AQUIII");
                    String Clave=Valores.getString(1);
                    return (Clave);
                }
        return ("false");
     }
    
    public static String Consultar_PKPorNombreParroquia(String Tabla, String NombreClave, String ABuscar , String AComparar, String ClaveForanea) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
         ResultSet Valores= st.executeQuery("SELECT ("+NombreClave+") FROM "+Tabla+" WHERE ( '"+ABuscar+"' = "+AComparar+" )  and (LUG_TIPO = 'Parroquia') and (LUG_FK_LUGAR = "+ClaveForanea+")");
            while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"AQUIII");
                    String Clave=Valores.getString(1);
                    return (Clave);
                }
        return ("false");
     }
    
    
}
