/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaGenerarContrato;
import Interfaz.VentanaMenuEdificio;
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
public class VentanaGenerarContratoControlador {
        
public static void RellenaTablaEdificiosSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        String Rif="";
        String Nombre="";
        int foranea =1;
        VentanaGenerarContrato.cont = 0;
        ResultSet Valores= st.executeQuery("SELECT *"
                                         + " FROM EDIFICIO");
            while (Valores.next()){
                    Rif=Valores.getString(2);
                    Nombre=Valores.getString(3);
                    VentanaGenerarContrato.ModeloEdificios.insertRow(VentanaGenerarContrato.cont, new Object[]{});
                    VentanaGenerarContrato.ModeloEdificios.setValueAt(Rif,VentanaGenerarContrato.cont,0);
                    VentanaGenerarContrato.ModeloEdificios.setValueAt(Nombre,VentanaGenerarContrato.cont,1);
                    VentanaGenerarContrato.cont++;
            }
 
            
            
    };
 
public static void RellenaTablaOficinasSQL() throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        //JOptionPane.showMessageDialog(null,"La clave trampa es:->"+MenuBienesRaices.ClaveTrampa);
        VentanaGenerarContrato.cont = 0;
         ResultSet Valores= st.executeQuery("SELECT O.OFI_CLAVE, O.OFI_NOMBRE , O.OFI_CORREO , L.LUG_NOMBRE \n" +
                                                                            "FROM OFICINA O, LUGAR L\n" +
                                                                            "WHERE O.OFI_FK_LUGAR = L.LUG_CLAVE");
            while (Valores.next()){
                     VentanaGenerarContrato.ModeloOficinas.insertRow(VentanaGenerarContrato.cont, new Object[]{});
                    VentanaGenerarContrato.ModeloOficinas.setValueAt(Valores.getInt(1),VentanaGenerarContrato.cont,0);
                    VentanaGenerarContrato.ModeloOficinas.setValueAt(Valores.getString(2),VentanaGenerarContrato.cont,1);
                    VentanaGenerarContrato.ModeloOficinas.setValueAt(Valores.getString(3),VentanaGenerarContrato.cont,2);
                    VentanaGenerarContrato.ModeloOficinas.setValueAt(Valores.getString(4),VentanaGenerarContrato.cont,3);
                    VentanaGenerarContrato.cont++;
            }
    
}
   
public static void RegistrarLLamado(String numero, String Quorum, String Porcentaje, String fk_Contrato ) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into llamado values(SQ_PK_LLAMADO.NEXTVAL,"+numero+","+Quorum+","+Porcentaje+","+fk_Contrato+")");
          pst.executeUpdate();    
}


public static void RegistrarLibro(String Tipo, String fk_Contrato ) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("INSERT INTO LIBRO VALUES (SQ_PK_LIBRO.NEXTVAL,'"+Tipo+"',"+fk_Contrato+")");
          pst.executeUpdate();    
}


public static void RegistrarContratoSQL(String Monto, String F1, String F2, String FkOfic, String FKEdif) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement("insert into contrato values(SQ_PK_CONTRATO.NEXTVAL,"+Monto+",TO_DATE('"+F1+"','YYYYMMDD'),TO_DATE('"+F2+"','YYYYMMDD'),"+FkOfic+","+FKEdif+")");
          pst.executeUpdate();    

}

public static String ConsultaClaveEdificioSeleccionadoSQL2(String Nombre, String Rif) throws SQLException{
          String clave =null ;
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
         ResultSet Valores= st.executeQuery("SELECT E.EDI_CLAVE\n" +
                                                                          " FROM EDIFICIO E \n" +
                                                                          " WHERE E.EDI_RIF = '"+Rif+"' AND E.EDI_NOMBRE = '"+Nombre+"'");
  
            while (Valores.next()){
                  clave=Integer.toString(Valores.getInt(1));
                   return (clave);
            }
    return ("null");
            
};

public static String ConsultaClaveContrato() throws SQLException{
        String clave =null ;
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        ResultSet Valores= st.executeQuery(" SELECT MAX(C.CONT_CLAVE) \n" +
                                                                          "  FROM CONTRATO C ");
                                                                          
  
            while (Valores.next()){
                  clave=Integer.toString(Valores.getInt(1));
                  JOptionPane.showMessageDialog(null,"LA CLAVE ES->"+clave);
                  return (clave);
                 
            }
    return ("null");
            
};


}
