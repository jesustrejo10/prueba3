/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaMenuEdificio;
import Interfaz.VentanaMenuPropietario;
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

public class MenuBienesRaicesControlador {

public static void RellenaTablaSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        MenuBienesRaices.cont = 0;
        ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM EDIFICIO");
            while (Valores.next()){
                    Rif=Valores.getString(2);
                    Nombre=Valores.getString(3);
                    MenuBienesRaices.ModeloEdificios.insertRow(MenuBienesRaices.cont, new Object[]{});
                    MenuBienesRaices.ModeloEdificios.setValueAt(Rif,MenuBienesRaices.cont,0);
                    MenuBienesRaices.ModeloEdificios.setValueAt(Nombre,MenuBienesRaices.cont,1);
                    MenuBienesRaices.cont++;
            }
 
            
            
    };
    
public static void RellenaTablaApartamentosSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        //JOptionPane.showMessageDialog(null,"La clave trampa es:->"+MenuBienesRaices.ClaveTrampa);
        MenuBienesRaices.cont = 0;
         ResultSet Valores= st.executeQuery("SELECT AD.AD_CLAVE,AD.AD_PISO,AD.AD_ALICUOTA,AD_PRECIO, APT.APT_MEDIDAS\n" +
                                                                            "FROM APT_DET AD, APARTAMENTO APT, EDIFICIO E\n" +
                                                                            "WHERE (AD.AD_FK_EDIFICIO = "+MenuBienesRaices.ClaveTrampa+") AND\n" +
                                                                            "(AD.AD_FK_APARTAMENTO = APT.APT_CLAVE)and"
                                                                        +  "(AD.AD_FK_EDIFICIO = E.EDI_CLAVE) AND (AD.AD_VENTA = 'SI')");
            while (Valores.next()){
                     MenuBienesRaices.ModeloApartamentos.insertRow(MenuBienesRaices.cont, new Object[]{});
                    MenuBienesRaices.ModeloApartamentos.setValueAt(Valores.getInt(1),MenuBienesRaices.cont,0);
                    MenuBienesRaices.ModeloApartamentos.setValueAt(Valores.getString(2),MenuBienesRaices.cont,1);
                    MenuBienesRaices.ModeloApartamentos.setValueAt(Valores.getString(3),MenuBienesRaices.cont,2);
                    MenuBienesRaices.ModeloApartamentos.setValueAt(Valores.getString(5),MenuBienesRaices.cont,3);
                    MenuBienesRaices.ModeloApartamentos.setValueAt(Valores.getString(4),MenuBienesRaices.cont,4);
                    MenuBienesRaices.cont++;
            }
    
}
  
public static void RellenaTablaOficinasSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        //JOptionPane.showMessageDialog(null,"La clave trampa es:->"+MenuBienesRaices.ClaveTrampa);
        MenuBienesRaices.cont = 0;
         ResultSet Valores= st.executeQuery("SELECT O.OFI_CLAVE, O.OFI_NOMBRE , O.OFI_CORREO , L.LUG_NOMBRE \n" +
                                                                            "FROM OFICINA O, LUGAR L\n" +
                                                                            "WHERE O.OFI_FK_LUGAR = L.LUG_CLAVE");
            while (Valores.next()){
                     MenuBienesRaices.modeloOficinas.insertRow(MenuBienesRaices.cont, new Object[]{});
                    MenuBienesRaices.modeloOficinas.setValueAt(Valores.getInt(1),MenuBienesRaices.cont,0);
                    MenuBienesRaices.modeloOficinas.setValueAt(Valores.getString(2),MenuBienesRaices.cont,1);
                    MenuBienesRaices.modeloOficinas.setValueAt(Valores.getString(3),MenuBienesRaices.cont,2);
                    MenuBienesRaices.modeloOficinas.setValueAt(Valores.getString(4),MenuBienesRaices.cont,3);
                    MenuBienesRaices.cont++;
            }
    
}
    
public static void RellenaTablaApartamentosCompradosSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        //JOptionPane.showMessageDialog(null,"La clave trampa es:->"+MenuBienesRaices.ClaveTrampa);
        MenuBienesRaices.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT E.EDI_NOMBRE , APT.APT_MEDIDAS , AD.AD_ALICUOTA ,AD.AD_PISO,AD.AD_CLAVE,AD.AD_PRECIO\n" +
                                                                            "FROM EDIFICIO E, APARTAMENTO APT, PROPIETARIO P, APT_DET AD\n" +
                                                                            "WHERE E.EDI_CLAVE = AD.AD_FK_EDIFICIO AND APT.APT_CLAVE = AD.AD_FK_APARTAMENTO AND P.PRO_CLAVE = AD.AD_FK_PROPIETARIO"
                 + "                                                          and P.PRO_CLAVE = "+Clave+"");
            while (Valores.next()){
                     MenuBienesRaices.ModeloApartamentosComprados.insertRow(MenuBienesRaices.contAPT, new Object[]{});
                     MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getString(1),MenuBienesRaices.contAPT,0);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getString(2),MenuBienesRaices.contAPT,1);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getFloat(3),MenuBienesRaices.contAPT,2);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getString(4),MenuBienesRaices.contAPT,3);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getInt(5),MenuBienesRaices.contAPT,4);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getFloat(6),MenuBienesRaices.contAPT,5);
                    MenuBienesRaices.contAPT++;
            }
    
}

public static void RellenaTablaApartamentosCompradosOficinaSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        //JOptionPane.showMessageDialog(null,"La clave trampa es:->"+MenuBienesRaices.ClaveTrampa);
        MenuBienesRaices.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT E.EDI_NOMBRE , APT.APT_MEDIDAS , AD.AD_ALICUOTA ,AD.AD_PISO,AD.AD_CLAVE,AD.AD_PRECIO\n" +
                                                                            "FROM EDIFICIO E, APARTAMENTO APT, OFICINA O, APT_DET AD\n" +
                                                                            "WHERE E.EDI_CLAVE = AD.AD_FK_EDIFICIO AND APT.APT_CLAVE = AD.AD_FK_APARTAMENTO AND O.OFI_CLAVE = AD.AD_FK_OFICINA"
                 + "                                                          and O.OFI_CLAVE = "+Clave+"");
            while (Valores.next()){
                     MenuBienesRaices.ModeloApartamentosComprados.insertRow(MenuBienesRaices.contAPT, new Object[]{});
                     MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getString(1),MenuBienesRaices.contAPT,0);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getString(2),MenuBienesRaices.contAPT,1);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getFloat(3),MenuBienesRaices.contAPT,2);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getString(4),MenuBienesRaices.contAPT,3);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getInt(5),MenuBienesRaices.contAPT,4);
                    MenuBienesRaices.ModeloApartamentosComprados.setValueAt(Valores.getFloat(6),MenuBienesRaices.contAPT,5);
                    MenuBienesRaices.contAPT++;
            }
    
}
    
public static void ConsultaClaveEdificioSeleccionadoSQL(String rif) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("  select EDI_CLAVE\n" +
                                                                             "  from EDIFICIO\n" +
                                                                             "  WHERE (EDI_RIF = '"+rif+"')");

          while (Valores.next()){
                    MenuBienesRaices.ClaveTrampa = Integer.toString(Valores.getInt(1));
          }  
}
    
public static void AsignaApartamentoAPropietario(String ClaveApartamento, String ClavePropietario ) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("update APT_DET SET " +
                                                                                                    " AD_FK_PROPIETARIO = "+ClavePropietario+", AD_VENTA = 'NO' "+
                                                                                                    " WHERE AD_CLAVE ="+ClaveApartamento+" ");
                 
          pst.executeUpdate();    



}
    
public static void ColocarApartamentoEnVentaPropietario(String ClaveApartamento, String NuevoPrecio ) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("update APT_DET SET " +
                                                                                                    " AD_VENTA = 'SI' , AD_PRECIO = "+NuevoPrecio+""+
                                                                                                    " WHERE AD_CLAVE ="+ClaveApartamento+"");
                 
          pst.executeUpdate();    



}

public static void RegistrarTransaccionBienesRaices(Float Comision,String fkapt, String fk_ofi, String fecha ) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into VENTA_APT VALUES(SQ_PK_VENTA_APT.NEXTVAL,"+Comision+","+fkapt+","+fk_ofi+", to_date('"+fecha+"','YYYYMMDD')) ");
          pst.executeUpdate();    
}

public static void RellenaTablaPropietariosSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido ="";
          MenuBienesRaices.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM PROPIETARIO");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido = Valores.getString(4);
                    MenuBienesRaices.modeloPropietarios.insertRow(MenuBienesRaices.cont, new Object[]{});
                    MenuBienesRaices.modeloPropietarios.setValueAt(ID,MenuBienesRaices.cont,0);
                    MenuBienesRaices.modeloPropietarios.setValueAt(Nombre,MenuBienesRaices.cont,1);
                    MenuBienesRaices.modeloPropietarios.setValueAt(Apellido,MenuBienesRaices.cont,2);
                    MenuBienesRaices.cont++;
            }
 };

public static void RellenaTablaaPSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Nombre="";
          String Apellido ="";
          MenuBienesRaices.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM PROPIETARIO");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Nombre=Valores.getString(2);
                    Apellido = Valores.getString(4);
                    MenuBienesRaices.modeloPropietarios.insertRow(MenuBienesRaices.cont, new Object[]{});
                    MenuBienesRaices.modeloPropietarios.setValueAt(ID,MenuBienesRaices.cont,0);
                    MenuBienesRaices.modeloPropietarios.setValueAt(Nombre,MenuBienesRaices.cont,1);
                    MenuBienesRaices.modeloPropietarios.setValueAt(Apellido,MenuBienesRaices.cont,2);
                    MenuBienesRaices.cont++;
            }
 };

public static void AsignaApartamentoAOficina(String ClaveApartamento, String ClavePropietario ) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("update APT_DET SET " +
                                                                                                    " AD_FK_OFICINA = "+ClavePropietario+", AD_VENTA = 'NO' , AD_FK_PROPIETARIO = null"+
                                                                                                    " WHERE AD_CLAVE ="+ClaveApartamento+" ");
                 
          pst.executeUpdate();    



}


}