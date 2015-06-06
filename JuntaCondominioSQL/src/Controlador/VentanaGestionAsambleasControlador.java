/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaGestionCuenta;
import Interfaz.VentanaGestiondeAsambleas;
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
public class VentanaGestionAsambleasControlador {
 

public static void CalcularClaveFondo(String fkContrato) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select CF_CLAVE  \n" +
                                                                            " from CONT_FOND, CONTRATO CON\n" +
                                                                            " WHERE CF_FK_FONDO = '1'\n" +
                                                                            " AND CF_FK_CONTRATO = CON.CONT_CLAVE\n" +
                                                                            " AND CON.CONT_CLAVE = '"+fkContrato+"'");
          while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"OK");
                    VentanaGestiondeAsambleas.ClaveFondo = Integer.toString(Valores.getInt(1));
                    
          }
 }    
    
public static void InsertarLIBCIT(String ClaveLibro, String CalveCitaAsamblea) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into LIB_CIT (LT_CLAVE,LT_FK_LIBRO,LT_FK_CITAASAMBLEA) VALUES "
                  + "                                                                               ( SQ_PK_LIBROS.NEXTVAL,"+ClaveLibro+","+CalveCitaAsamblea+")");
          pst.executeUpdate(); 
   }

public static void RellenaTablaContratosSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaGestiondeAsambleas.cont = 0;
         ResultSet Valores= st.executeQuery("SELECT CON.CONT_CLAVE, E.EDI_RIF , E.EDI_NOMBRE, O.OFI_NOMBRE\n" +
                                                                            " FROM CONTRATO CON, EDIFICIO E, OFICINA O\n" +
                                                                            " WHERE CON.CONT_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            " AND O.OFI_CLAVE = CON.CONT_FK_OFICINA");
            while (Valores.next()){
                
                    VentanaGestiondeAsambleas.ModeloContratos.insertRow(VentanaGestiondeAsambleas.cont, new Object[]{});
                    VentanaGestiondeAsambleas.ModeloContratos.setValueAt(Integer.toString(Valores.getInt(1)),VentanaGestiondeAsambleas.cont,0);
                    VentanaGestiondeAsambleas.ModeloContratos.setValueAt(Valores.getString(2),VentanaGestiondeAsambleas.cont,1);
                    VentanaGestiondeAsambleas.ModeloContratos.setValueAt(Valores.getString(3),VentanaGestiondeAsambleas.cont,2);
                    VentanaGestiondeAsambleas.ModeloContratos.setValueAt(Valores.getString(4),VentanaGestiondeAsambleas.cont,3);
                   VentanaGestiondeAsambleas.cont++;
            }
 }

public static void RellenaTablaTrabajosSQL(String ClaveContrato) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGestiondeAsambleas.cont = 0;
          ResultSet Valores= st.executeQuery("select TRA_CLAVE ,  TRA_DESCRIPCION , TRA_F_PROPUESTO, TRA_MONTO\n" +
                                                                            "FROM TRABAJO, AD_TRA ATT, AREA_DET AD, EDIFICIO E \n" +
                                                                            "WHERE TRA_APROBADO = 'NO' AND TRA_REALIZADO= 'NO'\n" +
                                                                            "AND TRABAJO.TRA_CLAVE = ATT.AT_FK_TRABAJO AND\n" +
                                                                            "ATT.AT_FK_AREADET = AD.AD_CLAVE AND \n" +
                                                                            "AD.AD_FK_EDIFICIO = E.EDI_CLAVE "
                  + "                                                        AND TRA_CLAVE IN (select T.TRA_CLAVE\n" +
                                                                                                                   " from CONTRATO CON, CONT_FOND CF, TRABAJO T\n" +
                                                                                                                   " WHERE CON.CONT_CLAVE = CF.CF_FK_CONTRATO\n" +
                                                                                                                   " AND CON.CONT_CLAVE = "+ClaveContrato+" \n" +
                                                                                                                   " AND T.TRA_FK_CONT_FOND = CF.CF_CLAVE)"
                  + ""
                  + ""
                  + "");
            while (Valores.next()){
                    VentanaGestiondeAsambleas.ModeloTrabajos.insertRow(VentanaGestiondeAsambleas.cont, new Object[]{});
                    VentanaGestiondeAsambleas.ModeloTrabajos.setValueAt(Integer.toString(Valores.getInt(1)),VentanaGestiondeAsambleas.cont,0);
                    VentanaGestiondeAsambleas.ModeloTrabajos.setValueAt(Valores.getString(2),VentanaGestiondeAsambleas.cont,1);
                    VentanaGestiondeAsambleas.ModeloTrabajos.setValueAt(Valores.getDate(3),VentanaGestiondeAsambleas.cont,2);
                    VentanaGestiondeAsambleas.ModeloTrabajos.setValueAt(Float.toString(Valores.getFloat(4)),VentanaGestiondeAsambleas.cont,3);
                   VentanaGestiondeAsambleas.cont++;
            }
 }

public static void CalcularClaveOficinaDireccion(String ClaveContrato) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("  select O.OFI_CLAVE, O.OFI_FK_LUGAR, E.EDI_FK_LUGAR\n" +
                                                                            "  from OFICINA O INNER JOIN CONTRATO CON ON O.OFI_CLAVE = CON.CONT_FK_OFICINA\n" +
                                                                            "                 INNER JOIN EDIFICIO E ON E.EDI_CLAVE = CON.CONT_FK_EDIFICIO\n" +
                                                                            "  WHERE CON.CONT_CLAVE = "+ClaveContrato+"");
           while (Valores.next()){
                    VentanaGestiondeAsambleas.ClaveOficina = Integer.toString(Valores.getInt(1));
                    VentanaGestiondeAsambleas.DireccionOficina= Integer.toString(Valores.getInt(2));
                    VentanaGestiondeAsambleas. DireccionEdificio= Integer.toString(Valores.getInt(3));
          }
 }

public static void CalcularLLamadoSQL(String ClaveContrato, String NumeroLlamado) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
         ResultSet Valores= st.executeQuery("select L.LLA_NUMERO, L.LLA_QUORUM_MINIMO, L.LLA_PORCENTAJEAPROBACION ,JC.JC_CLAVE, COUNT(AD.AD_CLAVE) \n" +
                                                                            " FROM LLAMADO L INNER JOIN CONTRATO CON ON L.LLA_FK_CONTRATO = CON.CONT_CLAVE INNER JOIN EDIFICIO E ON E.EDI_CLAVE = CON.CONT_FK_EDIFICIO\n" +
                                                                            " INNER JOIN APT_DET AD ON AD.AD_FK_EDIFICIO = E.EDI_CLAVE INNER JOIN JUNTACONDOMINIO JC ON E.EDI_CLAVE = JC.JC_FK_EDIFICIO\n" +
                                                                            " AND CON.CONT_CLAVE = "+ClaveContrato+" AND L.LLA_NUMERO = "+NumeroLlamado+"\n" +
                                                                            " AND JC.JC_FECHA_INICIAL = (SELECT MAX(JC.JC_FECHA_INICIAL)\n" +
                                                                            "                            FROM JUNTACONDOMINIO JC)\n" +
                                                                            " GROUP BY L.LLA_NUMERO, L.LLA_QUORUM_MINIMO, L.LLA_PORCENTAJEAPROBACION ,JC.JC_CLAVE");
            while (Valores.next()){
                    JOptionPane.showMessageDialog(null,"OK");
                    VentanaGestiondeAsambleas.QuorumMinimo = Valores.getInt(2);
                    VentanaGestiondeAsambleas.PorcentajeAprob = Valores.getFloat(3);
                    VentanaGestiondeAsambleas.MaximoAPT = Valores.getInt(5);
                    VentanaGestiondeAsambleas.JuntaActiva = Integer.toString(Valores.getInt(4));
            }
 }

public static void InsertarCitaAsambleaSQL(String Fecha, String Quorum, String Tipo, String FkJunta) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO CITAASAMBLEA (CIT_CLAVE,CIT_FECHA,CIT_QUORUM,CIT_TIPO,CIT_FK_JUNTACONDOMINIO) VALUES"
                  + "                                                                               (SQ_PK_CITAASAMBLEA.NEXTVAL,"
                  + "                                                                               TO_DATE('"+Fecha+"','YYYYMMDD'),"+Quorum+","
                  + "                                                                               '"+Tipo+"',"
                  + "                                                                               "+FkJunta+")");
          pst.executeUpdate(); 
   }

public static void CalcularClaveLibro(String ClaveContrato) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select LIB_CLAVE , (select max(CITAASAMBLEA.CIT_CLAVE) from CITAASAMBLEA)\n" +
                                                                            "from libro inner join contrato on contrato.CONT_CLAVE = libro.LIB_FK_CONTRATO\n" +
                                                                            "where contrato.CONT_CLAVE = "+ClaveContrato+"");
          while (Valores.next()){
                    JOptionPane.showMessageDialog(null,"OK");
                    VentanaGestiondeAsambleas.Clavelibro = Integer.toString(Valores.getInt(1));
                    VentanaGestiondeAsambleas.ClaveCitaAsamblea =  Integer.toString(Valores.getInt(2));
          }
 }

public static void InsertarAsambleaSQL(String Topico,String tipo, String FK_Ofic, String fklug) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO ASAMBLEA (ASA_CLAVE,ASA_TOPICO,ASA_TIPO,ASA_FK_OFICINA,ASA_FK_LUGAR) \n" +
"                               VALUES(SQ_PK_CITAASAMBLEA.NEXTVAL,'"+Topico+"','"+tipo+"',"+FK_Ofic+","+fklug+")");
          pst.executeUpdate(); 
   }

public static void CalcularClaveAsamblea() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select MAX(ASA_CLAVE)\n" +
                                                                            " from ASAMBLEA");
          while (Valores.next()){
                    //JOptionPane.showMessageDialog(null,"OK");
                    VentanaGestiondeAsambleas.ClaveAsamblea = Integer.toString(Valores.getInt(1));
                    
          }
 }

public static void InsertaTrabajoMayorSQL(String VotosFavor, String VotosContra, String ClaveAsamblea,String ClaveTrabajo) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into TRABAJOMAYOR VALUES(SQ_PK_AD_TRA.NEXTVAL,"+VotosFavor+","+VotosContra+","+ClaveAsamblea+","+ClaveTrabajo+")");
          pst.executeUpdate(); 
   }

public static void InsertaTrabajoAnuncioSQL(String Monto, String fk_fondo, String fecha) throws SQLException{
          JOptionPane.showMessageDialog(null,"Entre");
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();   
          PreparedStatement pst=  Con.prepareStatement("insert into TRABAJO (TRA_CLAVE,TRA_DESCRIPCION,TRA_MONTO,TRA_CLASIFICACION,TRA_TIPO,TRA_SUSCEPTIBLE,TRA_FK_PROVEEDORSERVICIO,TRA_FK_CONT_FOND,TRA_F_REALIZADO,TRA_F_PROPUESTO,TRA_REALIZADO,TRA_APROBADO) \n" +
                                                                                                    "             VALUES(SQ_PK_TRABAJO.NEXTVAL,'COSTO DEL ANUNCIO DE PRENSA',\n" +
                                                                                                    "             "+Monto+",\n" +
                                                                                                    "             'TRABAJO',\n" +
                                                                                                    "             'ANUNCIO',\n" +
                                                                                                    "             'RENCIONIVA',\n" +
                                                                                                    "             9921,\n" +
                                                                                                    "             "+fk_fondo+",\n" +
                                                                                                    "             to_date('"+fecha+"','yyyymmdd'),\n" +
                                                                                                    "             to_date('"+fecha+"','yyyymmdd'),\n" +
                                                                                                    "             'SI',\n" +
                                                                                                    "             'SI') ");
          pst.executeUpdate(); 
   }

public static void InsertaHor_DETSQL(String Hinicio, String HFin, String FK_horario, String fkasa) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement(" insert into HOR_DET (HD_CLAVE,HD_INICIO,HD_FIN,HD_FK_HORARIO,HD_FK_ASAMBLEA) \n" +
                                                                                                    "  values (SQ_PK_HOR_DET.NEXTVAL ,TO_TIMESTAMP('"+Hinicio+"','YYYYMMDDHH24MISS'),TO_TIMESTAMP('"+HFin+"','YYYYMMDDHH24MISS'),"+FK_horario+","+fkasa+")");
          pst.executeUpdate(); 
   }

public static void ApruebaTrabajoSQL(String ClaveTrabajo) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("update TRABAJO SET TRA_APROBADO = 'SI'\n" +
                                                                                                    " WHERE TRA_CLAVE = "+ClaveTrabajo);
          pst.executeUpdate(); 
   }
}
