/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.VentanaMenuJuntaCondominioControlador;
import Modelo.Util;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */



public class VentanaMenuJuntaCondominio extends javax.swing.JFrame {

    DateFormat df = DateFormat.getDateInstance();
     public static DefaultTableModel modelo = new DefaultTableModel();
     public static DefaultTableModel modeloEdificios = new DefaultTableModel();
     public static DefaultTableModel modeloJuntaSegunEdificio = new DefaultTableModel();
     public static int cont = 0;
     public static int cont2=0;
     public static int cont3=0;
       public static int Opcion;
       public static boolean ActivaCombo = false;
          public static String ClaveEdificio= null;
           public static String ClaveJunta= null;
          public static  String seleccionEnTablaClaveJunta = null;
          public static  String seleccionEnTablaClaveEdificio = null;
    
    /**
     * Creates new form VentanaMenuApartamento
     */
    public VentanaMenuJuntaCondominio()  throws SQLException {
        initComponents();
         PanelTabla.setVisible(false);
         PanelTabla2.setVisible(false);
         PanelFormulario.setBorder(BorderFactory.createLineBorder(Color.black));
         PanelFormulario.setVisible(false);
         jButton2.setVisible(false);
         jLabel6.setVisible(false);
         TXTSeleccionTabla.setText("");
         TXTSeleccionTabla2.setText("");
         TXTSeleccionTabla2.setVisible(false);
         jButton3.setVisible(true);

    }

    
     public static void LimpiarJTable(DefaultTableModel Nombremodelo){
          int a =Nombremodelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    Nombremodelo.removeRow(i);
          }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelSeleccion = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        PanelFormulario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXTClaveEdificio = new javax.swing.JTextField();
        TXTClave = new javax.swing.JTextField();
        CampoFechaInicio = new com.toedter.calendar.JDateChooser();
        CampoFechaFin = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        PanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        TXTSeleccionTabla = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PanelTabla2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        TXTSeleccionTabla2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Menu Junta Condominio");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione una opcion que desee realizar");

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear Junta", "Consultar Junta", "Borrar Junta", "Agregar Propietarios", "Eliminar Propietarios" }));
        ComboOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOpcionActionPerformed(evt);
            }
        });

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSeleccionLayout = new javax.swing.GroupLayout(PanelSeleccion);
        PanelSeleccion.setLayout(PanelSeleccionLayout);
        PanelSeleccionLayout.setHorizontalGroup(
            PanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelSeleccionLayout.setVerticalGroup(
            PanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jLabel3.setText("Numero de Identificacion (*)");

        jLabel4.setText("Fecha de Inicio");

        jLabel5.setText("Fecha en que termina");

        jLabel7.setText("Rif del Edificio");

        TXTClaveEdificio.setText("jTextField1");

        TXTClave.setText("jTextField1");

        jButton4.setText("borrar ID");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXTClave, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(TXTClaveEdificio)
                            .addComponent(CampoFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CampoFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXTClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CampoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(CampoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TXTClaveEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton2.setText("Finalizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jLabel6.setText("Edificios");

        javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
        PanelTabla.setLayout(PanelTablaLayout);
        PanelTablaLayout.setHorizontalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGroup(PanelTablaLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTablaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TXTSeleccionTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelTablaLayout.setVerticalGroup(
            PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXTSeleccionTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(PanelTabla2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(PanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTabla2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTabla2Layout.createSequentialGroup()
                        .addComponent(TXTSeleccionTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        PanelTabla2Layout.setVerticalGroup(
            PanelTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTabla2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TXTSeleccionTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(21, 21, 21)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanelTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(PanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          LimpiarJTable(modeloEdificios);       
             
              Opcion = ComboOpcion.getSelectedIndex();
                if (Opcion==0){
                    cargarInterfazEdificios();
                     try {
                        VentanaMenuJuntaCondominioControlador.RellenaTablaSQL();
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                jButton2.setVisible(true);
                jButton4.setText("Borrar Rif");
                jLabel8.setText("Rellene el formulario los campos con * son obligatorios.");
                jButton2.setText("Agregar");
                jLabel6.setVisible(true);
                JOptionPane.showMessageDialog(rootPane,"Seleccione en la tabla el Edificio que desea asignarle la Junta.");
                PanelTabla.setVisible(true);
                PanelFormulario.setVisible(true);
                TXTClave.setText("");
                TXTClave.setEnabled(true);
                CampoFechaInicio.setEnabled(true);
                CampoFechaFin.setEnabled(true);
                TXTClaveEdificio.setText("");
                TXTClaveEdificio.setEnabled(false);
                TXTSeleccionTabla.setVisible(false);
                }
                 if (Opcion==1){
                     cargarInterfaz();
                                try {
                            VentanaMenuJuntaCondominioControlador.RellenaTablaJuntaCondominioSQL();
                        } catch (SQLException ex) {
                            Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                     PanelTabla.setVisible(true);

                        jLabel8.setVisible(false);
                        jButton2.setVisible(false);
                        jLabel6.setVisible(false);
                        PanelFormulario.setVisible(false);
                        
                        jButton2.setText("Consultar Miembros");
                        jButton2.setVisible(true);
                        TXTSeleccionTabla.setVisible(false);
                 }
                 
                 
                 if (Opcion==2){ //BORRAR UNA JUNTA
                      cargarInterfaz();
                                try {
                            VentanaMenuJuntaCondominioControlador.RellenaTablaJuntaCondominioSQL();
                        } catch (SQLException ex) {
                            Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       PanelTabla.setVisible(true);
                        jButton2.setVisible(true);
                        jButton2.setText("Eliminar");
                        jButton4.setVisible(true);
                        jButton4.setText("Borrar Campos");
                        jLabel8.setVisible(true);
                        jLabel8.setText("Seleccione en la tabla la Junta a eliminar");
                        jLabel6.setVisible(true);
                        jLabel6.setText("Elimine una junta");
                        jLabel7.setText("Nombre Edificio");
                        PanelFormulario.setVisible(true);
                        TXTClave.setText("");
                        TXTClave.setEnabled(false);
                        TXTClaveEdificio.setText("");
                        TXTClaveEdificio.setEnabled(false);
                        CampoFechaInicio.setDate(null);  
                        CampoFechaInicio.setEnabled(false);
                        CampoFechaFin.setDate(null);
                        CampoFechaFin.setEnabled(false);
                     
                 }
                    if (Opcion == 3){ //AGREGAR UN MIEMBRO A LA JUNTACONDOMINIO QUE SE SELECCIONE
                        cargarInterfazEdificios();
                        JOptionPane.showMessageDialog(rootPane,"Seleccione en la tabla el Edificio Al que desea agregar miembros en sus juntas");
                                try {
                       VentanaMenuJuntaCondominioControlador.RellenaTablaSQL();
                        } catch (SQLException ex) {
                            Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                     PanelTabla.setVisible(true);
                        jLabel8.setVisible(false);
                        jButton2.setVisible(false);
                        jLabel6.setVisible(false);
                        PanelFormulario.setVisible(false);                                             
                        TXTSeleccionTabla.setVisible(false);
                 
             }
                    
                    if(Opcion==4){
                        cargarInterfazEdificios();
                        JOptionPane.showMessageDialog(rootPane,"Seleccione en la tabla el Edificio Al que desea eliminarle miembros en sus juntas");
                                try {
                       VentanaMenuJuntaCondominioControlador.RellenaTablaSQL();
                        } catch (SQLException ex) {
                            Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        PanelTabla.setVisible(true);
                        jLabel8.setVisible(false);
                        jButton2.setVisible(false);
                        jLabel6.setVisible(false);
                        PanelFormulario.setVisible(false);                                             
                        TXTSeleccionTabla.setVisible(false);
                        
                    }
              
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
          if(Opcion==0){
              if( ( Tabla.getSelectedRows().length > 0 ) && (Opcion == 0) ) {
                int num = Tabla.getSelectedRow();
                 String Clave = (String) Tabla.getValueAt(num,0);
                  this.TXTClaveEdificio.setText(Clave);
              }
          }
            if(Opcion==1){
              if( ( Tabla.getSelectedRows().length > 0 ) && (Opcion == 1) ) {
                int num = Tabla.getSelectedRow();
                 String Clave = (String) Tabla.getValueAt(num,0);
                  seleccionEnTablaClaveJunta = Clave ;
                  TXTSeleccionTabla.setText(Clave);
              }
          }
          

          
          if(Opcion ==2){
              if( ( Tabla.getSelectedRows().length > 0 ) && (Opcion == 2) ) {
                  try {
                      int num = Tabla.getSelectedRow();
                      String ClaveJunta = (String) Tabla.getValueAt(num,0);
                      String FechaInicio = (String) Tabla.getValueAt(num, 1);
                      
                      SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                      java.util.Date Fecha1 =sdf.parse(FechaInicio);
                      
                      
                      String FechaFin = (String) Tabla.getValueAt(num, 2);
                      java.util.Date Fecha2 =sdf.parse(FechaFin);
                      String NombreEdificio = (String) Tabla.getValueAt(num,3);
                     // ClaveEdificio = Util.Consultar_PK_EdificioConNombre(NombreEdificio);// LIBRERIA UTIL 
                      this.TXTClaveEdificio.setText(NombreEdificio);

                      this.TXTClave.setText(ClaveJunta);
                      this.CampoFechaInicio.setDate(Fecha1);
                      this.CampoFechaFin.setDate(Fecha2);
                  } catch (ParseException ex) {
                      Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                 
                  
                
              }
              
          }
          
          if (Opcion == 3){
               if( ( Tabla.getSelectedRows().length > 0 ) && (Opcion == 3) ) {
             
                      int num = Tabla.getSelectedRow();
                      String Rif = (String) Tabla.getValueAt(num,0);
                       
                   try {
                     ClaveEdificio= Util.Consultar_PK_EdificioConRif(Rif);
                   } catch (SQLException ex) {
                       Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   seleccionEnTablaClaveEdificio = ClaveEdificio;
                   TXTSeleccionTabla.setText(ClaveEdificio);
                   
                   //aqui cuando clickee en la primera tabla, se llena la segunda con las juntas del edificio que escogio el usuario
                   cargarInterfazJuntaSegunEdificio();
                   int ClaveE = Integer.parseInt(ClaveEdificio);
                   try {
                       VentanaMenuJuntaCondominioControlador.RellenaTablaJuntaSegunEdificioSQL(ClaveE);
                   } catch (SQLException ex) {
                       Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                   }
            JOptionPane.showMessageDialog(rootPane,"Seleccione en la segunda tabla La junta que desea agregarle los miembros");  
            PanelTabla2.setVisible(true);
          }
          }
          
          if(Opcion==4){
              if( ( Tabla.getSelectedRows().length > 0 ) && (Opcion == 4) ) {
             
                      int num = Tabla.getSelectedRow();
                      String Rif = (String) Tabla.getValueAt(num,0);
                       
                   try {
                     ClaveEdificio= Util.Consultar_PK_EdificioConRif(Rif);
                   } catch (SQLException ex) {
                       Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   seleccionEnTablaClaveEdificio = ClaveEdificio;
                   TXTSeleccionTabla.setText(ClaveEdificio);
                   
                   //aqui cuando clickee en la primera tabla, se llena la segunda con las juntas del edificio que escogio el usuario
                   cargarInterfazJuntaSegunEdificio();
                   int ClaveE = Integer.parseInt(ClaveEdificio);
                   try {
                       VentanaMenuJuntaCondominioControlador.RellenaTablaJuntaSegunEdificioSQL(ClaveE);
                   } catch (SQLException ex) {
                       Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(Level.SEVERE, null, ex);
                   }
            JOptionPane.showMessageDialog(rootPane,"Seleccione en la segunda tabla La junta que desea eliminarle  miembros");  
            PanelTabla2.setVisible(true);
          }
              
              
          }
          
                   
                  
           
    }//GEN-LAST:event_TablaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 // BOTON PARA AGREGAR UNA JUNTA DE CONDOMINIO
        try{
             if (Opcion ==0){
               
                   
                         String Clave = TXTClave.getText();
                         
                         String FechaInicio = df.format(CampoFechaInicio.getDate());
                         SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 
                          java.util.Date Fecha1=sdf.parse(FechaInicio); 
                          
                         String FechaFin = df.format(CampoFechaFin.getDate());
                         SimpleDateFormat sdf2= new SimpleDateFormat("dd/MM/yyyy"); 
                          java.util.Date Fecha2=sdf.parse(FechaFin); 
                          
                         ClaveEdificio = Util.Consultar_PK_EdificioConRif(TXTClaveEdificio.getText());// LIBRERIA UTIL 
                         
                         java.sql.Date F1 = convertJavaDateToSqlDate(Fecha1); //CONVERSIONES A TIPO SQL.DATE
                         java.sql.Date F2 = convertJavaDateToSqlDate(Fecha2);
                         
                         VentanaMenuJuntaCondominioControlador.insertaJuntaCondominioSQL(Clave,F1,F2,ClaveEdificio);
                          JOptionPane.showMessageDialog(rootPane,"Junta de Condominio Agregada Correctamente");
                           
                          /*VentanaMenuJuntaCondominio reinicia = new VentanaMenuJuntaCondominio();
                              reinicia.setVisible(true);
                              this.dispose();
                          */
                              
                              VentanaMiembros VM = new VentanaMiembros(Opcion,Clave);
                              VM.setVisible(true);
                              this.dispose();
                              
                    
                    }
             
             if(Opcion==1) {
                 if(TXTSeleccionTabla.getText().equals(seleccionEnTablaClaveJunta))
                 {
                 VentanaMiembros VM = new VentanaMiembros(Opcion,seleccionEnTablaClaveJunta);
                              VM.setVisible(true);
                              this.dispose();
                 }
                 else
                      JOptionPane.showMessageDialog(rootPane,"Debe seleccionar una junta de la tabla");
           
                 
                
             }
             
             if(Opcion==2) {
                 String ClaveJunta = TXTClave.getText();
                 VentanaMenuJuntaCondominioControlador.EliminarJuntaCondominioSQL(ClaveJunta);
                 VentanaMenuJuntaCondominioControlador.EliminarMiembrosSQL(ClaveJunta);
                 JOptionPane.showMessageDialog(rootPane,"Junta De Condominio Eliminada Junto con sus miembros");
                              VentanaMenuJuntaCondominio reinicia = new VentanaMenuJuntaCondominio();
                              reinicia.setVisible(true);
                              this.dispose();    
             }
             
             if (Opcion == 3){
                 
                   if(TXTSeleccionTabla.getText().equals(seleccionEnTablaClaveEdificio) && TXTSeleccionTabla2.getText().equalsIgnoreCase(ClaveJunta)) 
                 {
                 VentanaMiembros VM = new VentanaMiembros(Opcion,ClaveJunta);
                              VM.setVisible(true);
                              this.dispose();
                 }
                 else
                      JOptionPane.showMessageDialog(rootPane,"Debe seleccionar un Edificio de la tabla");
                 
            
             }
             
             if(Opcion==4){
                    if(TXTSeleccionTabla.getText().equals(seleccionEnTablaClaveEdificio) && TXTSeleccionTabla2.getText().equalsIgnoreCase(ClaveJunta)) 
                 {
                 VentanaMiembros VM = new VentanaMiembros(Opcion,ClaveJunta);
                              VM.setVisible(true);
                              this.dispose();
                 }
                 else
                      JOptionPane.showMessageDialog(rootPane,"Debe seleccionar un Edificio de la tabla");
                 
             }
                   
                    }catch (Exception e){
          JOptionPane.showMessageDialog(rootPane,"Error, debe llenar los campos obligatorios, o seleccionar en la tabla"+e);
           JOptionPane.showMessageDialog(rootPane,"lo que vale opcion > "+Opcion);
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         VentanaMenuPrincipal nuevo = null;
        try {
            nuevo = new VentanaMenuPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         nuevo.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

         
    }//GEN-LAST:event_formMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
           if (Opcion ==0){
               TXTClaveEdificio.setText("");
           }
           if(Opcion ==2){
                TXTClave.setText("");   
                TXTClaveEdificio.setText("");
                CampoFechaInicio.setDate(null);  
                CampoFechaFin.setDate(null);
                   
               
           }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ComboOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboOpcionActionPerformed

    private void Tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla2MouseClicked
        // TODO add your handling code here:
        
         if(Opcion==3){
              if( ( Tabla2.getSelectedRows().length > 0 ) && (Opcion == 3) ) {
                int num = Tabla2.getSelectedRow();
                 ClaveJunta = (String) Tabla2.getValueAt(num,0);
                 
                   JOptionPane.showMessageDialog(rootPane,"Presione el Boton Agregar Miembros");
                   
                   TXTSeleccionTabla2.setText(ClaveJunta);
                   jButton2.setVisible(true);
                   jButton2.setText("Agregar Miembros");
                  
              }
          }
         
         if(Opcion==4){
             if( ( Tabla2.getSelectedRows().length > 0 ) && (Opcion == 4) ) {
                int num = Tabla2.getSelectedRow();
                 ClaveJunta = (String) Tabla2.getValueAt(num,0);
                 
                   JOptionPane.showMessageDialog(rootPane,"Presione el Boton Eliminar Miembros");
                   
                   TXTSeleccionTabla2.setText(ClaveJunta);
                   jButton2.setVisible(true);
                   jButton2.setText("Eliminar Miembros");
                  
              }
             
         }
        
    }//GEN-LAST:event_Tabla2MouseClicked

    
    public void cargarInterfaz(){
        String x[][]={};
        String columnas[]={"RIF","Nombre"};
        String columnas2[]={"ID","FechaInicio","FechaFin","NombreEdificio"};
        if (Opcion == 0) {
               modelo = new DefaultTableModel(x, columnas);
                Tabla.setModel(modelo);
        }
        if (Opcion == 1) {
               modelo = new DefaultTableModel(x, columnas2);
                Tabla.setModel(modelo);
        }
        if (Opcion == 2) {
               modelo = new DefaultTableModel(x, columnas2);
                Tabla.setModel(modelo);
        }
     
        //RellenaTablaSQL();
    }
    
    public void cargarInterfazEdificios (){
         String x[][]={};
        String columnas[]={"RIF","Nombre"};
        modeloEdificios = new DefaultTableModel(x, columnas);
        Tabla.setModel(modeloEdificios);
    }
    
     public void cargarInterfazJuntaSegunEdificio (){
         String x[][]={};
         String columnas[]={"ID","FechaInicio","FechaFin"};
        modeloJuntaSegunEdificio = new DefaultTableModel(x, columnas);
        Tabla2.setModel(modeloJuntaSegunEdificio);
    }
    
    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) { //CONVIERTE UTIL.DATE A SQL.DATE
        return new java.sql.Date(date.getTime()); }



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
            java.util.logging.Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuJuntaCondominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try {
                    new VentanaMenuJuntaCondominio().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CampoFechaFin;
    private com.toedter.calendar.JDateChooser CampoFechaInicio;
    private javax.swing.JComboBox ComboOpcion;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelSeleccion;
    private javax.swing.JPanel PanelTabla;
    private javax.swing.JPanel PanelTabla2;
    private javax.swing.JTextField TXTClave;
    private javax.swing.JTextField TXTClaveEdificio;
    private javax.swing.JTextField TXTSeleccionTabla;
    private javax.swing.JTextField TXTSeleccionTabla2;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable Tabla2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
