/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuGestionDeFondos;
import Interfaz.VentanaGenerarContrato;
import static Interfaz.VentanaGenerarContrato.ClaveOficinaSeleccionada;
import Interfaz.VentanaMenuTrabajo;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
            

         public static void InsertarHonorariosSQL(String Monto, String ClaveOfi, String ClaveFondo, String Fecha) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          //DEBERIA INSERTAR EN EL LIBRO DE UNA VEZ!...
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO TRABAJO (TRA_CLAVE,TRA_DESCRIPCION,TRA_MONTO,TRA_CLASIFICACION,TRA_TIPO,TRA_SUSCEPTIBLE,TRA_FK_OFICINA,TRA_FK_CONT_FOND,TRA_F_REALIZADO,TRA_F_PROPUESTO,TRA_REALIZADO,TRA_APROBADO) \n" +
                                                                                            "  VALUES(SQ_PK_TRABAJO.NEXTVAL,'Honorarios Oficina',"+Monto+",'TRABAJO','ASAMBLEA','RENCIONIVA',"+ClaveOfi+","+ClaveFondo+",\n" +
                                                                                            "  TO_DATE('"+Fecha+"','YYYYMMDD'),TO_DATE('"+Fecha+"','YYYYMMDD'),'SI','SI')");
         
          pst.executeUpdate();    
          Con.close();
}

         
public static void ConsultaHonorarios(String ClaveContrato) throws SQLException{
       
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
         ResultSet Valores= st.executeQuery("select COUNT(AD.AD_CLAVE)\n" +
                                                                            "from APT_DET AD, EDIFICIO E, CONTRATO CON\n" +
                                                                            "WHERE AD.AD_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            "AND E.EDI_CLAVE = CON.CONT_FK_EDIFICIO\n" +
                                                                            "AND CON.CONT_CLAVE = "+ClaveContrato+"");
  
            while (Valores.next()){
                JOptionPane.showMessageDialog(null,Valores.getInt(1));
                float p =      Valores.getInt(1);
                MenuGestionDeFondos.Honorarios =    p * 220;

                   
            }

}



         public static void InsertarTrabajoSQL(String FK_fondo, String Monto) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          //DEBERIA INSERTAR EN EL LIBRO DE UNA VEZ!...
          PreparedStatement pst=  Con.prepareStatement(" insert into TRABAJO (TRA_APROBADO,TRA_CLAVE, TRA_FK_CONT_FOND,TRA_DESCRIPCION, TRA_MONTO , TRA_CLASIFICACION , TRA_TIPO , TRA_SUSCEPTIBLE , TRA_FK_OFICINA,TRA_F_PROPUESTO , TRA_F_REALIZADO,TRA_REALIZADO) \n" +
                                                                                                      "VALUES ( 'SI',"
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
          Con.close();
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