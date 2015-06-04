/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaMenuFondos;
import Interfaz.VentanaMenuJuntaCondominio;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gustavo
 */
public class VentanaMenuFondosControlador {
    
    
        public static void RellenaTablaSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String RIF="";
          String Nombre="";
          VentanaMenuFondos.cont2 = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM EDIFICIO");
            while (Valores.next()){
                    RIF=Valores.getString(2);
                    Nombre=Valores.getString(3);
                    VentanaMenuFondos.modeloEdificios.insertRow(VentanaMenuFondos.cont2, new Object[]{});
                    VentanaMenuFondos.modeloEdificios.setValueAt(RIF,VentanaMenuFondos.cont2,0);
                    VentanaMenuFondos.modeloEdificios.setValueAt(Nombre,VentanaMenuFondos.cont2,1);
                    VentanaMenuFondos.cont2++;
            }
 };
        
        public static void RellenaTablaContratosSQL(String ClaveEdif) throws SQLException {
            ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          int clave = Integer.parseInt(ClaveEdif);
          String ID="";
          String NombreOficina="";
          VentanaMenuFondos.cont3 = 0;
          ResultSet Valores= st.executeQuery("SELECT C.CONT_CLAVE, O.OFI_NOMBRE , O.OFI_CLAVE " +
                                            "FROM CONTRATO C, OFICINA O, EDIFICIO E " +
                                            "WHERE C.CONT_FK_OFICINA=O.OFI_CLAVE AND C.CONT_FK_EDIFICIO = "+clave+
                                            " GROUP BY C.CONT_CLAVE, O.OFI_NOMBRE, O.OFI_CLAVE");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    NombreOficina=Valores.getString(2);
                    VentanaMenuFondos.IdentificacionesOficinas.add(VentanaMenuFondos.cont3, Valores.getString(3));
                    
                    VentanaMenuFondos.modeloContratos.insertRow(VentanaMenuFondos.cont3, new Object[]{});
                    VentanaMenuFondos.modeloContratos.setValueAt(ID,VentanaMenuFondos.cont3,0);
                    VentanaMenuFondos.modeloContratos.setValueAt(NombreOficina,VentanaMenuFondos.cont3,1);
                    VentanaMenuFondos.cont3++;
            }
            
        };
        
       public static void RellenaTablaFondosSQL(int ClaveContrato) throws SQLException{
               ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String Clave="";
          String Tipo="";
          float Monto=0;
          VentanaMenuFondos.cont4 = 0;
          ResultSet Valores= st.executeQuery("SELECT F.FON_CLAVE,F.FON_TIPO,C.CF_MONTO " +
"FROM CONT_FOND C, FONDO F " +
"WHERE C.CF_FK_CONTRATO="+ClaveContrato+" AND F.FON_CLAVE=C.CF_FK_FONDO");

            while (Valores.next()){
                    Clave=Valores.getString(1);
                    Tipo=Valores.getString(2);
                    Monto=Float.parseFloat(Valores.getString(3));
                    
                    VentanaMenuFondos.modeloFondos.insertRow(VentanaMenuFondos.cont4, new Object[]{});
                    VentanaMenuFondos.modeloFondos.setValueAt(Clave,VentanaMenuFondos.cont4,0);
                    VentanaMenuFondos.modeloFondos.setValueAt(Tipo,VentanaMenuFondos.cont4,1);
                    VentanaMenuFondos.modeloFondos.setValueAt(Monto,VentanaMenuFondos.cont4,2);
                    VentanaMenuFondos.cont4++;
            }
       };
       
       
       public static void RestarAlFondoEmisorSQL(int MontoParaRestar,int ClaveContrato, int ClaveFondo) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("update CONT_FOND SET CF_MONTO = CF_MONTO-"+MontoParaRestar+
                                                        " WHERE CF_FK_CONTRATO = "+ClaveContrato+" AND CF_FK_FONDO= "+ClaveFondo);
                 
          pst.executeUpdate();    

       };
       
              public static void SumarAlFondoReceptorSQL(int MontoParaRestar,int ClaveContrato, int ClaveFondo) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("update CONT_FOND SET CF_MONTO = CF_MONTO+"+MontoParaRestar+
                                                        " WHERE CF_FK_CONTRATO = "+ClaveContrato+" AND CF_FK_FONDO= "+ClaveFondo);
                 
          pst.executeUpdate();    

       };
        
        
        
}
