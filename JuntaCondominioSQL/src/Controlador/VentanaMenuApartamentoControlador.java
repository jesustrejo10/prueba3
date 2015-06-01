/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaGenerarContrato;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jesus
 */
public class VentanaMenuApartamentoControlador {

    public static void InsertaAPTSQL( String Medidas) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO APARTAMENTO  (APT_CLAVE,APT_MEDIDAS) VALUES (SQ_PK_APARTAMENTO.NEXTVAL,'"+Medidas+"')");
          //pst.setString(2,Piso);
          //pst.setString(3,Medidas);
          pst.executeUpdate();    
}
    public static void InsertaAPT_DETSQL(Float Alicuota, String FK_Edificio, String FK_APT, String Venta, String Piso,Float Precio,String Fk_cuenta) throws SQLException{
        
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO APT_DET  (AD_CLAVE,AD_ALICUOTA,AD_FK_EDIFICIO,AD_FK_APARTAMENTO,AD_VENTA,AD_PISO,AD_PRECIO,AD_FK_CUENTA) "
                  + "                                                                               VALUES (SQ_PK_APT_DET.NEXTVAL,"+Alicuota+","+FK_Edificio+","+FK_APT+",'"+Venta+"','"+Piso+"',"+Precio+","+Fk_cuenta+")");
          pst.executeUpdate();    
}
    
    public static void InsertaCuenta_APT_DETSQL() throws SQLException{
        
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO CUENTA VALUES (SQ_PK_CUENTA.NEXTVAL,0,'NO_MOROSA')");
          pst.executeUpdate();    
}   
    
 public static String DevuelveClaveCuenta() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select MAX(CUE_CLAVE)\n" +
                                                                          " FROM CUENTA");
          while (Valores.next()){
                    return (Valores.getString(1));
          }
          return ("1");
    };

    
    
}
    

