/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Interfaz.VentanaMenuLibro;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class VentanaMenuLibroControlador {
    
    public static void RellenaTablaContratosSQL() throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          String ID="";
          String Monto="";
          String Quorum ="";
          String FechaEmision="";
          String FechaVenci="";
          VentanaMenuLibro.cont = 0;
          ResultSet Valores= st.executeQuery("SELECT *"
                                            + " FROM CONTRATO");
            while (Valores.next()){
                    ID=Valores.getString(1);
                    Monto=Valores.getString(2);
                    FechaEmision = Valores.getString(3);
                    FechaVenci = Valores.getString(4);
                    Quorum = Valores.getString(5);
                    VentanaMenuLibro.ModeloContratos.insertRow(VentanaMenuLibro.cont, new Object[]{});
                    VentanaMenuLibro.ModeloContratos.setValueAt(ID,VentanaMenuLibro.cont,0);
                    VentanaMenuLibro.ModeloContratos.setValueAt(Monto,VentanaMenuLibro.cont,1);
                     VentanaMenuLibro.ModeloContratos.setValueAt(FechaEmision,VentanaMenuLibro.cont,2);
                    VentanaMenuLibro.ModeloContratos.setValueAt(FechaVenci,VentanaMenuLibro.cont,3);
                    VentanaMenuLibro.ModeloContratos.setValueAt(Quorum,VentanaMenuLibro.cont,4);
                    VentanaMenuLibro.cont++;
            }
 };
    

 public static void RellenaTablaLibrosJSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuLibro.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT L.LIB_CLAVE , L.LIB_TIPO \n" +
                                                                            " FROM LIBRO L, CONTRATO\n" +
                                                                            " WHERE L.LIB_FK_CONTRATO = CONT_CLAVE "
                 + "                                                           and CONT_CLAVE = "+Clave+" and L.LIB_TIPO= 'JUNTA' ");
            while (Valores.next()){
                     VentanaMenuLibro.ModeloLibros.insertRow(VentanaMenuLibro.contAPT, new Object[]{});
                     VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getInt(1),VentanaMenuLibro.contAPT,0);
                    VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getString(2),VentanaMenuLibro.contAPT,1);
                   // VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getString(3),VentanaMenuLibro.contAPT,2);
                    
                    VentanaMenuLibro.contAPT++;
            }
    
}  
 
 public static void RellenaTablaLibrosSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuLibro.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT L.LIB_CLAVE , L.LIB_TIPO\n" +
                                                                            " FROM LIBRO L, CONTRATO\n" +
                                                                            " WHERE L.LIB_FK_CONTRATO = CONT_CLAVE "
                 + "                                                           and CONT_CLAVE = "+Clave+"");
            while (Valores.next()){
                     VentanaMenuLibro.ModeloLibros.insertRow(VentanaMenuLibro.contAPT, new Object[]{});
                     VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getInt(1),VentanaMenuLibro.contAPT,0);
                    VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getString(2),VentanaMenuLibro.contAPT,1);
                    //VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getString(3),VentanaMenuLibro.contAPT,2);
                    
                    VentanaMenuLibro.contAPT++;
            }
    
}  
 
 
 

 public static void RellenaTablaLibrosOSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuLibro.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT L.LIB_CLAVE , L.LIB_TIPO\n" +
                                                                            " FROM LIBRO L, CONTRATO\n" +
                                                                            " WHERE L.LIB_FK_CONTRATO = CONT_CLAVE "
                 + "                                                           and CONT_CLAVE = "+Clave+" and L.LIB_TIPO = 'OFICINA' ");
            while (Valores.next()){
                     VentanaMenuLibro.ModeloLibros.insertRow(VentanaMenuLibro.contAPT, new Object[]{});
                     VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getInt(1),VentanaMenuLibro.contAPT,0);
                    VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getString(2),VentanaMenuLibro.contAPT,1);
                   // VentanaMenuLibro.ModeloLibros.setValueAt(Valores.getString(3),VentanaMenuLibro.contAPT,2);
                    
                    VentanaMenuLibro.contAPT++;
            }
    
} 
 
 
 
 
 
 public static void RellenaTablaMiembrosSQL(String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuLibro.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT M.MIE_CLAVE , M.MIE_CARGO, PRO_PNOMBRE, PRO_PAPELLIDO\n" +
                                                                            " FROM MIEMBRO M, EDIFICIO, JUNTACONDOMINIO, CONTRATO, PROPIETARIO\n" +
                                                                            " WHERE CONT_FK_EDIFICIO = EDI_CLAVE AND JC_FK_EDIFICIO = EDI_CLAVE AND MIE_FK_JUNTACONDOMINIO = JC_CLAVE AND PRO_CLAVE = MIE_FK_PROPIETARIO"
                 + "                                                           and CONT_CLAVE = "+Clave+"");
            while (Valores.next()){
                     VentanaMenuLibro.ModeloMiembros.insertRow(VentanaMenuLibro.contAPT, new Object[]{});
                     VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getInt(1),VentanaMenuLibro.contAPT,0);
                    VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getString(3),VentanaMenuLibro.contAPT,1);
                    VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getString(4),VentanaMenuLibro.contAPT,2);
                    VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getString(2),VentanaMenuLibro.contAPT,3);
                    VentanaMenuLibro.contMIE++;
            }
            
            
 }       
            
            
            
            public static void RellenaTablaOFIEMPSQL (String Clave) throws SQLException{
 
        ConexionOracle Conexion= new ConexionOracle();
        Connection Con=Conexion.Conectar();
        Statement st= Con.createStatement();
        VentanaMenuLibro.contAPT = 0;
         ResultSet Valores= st.executeQuery("SELECT E.EO_CLAVE , E.EO_CARGO, EMP_PNOMBRE, EMP_PAPELLIDO\n" +
                                                                            " FROM EMP_OFI E, OFICINA,CONTRATO,EMPLEADO\n" +
                                                                            " WHERE CONT_FK_OFICINA = OFI_CLAVE AND E.EO_FK_OFICINA = OFI_CLAVE AND EMP_CLAVE = E.EO_FK_EMPLEADO "
                 + "                                                           and CONT_CLAVE = "+Clave+"");
            while (Valores.next()){
                     VentanaMenuLibro.ModeloMiembros.insertRow(VentanaMenuLibro.contAPT, new Object[]{});
                     VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getInt(1),VentanaMenuLibro.contAPT,0);
                    VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getString(3),VentanaMenuLibro.contAPT,1);
                    VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getString(4),VentanaMenuLibro.contAPT,2);
                    VentanaMenuLibro.ModeloMiembros.setValueAt(Valores.getString(2),VentanaMenuLibro.contAPT,3);
                    VentanaMenuLibro.contMIE++;
            } 
            
    
}
 public static void RellenaTablasEscriturasSQL(String Clave) throws SQLException{
 
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          VentanaMenuLibro.cont = 0;
          ResultSet Valores= st.executeQuery("select LM.LM_CLAVE,LM.LM_DESCRIPCION, LM.LM_FECHA\n" +
                                                                            " from LIBRO, LIB_MIEM LM\n" +
                                                                            " WHERE LM.LM_FK_LIBRO = LIBRO.LIB_CLAVE and LIB_CLAVE = "+Clave+"\n" +                                                           
                                                                  "UNION\n" +
                                                                 "select T.TRA_CLAVE, T.TRA_DESCRIPCION, T.TRA_F_REALIZADO\n" +
                                                                            " from LIBRO, LIB_TRA LT, TRABAJO T\n" +
                                                                            " WHERE LT.LT_FK_LIBRO = LIBRO.LIB_CLAVE and T.TRA_CLAVE = LT.LT_FK_TRABAJO and LIB_CLAVE = "+Clave+"\n" + 
                                                                  "UNION\n" +
                                                                    "select LE.LE_CLAVE,LE.LE_DESCRIPCION, LE.LE_FECHA\n" +
                                                                            " from LIBRO, LIB_EMP LE\n" +
                                                                            " WHERE LE.LE_FK_LIBRO = LIBRO.LIB_CLAVE and LIB_CLAVE = "+Clave+"");                                                                                                                                                                       
         
          
          while (Valores.next()){
   
             // JOptionPane.showMessageDialog(null, "PRUEBA");
              VentanaMenuLibro.ModeloEscrituras.insertRow(VentanaMenuLibro.cont, new Object[]{});
                    VentanaMenuLibro.ModeloEscrituras.setValueAt(Valores.getInt(1),VentanaMenuLibro.cont,0);
                    VentanaMenuLibro.ModeloEscrituras.setValueAt(Valores.getString(2),VentanaMenuLibro.cont,1);
                    VentanaMenuLibro.ModeloEscrituras.setValueAt(Valores.getDate(3),VentanaMenuLibro.cont,2);
                    VentanaMenuLibro.cont++;
            }
 };
 
 
 
public static void InsertarLibroMSQL(String DESCRIPCION, String FechaInicioString, String fk_miembro, String fk_libro) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement(" insert into LIB_MIEM  \n" +
                                                         "VALUES ("
                  + "                                              SQ_PK_LIB_MIEM.NEXTVAL,"
                  + "                                              '"+fk_miembro+"',"                                                                          
                  + "                                              '"+fk_libro+"',"  
                  + "                                              TO_DATE('"+FechaInicioString+"','YYYYMMDD'),"                
                  + "                                             '"+DESCRIPCION+"')");

          pst.executeUpdate(); 
}


public static void InsertarLibroESQL(String DESCRIPCION, String FechaInicioString, String fk_ofiemp, String fk_libro) throws SQLException{
           ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          PreparedStatement pst=  Con.prepareStatement(" insert into LIB_EMP  \n" +
                                                         "VALUES ("
                  + "                                              SQ_PK_LIB_MIEM.NEXTVAL,"
                  + "                                              '"+fk_libro+"',"                                                                          
                  + "                                              '"+fk_ofiemp+"',"  
                  + "                                              TO_DATE('"+FechaInicioString+"','YYYYMMDD'),"                
                  + "                                             '"+DESCRIPCION+"')");

          pst.executeUpdate(); 
}

  public static void RellenaCamposFaltantes(String Clave) throws SQLException{

          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("select LM.LM_FECHA\n" +
                                                                            " from LIBRO, LIB_MIEM LM\n" +
                                                                            " WHERE LM.LM_FK_LIBRO = LIBRO.LIB_CLAVE  and LM.LM_CLAVE = "+Clave+"\n" +                                                           
                                                                  "UNION\n" +
                                                                 "select LT. LT_FECHAREALIZADO\n" +
                                                                            " from LIBRO, LIB_TRA LT, TRABAJO T\n" +
                                                                            " WHERE LT.LT_FK_LIBRO = LIBRO.LIB_CLAVE and T.TRA_CLAVE = LT.LT_FK_TRABAJO  AND  LT.LT_CLAVE = "+Clave+" \n" + 
                                                                  "UNION\n" +
                                                                    "select LE.LE_FECHA\n" +
                                                                            " from LIBRO, LIB_EMP LE\n" +
                                                                            " WHERE LE.LE_FK_LIBRO = LIBRO.LIB_CLAVE  AND LE.LE_CLAVE = "+Clave+"");       
                    while (Valores.next()){
                             VentanaMenuLibro.prueba = Valores.getDate(1);
                            //JOptionPane.showMessageDialog(null, "PRUEBA "+VentanaMenuLibro.prueba);
                    }
}







}







