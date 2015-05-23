/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public static void InsertaAPT_DETSQL(Float Alicuota, String FK_Edificio, String FK_APT, String Venta, String Piso,Float Precio) throws SQLException{
        
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO APT_DET  (AD_CLAVE,AD_ALICUOTA,AD_FK_EDIFICIO,AD_FK_APARTAMENTO,AD_VENTA,AD_PISO,AD_PRECIO) VALUES (SQ_PK_APT_DET.NEXTVAL,"+Alicuota+","+FK_Edificio+","+FK_APT+",'"+Venta+"','"+Piso+"',"+Precio+")");
          pst.executeUpdate();    
}
    
    
    
    
}
    

