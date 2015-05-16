/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
    

import Interfaz.VentanaMenuEdificio;
import Interfaz.VentanaMenuJuntaCondominio;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Gustavo
 */
public class VentanaMenuJuntaCondominioControlador {
    
    
   public static void  insertaJuntaCondominioSQL(String Clave, java.sql.Date FechaInicio, java.sql.Date FechaFin, String ClaveEdificio) throws SQLException, ParseException {
       ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO JUNTACONDOMINIO (JC_CLAVE,JC_FECHA_INICIAL,JC_FECHA_FIN,JC_FK_EDIFICIO) VALUES (?,?,?,?)");
          pst.setInt(1,Integer.parseInt(Clave));
          pst.setDate(2, FechaInicio);
           pst.setDate(3, FechaFin);
          pst.setInt(4,Integer.parseInt(ClaveEdificio));
          pst.executeUpdate(); 
   }
    
    public static void RellenaTablaSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String RIF="";
          String Nombre="";
          VentanaMenuJuntaCondominio.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM EDIFICIO");
            while (Valores.next()){
                    RIF=Valores.getString(2);
                    Nombre=Valores.getString(3);
                    VentanaMenuJuntaCondominio.modelo.insertRow(VentanaMenuJuntaCondominio.cont, new Object[]{});
                    VentanaMenuJuntaCondominio.modelo.setValueAt(RIF,VentanaMenuJuntaCondominio.cont,0);
                    VentanaMenuJuntaCondominio.modelo.setValueAt(Nombre,VentanaMenuJuntaCondominio.cont,1);
                    VentanaMenuJuntaCondominio.cont++;
            }
 };

    public static void insertaJuntaCondominioSQL(String Clave, java.util.Date Fecha1, String FechaFin, String ClaveEdificio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
