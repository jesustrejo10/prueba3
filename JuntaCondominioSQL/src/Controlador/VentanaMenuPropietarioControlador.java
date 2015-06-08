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
import javax.swing.JOptionPane;

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

public static void ActualizaPropietarioSQL(String Clave, String PNombre, String SNombre, String PApellido , String SApellido , String FK_lugar)throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
    try (Connection Con = Conexion.Conectar()) {
       // JOptionPane.showMessageDialog(null,"entreee1");
        PreparedStatement pst=  Con.prepareStatement("update PROPIETARIO SET PRO_CLAVE="+Clave+",PRO_PNOMBRE = '"+PNombre+"',PRO_SNOMBRE = '"+SNombre+"',PRO_PAPELLIDO = '"+PApellido+"',PRO_SAPELLIDO = '"+SApellido+"',PRO_FK_LUGAR = "+FK_lugar+"" +
                "WHERE PRO_CLAVE ="+VentanaMenuPropietario.ClaveActualPropietario+"");
        //JOptionPane.showMessageDialog(null,"entreee2");
        
        pst.executeUpdate();
        //JOptionPane.showMessageDialog(null,"entreee3");
    }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error en"+ex);
     }
}

public static void EliminaPropietarioSQL()throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("DELETE PROPIETARIO " +
            "WHERE PRO_CLAVE ="+VentanaMenuPropietario.ClaveActualPropietario+"");
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
          ResultSet Valores= st.executeQuery("SELECT PRO_SNOMBRE, PRO_SAPELLIDO, PRO_FK_LUGAR "
                                                                          + "FROM PROPIETARIO"
                                                                         + " WHERE (PRO_CLAVE = "+Clave+")");
                    while (Valores.next()){
                              VentanaMenuPropietario.ForaneaPropietarioSeleccionado = Integer.toString(Valores.getInt(3));
                              VentanaMenuPropietario.SNombrePropietarioSeleccionado = Valores.getString(1);
                              VentanaMenuPropietario.SapellidoPropietarioSeleccionado = Valores.getString(2);
                              //JOptionPane.showMessageDialog(null,"Encontro al propietario ->"+Valores.getString(1));
                    }
    
          }

public static void RellenaComboParroquiaPropietarioSeleccionado (String Foranea) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          int fk_parroquia= 0;
          ResultSet Valores= st.executeQuery("SELECT LUG_NOMBRE,LUG_FK_LUGAR FROM LUGAR WHERE (LUG_CLAVE = "+Foranea+")");
                    while (Valores.next()){
                              VentanaMenuPropietario.ParroquiaPropietarioSeleccionado = Valores.getString(1);
                              fk_parroquia = Valores.getInt(2);
                    }
         int fk_Municipio = 0; 
          Valores= st.executeQuery("SELECT LUG_NOMBRE,LUG_FK_LUGAR FROM LUGAR WHERE (LUG_CLAVE = "+fk_parroquia+") and (LUG_TIPO = 'Municipio')");
                    while (Valores.next()){
                              VentanaMenuPropietario.MunicipioPropietarioSeleccionado =Valores.getString(1);
                              fk_Municipio = Valores.getInt(2);
                    }
          
          Valores= st.executeQuery("SELECT LUG_NOMBRE FROM LUGAR WHERE (LUG_CLAVE = "+fk_Municipio+") and (LUG_TIPO = 'Estado')");
                    while (Valores.next()){
                              VentanaMenuPropietario.EstadoPropietarioSeleccionado =Valores.getString(1);
                            
                    }          
          
          }
};


