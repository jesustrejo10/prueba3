/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaMenuTrabajo;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class VentanaMenuTrabajoControlador {
    
public static void RellenaTablaEdificiosQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuTrabajo.cont = 0;
        ResultSet Valores= st.executeQuery("select EDI.EDI_RIF, EDI.EDI_NOMBRE, LUG.LUG_NOMBRE\n" +
                                                                           "FROM EDIFICIO EDI, LUGAR LUG\n" +
                                                                           "WHERE LUG.LUG_CLAVE = EDI.EDI_FK_LUGAR");
            while (Valores.next()){
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaMenuTrabajo.ModeloEdificios.insertRow(VentanaMenuTrabajo.cont, new Object[]{});
                    VentanaMenuTrabajo.ModeloEdificios.setValueAt(Rif,VentanaMenuTrabajo.cont,0);
                    VentanaMenuTrabajo.ModeloEdificios.setValueAt(Nombre,VentanaMenuTrabajo.cont,1);
                    VentanaMenuTrabajo.ModeloEdificios.setValueAt(Valores.getString(3),VentanaMenuTrabajo.cont,2);
                    
                    VentanaMenuTrabajo.cont++;
            }
 
            
            
    };
    
public static void RellenaTablaProveedores() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuTrabajo.cont = 0;
        ResultSet Valores= st.executeQuery("select * from PROVEEDORSERVICIO");
            while (Valores.next()){ 
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaMenuTrabajo.ModeloProveedor.insertRow(VentanaMenuTrabajo.cont, new Object[]{});
                    VentanaMenuTrabajo.ModeloProveedor.setValueAt(Rif,VentanaMenuTrabajo.cont,0);
                    VentanaMenuTrabajo.ModeloProveedor.setValueAt(Nombre,VentanaMenuTrabajo.cont,1);
                    VentanaMenuTrabajo.ModeloProveedor.setValueAt(Valores.getString(3),VentanaMenuTrabajo.cont,2);
                    
                    VentanaMenuTrabajo.cont++;
            }
 
            
            
    };
    
public static void RellenaTablaAreaComun(String rif) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuTrabajo.cont = 0;
        ResultSet Valores= st.executeQuery(" select AC.AC_NOMBRE, AD.AD_CLAVE , E.EDI_NOMBRE\n" +
                                                                            " FROM AREACOMUN AC, AREA_DET AD, EDIFICIO E\n" +
                                                                            " WHERE AC.AC_CLAVE = AD.AD_FK_AREACOMUN AND AD.AD_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            " AND E.EDI_RIF = '"+rif+"'");
            while (Valores.next()){ 
                    Rif=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    VentanaMenuTrabajo.ModeloAreaComun.insertRow(VentanaMenuTrabajo.cont, new Object[]{});
                    VentanaMenuTrabajo.ModeloAreaComun.setValueAt(Rif,VentanaMenuTrabajo.cont,1);
                    VentanaMenuTrabajo.ModeloAreaComun.setValueAt(Nombre,VentanaMenuTrabajo.cont,0);
                    VentanaMenuTrabajo.ModeloAreaComun.setValueAt(Valores.getString(3),VentanaMenuTrabajo.cont,2);
                    VentanaMenuTrabajo.cont++;
            }
    }

public static void InsertarTrabajoSQL(String fk_proveedor ,String f1, String f2) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          //DEBERIA INSERTAR EN EL LIBRO DE UNA VEZ!...
          PreparedStatement pst=  Con.prepareStatement(" insert into TRABAJO (TRA_FK_CONT_FOND,TRA_CLAVE, TRA_DESCRIPCION, TRA_MONTO , TRA_CLASIFICACION , TRA_TIPO , TRA_SUSCEPTIBLE , TRA_FK_PROVEEDORSERVICIO,TRA_F_PROPUESTO , TRA_F_REALIZADO,TRA_REALIZADO, TRA_APROBADO) \n" +
                                                                                                      "VALUES ("
                  +"                                                                               "+VentanaMenuTrabajo.FK_FONDO+", "
                  + "                                                                              SQ_PK_TRABAJO.NEXTVAL,"
                  + "                                                                              '"+VentanaMenuTrabajo.Descripcion+"',"
                  + "                                                                              "+VentanaMenuTrabajo.Monto+","
                  + "                                                                              '"+VentanaMenuTrabajo.Clasificacion+"',"
                  + "                                                                              '"+VentanaMenuTrabajo.tipo+"',"
                  + "                                                                              '"+VentanaMenuTrabajo.suceptible+"',"
                  + "                                                                              "+fk_proveedor+","
                  + "                                                                              TO_DATE('"+f1+"','YYYYMMDD'),"
                  + "                                                                              TO_DATE('"+f2+"','YYYYMMDD'),"
                  + "                                                                              'SI' ,"
                  + "                                                                              'SI')");
          pst.executeUpdate();    
}

public static void InsertarTrabajoNoAprobadoSQL(String fk_proveedor ,String f1) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          //DEBERIA INSERTAR EN EL LIBRO DE UNA VEZ!...
          PreparedStatement pst=  Con.prepareStatement(" insert into TRABAJO (TRA_FK_CONT_FOND,TRA_CLAVE, TRA_DESCRIPCION, TRA_MONTO , TRA_CLASIFICACION , TRA_TIPO , TRA_SUSCEPTIBLE , TRA_FK_PROVEEDORSERVICIO,TRA_F_PROPUESTO ,TRA_REALIZADO, TRA_APROBADO) \n" +
                                                                                                      "VALUES ("
                  +"                                                                               "+VentanaMenuTrabajo.FK_FONDO+", "
                  + "                                                                              SQ_PK_TRABAJO.NEXTVAL,"
                  + "                                                                              '"+VentanaMenuTrabajo.Descripcion+"',"
                  + "                                                                              "+VentanaMenuTrabajo.Monto+","
                  + "                                                                              '"+VentanaMenuTrabajo.Clasificacion+"',"
                  + "                                                                              '"+VentanaMenuTrabajo.tipo+"',"
                  + "                                                                              '"+VentanaMenuTrabajo.suceptible+"',"
                  + "                                                                              "+fk_proveedor+","
                  + "                                                                              TO_DATE('"+f1+"','YYYYMMDD'),"
                  + "                                                                              'NO' ,"
                  + "                                                                              'NO')");
          pst.executeUpdate();    
}

public static void InsertarAD_TRASQL(String fk_trabajo, String fk_AD) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into AD_TRA VALUES(SQ_PK_AD_TRA.NEXTVAL,"+fk_AD+","+fk_trabajo+")");
          pst.executeUpdate();    
}

public static String DevuelveClaveTrabajo() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select MAX(TRA_CLAVE) FROM TRABAJO");
                    while (Valores.next()){ 
                              return(Integer.toString(Valores.getInt(1)));
                    }
          return ("");   
            
    };

public static String DevuelveClaveFondo(String RifEdificio,  String TipoFondo, String FechaEntrada) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select CF.CF_CLAVE \n" +
                                                                            " from CONT_FOND CF, CONTRATO CON, EDIFICIO E, FONDO F \n" +
                                                                            " WHERE \n" +
                                                                            "    CF.CF_FK_CONTRATO = CON.CONT_CLAVE \n" +
                                                                            "    AND CF.CF_FK_FONDO = F.FON_CLAVE \n" +
                                                                            "    AND CON.CONT_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            "    AND CON.CONT_FECHA_EMISION = '"+FechaEntrada+"' \n" +
                                                                            "    AND                              \n" +
                                                                            "    E.EDI_RIF = '"+RifEdificio+"' \n" +
                                                                            "    AND F.FON_CLAVE = "+TipoFondo+"  ");
                    while (Valores.next()){ 
                              return(Integer.toString(Valores.getInt(1)));
                    }
          return ("");   
            
    };
public static String DevuelveFechaMaximaContrato(String RifEdificio) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" SELECT MAX(CON.CONT_FECHA_EMISION)       \n" +
                                                                            " FROM CONTRATO CON, EDIFICIO E    \n" +
                                                                            " WHERE CON.CONT_FK_EDIFICIO = E.EDI_CLAVE AND \n" +
                                                                            " E.EDI_RIF = '"+RifEdificio+"' ");
                    while (Valores.next()){ 
                              Date Rc = Valores.getDate(1);
                              String fuera = Rc.toString();
                              //JOptionPane.showMessageDialog(null,"Fecha Salida ="+fuera);
                        return(fuera);
                    }
          return ("");   
            
    };





public static Float DevuelvePrecioAlto(String Clave) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select CONT_MONTO " +
                                                                            " from CONTRATO, EDIFICIO E " +
                                                                            " WHERE CONTRATO.CONT_FK_EDIFICIO = E.EDI_CLAVE " +
                                                                            " AND E.EDI_RIF = '"+Clave+"' " +
                                                                            " AND CONTRATO.CONT_FECHA_EMISION = (SELECT MAX (CONTRATO.CONT_FECHA_EMISION)\n" +
                                                                                                                            "                                   FROM CONTRATO\n" +
                                                                                                                            "                                   WHERE CONTRATO.CONT_FK_EDIFICIO = E.EDI_CLAVE)");
                    while (Valores.next()){ 
                              return(Valores.getFloat(1));
                    }
    return null;
            
    };

}