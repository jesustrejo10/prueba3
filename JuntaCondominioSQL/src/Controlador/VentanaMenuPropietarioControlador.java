/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.VentanaMenuEdificioControlador.Estados;
import Interfaz.VentanaMenuEdificio;
import Interfaz.VentanaMenuPropietario;
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
        
public static void RellenaTablaSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String ID="";
        String Nombre="";
        String Apellido ="";
        VentanaMenuPropietario.cont = 0;
         ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM PROPIETARIO");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido = Valores.getString(4);
                    VentanaMenuPropietario.modelo.insertRow(VentanaMenuPropietario.cont, new Object[]{});
                    VentanaMenuPropietario.modelo.setValueAt(ID,VentanaMenuPropietario.cont,0);
                    VentanaMenuPropietario.modelo.setValueAt(Nombre,VentanaMenuPropietario.cont,1);
                    VentanaMenuPropietario.modelo.setValueAt(Apellido,VentanaMenuPropietario.cont,2);
                    VentanaMenuPropietario.cont++;
            }
 };

public static void RellenaCamposFaltantes(String Clave) throws SQLException{

          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("SELECT (PRO_SNOMBRE, PRO_SAPELLIDO, PRO_FK_LUGAR) FROM PROPIETARIO WHERE (PRO_CLAVE = '"+Clave+"')");
                    while (Valores.next()){
                              VentanaMenuPropietario.ForaneaPropietarioSeleccionado = Integer.toString(Valores.getInt(3));
                              VentanaMenuPropietario.SNombrePropietarioSeleccionado = Valores.getString(1);
                              VentanaMenuPropietario.SapellidoPropietarioSeleccionado = Valores.getString(2);
                    }
    
          }

}

