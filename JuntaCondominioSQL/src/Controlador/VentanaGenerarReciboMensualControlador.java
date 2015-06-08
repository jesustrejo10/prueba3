/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaGenerarReciboMensual;
import Interfaz.VentanaMenuEdificio;
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
public class VentanaGenerarReciboMensualControlador {
    
    public static void RellenaTablaEdificiosSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        VentanaGenerarReciboMensual.cont = 0;
         ResultSet Valores= st.executeQuery("select E.EDI_RIF , E.EDI_NOMBRE, L.LUG_NOMBRE \n" +
                                                                            "from EDIFICIO E, LUGAR L \n" +
                                                                            "WHERE E.EDI_FK_LUGAR = L.LUG_CLAVE");
            while (Valores.next()){
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaGenerarReciboMensual.ModeloEdificios.insertRow(VentanaGenerarReciboMensual.cont, new Object[]{});
                    VentanaGenerarReciboMensual.ModeloEdificios.setValueAt(Rif,VentanaGenerarReciboMensual.cont,0);
                    VentanaGenerarReciboMensual.ModeloEdificios.setValueAt(Nombre,VentanaGenerarReciboMensual.cont,1);
                    VentanaGenerarReciboMensual.ModeloEdificios.setValueAt(Valores.getString(3),VentanaGenerarReciboMensual.cont,2);
                    VentanaGenerarReciboMensual.cont++;
            }
 }

     public static void RellenaTablaTrabajosDisponiblesSQL(String ClaveEdif) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGenerarReciboMensual.cont = 0;
          ResultSet Valores= st.executeQuery(" select T.TRA_CLAVE, T.TRA_DESCRIPCION,  T.TRA_F_REALIZADO, T.TRA_MONTO, T.TRA_TIPO\n" +
                                                                            " from TRABAJO T, CONT_FOND CF, CONTRATO CON, EDIFICIO E\n" +
                                                                            " WHERE T.TRA_FK_CONT_FOND = CF.CF_CLAVE\n" +
                                                                            " AND CON.CONT_CLAVE = CF.CF_FK_CONTRATO\n" +
                                                                            " AND E.EDI_CLAVE = CON.CONT_FK_EDIFICIO\n" +
                                                                            " AND T.TRA_APROBADO = 'SI'"+
                                                                            " AND E.EDI_CLAVE = "+ClaveEdif+"\n" +
                                                                            " AND T.TRA_FK_RECIBOMENSUAL IS NULL\n" +
                                                                            " AND CON.CONT_FECHA_EMISION = (SELECT MAX(CON.CONT_FECHA_EMISION)\n" +
                                                                            "                              FROM CONTRATO CON\n" +
                                                                            "                              WHERE CON.CONT_FK_EDIFICIO = E.EDI_CLAVE)");
          while (Valores.next()){

                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.insertRow(VentanaGenerarReciboMensual.cont, new Object[]{});
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getInt(1),VentanaGenerarReciboMensual.cont,0);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getString(2),VentanaGenerarReciboMensual.cont,1);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getDate(3),VentanaGenerarReciboMensual.cont,2);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getString(4),VentanaGenerarReciboMensual.cont,3);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getString(5),VentanaGenerarReciboMensual.cont,4);
                    VentanaGenerarReciboMensual.cont++;
          }
          Con.close();
 };
   
     public static String CalculaPrecioRecibo() throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("    SELECT SUM(T.TRA_MONTO) AS MONTORECIBO\n" +
                                                                            "     from TRABAJO T  \n" +
                                                                            "    WHERE (T.TRA_CLAVE IN ("+VentanaGenerarReciboMensual.TrabajosSeleccionados+"))");
          while (Valores.next()){
                    return Float.toString(Valores.getFloat(1));
          }     
          float returnx = 0;
          return ("0");
     };    
  
      public static String CalculaJuntaActual(String Clave) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select JC_CLAVE \n" +
                                                                              " from JUNTACONDOMINIO, EDIFICIO E\n" +
                                                                              " where \n" +
                                                                              " E.EDI_CLAVE = JUNTACONDOMINIO.JC_FK_EDIFICIO AND\n" +
                                                                              " E.EDI_CLAVE = "+Clave+" AND\n" +
                                                                          "    JC_FECHA_FIN = (select MAX(JC_FECHA_FIN)\n" +    
                                                                          "                                     FROM JUNTACONDOMINIO) " );
          while (Valores.next()){
                    return Integer.toString(Valores.getInt(1));
          }     
          return ("0");
     }; 
     
     public static String CalculaPrecioRecibo2() throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("    SELECT SUM(T.TRA_MONTO) AS MONTORECIBO\n" +
                                                                            "     from TRABAJO T  \n" +
                                                                            "    WHERE (T.TRA_CLAVE IN ("+VentanaGenerarReciboMensual.TrabajosSeleccionados+"))");
          while (Valores.next()){
                    return Float.toString(Valores.getFloat(1));
          }     
          float returnx = 0;
          return ("0");
     };
     
     public static void RellenaTablaTrabajosDisponiblesSQL2(String ClaveEdif) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGenerarReciboMensual.cont = 0;
          ResultSet Valores= st.executeQuery(" select T.TRA_CLAVE, T.TRA_DESCRIPCION,  T.TRA_F_REALIZADO, T.TRA_MONTO, T.TRA_TIPO\n" +
                                                                            "  from TRABAJO T, CONT_FOND CF, CONTRATO CON, EDIFICIO E\n" +
                                                                            "  WHERE T.TRA_FK_CONT_FOND = CF.CF_CLAVE\n" +
                                                                            "  AND CON.CONT_CLAVE = CF.CF_FK_CONTRATO\n" +
                                                                            "  AND E.EDI_CLAVE = CON.CONT_FK_EDIFICIO\n" +
                                                                            "  AND E.EDI_CLAVE = "+ClaveEdif+"\n" +
                                                                            " AND T.TRA_APROBADO = 'SI'"+
                                                                            "  AND T.TRA_FK_RECIBOMENSUAL IS NULL\n" +
                                                                            "  AND (T.TRA_CLAVE NOT IN ("+VentanaGenerarReciboMensual.TrabajosSeleccionados+"))\n" +
                                                                            "  AND CON.CONT_FECHA_EMISION = (SELECT MAX(CON.CONT_FECHA_EMISION)\n" +
                                                                                                                "                                  FROM CONTRATO CON\n" +
                                                                                                                "                                  WHERE CON.CONT_FK_EDIFICIO = E.EDI_CLAVE)");
          while (Valores.next()){

                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.insertRow(VentanaGenerarReciboMensual.cont, new Object[]{});
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getInt(1),VentanaGenerarReciboMensual.cont,0);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getString(2),VentanaGenerarReciboMensual.cont,1);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getDate(3),VentanaGenerarReciboMensual.cont,2);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getString(4),VentanaGenerarReciboMensual.cont,3);
                    VentanaGenerarReciboMensual.ModeloTrabajosDisponibles.setValueAt(Valores.getString(5),VentanaGenerarReciboMensual.cont,4);
                    VentanaGenerarReciboMensual.cont++;
          }
          Con.close();
 };
    
     public static void RellenaTablaTrabajosDisponiblesSQL3(String ClaveEdif) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGenerarReciboMensual.cont = 0;
          ResultSet Valores= st.executeQuery(" select T.TRA_CLAVE, T.TRA_DESCRIPCION,  T.TRA_F_REALIZADO, T.TRA_MONTO, T.TRA_TIPO\n" +
                                                                            "  from TRABAJO T, CONT_FOND CF, CONTRATO CON, EDIFICIO E\n" +
                                                                            "  WHERE T.TRA_FK_CONT_FOND = CF.CF_CLAVE\n" +
                                                                            "  AND CON.CONT_CLAVE = CF.CF_FK_CONTRATO\n" +
                                                                            "  AND E.EDI_CLAVE = CON.CONT_FK_EDIFICIO\n" +
                                                                            "  AND E.EDI_CLAVE = "+ClaveEdif+"\n" +
                                                                            "  AND T.TRA_APROBADO = 'SI'"+                                                          
                                                                            "  AND T.TRA_FK_RECIBOMENSUAL IS NULL\n" +
                                                                            "  AND (T.TRA_CLAVE IN ("+VentanaGenerarReciboMensual.TrabajosSeleccionados+"))\n" +
                                                                            "  AND CON.CONT_FECHA_EMISION = (SELECT MAX(CON.CONT_FECHA_EMISION)\n" +
                                                                                                                "                                  FROM CONTRATO CON\n" +
                                                                                                                "                                  WHERE CON.CONT_FK_EDIFICIO = E.EDI_CLAVE)");
          
          while (Valores.next()){

                    VentanaGenerarReciboMensual.ModeloTrabajosAsignados.insertRow(VentanaGenerarReciboMensual.cont, new Object[]{});
                    VentanaGenerarReciboMensual.ModeloTrabajosAsignados.setValueAt(Valores.getInt(1),VentanaGenerarReciboMensual.cont,0);
                    VentanaGenerarReciboMensual.ModeloTrabajosAsignados.setValueAt(Valores.getString(2),VentanaGenerarReciboMensual.cont,1);
                    VentanaGenerarReciboMensual.ModeloTrabajosAsignados.setValueAt(Valores.getDate(3),VentanaGenerarReciboMensual.cont,2);
                    VentanaGenerarReciboMensual.ModeloTrabajosAsignados.setValueAt(Valores.getString(4),VentanaGenerarReciboMensual.cont,3);
                    VentanaGenerarReciboMensual.ModeloTrabajosAsignados.setValueAt(Valores.getString(5),VentanaGenerarReciboMensual.cont,4);
                    VentanaGenerarReciboMensual.cont++;
          }
          Con.close();
 };
     
     public static void InsertaReciboMensualSQL(String fk_Junta, String Fecha) throws SQLException{
         if (fk_Junta.equalsIgnoreCase(""))
                    JOptionPane.showMessageDialog(null,"Error, para generar un recibo el edificio debe tener una Juntade Condominio");
         else{
                    ConexionOracle Conexion= new ConexionOracle();
                    Connection Con=Conexion.Conectar();
                    PreparedStatement pst=  Con.prepareStatement("INSERT INTO RECIBOMENSUAL VALUES (SQ_RECIBO_MENSUAL.NEXTVAL,TO_DATE('"+Fecha+"','YYYYMMDD'),'APROBADO',"+fk_Junta+")");
                    pst.executeUpdate();    
          }        
     }

     public static void ActualizaTrabajoAPasado(String fk_Recibo, String ClaveTrabajo) throws SQLException{
     
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con = Conexion.Conectar(); 
          Statement st= Con.createStatement();
          PreparedStatement pst=  Con.prepareStatement("update TRABAJO set TRA_FK_RECIBOMENSUAL = "+fk_Recibo+"  \n" +
                                                                                                     "where TRA_CLAVE = "+ClaveTrabajo);
          pst.executeUpdate();
     }
     
       public static void InsertaAvisoCobroSQL(String FK_RECIBOMENSUAL) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
        try (Connection Con = Conexion.Conectar()) {
            Statement st= Con.createStatement();
            ResultSet Valores= st.executeQuery(" select C.CUE_CLAVE , AD.AD_ALICUOTA\n" +
                                                                               " from CUENTA C , APT_DET AD\n" +
                                                                               " WHERE C.CUE_CLAVE = AD.AD_FK_CUENTA");
            while (Valores.next()){
                String Cuenta = Integer.toString(Valores.getInt(1));
                Float Monto = VentanaGenerarReciboMensual.PrecioRecibo*(Valores.getFloat(2) / 100);
                PreparedStatement pst=  Con.prepareStatement("INSERT INTO AVISOCOBRO VALUES ("
                        + "                                                                               SQ_PK_AVISOCOBRO.NEXTVAL,"
                        + "                                                                               "+Monto+","
                        + "                                                                               'NOPAGADO',"
                        + "                                                                               "+FK_RECIBOMENSUAL+","
                        + "                                                                               "+Cuenta+")");
                pst.executeUpdate();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en:"+e);
        }
          
     };
     
     
}

