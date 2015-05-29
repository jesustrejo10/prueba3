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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
          ResultSet Valores= st.executeQuery(" SELECT T.TRA_CLAVE, T.TRA_DESCRIPCION, T.TRA_F_REALIZADO,T.TRA_MONTO,T.TRA_TIPO\n" +
                                                                            " from TRABAJO T ,AD_TRA ATT, AREA_DET AD, EDIFICIO E\n" +
                                                                            " WHERE (T.TRA_CLAVE = ATT.AT_FK_TRABAJO) AND (ATT.AT_FK_AREADET = AD.AD_CLAVE) AND \n" +
                                                                            " (AD.AD_FK_EDIFICIO = E.EDI_CLAVE) and (T.TRA_FK_RECIBOMENSUAL IS NULL)\n" +
                                                                            " and (E.EDI_CLAVE = "+ClaveEdif+")");
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
   
     
     
     public static void RellenaTablaTrabajosDisponiblesSQL2(String ClaveEdif) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaGenerarReciboMensual.cont = 0;
          ResultSet Valores= st.executeQuery(" SELECT T.TRA_CLAVE, T.TRA_DESCRIPCION, T.TRA_F_REALIZADO,T.TRA_MONTO,T.TRA_TIPO\n" +
                                                                            " from TRABAJO T ,AD_TRA ATT, AREA_DET AD, EDIFICIO E\n" +
                                                                            " WHERE (T.TRA_CLAVE = ATT.AT_FK_TRABAJO) AND (ATT.AT_FK_AREADET = AD.AD_CLAVE) AND \n" +
                                                                            " (AD.AD_FK_EDIFICIO = E.EDI_CLAVE) and (T.TRA_FK_RECIBOMENSUAL IS NULL)\n" +
                                                                            " and (E.EDI_CLAVE = "+ClaveEdif+") AND (T.TRA_CLAVE NOT IN ("+VentanaGenerarReciboMensual.TrabajosSeleccionados+"))");
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
          ResultSet Valores= st.executeQuery(" SELECT T.TRA_CLAVE, T.TRA_DESCRIPCION, T.TRA_F_REALIZADO,T.TRA_MONTO,T.TRA_TIPO\n" +
                                                                            " from TRABAJO T ,AD_TRA ATT, AREA_DET AD, EDIFICIO E\n" +
                                                                            " WHERE (T.TRA_CLAVE = ATT.AT_FK_TRABAJO) AND (ATT.AT_FK_AREADET = AD.AD_CLAVE) AND \n" +
                                                                            " (AD.AD_FK_EDIFICIO = E.EDI_CLAVE) and (T.TRA_FK_RECIBOMENSUAL IS NULL)\n" +
                                                                            " and (E.EDI_CLAVE = "+ClaveEdif+") AND (T.TRA_CLAVE IN ("+VentanaGenerarReciboMensual.TrabajosSeleccionados+"))");
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
     
}

