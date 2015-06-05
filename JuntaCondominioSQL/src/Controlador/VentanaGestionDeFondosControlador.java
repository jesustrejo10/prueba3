/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaGenerarContrato;
import static Interfaz.VentanaGenerarContrato.ClaveOficinaSeleccionada;
import Interfaz.VentanaMenuTrabajo;
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
public class VentanaGestionDeFondosControlador {
       
          public static void InsertarContFondosSQL(String Monto,String FK_FONDO , String FK_Contrato) throws SQLException{
                    ConexionOracle Conexion= new ConexionOracle();
                    Connection Con=Conexion.Conectar();
                    PreparedStatement pst=  Con.prepareStatement("INSERT INTO CONT_FOND VALUES(sq_pk_fondo_Contrato.NEXTVAL,"+FK_Contrato+","+FK_FONDO+","+Monto+")");
                    pst.executeUpdate(); 
   }
          public static void RegistraMontosEnTrabajo(){}
            



         public static void InsertarTrabajoSQL(String FK_fondo, String Monto) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          //DEBERIA INSERTAR EN EL LIBRO DE UNA VEZ!...
          PreparedStatement pst=  Con.prepareStatement(" insert into TRABAJO (TRA_CLAVE, TRA_FK_CONT_FOND,TRA_DESCRIPCION, TRA_MONTO , TRA_CLASIFICACION , TRA_TIPO , TRA_SUSCEPTIBLE , TRA_FK_OFICINA,TRA_F_PROPUESTO , TRA_F_REALIZADO,TRA_REALIZADO) \n" +
                                                                                                      "VALUES ("
                  + "                                                                              SQ_PK_TRABAJO.NEXTVAL,"
                  +"                                                                                "+FK_fondo+","
                  + "                                                                              'CREACION DE FONDO',"
                  + "                                                                              "+Monto+","
                  + "                                                                              'TRABAJO',"
                  + "                                                                              'FONDO',"
                  + "                                                                              'NORETENCIONIVA',"
                  + "                                                                              "+VentanaGenerarContrato.ClaveOficinaSeleccionada+","
                  + "                                                                              TO_DATE('"+VentanaGenerarContrato.FechaRealizado+"','YYYYMMDD'),"
                  + "                                                                              TO_DATE('"+VentanaGenerarContrato.FechaRealizado+"','YYYYMMDD'),"
                  + "                                                                              'SI' )");
          pst.executeUpdate();    
}


public static String DevuelveClave() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();

         ResultSet Valores= st.executeQuery("select MAX(CF_CLAVE) FROM CONT_FOND");
            while (Valores.next()){
                    return Integer.toString(Valores.getInt(1));
            }
    return ("1");
}
}