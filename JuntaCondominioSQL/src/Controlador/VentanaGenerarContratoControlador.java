/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Interfaz.MenuBienesRaices;
import Interfaz.VentanaGenerarContrato;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    
}
