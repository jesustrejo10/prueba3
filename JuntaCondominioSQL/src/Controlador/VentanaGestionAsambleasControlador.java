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

/**
 *
 * @author jesus
 */
public class VentanaGestionAsambleasControlador {
    
    
    
    
    
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

                    VentanaGestiondeAsambleas.QuorumMinimo = Valores.getInt(2);
                    VentanaGestiondeAsambleas.PorcentajeAprob = Valores.getFloat(3);
                    VentanaGestiondeAsambleas.MaximoAPT = Valores.getInt(4);
                    VentanaGestiondeAsambleas.JuntaActiva = Integer.toString(Valores.getInt(5));
            }
 }

public static void InsertarCitaAsambleaSQL(String Fecha, String Quorum, String Tipo, String FkJunta) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO CITAASAMBLEA (CIT_CLAVE,CIT_FECHA,CIT_QUORUM,CIT_TIPO,CIT_FK_JUNTACONDOMINIO) VALUES"
                  + "                                                                               (SQ_PK_CITAASAMBLEA.NEXTVAL,"
                  + "                                                                               TO_DATE('"+Fecha+"','DDMMYYYY'),"+Quorum+","
                  + "                                                                               '"+Tipo+"',"
                  + "                                                                               "+FkJunta+")");
          pst.executeUpdate(); 
   }
}
