/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.VentanaGestiondeAsambleas;
import Interfaz.VentanaReciboMensual;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.eclipse.jdt.core.dom.Statement;

/**
 *
 * @author jesus
 */
public class VentanaReciboMensualControlador {
    
    
    
public static void RellenaRecibo1SQL() throws SQLException{
 
            ConexionOracle Conexion= new ConexionOracle();
            Connection Con=Conexion.Conectar();
            java.sql.Statement st= Con.createStatement();
            ResultSet Valores= st.executeQuery(" select  E.EDI_NOMBRE ,\n" +
                                                                                "        ('Ubicado en el Estado: '||EST.LUG_NOMBRE || ' EN el Municipio: ' || MUN.LUG_NOMBRE || ' En la Parroquia :' || PAR.LUG_NOMBRE) AS DIRECCION\n" +
                                                                                "        ,( PRO.PRO_PNOMBRE ||' '|| PRO.PRO_PAPELLIDO )AS NOMBRE,\n" +
                                                                                "        AD.AD_ALICUOTA,\n" +
                                                                                "        AD.AD_CLAVE,\n" +
                                                                                "        OFI.OFI_NOMBRE,\n" +
                                                                                "        AVI.AVI_CLAVE,\n" +
                                                                                "        REC.RECI_FECHA\n" +
                                                                                " from    EDIFICIO E, LUGAR PAR, LUGAR MUN , LUGAR EST, PROPIETARIO PRO, APT_DET AD, CONTRATO CON, OFICINA OFI,\n" +
                                                                                "        CUENTA CUE, AVISOCOBRO AVI, RECIBOMENSUAL REC\n" +
                                                                                " where   E.EDI_FK_LUGAR = PAR.LUG_CLAVE and PAR.LUG_FK_LUGAR = MUN.LUG_CLAVE AND MUN.LUG_FK_LUGAR = EST.LUG_CLAVE\n" +
                                                                                "        AND AD.AD_FK_EDIFICIO = E.EDI_CLAVE AND AD.AD_FK_PROPIETARIO = PRO.PRO_CLAVE \n" +
                                                                                "        AND E.EDI_CLAVE = CON.CONT_FK_EDIFICIO AND CON.CONT_FK_OFICINA = OFI.OFI_CLAVE\n" +
                                                                                "        AND AD.AD_FK_CUENTA = CUE.CUE_CLAVE AND AVI.AVI_FK_CUENTA = CUE.CUE_CLAVE\n" +
                                                                                "        AND AVI.AVI_FK_RECIBOMENSUAL = REC.RECI_CLAVE\n" +
                                                                                "        AND AVI.AVI_CLAVE = 70 ");
            while (Valores.next()){
                    VentanaReciboMensual.NombreEdificio = Valores.getString(1);
                    VentanaReciboMensual.DireccionCompleta = Valores.getString(2);
                    VentanaReciboMensual.NombrePropietario = Valores.getString(3);
                    VentanaReciboMensual.AlicuotaAPT_DET = Float.toString(Valores.getFloat(4));
                    VentanaReciboMensual.NumeroAPT = Integer.toString(Valores.getInt(5));
                    VentanaReciboMensual.NombreOficina = Valores.getString(6);
                    VentanaReciboMensual.CodigoAvisoCobro = Integer.toString(Valores.getInt(7));
                    VentanaReciboMensual.FechaReciboMensual = Valores.getDate(8);
            }
 }


public static void RellenaReciboMensual2SQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        java.sql.Statement st= Con.createStatement();
        VentanaReciboMensual.cont = 0;
         ResultSet Valores= st.executeQuery(" select  T.TRA_DESCRIPCION , T.TRA_F_REALIZADO, T.TRA_MONTO, (T.TRA_MONTO*(AD.AD_ALICUOTA/100)) AS MONTODET\n" +
                                                                            " from  TRABAJO T inner join RECIBOMENSUAL RECI ON T.TRA_FK_RECIBOMENSUAL = RECI.RECI_CLAVE \n" +
                                                                            "        INNER JOIN AVISOCOBRO AVI ON RECI.RECI_CLAVE = AVI.AVI_FK_RECIBOMENSUAL\n" +
                                                                            "        INNER JOIN CUENTA CUE ON CUE.CUE_CLAVE = AVI.AVI_FK_CUENTA\n" +
                                                                            "        INNER JOIN APT_DET AD ON AD.AD_FK_CUENTA = CUE.CUE_CLAVE\n" +
                                                                            "        where AVI.AVI_CLAVE = 70");
            while (Valores.next()){

                    VentanaReciboMensual.ModeloTrabajos.insertRow(VentanaReciboMensual.cont, new Object[]{});
                    VentanaReciboMensual.ModeloTrabajos.setValueAt((Valores.getString(1)),VentanaReciboMensual.cont,0);
                    VentanaReciboMensual.ModeloTrabajos.setValueAt(Valores.getDate(2),VentanaReciboMensual.cont,1);
                    VentanaReciboMensual.ModeloTrabajos.setValueAt(Float.toString(Valores.getFloat(3)),VentanaReciboMensual.cont,2);
                    VentanaReciboMensual.ModeloTrabajos.setValueAt(Float.toString(Valores.getFloat(4)),VentanaReciboMensual.cont,3);
                   VentanaReciboMensual.cont++;
            }
 }
}
