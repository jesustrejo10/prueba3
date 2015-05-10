/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.VentanaMenuRolesControlador.Consultar_PK_ROL;
import Interfaz.VentanaMenuEdificio;
import Interfaz.VentanaMenuRoles;
import Modelo.ConexionOracle;
import Modelo.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Trejo
 */
public class VentanaMenuEdificioControlador {

public static ArrayList<String> Estados= new ArrayList();
public static ArrayList<String> Municipios = new ArrayList();
public static ArrayList<String> Parroquias = new ArrayList();

public static void LlenarEstado() throws SQLException{
    llenarListaEstados();
     
}

public static String devuelvedireccionSQL(String fk_Parroquia) throws SQLException{
    
    ConexionOracle Conexion= new ConexionOracle();
    Connection Con=Conexion.Conectar();
    Statement st= Con.createStatement();
    String direccion="";
    String Estado = null;
    String Municipio = null;
    String Parroquia = null;
    ResultSet Valores= st.executeQuery("SELECT E.LUG_NOMBRE, M.LUG_NOMBRE, P.LUG_NOMBRE"
            + "                                                        FROM LUGAR  P, LUGAR E, LUGAR M "
            + "                                                        WHERE (P.LUG_CLAVE ="+fk_Parroquia+") AND (P.LUG_FK_LUGAR= M.LUG_CLAVE) AND (M.LUG_FK_LUGAR = E.LUG_CLAVE)");
       while (Valores.next()){
            Estado =(Valores.getString(1));
            Municipio =(Valores.getString(2));
            Parroquia =(Valores.getString(3));
       }
    
    direccion = Estado+"/"+Municipio+"/"+Parroquia;
    JOptionPane.showMessageDialog(null,"La direccion es ->"+direccion);
    
return (direccion);
}

public static void llenarListaEstados() throws SQLException{
        
    ConexionOracle Conexion= new ConexionOracle();
    Connection Con=Conexion.Conectar();
    Statement st= Con.createStatement();
    ResultSet Valores= st.executeQuery("SELECT (LUG_NOMBRE) FROM LUGAR WHERE (LUG_TIPO = 'Estado')");
       while (Valores.next()){
            //JOptionPane.showMessageDialog(null,"AQUIII");
            Estados.add(Valores.getString(1));
       }
}

public static void llenarListaMunicipios(String FK_Lugar) throws SQLException{
    Municipios.clear();
    ConexionOracle Conexion= new ConexionOracle();
    Connection Con=Conexion.Conectar();
    Statement st= Con.createStatement();
    ResultSet Valores= st.executeQuery("SELECT (LUG_NOMBRE) FROM LUGAR WHERE (LUG_FK_LUGAR ="+FK_Lugar+" )");
       while (Valores.next()){
            //JOptionPane.showMessageDialog(null,"AQUIII");
            Municipios.add(Valores.getString(1));
            
       }
}

public static void llenarListaParroquias(String FK_Lugar) throws SQLException{
    Parroquias.clear();
    //String prueba = Integer.toString(Integer.parseInt(FK_Lugar)+1);
    //FK_Lugar = prueba;
    ConexionOracle Conexion= new ConexionOracle();
    Connection Con=Conexion.Conectar();
    Statement st= Con.createStatement();
    ResultSet Valores= st.executeQuery("SELECT (LUG_NOMBRE) FROM LUGAR WHERE (LUG_FK_LUGAR ="+FK_Lugar+" )");
       while (Valores.next()){
            //JOptionPane.showMessageDialog(null,"AQUIII");
            Parroquias.add(Valores.getString(1));
            
       }
}

public static int InsertarEdificioSQL(String Rif, String Nombre, String FK_Lugar) throws SQLException{

        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        String Clave= Util.Consultar_PK("EDIFICIO","EDI_CLAVE");
        //JOptionPane.showMessageDialog(null,"LA CLAVE DEL EDIF ES:"+Clave);
        
        if (Clave.equalsIgnoreCase("null")){
            //JOptionPane.showMessageDialog(null,"LOGRE BURLAR EL NULL");
            Clave="0";
        }
            
        //JOptionPane.showMessageDialog(null,"ENCONTRO LA CLAVE DEL EDIF ->"+Clave);
        PreparedStatement pst=  Con.prepareStatement("INSERT INTO EDIFICIO (EDI_CLAVE,EDI_RIF,EDI_NOMBRE,EDI_FK_LUGAR) VALUES (?,?,?,?)");
        pst.setInt(1,Integer.parseInt(Clave)+1);
        pst.setString(2,Rif);
        pst.setString(3,Nombre);
        pst.setInt(4,Integer.parseInt(FK_Lugar));
        pst.executeUpdate();    

        return (Integer.parseInt(Clave)+1);
}

public static void RellenaTablaSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaMenuEdificio.cont = 0;
         ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM EDIFICIO");
            while (Valores.next()){
                    Rif=Valores.getString(2);
                    Nombre=Valores.getString(3);
                    foranea = Valores.getInt(4);
                    VentanaMenuEdificio.modelo.insertRow(VentanaMenuEdificio.cont, new Object[]{});
                    VentanaMenuEdificio.modelo.setValueAt(Rif,VentanaMenuEdificio.cont,0);
                    VentanaMenuEdificio.modelo.setValueAt(Nombre,VentanaMenuEdificio.cont,1);
                    VentanaMenuEdificio.modelo.setValueAt(Integer.toString(foranea),VentanaMenuEdificio.cont,2);
                    VentanaMenuEdificio.cont++;
            }
 };
 
public static void ConsultaClaveEdificioSeleccionadoSQL(String Nombre, String Rif) throws SQLException{

        String clave =null ;
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        ResultSet Valores= st.executeQuery("SELECT AC_CLAVE " +
                                                                           "FROM AREACOMUN, EDIFICIO , AREA_DET " +
                                                                           "WHERE   ((EDI_CLAVE = AD_FK_EDIFICIO)  AND  (AD_FK_AREACOMUN = AC_CLAVE) and (EDI_NOMBRE = '"+Nombre+"') and (EDI_RIF = '"+Rif+"'))");
  
            while (Valores.next()){
                  clave=Integer.toString(Valores.getInt(1));
                  VentanaMenuEdificio.PermisosActuales.add(clave);
                  //JOptionPane.showMessageDialog(null,"lo encuentra");
            }
    
            
};

public static void InsertaArea_DetSQL(int fk_edificio) throws SQLException{

        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        int Clave = Integer.parseInt(Util.Consultar_PK("AREA_DET","AD_CLAVE")) +1;
        for (String x : VentanaMenuEdificio.AreasComunes){
        PreparedStatement pst=  Con.prepareStatement("INSERT INTO AREA_DET (AD_CLAVE,AD_FK_AREACOMUN,AD_FK_EDIFICIO) VALUES (?,?,?)");
        pst.setInt(1,Clave);
        pst.setInt(2,Integer.parseInt(x));
        pst.setInt(3,fk_edificio);
        pst.executeUpdate();    
        Clave++;
        }

}
}