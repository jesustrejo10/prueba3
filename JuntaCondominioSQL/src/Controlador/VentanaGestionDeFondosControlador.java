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
public class VentanaGestionDeFondosControlador {
       
          public static void InsertarContFondosSQL(String Monto,String FK_FONDO , String FK_Contrato) throws SQLException{
                    ConexionOracle Conexion= new ConexionOracle();
                    Connection Con=Conexion.Conectar();
                    PreparedStatement pst=  Con.prepareStatement("INSERT INTO CONT_FOND VALUES(sq_pk_fondo_Contrato.NEXTVAL,"+FK_FONDO+","+FK_Contrato+","+Monto+")");
                    pst.executeUpdate(); 
   }
          public static void RegistraMontosEnTrabajo(){}
            
}
