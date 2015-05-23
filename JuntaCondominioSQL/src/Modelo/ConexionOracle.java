/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jesus Trejo
 */
import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConexionOracle {
    
    private Connection ConexionDB=null; 
   
    public Connection Conectar(){
    
        try{
        
            Class.forName("oracle.jdbc.OracleDriver");
            String DataBase="jdbc:oracle:thin:@localhost:1521:XE";
            ConexionDB=DriverManager.getConnection(DataBase,"SYSTEM","1234");
            if(ConexionDB!=null){
                System.out.println("Conexion a la base de datos Condominios Ucab Completada");
            }
            else {
                System.out.println("Conexion Fallida");
        
            }
        }
        catch(Exception e){
            
            e.printStackTrace();
            
            
        }
    
    
    
    return ConexionDB;
    }
}
