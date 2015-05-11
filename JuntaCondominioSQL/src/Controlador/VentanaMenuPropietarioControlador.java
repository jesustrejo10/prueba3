/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.VentanaMenuEdificioControlador.Estados;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class VentanaMenuPropietarioControlador {
    
public static ArrayList<String> Estados= new ArrayList();
public static ArrayList<String> Municipios = new ArrayList();
public static ArrayList<String> Parroquias = new ArrayList();


public static void llenarListaEstados() throws SQLException{
        
    ConexionOracle Conexion= new ConexionOracle();
    Connection Con=Conexion.Conectar();
    Statement st= Con.createStatement();
    ResultSet Valores= st.executeQuery("SELECT (LUG_NOMBRE) FROM LUGAR WHERE (LUG_TIPO = 'Estado')");
       while (Valores.next()){
            //JOptionPane.showMessageDialog(null,"AQUIII");
            Estados.add(Valores.getString(1));
       }
}

public static void insertaPropietarioSQL(String Clave, String PNombre, String SNombre, String PApellido , String SApellido , String FK_lugar)throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO PROPIETARIO  (PRO_CLAVE,PRO_PNOMBRE,PRO_SNOMBRE,PRO_PAPELLIDO,PRO_SAPELLIDO,PRO_FK_LUGAR) VALUES (?,?,?,?,?,?)");
          pst.setInt(1,Integer.parseInt(Clave));
          pst.setString(2,PNombre);
          pst.setString(3,SNombre);
          pst.setString(4,PApellido);
          pst.setString(5,SApellido);
          pst.setInt(6,Integer.parseInt(FK_lugar));
          pst.executeUpdate();    
}
        

}

