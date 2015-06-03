/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaGenerarReciboMensual;
import Interfaz.VentanaGestionCuenta;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jesus
 */
public class VentanaGestionCuentaControlador {

    
    public static void RellenaTablaEdificiosSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        VentanaGestionCuenta.cont = 0;
         ResultSet Valores= st.executeQuery("select E.EDI_RIF , E.EDI_NOMBRE, L.LUG_NOMBRE \n" +
                                                                            "from EDIFICIO E, LUGAR L \n" +
                                                                            "WHERE E.EDI_FK_LUGAR = L.LUG_CLAVE");
            while (Valores.next()){
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaGestionCuenta.ModeloEdificios.insertRow(VentanaGestionCuenta.cont, new Object[]{});
                    VentanaGestionCuenta.ModeloEdificios.setValueAt(Rif,VentanaGestionCuenta.cont,0);
                    VentanaGestionCuenta.ModeloEdificios.setValueAt(Nombre,VentanaGestionCuenta.cont,1);
                    VentanaGestionCuenta.ModeloEdificios.setValueAt(Valores.getString(3),VentanaGestionCuenta.cont,2);
                    VentanaGestionCuenta.cont++;
            }
 }
    
    public static void RellenaTablaApartamentosSQL(String ClaveEdificio) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGestionCuenta.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT AD.AD_CLAVE,AD.AD_PISO,AD.AD_ALICUOTA,AD_PRECIO\n" +
                                                                            " FROM APT_DET AD, EDIFICIO E\n" +
                                                                            " WHERE AD.AD_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            " AND E.EDI_CLAVE = "+ClaveEdificio);
          while (Valores.next()){
                    VentanaGestionCuenta.ModeloApartamentos.insertRow(VentanaGestionCuenta.cont, new Object[]{});
                    VentanaGestionCuenta.ModeloApartamentos.setValueAt(Valores.getInt(1),VentanaGestionCuenta.cont,0);
                    VentanaGestionCuenta.ModeloApartamentos.setValueAt(Valores.getString(2),VentanaGestionCuenta.cont,1);
                    VentanaGestionCuenta.ModeloApartamentos.setValueAt(Valores.getString(3),VentanaGestionCuenta.cont,2);
                    VentanaGestionCuenta.ModeloApartamentos.setValueAt(Valores.getString(4),VentanaGestionCuenta.cont,3);
                    VentanaGestionCuenta.cont++;
            }
    
}
    
    public static void RellenaTablaAvisosSQL(String ClaveApt) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGestionCuenta.cont2 = 0;
          ResultSet Valores= st.executeQuery(" select AVI.AVI_CLAVE , AVI.AVI_MONTO , AVI.AVI_PAGADO, TO_CHAR(REC.RECI_FECHA,'MONTHYYYY') AS FECHA\n" +
                                                                        "  FROM AVISOCOBRO AVI, RECIBOMENSUAL REC, CUENTA CUE, APT_DET AD\n" +
                                                                        "  WHERE AVI.AVI_FK_RECIBOMENSUAL = REC.RECI_CLAVE\n" +
                                                                        "       and (AVI.AVI_FK_CUENTA = CUE.CUE_CLAVE)\n" +
                                                                        "       AND (CUE.CUE_CLAVE = AD.AD_FK_CUENTA)\n" +
                                                                        "       AND (AD.AD_CLAVE="+ClaveApt+")");
          while (Valores.next()){
                    VentanaGestionCuenta.ModeloAvisos.insertRow(VentanaGestionCuenta.cont2, new Object[]{});
                    VentanaGestionCuenta.ModeloAvisos.setValueAt(Valores.getString(1),VentanaGestionCuenta.cont2,0);
                    VentanaGestionCuenta.ModeloAvisos.setValueAt(Valores.getString(2),VentanaGestionCuenta.cont2,1);
                    VentanaGestionCuenta.ModeloAvisos.setValueAt(Valores.getString(3),VentanaGestionCuenta.cont2,2);
                    VentanaGestionCuenta.ModeloAvisos.setValueAt(Valores.getString(4),VentanaGestionCuenta.cont2,3);
                    VentanaGestionCuenta.cont2++;
          }
    
}
    
    
    public static void RellenaDatosDeudaPorAPTSQL(String ClaveApt) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          boolean verif = false;
          ResultSet Valores= st.executeQuery("select AD.AD_CLAVE ,(P.PRO_PNOMBRE || ' ' || P.PRO_PAPELLIDO ) AS NombreCompleto, CUE.CUE_TIPO , SUM(AVI.AVI_MONTO) , COUNT (AVI.AVI_CLAVE)\n" +
                                                                            " from PROPIETARIO P, CUENTA CUE , APT_DET AD , AVISOCOBRO AVI\n" +
                                                                            " WHERE P.PRO_CLAVE = AD.AD_FK_PROPIETARIO AND AD.AD_FK_CUENTA = CUE.CUE_CLAVE\n" +
                                                                            " AND CUE.CUE_CLAVE = AVI.AVI_FK_CUENTA AND AVI.AVI_PAGADO = 'NOPAGADO'\n" +
                                                                            " AND AD.AD_CLAVE = "+ClaveApt+" \n" +
                                                                            " GROUP BY ( AD.AD_CLAVE, P.PRO_PNOMBRE ,P.PRO_PAPELLIDO, CUE.CUE_TIPO)");
          while (Valores.next()){
                    verif = true;
                    VentanaGestionCuenta.NombreCompleto = Valores.getString(2);
                    VentanaGestionCuenta.TipoCuenta = Valores.getString(3);
                    VentanaGestionCuenta.MontoDeuda = Float.toString(Valores.getFloat(4));
                    VentanaGestionCuenta.CantidadDeuda = Integer.toString(Valores.getInt(5));
            }
          if (!verif){
                    VentanaGestionCuenta.NombreCompleto = "Apartamento Sin Dueno";
                    VentanaGestionCuenta.TipoCuenta = "";
                    VentanaGestionCuenta.MontoDeuda = "";
                    VentanaGestionCuenta.CantidadDeuda = "";
              
          }
}
    
    
}
