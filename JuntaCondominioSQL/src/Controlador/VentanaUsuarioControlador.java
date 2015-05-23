/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.VentanaMenuRolesControlador.Consultar_PK_ROL;
import Interfaz.VentanaMenuRoles;
import Interfaz.VentanaMenuUsuario;
import Modelo.ConexionOracle;
import Modelo.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jesus Trejo
 */
public class VentanaUsuarioControlador {
    
    public static JComboBox Roles;
    
    public static void LlenarComboBoxSQL() throws SQLException{
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Opcion = "";
        ResultSet Valores= st.executeQuery("SELECT ROL_NOMBRE FROM ROL");
            while (Valores.next()){
               Opcion=Valores.getString(1);
               Roles.addItem(Opcion);
            }
      
    }
    
    public static boolean CompruebaUsuarioDisponibleSQL(String usuario) throws SQLException{
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Comprueba = "";
        ResultSet Valores= st.executeQuery("SELECT USU_USUARIO FROM USUARIO");
            while (Valores.next()){
               Comprueba=Valores.getString(1);
               if (Comprueba.equalsIgnoreCase(usuario))
                   return false;
            }
        return true;
    }
    
    public static void initOutlets(JComboBox Roles){
        VentanaUsuarioControlador.Roles=Roles;
    
    }
    
    public static void InsertaUsuarioBD(String Usuario, String Password, String Rol) throws SQLException{
        
       String FKRol = Util.Consultar_PKPorNombre("ROL", "ROL_CLAVE", Rol, "ROL_NOMBRE");
      //JOptionPane.showMessageDialog(Roles,"LA CLAVE DE "+Rol+" Es: "+FKRol);
       String PKUsuario = Util.Consultar_PK_USUARIO("USUARIO", "USU_ CLAVE");
     // DEBO SUMAR UNO.
      //JOptionPane.showMessageDialog(Roles,"LA CLAVE DE USUARIO ES: "+PKUsuario);
    
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        PreparedStatement pst=  Con.prepareStatement("INSERT INTO USUARIO (USU_CLAVE,USU_USUARIO,USU_CONTRASENA,USU_FK_ROL) VALUES (?,?,?,?)");
        pst.setInt(1,Integer.parseInt(PKUsuario)+1);
        pst.setString(2,Usuario);
        pst.setString(3,Password);
        pst.setInt(4,Integer.parseInt(FKRol));
        pst.executeUpdate();
     
       
    }
    
    
}
