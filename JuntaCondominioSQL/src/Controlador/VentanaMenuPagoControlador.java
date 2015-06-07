/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaGestionCuenta;
import Interfaz.VentanaMenuPagos;
import Interfaz.VentanaMenuReclamo;
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
public class VentanaMenuPagoControlador {
    
public static void RellenaTablaApartamentosCompradosSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuPagos.cont = 0;
         ResultSet Valores= st.executeQuery(" SELECT E.EDI_NOMBRE , APT.APT_MEDIDAS , AD.AD_ALICUOTA ,AD.AD_PISO,AD.AD_CLAVE,AD.AD_PRECIO\n" +
                                                                            " FROM EDIFICIO E, APARTAMENTO APT, PROPIETARIO P, APT_DET AD\n" +
                                                                            " WHERE E.EDI_CLAVE = AD.AD_FK_EDIFICIO AND APT.APT_CLAVE = AD.AD_FK_APARTAMENTO AND P.PRO_CLAVE = AD.AD_FK_PROPIETARIO"
                 + "                                                          and P.PRO_CLAVE = "+Clave+"");
            while (Valores.next()){
                     VentanaMenuPagos.modeloApt.insertRow(VentanaMenuPagos.cont, new Object[]{});
                     VentanaMenuPagos.modeloApt.setValueAt(Valores.getString(1),VentanaMenuPagos.cont,0);
                    VentanaMenuPagos.modeloApt.setValueAt(Valores.getString(2),VentanaMenuPagos.cont,1);
                    VentanaMenuPagos.modeloApt.setValueAt(Valores.getFloat(3),VentanaMenuPagos.cont,2);
                    VentanaMenuPagos.modeloApt.setValueAt(Valores.getString(4),VentanaMenuPagos.cont,3);
                    VentanaMenuPagos.modeloApt.setValueAt(Valores.getInt(5),VentanaMenuPagos.cont,4);
                    VentanaMenuPagos.modeloApt.setValueAt(Valores.getFloat(6),VentanaMenuPagos.cont,5);
                    VentanaMenuPagos.cont++;
            }
    
}

public static void RellenaTablaContratos() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuPagos.cont = 0;
         ResultSet Valores= st.executeQuery("  select CON.CONT_CLAVE, E.EDI_RIF, E.EDI_NOMBRE , ('Edo.'||ESTADO.LUG_NOMBRE ||' Mun.'|| MUNICIPIO.LUG_NOMBRE ||' Par.'|| PARROQUIA.LUG_NOMBRE) as Direccion\n" +
                                                                            "  from CONTRATO CON INNER JOIN EDIFICIO E ON CON.CONT_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            "  INNER JOIN LUGAR PARROQUIA ON E.EDI_FK_LUGAR = PARROQUIA.LUG_CLAVE INNER JOIN\n" +
                                                                            "  LUGAR MUNICIPIO ON PARROQUIA.LUG_FK_LUGAR = MUNICIPIO.LUG_CLAVE INNER JOIN\n" +
                                                                            "  LUGAR ESTADO  ON ESTADO.LUG_CLAVE = MUNICIPIO.LUG_FK_LUGAR\n" +
                                                                            "  where CON.CONT_FECHA_EMISION = (SELECT MAX (CON.CONT_FECHA_EMISION)\n" +
                                                                            "                                  FROM CONTRATO CON WHERE CON.CONT_FK_EDIFICIO\n" +
                                                                            "                                  = E.EDI_CLAVE)");
            while (Valores.next()){
                     VentanaMenuPagos.modeloContratos.insertRow(VentanaMenuPagos.cont, new Object[]{});
                     VentanaMenuPagos.modeloContratos.setValueAt(Valores.getInt(1),VentanaMenuPagos.cont,0);
                    VentanaMenuPagos.modeloContratos.setValueAt(Valores.getString(2),VentanaMenuPagos.cont,1);
                    VentanaMenuPagos.modeloContratos.setValueAt(Valores.getString(3),VentanaMenuPagos.cont,2);
                    VentanaMenuPagos.modeloContratos.setValueAt(Valores.getString(4),VentanaMenuPagos.cont,3);
                    VentanaMenuPagos.cont++;
            }
    
}

public static void RellenaTablaTrabajos() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuPagos.cont = 0;
         ResultSet Valores= st.executeQuery(" select T.TRA_CLAVE,T.TRA_TIPO ,T.TRA_DESCRIPCION , PROV.PS_NOMBRE , T.TRA_MONTO\n" +
                                                                            " from TRABAJO T, PROVEEDORSERVICIO PROV, CONT_FOND CF, CONTRATO CON\n" +
                                                                            " WHERE PROV.PS_CLAVE = T.TRA_FK_PROVEEDORSERVICIO\n" +
                                                                            " AND CF.CF_CLAVE = T.TRA_FK_CONT_FOND\n" +
                                                                            " AND CON.CONT_CLAVE = CF.CF_FK_CONTRATO AND\n" +
                                                                            " CON.CONT_CLAVE = "+VentanaMenuPagos.ClaveContrato+"\n" +
                                                                            " UNION ALL\n" +
                                                                            " select T.TRA_CLAVE,T.TRA_TIPO, T.TRA_DESCRIPCION , O.OFI_NOMBRE , T.TRA_MONTO\n" +
                                                                            " from TRABAJO T, OFICINA O, CONT_FOND CF, CONTRATO CON\n" +
                                                                            " WHERE O.OFI_CLAVE = T.TRA_FK_OFICINA\n" +
                                                                            " AND CF.CF_CLAVE = T.TRA_FK_CONT_FOND\n" +
                                                                            " AND CON.CONT_CLAVE = CF.CF_FK_CONTRATO AND\n" +
                                                                            " CON.CONT_CLAVE = "+VentanaMenuPagos.ClaveContrato+" ");
            while (Valores.next()){
                     VentanaMenuPagos.ModeloTrabajos.insertRow(VentanaMenuPagos.cont, new Object[]{});
                     VentanaMenuPagos.ModeloTrabajos.setValueAt(Valores.getInt(1),VentanaMenuPagos.cont,0);
                    VentanaMenuPagos.ModeloTrabajos.setValueAt(Valores.getString(2),VentanaMenuPagos.cont,1);
                    VentanaMenuPagos.ModeloTrabajos.setValueAt(Valores.getString(3),VentanaMenuPagos.cont,2);
                    VentanaMenuPagos.ModeloTrabajos.setValueAt(Valores.getString(4),VentanaMenuPagos.cont,3);
                    VentanaMenuPagos.ModeloTrabajos.setValueAt(Float.toString(Valores.getFloat(5)),VentanaMenuPagos.cont,4);
                    VentanaMenuPagos.Monto= Float.toString(Valores.getFloat(5));
                    VentanaMenuPagos.cont++;
            }
    
}

public static void RellenaTablaAvisosSQL(String ClaveApt) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaMenuPagos.cont = 0;
          ResultSet Valores= st.executeQuery(" select AVI.AVI_CLAVE , AVI.AVI_MONTO , AVI.AVI_PAGADO, TO_CHAR(REC.RECI_FECHA,'MONTHYYYY') AS FECHA\n" +
                                                                        "  FROM AVISOCOBRO AVI, RECIBOMENSUAL REC, CUENTA CUE, APT_DET AD\n" +
                                                                        "  WHERE AVI.AVI_FK_RECIBOMENSUAL = REC.RECI_CLAVE\n" +
                                                                        "       and (AVI.AVI_FK_CUENTA = CUE.CUE_CLAVE)\n" +
                                                                        "       AND (CUE.CUE_CLAVE = AD.AD_FK_CUENTA)\n" +
                                                                        "       AND (AD.AD_CLAVE="+ClaveApt+")"
                  + "                                                           AND (AVI.AVI_PAGADO = 'NOPAGADO')");
          while (Valores.next()){
                    VentanaMenuPagos.ModeloAvisos.insertRow(VentanaMenuPagos.cont, new Object[]{});
                    VentanaMenuPagos.ModeloAvisos.setValueAt(Valores.getString(1),VentanaMenuPagos.cont,0);
                    VentanaMenuPagos.ModeloAvisos.setValueAt(Valores.getString(2),VentanaMenuPagos.cont,1);
                    VentanaMenuPagos.ModeloAvisos.setValueAt(Valores.getString(3),VentanaMenuPagos.cont,2);
                    VentanaMenuPagos.ModeloAvisos.setValueAt(Valores.getString(4),VentanaMenuPagos.cont,3);
                    VentanaMenuPagos.cont++;
          }
    
}
      
public static void InsertarPAGOS2QL(String Monto, String Fecha, String Fk_fondo, String Fk_Oficina, String fkTarjeta, String fkCheque, String Descripcion) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into PAGO (PAG_CLAVE,PAG_MONTO,PAG_DESCRIPCION,PAG_FECHA,PAG_CONFORME,PAG_FK_FONDO_DETALLADO,PAG_FK_OFICINA,PAG_FK_CHEQUE,PAG_FK_TARJETA)\n" +
                                                                            "          values(SQ_TDP.NEXTVAL,"+Monto+",'"+Descripcion+"',to_date('"+Fecha+"','yyyymmdd'),'CONFORME',"+Fk_fondo+","+Fk_Oficina+","+VentanaMenuPagos.ClaveCheque+","+VentanaMenuPagos.ClaveTarjeta+")");

          pst.executeUpdate(); 
}

public static void RellenaTablaPropietarioSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido ="";
          VentanaMenuPagos.cont = 0;
          ResultSet Valores= st.executeQuery("select PROPIETARIO.PRO_CLAVE, PROPIETARIO.PRO_PNOMBRE, PROPIETARIO.PRO_PAPELLIDO, l.LUG_NOMBRE\n" +
                                                                            " from PROPIETARIO, lugar l\n" +
                                                                            " where l.LUG_CLAVE = PROPIETARIO.PRO_FK_LUGAR");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido = Valores.getString(3);
                    VentanaMenuPagos.modeloPropietarios.insertRow(VentanaMenuPagos.cont, new Object[]{});
                    VentanaMenuPagos.modeloPropietarios.setValueAt(ID,VentanaMenuPagos.cont,0);
                    VentanaMenuPagos.modeloPropietarios.setValueAt(Nombre,VentanaMenuPagos.cont,1);
                    VentanaMenuPagos.modeloPropietarios.setValueAt(Apellido,VentanaMenuPagos.cont,2);
                    VentanaMenuPagos.modeloPropietarios.setValueAt(Valores.getString(4),VentanaMenuPagos.cont,3);
                    VentanaMenuPagos.cont++;
            }
 };

public static void InsertarTarjetaSQL(String Descripcion, String Monto, String NumeroTarjeta, String TipoTarjeta) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO TARJETA VALUES(SQ_TDP.NEXTVAL,'"+Descripcion+"',"+Monto+",'"+NumeroTarjeta+"','"+TipoTarjeta+"')");

          pst.executeUpdate(); 
}

public static void InsertarChequeSQL(String Descripcion, String Monto, String Endoso, String NumCheque) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO CHEQUE VALUES(SQ_TDP.NEXTVAL,'"+Descripcion+"',"+Monto+",'"+Endoso+"','"+NumCheque+"')");

          pst.executeUpdate(); 
}

public static void InsertarPAGOSQL(String Monto, String Fecha, String Fk_fondo, String Fk_prop, String fkTarjeta, String fkCheque, String Descripcion) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into PAGO (PAG_CLAVE,PAG_MONTO,PAG_DESCRIPCION,PAG_FECHA,PAG_CONFORME,PAG_FK_FONDO_DETALLADO,PAG_FK_PROPIETARIO,PAG_FK_CHEQUE,PAG_FK_TARJETA)\n" +
                                                                            "          values(SQ_TDP.NEXTVAL,"+Monto+",'"+Descripcion+"',to_date('"+Fecha+"','yyyymmdd'),'CONFORME',"+Fk_fondo+","+Fk_prop+","+VentanaMenuPagos.ClaveCheque+","+VentanaMenuPagos.ClaveTarjeta+")");

          pst.executeUpdate(); 
}

public static void CalcularClaveTarjeta () throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select MAX(TDP2_CLAVE ) from TARJETA");
                    while (Valores.next()){
                              VentanaMenuPagos.ClaveTarjeta = Integer.toString(Valores.getInt(1));
                           
                    }
}

public static void CalcularClaveCheque () throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select MAX(TDP1_CLAVE ) from CHEQUE");
                    while (Valores.next()){
                              VentanaMenuPagos.ClaveCheque = Integer.toString(Valores.getInt(1));
                           
                    }
}

public static void CalcularClaveContFondo() throws SQLException{

          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select CF_CLAVE\n" +
                                                                            " from CONT_FOND INNER JOIN CONTRATO CON ON CON.CONT_CLAVE = CONT_FOND.CF_FK_CONTRATO\n" +
                                                                            " INNER JOIN EDIFICIO E ON E.EDI_CLAVE = CON.CONT_FK_EDIFICIO INNER JOIN APT_DET AD\n" +
                                                                            " ON AD.AD_FK_EDIFICIO = E.EDI_CLAVE WHERE\n" +
                                                                            " AD.AD_CLAVE ="+ VentanaMenuPagos.ClaveAptSeleccionado+" AND CON.CONT_FECHA_EMISION = (SELECT MAX (CON.CONT_FECHA_EMISION)\n" +
                                                                            "                                              FROM CONTRATO CON\n" +
                                                                            "                                              WHERE CON.CONT_FK_EDIFICIO = E.EDI_CLAVE)\n" +
                                                                            " AND CONT_FOND.CF_FK_FONDO = 1");
                    while (Valores.next()){
                              VentanaMenuPagos.ClaveContFond = Integer.toString(Valores.getInt(1));
                           
                    }
}

public static void ActualizarFondos (Float Recargo) throws SQLException{
          float MontoActual = Recargo;
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select CF_MONTO\n" +
                                                                            "FROM CONT_FOND\n" +
                                                                            "WHERE CF_CLAVE = "+VentanaMenuPagos.ClaveContFond+"");
          while (Valores.next()){
                    MontoActual = Valores.getFloat(1);
                    MontoActual = MontoActual + Recargo; 
          }
          
          PreparedStatement pst=  Con.prepareStatement("UPDATE CONT_FOND SET\n" +
                                                                                                    " CF_MONTO ="+Float.toString(MontoActual)+" \n" +
                                                                                                    " WHERE CF_CLAVE = "+VentanaMenuPagos.ClaveContFond+"");
          pst.executeUpdate(); 
          
          PreparedStatement pst2=  Con.prepareStatement("UPDATE AVISOCOBRO SET AVI_PAGADO = 'PAGADO' \n" +
                                                                                                       "WHERE AVI_CLAVE = "+VentanaMenuPagos.ClaveAvisoSeleccionado+"" );
          pst2.executeUpdate(); 
          
}

public static void CalcularClaveOficina () throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" SELECT O.OFI_CLAVE\n" +
                                                                            " FROM OFICINA O INNER JOIN CONTRATO CON ON O.OFI_CLAVE = CON.CONT_FK_OFICINA\n" +
                                                                            " WHERE CON.CONT_CLAVE = "+VentanaMenuPagos.ClaveContrato+"");
                    while (Valores.next()){
                              VentanaMenuPagos.ClaveOficina = Integer.toString(Valores.getInt(1));
                           
                    }
}


public static void ActualizarFondos2 (Float Recargo) throws SQLException{
          float MontoActual = Recargo;
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select CF_MONTO\n" +
                                                                            "FROM CONT_FOND\n" +
                                                                            "WHERE CF_CLAVE = "+VentanaMenuPagos.ClaveContFond+"");
          while (Valores.next()){
                    MontoActual = Valores.getFloat(1);
                    MontoActual = MontoActual - Recargo; 
          }
          
          PreparedStatement pst=  Con.prepareStatement("UPDATE CONT_FOND SET\n" +
                                                                                                    " CF_MONTO ="+Float.toString(MontoActual)+" \n" +
                                                                                                    " WHERE CF_CLAVE = "+VentanaMenuPagos.ClaveContFond+"");
          pst.executeUpdate(); 
         
            }





public static void ActualizarFondos3 () throws SQLException{
          
          String clavePago = null;
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" SELECT MAX(PAG_CLAVE)\n" +
                                                                               " FROM PAGO");
          while (Valores.next()){
                    clavePago = Integer.toString(Valores.getInt(1));
          }
          
          
          PreparedStatement pst2=  Con.prepareStatement(" update TRABAJO TRA SET TRA.TRA_FK_PAGO =  "+clavePago+"\n" +
                                                                                                       " where TRA.TRA_CLAVE = "+VentanaMenuPagos.ClaveTrabajo+"" );
          pst2.executeUpdate(); 
 
          

}
          
 
}