/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.VentanaMenuJuntaCondominioControlador;
import Controlador.VentanaMiembrosControlador;
import static Interfaz.VentanaMenuJuntaCondominio.Opcion;
import Modelo.Util;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Gustavo
 */



public class VentanaMiembros extends javax.swing.JFrame {

     public static DefaultTableModel modeloMiembros = new DefaultTableModel();
     public static DefaultTableModel modeloPropietarios = new DefaultTableModel();
     public static int cont = 0;
     public static int contadorEspecial=0;
     public static int ClaveJunta;
     public static int ClaveEdificio;
     public static int ClaveMiembro;
     public static int valida=0;
     public static String ClavePropietario= null;
     public static String ClaveMiembros = null;
     public static ArrayList IdentificacionesMiembros = new ArrayList();
    public static ArrayList IdentificacionesPropietarios = new ArrayList(); 
    
    /**
     * Creates new form VentanaMiembros
     * @param Opcion
     * @param Clave
     */
    
    
    public VentanaMiembros(Integer Opcion,String Clave ) throws SQLException {
        initComponents();
        
         IdentificacionesMiembros.add(0,"9999");
        IdentificacionesMiembros.add(1, "9999");
        IdentificacionesMiembros.add(2, "9999");
        IdentificacionesMiembros.add(3, "9999");
        IdentificacionesMiembros.add(4, "9999");
        IdentificacionesMiembros.add(5, "9999");
       
        ClaveJunta = Integer.parseInt(Clave);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        if(Opcion == 0){ //para agregar propietarios a la junta recien creada
            JOptionPane.showMessageDialog(rootPane,"Por favor Escriba el cargo del miembro y seleccione /n en la tabla de Propietarios, para agregar un miembro");
            LimpiarJTable(modeloMiembros);
            LimpiarJTable(modeloPropietarios);
            
            TXTCargo.setEnabled(true);
            TXTCargo.requestFocusInWindow();
        
            
            PanelTabla2.setVisible(true);
            PanelTabla1.setVisible(true);
            PanelTabla1.setVisible(true);
            
          
            TXTCargo.setText("");
            
            jButton1.setText("Borrar Campos");
            
            
            
            try{
            cargarInterfazPropietarios();
             ClaveEdificio =  Integer.parseInt(Util.Consultar_PK_EdificioConClaveJunta(ClaveJunta));
            
            VentanaMiembrosControlador.RellenaTablaPropietariosSQL(ClaveEdificio);
            } catch(SQLException ex) {
                        Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
          
        }
        
 
        
         if(Opcion == 1){ //CONSULTAR MIEMBROS
            LimpiarJTable(modeloMiembros);
            cargarInterfazMiembros();
          PanelFormulario.setVisible(false);
            PanelTabla2.setVisible(false);
            PanelTabla1.setVisible(true);
            
            jButton1.setVisible(false);
          
            jButton2.setVisible(true);
            jButton2.setText("Atras");
            
             
             
             
             try {
                        VentanaMiembrosControlador.RellenaTablaMiembrosSQL(ClaveJunta);
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
             
             
             
             
             
             
         }
         
                if(Opcion ==3){ //Para Agregar Miembros a una junta
                    LimpiarJTable(modeloMiembros);
                   
            LimpiarJTable(modeloPropietarios);
                    cargarInterfazMiembros();
                    jLabel1.setVisible(true);
                    jLabel1.setText("Tabla Miembros de la junta "+ClaveJunta);
                    jLabel2.setVisible(true);
                    jLabel2.setText("Tabla Propietarios Disponibles para la junta "+ClaveJunta);
                    jButton1.setVisible(false);
                   
                     JOptionPane.showMessageDialog(rootPane,"Indique el cargo que ocupara el propietario /n y seleccionelo de la tabla propietarios ");
                     TXTCargo.requestFocusInWindow();
                    ClaveEdificio =  Integer.parseInt(Util.Consultar_PK_EdificioConClaveJunta(ClaveJunta));
                    try {
                        VentanaMiembrosControlador.RellenaTablaMiembrosSQL(ClaveJunta);
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ObtenerMiembrosDeTabla();
                    cargarInterfazPropietarios();
                    try {
                       
                        VentanaMiembrosControlador.RellenaTablaPropietariosNoEnJuntaSQL(IdentificacionesMiembros,ClaveJunta);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
        }
                
                if(Opcion ==4){
                    
                       LimpiarJTable(modeloMiembros);
                       LimpiarJTable(modeloPropietarios);
          JOptionPane.showMessageDialog(rootPane,"Seleccione en la tabla de miembros el que desee eliminar de la Junta '"+ClaveJunta+"'");
                    
            PanelTabla2.setVisible(true);
            PanelTabla1.setVisible(true);
            PanelFormulario.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(true);
            jButton2.setText("Atras");
            jLabel1.setText("Seleccione un miembro para eliminarlo de la junta '"+ClaveJunta+"'");
            jLabel2.setText("Tabla de propietarios");
             try {
                 cargarInterfazMiembros();
                        VentanaMiembrosControlador.RellenaTablaMiembrosSQL(ClaveJunta);
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ObtenerMiembrosDeTabla();
                    cargarInterfazPropietarios();
                    
                    try {
                       
                        VentanaMiembrosControlador.RellenaTablaPropietariosNoEnJuntaSQL(IdentificacionesMiembros,ClaveJunta);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(Tabla1.getRowCount() == 0){
                        JOptionPane.showMessageDialog(rootPane,"No hay miembros que eliminar en esta junta");
      
                        
                    }
                    
                    
                        
                    
                        
                    
                }
    }

    
       public static void LimpiarJTable(DefaultTableModel Nombremodelo){
          int a =Nombremodelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    Nombremodelo.removeRow(i);
          }
        }

     public void cargarInterfazMiembros(){
        String x[][]={};
        String columnas[]={"Cargo","Nombre","Apellido","ID"}; //Miembros
               modeloMiembros = new DefaultTableModel(x, columnas); //Talbla que muestra a los miembros
                Tabla1.setModel(modeloMiembros);
        
     }
          
     public void cargarInterfazPropietarios(){
        String x[][]={};
       String columnas2[]={"ID","Nombre","Apellido"}; //Propietarios
                modeloPropietarios = new DefaultTableModel(x, columnas2); //Tabla que muestra a los propietarios
                Tabla2.setModel(modeloPropietarios);
        
       
     }
     
         public void ObtenerMiembrosDeTabla(){ /*FUNCION QUE DEBE DEVOLBER UN ARRAY CON LAS CLAVES DE 
                                            MIEMBROS EN LA TABLA 1*/
                                                            
             int columna = 3;
             int fila=0;
             int ID=0;
          if (Opcion == 3)  {
         while(fila <Tabla1.getRowCount()){
             ID = Integer.parseInt((String) Tabla1.getValueAt(fila, columna));
             IdentificacionesMiembros.add(fila,ID);       
            JOptionPane.showMessageDialog(rootPane,"Valor de columna= "+columna+", Valor de fila = "+fila+" Valor del getcount= "+Tabla1.getRowCount()+" Valor de ID= "+ID+" Valor del ARRAY posicion Fila "+IdentificacionesMiembros.get(fila));
             fila++;
                
         }
                
          }
          
            if (Opcion == 4)  {
         while(fila <Tabla1.getRowCount()){
             ID = Integer.parseInt((String) Tabla1.getValueAt(fila, columna));
             IdentificacionesMiembros.add(fila,ID);       
            JOptionPane.showMessageDialog(rootPane,"Valor de columna= "+columna+", Valor de fila = "+fila+" Valor del getcount= "+Tabla1.getRowCount()+" Valor de ID= "+ID+" Valor del ARRAY posicion Fila "+IdentificacionesMiembros.get(fila));
             fila++;
                
         }
                
          }
        
        
    }
    
    

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        PanelFormulario = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TXTCargo = new javax.swing.JTextField();
        PanelTabla1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        PanelTabla2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("MENU DE MIEMBROS");

        jButton1.setText("Boton");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Cargo que ocupara el miembro");

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXTCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXTCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla1);

        javax.swing.GroupLayout PanelTabla1Layout = new javax.swing.GroupLayout(PanelTabla1);
        PanelTabla1.setLayout(PanelTabla1Layout);
        PanelTabla1Layout.setHorizontalGroup(
            PanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTabla1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelTabla1Layout.setVerticalGroup(
            PanelTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla2);

        javax.swing.GroupLayout PanelTabla2Layout = new javax.swing.GroupLayout(PanelTabla2);
        PanelTabla2.setLayout(PanelTabla2Layout);
        PanelTabla2Layout.setHorizontalGroup(
            PanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(PanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTabla2Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
        PanelTabla2Layout.setVerticalGroup(
            PanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
            .addGroup(PanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelTabla2Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(PanelTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(PanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(PanelTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(3, 3, 3)
                .addComponent(PanelTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        TXTCargo.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseClicked
        // TODO add your handling code here:
        IdentificacionesMiembros.add(0,"9999");
        IdentificacionesMiembros.add(1, "9999");
        IdentificacionesMiembros.add(2, "9999");
        IdentificacionesMiembros.add(3, "9999");
        IdentificacionesMiembros.add(4, "9999");
        IdentificacionesMiembros.add(5, "9999");
        if(Opcion==4){
            if( ( Tabla1.getSelectedRows().length > 0 ) && (Opcion == 4) ) {
                int num = Tabla1.getSelectedRow();
                int ClaveMiembro2 =  Integer.parseInt((String) Tabla1.getValueAt(num,3));

                try {
                    VentanaMiembrosControlador.eliminaMiembrosSQL(ClaveMiembro2,ClaveJunta);
                    String aux= Integer.toString(ClaveJunta);
                    JOptionPane.showMessageDialog(rootPane,"Miembro Eliminado Correctamente");
                    VentanaMiembros Reinicia= new VentanaMiembros(Opcion,aux);
                    Reinicia.setVisible(true);
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_Tabla1MouseClicked

    private void Tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla2MouseClicked
        // TODO add your handling code here:
        IdentificacionesMiembros.add(0,"9999");
        IdentificacionesMiembros.add(1, "9999");
        IdentificacionesMiembros.add(2, "9999");
        IdentificacionesMiembros.add(3, "9999");
        IdentificacionesMiembros.add(4, "9999");
        IdentificacionesMiembros.add(5, "9999");
        if(Opcion==0){
            JOptionPane.showMessageDialog(rootPane,"La opcion vale =  "+Opcion);

            if( ( Tabla2.getSelectedRows().length > 0 ) && (Opcion == 0) ) {
                int num = Tabla2.getSelectedRow();
                ClavePropietario = (String) Tabla2.getValueAt(num,0);
                LimpiarJTable(modeloMiembros);
                LimpiarJTable(modeloPropietarios);

                String CargoMiembro = TXTCargo.getText();
                int ClaveP = Integer.parseInt(ClavePropietario);

                try {
                    VentanaMiembrosControlador.insertaMiembrosSQL(CargoMiembro,ClaveP,ClaveJunta);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane,"Miembro Agregado Correctamente");

                cargarInterfazMiembros();

                try {
                    VentanaMiembrosControlador.RellenaTablaMiembrosSQL(ClaveJunta);
                    cargarInterfazPropietarios();

                    VentanaMiembrosControlador.RellenaTablaPropietarios2SQL(ClaveEdificio,ClaveP);

                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                }
                TXTCargo.setText("");

            }
        }

        if(Opcion==3){
            JOptionPane.showMessageDialog(rootPane,"La opcion vale =  "+Opcion);

            if( ( Tabla2.getSelectedRows().length > 0 ) && (Opcion == 3) ) {
                int num = Tabla2.getSelectedRow();
                ClavePropietario = (String) Tabla2.getValueAt(num,0);
                LimpiarJTable(modeloMiembros);
                LimpiarJTable(modeloPropietarios);

                String CargoMiembro = TXTCargo.getText();
                int ClaveP = Integer.parseInt(ClavePropietario);

                try {
                    VentanaMiembrosControlador.insertaMiembrosSQL(CargoMiembro,ClaveP,ClaveJunta);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane,"Miembro Agregado Correctamente");
                String aux= Integer.toString(ClaveJunta);

                try {
                    VentanaMiembros Reinicia = new VentanaMiembros(Opcion,aux);
                    Reinicia.setVisible(true);
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }//GEN-LAST:event_Tabla2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            VentanaMenuJuntaCondominio VJC = new VentanaMenuJuntaCondominio();
            VJC.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMiembros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(String Clave) {
                try {
                    new VentanaMiembros(Opcion,Clave).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMiembros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelTabla1;
    private javax.swing.JPanel PanelTabla2;
    private javax.swing.JTextField TXTCargo;
    private javax.swing.JTable Tabla1;
    private javax.swing.JTable Tabla2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
