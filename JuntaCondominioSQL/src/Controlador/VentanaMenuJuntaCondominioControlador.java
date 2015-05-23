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
import java.text.DateFormat;
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
          VentanaMenuJuntaCondominio.cont2 = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM EDIFICIO");
            while (Valores.next()){
                    RIF=Valores.getString(2);
                    Nombre=Valores.getString(3);
                    VentanaMenuJuntaCondominio.modeloEdificios.insertRow(VentanaMenuJuntaCondominio.cont2, new Object[]{});
                    VentanaMenuJuntaCondominio.modeloEdificios.setValueAt(RIF,VentanaMenuJuntaCondominio.cont2,0);
                    VentanaMenuJuntaCondominio.modeloEdificios.setValueAt(Nombre,VentanaMenuJuntaCondominio.cont2,1);
                    VentanaMenuJuntaCondominio.cont2++;
            }
 };
    
     public static void RellenaTablaJuntaCondominioSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String FechaInicio="";
          String FechaFin="";
          String NombreEdificio="";
          VentanaMenuJuntaCondominio.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT J.*,E.EDI_NOMBRE "
                                            + "FROM JUNTACONDOMINIO J, EDIFICIO E "
                                            + "WHERE J.JC_FK_EDIFICIO = E.EDI_CLAVE");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    FechaInicio=Valores.getString(2);
                    FechaFin=Valores.getString(3);
                    NombreEdificio=Valores.getString(5);
                    
                    FechaInicio= FechaInicio.substring(0,10);
                    FechaFin = FechaFin.substring(0, 10);
                    
                        
                    
                    VentanaMenuJuntaCondominio.modelo.insertRow(VentanaMenuJuntaCondominio.cont, new Object[]{});
                    VentanaMenuJuntaCondominio.modelo.setValueAt(ID,VentanaMenuJuntaCondominio.cont,0);
                    VentanaMenuJuntaCondominio.modelo.setValueAt(FechaInicio,VentanaMenuJuntaCondominio.cont,1);
                    VentanaMenuJuntaCondominio.modelo.setValueAt(FechaFin,VentanaMenuJuntaCondominio.cont,2);
                    VentanaMenuJuntaCondominio.modelo.setValueAt(NombreEdificio,VentanaMenuJuntaCondominio.cont,3);
                    VentanaMenuJuntaCondominio.cont++;
            }
 };
     
      public static void RellenaTablaJuntaSegunEdificioSQL(int ClaveEdificio) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String FechaInicio="";
          String FechaFin="";
          String NombreEdificio="";
          VentanaMenuJuntaCondominio.cont3 = 0;
          ResultSet Valores= st.executeQuery("SELECT J.JC_CLAVE, J.JC_FECHA_INICIAL, J.JC_FECHA_FIN,J.JC_FK_EDIFICIO,E.EDI_NOMBRE "
                                            + "FROM JUNTACONDOMINIO J, EDIFICIO E  "
                                            + "WHERE J.JC_FK_EDIFICIO=E.EDI_CLAVE AND J.JC_FK_EDIFICIO = "+ClaveEdificio+
                                              " GROUP BY J.JC_CLAVE, J.JC_FECHA_INICIAL, J.JC_FECHA_FIN,J.JC_FK_EDIFICIO,E.EDI_NOMBRE");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    FechaInicio=Valores.getString(2);
                    FechaFin=Valores.getString(3);
                    NombreEdificio=Valores.getString(5);
                    
                    FechaInicio= FechaInicio.substring(0,10);
                    FechaFin = FechaFin.substring(0, 10);
                    
                        
                    
                    VentanaMenuJuntaCondominio.modeloJuntaSegunEdificio.insertRow(VentanaMenuJuntaCondominio.cont3, new Object[]{});
                    VentanaMenuJuntaCondominio.modeloJuntaSegunEdificio.setValueAt(ID,VentanaMenuJuntaCondominio.cont3,0);
                    VentanaMenuJuntaCondominio.modeloJuntaSegunEdificio.setValueAt(FechaInicio,VentanaMenuJuntaCondominio.cont3,1);
                    VentanaMenuJuntaCondominio.modeloJuntaSegunEdificio.setValueAt(FechaFin,VentanaMenuJuntaCondominio.cont3,2);
                    
                    VentanaMenuJuntaCondominio.cont++;
            }
 };
     
     
     
     
     public static void EliminarJuntaCondominioSQL(String ClaveJunta) throws SQLException{
             ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("DELETE JUNTACONDOMINIO " +
            "WHERE JC_CLAVE ="+ClaveJunta+"");
          pst.executeUpdate(); 
         
     }
     
     public static void EliminarMiembrosSQL(String ClaveJunta) throws SQLException {
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("DELETE MIEMBRO " +
            "WHERE MIE_FK_JUNTACONDOMINIO ="+ClaveJunta+"");
          pst.executeUpdate(); 
     }
    

    public static void insertaJuntaCondominioSQL(String Clave, java.util.Date Fecha1, String FechaFin, String ClaveEdificio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
