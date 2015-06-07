/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaMenuEdificio;
import Interfaz.VentanaMenuPropietario;
import Interfaz.VentanaMenuReclamo;
import static Interfaz.VentanaMenuReclamo.DescripcionReclamoSeleccionado;
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
 * @author Luis
 */

public class VentanaMenuReclamoControlador  {
    
public static void RellenaTablaReclamosSQL(String Clave) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String Identificacion="";
          String TITULO="";
          //String DESCRIPCION ="";
          VentanaMenuReclamo.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT REC_CLAVE, REC_TITULO\n"+
                    " FROM RECLAMO, APT_DET \n"+
                   "WHERE AD_CLAVE = REC_FK_APT_DET AND AD_CLAVE = "+Clave+"");
            while (Valores.next()){
                    Identificacion=Valores.getString(1);
                    TITULO=Valores.getString(2);
          //          DESCRIPCION = Valores.getString(6);
                    VentanaMenuReclamo.ModeloApartamentosComprados.insertRow(VentanaMenuReclamo.cont, new Object[]{});
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Identificacion,VentanaMenuReclamo.cont,0);
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(TITULO,VentanaMenuReclamo.cont,1);
                   // VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(DESCRIPCION,VentanaMenuReclamo.cont,2);
                    VentanaMenuReclamo.cont++;
            }
 };
    
public static void RellenaTablaPropietariosSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido ="";
          VentanaMenuReclamo.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM PROPIETARIO");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido = Valores.getString(4);
                    VentanaMenuReclamo.ModeloPropietarios.insertRow(VentanaMenuReclamo.cont, new Object[]{});
                    VentanaMenuReclamo.ModeloPropietarios.setValueAt(ID,VentanaMenuReclamo.cont,0);
                    VentanaMenuReclamo.ModeloPropietarios.setValueAt(Nombre,VentanaMenuReclamo.cont,1);
                    VentanaMenuReclamo.ModeloPropietarios.setValueAt(Apellido,VentanaMenuReclamo.cont,2);
                    VentanaMenuReclamo.cont++;
            }
 };

public static void CalculaClaveOficina(String Clave) throws SQLException{

          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("  select O.OFI_CLAVE\n" +
                                                                            "   from OFICINA O INNER JOIN CONTRATO CON ON O.OFI_CLAVE = CON.CONT_FK_OFICINA \n" +
                                                                            "     INNER JOIN EDIFICIO E ON E.EDI_CLAVE = CON.CONT_FK_EDIFICIO INNER JOIN \n" +
                                                                            "      APT_DET AD ON AD.AD_FK_EDIFICIO = E.EDI_CLAVE\n" +
                                                                            "   WHERE AD.AD_CLAVE = "+Clave+"");
                    while (Valores.next()){
                              VentanaMenuReclamo.ClaveOficina = Integer.toString(Valores.getInt(1));
                           
                    }
}

public static void RellenaTablaApartamentosCompradosSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        //JOptionPane.showMessageDialog(null,"La clave trampa es:->"+MenuBienesRaices.ClaveTrampa);
        VentanaMenuReclamo.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT E.EDI_NOMBRE , APT.APT_MEDIDAS , AD.AD_ALICUOTA ,AD.AD_PISO,AD.AD_CLAVE,AD.AD_PRECIO\n" +
                                                                            " FROM EDIFICIO E, APARTAMENTO APT, PROPIETARIO P, APT_DET AD\n" +
                                                                            " WHERE E.EDI_CLAVE = AD.AD_FK_EDIFICIO AND APT.APT_CLAVE = AD.AD_FK_APARTAMENTO AND P.PRO_CLAVE = AD.AD_FK_PROPIETARIO"
                 + "                                                           and P.PRO_CLAVE = "+Clave+"");
            while (Valores.next()){
                     VentanaMenuReclamo.ModeloApartamentosComprados.insertRow(VentanaMenuReclamo.contAPT, new Object[]{});
                     VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Valores.getString(1),VentanaMenuReclamo.contAPT,0);
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Valores.getString(2),VentanaMenuReclamo.contAPT,1);
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Valores.getFloat(3),VentanaMenuReclamo.contAPT,2);
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Valores.getString(4),VentanaMenuReclamo.contAPT,3);
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Valores.getInt(5),VentanaMenuReclamo.contAPT,4);
                    VentanaMenuReclamo.ModeloApartamentosComprados.setValueAt(Valores.getFloat(6),VentanaMenuReclamo.contAPT,5);
                    VentanaMenuReclamo.contAPT++;
            }
    
}

public static void RellenaCamposFaltantes(String Clave) throws SQLException{

          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("SELECT REC_DESCRIPCION, REC_FECHA\n"
                                                                          + "FROM RECLAMO, APT_DET\n"
                                                                         + " WHERE (REC_CLAVE = "+Clave+")");
                    while (Valores.next()){
                              VentanaMenuReclamo.DESCRIPCION = Valores.getString(1);
                             VentanaMenuReclamo.prueba = Valores.getDate(2);
                    }
}

public static void InsertarReclamoSQL(String TITULO ,String DESCRIPCION, String FechaInicioString, String fk_apartamento) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement(" insert into RECLAMO  \n" +
                                                         "VALUES ("
                  + "                                              SQ_PK_RECLAMO.NEXTVAL,"
                  + "                                              '"+DESCRIPCION+"',"                                                                          
                  + "                                              TO_DATE('"+FechaInicioString+"','YYYYMMDD'),"
                  + "                                              '"+fk_apartamento+"',"                      
                  + "                                               "+VentanaMenuReclamo.ClaveOficina+","
                  + "                                             '"+TITULO+"')");

          pst.executeUpdate(); 
}

}
