/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaMenuEdificio;
import Interfaz.VentanaMenuJuntaCondominio;
import Interfaz.VentanaMiembros;
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
public class VentanaMiembrosControlador {
    
    
     public static void RellenaTablaMiembrosSQL(int Clave) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaMiembros.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT M.MIE_CARGO,P.PRO_PNOMBRE,P.PRO_PAPELLIDO,M.MIE_FK_PROPIETARIO "
                                                +"FROM MIEMBRO M,PROPIETARIO P "
                                                +"WHERE (M.MIE_FK_PROPIETARIO = P.PRO_CLAVE) AND (M.MIE_FK_JUNTACONDOMINIO ="+Clave+") "
                                                 +"GROUP BY MIE_CARGO,PRO_PNOMBRE,PRO_PAPELLIDO,MIE_FK_PROPIETARIO");                                  
            while (Valores.next()){
                    
                    VentanaMiembros.modeloMiembros.insertRow(VentanaMiembros.cont, new Object[]{});
                    VentanaMiembros.modeloMiembros.setValueAt(Valores.getString(1),VentanaMiembros.cont,0);
                    VentanaMiembros.modeloMiembros.setValueAt(Valores.getString(2),VentanaMiembros.cont,1);
                    VentanaMiembros.modeloMiembros.setValueAt(Valores.getString(3),VentanaMiembros.cont,2);
                    VentanaMiembros.modeloMiembros.setValueAt(Valores.getString(4),VentanaMiembros.cont,3);
                    VentanaMiembros.cont++;
            }
 };
     
     
     
     
     
     
     
    public static void RellenaTablaPropietariosSQL(int ClaveEdificio) throws SQLException {
        ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido="";
          VentanaMiembros.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT P.PRO_CLAVE,P.PRO_PNOMBRE,P.PRO_PAPELLIDO "+
                                             " FROM APT_DET Z,PROPIETARIO P "+
                                              "WHERE (Z.AD_FK_EDIFICIO ="+ClaveEdificio+") AND P.PRO_CLAVE= Z.AD_FK_PROPIETARIO "+
                                               "GROUP BY P.PRO_CLAVE,P.PRO_PNOMBRE,P.PRO_PAPELLIDO");                                  
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido= Valores.getString(3);
                    VentanaMiembros.modeloPropietarios.insertRow(VentanaMiembros.cont, new Object[]{});
                    VentanaMiembros.modeloPropietarios.setValueAt(ID,VentanaMiembros.cont,0);
                    VentanaMiembros.modeloPropietarios.setValueAt(Nombre,VentanaMiembros.cont,1);
                    VentanaMiembros.modeloPropietarios.setValueAt(Apellido,VentanaMiembros.cont,2);
                    VentanaMiembros.cont++;
            }
        
    };
    
    
    public static void RellenaTablaPropietarios2SQL(int ClaveEdificio,int ClaveP) throws SQLException{
        
         ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido="";
          VentanaMiembros.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT Z.AD_FK_PROPIETARIO,P.PRO_PNOMBRE,P.PRO_PAPELLIDO "+
                  "FROM (SELECT X.AD_FK_PROPIETARIO,X.AD_FK_EDIFICIO FROM APT_DET X WHERE (X.AD_FK_PROPIETARIO !="+ClaveP+")) Z,PROPIETARIO P "+
                  " WHERE   (Z.AD_FK_EDIFICIO ="+ClaveEdificio+") AND (Z.AD_FK_PROPIETARIO = P.PRO_CLAVE) AND (P.PRO_CLAVE != "+ClaveP+" )"+
                  " GROUP BY Z.AD_FK_PROPIETARIO,P.PRO_PNOMBRE,P.PRO_PAPELLIDO ");
          
          
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido= Valores.getString(3);
                    VentanaMiembros.modeloPropietarios.insertRow(VentanaMiembros.cont, new Object[]{});
                    VentanaMiembros.modeloPropietarios.setValueAt(ID,VentanaMiembros.cont,0);
                    VentanaMiembros.modeloPropietarios.setValueAt(Nombre,VentanaMiembros.cont,1);
                    VentanaMiembros.modeloPropietarios.setValueAt(Apellido,VentanaMiembros.cont,2);
                    VentanaMiembros.cont++;
            }
        
    };
    
      public static void ArrayPropietariosSQL(int ClaveEdificio) throws SQLException {
        ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          int ID =0;
          VentanaMiembros.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT P.PRO_CLAVE "+
                                             " FROM APT_DET Z,PROPIETARIO P "+
                                              "WHERE (Z.AD_FK_EDIFICIO ="+ClaveEdificio+") AND P.PRO_CLAVE= Z.AD_FK_PROPIETARIO "+
                                               "GROUP BY P.PRO_CLAVE");                                  
            while (Valores.next()){
                    ID=Integer.parseInt(Valores.getString(1));
                    VentanaMiembros.IdentificacionesPropietarios.add(ID);

            }
        
    };
      
public static void RellenaTablaPropietariosNoEnJuntaSQL(ArrayList Identificaciones,int ClaveJunta) throws SQLException {
    ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido="";
          VentanaMiembros.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT P.PRO_CLAVE,P.PRO_PNOMBRE,P.PRO_PAPELLIDO "+
                                            "FROM PROPIETARIO P,EDIFICIO E,JUNTACONDOMINIO JC, APT_DET AD "+
                                            "WHERE E.EDI_CLAVE=JC.JC_FK_EDIFICIO AND AD.AD_FK_EDIFICIO = E.EDI_CLAVE "+
                                            "AND AD.AD_FK_PROPIETARIO = P.PRO_CLAVE AND JC.JC_CLAVE= "+ClaveJunta+""+
                                            "AND P.PRO_CLAVE NOT IN ('"+Identificaciones.get(0)+"','"+Identificaciones.get(1)+"','"+Identificaciones.get(2)+"','"+Identificaciones.get(3)+"','"+Identificaciones.get(4)+"') "+
                                            "GROUP BY P.PRO_CLAVE, P.PRO_PNOMBRE, P.PRO_PAPELLIDO");
          
          
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido= Valores.getString(3);
                    VentanaMiembros.modeloPropietarios.insertRow(VentanaMiembros.cont, new Object[]{});
                    VentanaMiembros.modeloPropietarios.setValueAt(ID,VentanaMiembros.cont,0);
                    VentanaMiembros.modeloPropietarios.setValueAt(Nombre,VentanaMiembros.cont,1);
                    VentanaMiembros.modeloPropietarios.setValueAt(Apellido,VentanaMiembros.cont,2);
                    VentanaMiembros.cont++;
            }
    
};
      
 
    
   public static void insertaMiembrosSQL(String CargoMiembro ,Integer FK_Propietario , Integer FK_Junta ) throws SQLException {
       ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO MIEMBRO (MIE_CLAVE,MIE_CARGO,MIE_FK_PROPIETARIO,MIE_FK_JUNTACONDOMINIO) VALUES (SQ_PK_MIEMBROS.NEXTVAL,'"+CargoMiembro+"',"+FK_Propietario+","+FK_Junta+")");
          pst.executeUpdate(); 
       
   };
   
    public static void eliminaMiembrosSQL(int ClavePropietario,int ClaveJunta ) throws SQLException {
       ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst= Con.prepareStatement("DELETE  MIEMBRO WHERE MIE_FK_PROPIETARIO ="+ClavePropietario+" AND MIE_FK_JUNTACONDOMINIO= "+ClaveJunta); 
          pst.executeUpdate(); 
       
   };
    
    
    public static void RellenaTablaPropietariosDisponiblesSQL2(int ClaveJunta) throws SQLException{
 
       ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido="";
          VentanaMiembros.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT P.PRO_CLAVE,P.PRO_PNOMBRE,P.PRO_PAPELLIDO "+
                                            "FROM PROPIETARIO P,EDIFICIO E,JUNTACONDOMINIO JC, APT_DET AD "+
                                            "WHERE E.EDI_CLAVE=JC.JC_FK_EDIFICIO AND AD.AD_FK_EDIFICIO = E.EDI_CLAVE "+
                                            "AND AD.AD_FK_PROPIETARIO = P.PRO_CLAVE AND JC.JC_CLAVE= "+ClaveJunta+""+
                                            "AND P.PRO_CLAVE NOT IN ("+VentanaMiembros.MiembroSeleccionado+") "+
                                            "GROUP BY P.PRO_CLAVE, P.PRO_PNOMBRE, P.PRO_PAPELLIDO");
          
          
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido= Valores.getString(3);
                    VentanaMiembros.modeloPropietarios.insertRow(VentanaMiembros.cont, new Object[]{});
                    VentanaMiembros.modeloPropietarios.setValueAt(ID,VentanaMiembros.cont,0);
                    VentanaMiembros.modeloPropietarios.setValueAt(Nombre,VentanaMiembros.cont,1);
                    VentanaMiembros.modeloPropietarios.setValueAt(Apellido,VentanaMiembros.cont,2);
                    VentanaMiembros.cont++;
            }
 };
    


    
    
   
}
