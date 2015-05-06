/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaMenuRoles;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Trejo
 */
public class VentanaMenuRolesControlador {
 
    
    public static void InsertarRolBD(String nombre , String descripcion) throws SQLException{
    
        
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        String Clave= Consultar_PK_ROL();
        VentanaMenuRoles.ClaveRol = Integer.parseInt(Clave)+1;
        PreparedStatement pst=  Con.prepareStatement("INSERT INTO ROL (ROL_CLAVE,ROL_NOMBRE,ROL_DESCRIPCION) VALUES (?,?,?)");
        pst.setInt(1,Integer.parseInt(Clave)+1);
        pst.setString(2,nombre);
        pst.setString(3,descripcion);
        pst.executeUpdate();
        
    }
     
    public static void InsertarRol_PERBD() throws SQLException{
    
       
       ConexionOracle Conexion= new ConexionOracle();
       Connection Con=Conexion.Conectar();
       for (String x : VentanaMenuRoles.AuxiliarPermisos){ 
        
            String Clave= Consultar_PK("ROLPER","RP_CLAVE");
            PreparedStatement pst=  Con.prepareStatement("INSERT INTO ROLPER (RP_CLAVE,RP_FK_PERMISO,RP_FK_ROL) VALUES (?,?,?)");
                try {
                    pst.setInt(1,Integer.parseInt(Clave)+1);
                    }catch(Exception E){
                    pst.setInt(1,1);
                    }
            pst.setInt(2,Integer.parseInt(x));
            pst.setInt(3,VentanaMenuRoles.ClaveRol);
            pst.executeUpdate();
           
        }
        Con.close();
    }
    
    public static String Consultar_PK_ROL() throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Clave="";
         ResultSet Valores= st.executeQuery("SELECT MAX(ROL_CLAVE) FROM ROL");
            while (Valores.next()){
                    Clave=Valores.getString(1);
                    
                }
        return Clave;
      
      }
     
    public static void RellenaTablaSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String nombre="";
        String descrip="";
       
         ResultSet Valores= st.executeQuery("SELECT ROL_NOMBRE, ROL_DESCRIPCION"
                                         + " FROM ROL");
            while (Valores.next()){
                    nombre=Valores.getString(1);
                    descrip=Valores.getString(2);
                    VentanaMenuRoles.modelo.insertRow(VentanaMenuRoles.cont, new Object[]{});
                    VentanaMenuRoles.modelo.setValueAt(nombre,VentanaMenuRoles.cont,0);
                    VentanaMenuRoles.modelo.setValueAt(descrip,VentanaMenuRoles.cont,1);
                    VentanaMenuRoles.cont++;
                    
                    
            }
 };
   
    public static String Consultar_PK(String Tabla, String NombreClave) throws SQLException{
      
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Clave="1";
        int conta = 0;
         ResultSet Valores= st.executeQuery("SELECT MAX("+NombreClave+") FROM "+Tabla);
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
     



}