/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorconsulta;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author Gustavo
 */
public class GeneradorConsulta {
public static int contadorApt=1;
public static int contadorEdif=1;
public static int AleatorioPropietario=0;
public static int AleatorioOficina=0;
public static int AleatorioEdificio=0;
public static int AleatorioPiso=0;
public static String PropietarioNull="";
public static int contadorRif=5768493;
public static int contadorEdificio=1;
public static int contadorOficina=1;
public static int comparacionEdificios=11;
public static int x=0;


public static Random  Propietario = new Random();
public static Random  Oficina = new Random();
public static Random Edificio = new Random();
public static Random Piso= new Random();


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

  x=10;
        while(contadorEdificio!=31){
             System.out.println("insert into EDIFICIO values("+contadorEdificio+",'J-"+contadorRif+"','Margaritas',14154);");
             contadorEdificio++;
             contadorRif=contadorRif+578;
 
        }
         while(contadorOficina!=21){
             System.out.println("insert into OFICINA values("+contadorOficina+",'Automatic@hotmail.com','Florecita',14154);");
             contadorOficina++;
        
 
        }

           
        while(contadorApt!=301){
             AleatorioPropietario= (int)(Propietario.nextDouble()*(20+1));
             AleatorioOficina=(int)(Oficina.nextDouble()*(20+1));
             AleatorioPiso=(int)(Piso.nextDouble()*(15+1));
             
              if(contadorApt==comparacionEdificios){
                   if(contadorApt==101){
                       x=20;
                   }
                   contadorEdif++;
                   comparacionEdificios=comparacionEdificios+x;
              
               }
             if(AleatorioPropietario==0){
               if(AleatorioOficina==0){
                   AleatorioOficina=4;
               }
               if(AleatorioPiso==0){
                   AleatorioPiso++;
               }
               
              
             
             
             
        System.out.println("insert into APARTAMENTO VALUES ("+contadorApt+",'75m X 80m');");
      System.out.println("insert into CUENTA VALUES ("+contadorApt+",'75m X 80m');");
      System.out.println("insert into APT_DET VALUES ("+contadorApt+",10,"+contadorApt+",'',"+AleatorioOficina+","+contadorEdif+","+contadorApt+",1000000,'NO',"+AleatorioPiso+");");
        
        contadorApt++;
             }
             else{
                  if(contadorApt==comparacionEdificios){
                   contadorEdif++;
                   comparacionEdificios=comparacionEdificios+10;
               }
                 if(AleatorioPiso==0){
                     AleatorioPiso++;
                 }
  
                 System.out.println("insert into APARTAMENTO VALUES ("+contadorApt+",'75m X 80m')");
                System.out.println("insert into CUENTA VALUES ("+contadorApt+",'75m X 80m')");
                System.out.println("insert into APT_DET VALUES ("+contadorApt+",10,"+contadorApt+","+AleatorioPropietario+",'',"+contadorEdif+","+contadorApt+",1000000,'NO',"+AleatorioPiso+");");
                 
                  contadorApt++;
                 
             }
        }
        
         System.out.println("FIN");
    
    }
           
    
}
