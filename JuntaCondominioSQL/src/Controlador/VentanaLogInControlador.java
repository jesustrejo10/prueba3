/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Trejo
 */
public class VentanaLogInControlador {
    

public static boolean LogIn(String usuario, String password) throws SQLException{
    
        ConexionOracle ConectarDB= new ConexionOracle();
        Connection Con=ConectarDB.Conectar();
        Statement st= Con.createStatement();
        ResultSet Valores= st.executeQuery("SELECT * FROM USUARIO");
        
            while(Valores.next()){
                //JOptionPane.showMessageDialog(null,"LOS DATOS DEVUELTOS SON: ->"+(Valores.getString(2))+(Valores.getString(3)));
                if ((usuario.equals(Valores.getString(2))) && (password.equals(Valores.getString(3))))
                    return true;
            }
    return false;
    }

}


