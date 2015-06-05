/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.VentanaMenuEdificioControlador;
import static Controlador.VentanaMenuEdificioControlador.devuelvedireccionSQL;
import Controlador.VentanaMenuPropietarioControlador;
import static Interfaz.VentanaMenuEdificio.ActivaCombo;
import static Interfaz.VentanaMenuEdificio.ClaveEstado;
import static Interfaz.VentanaMenuEdificio.ClaveMunicipio;
import static Interfaz.VentanaMenuEdificio.Opcion;
import static Interfaz.VentanaMenuEdificio.PermisosActuales;
import static Interfaz.VentanaMenuEdificio.modelo;
import Modelo.Util;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class VentanaMenuPropietario extends javax.swing.JFrame {

          public static int Opcion;
          public static boolean ActivaCombo = false;
          public static String ClaveEstado = null;
          public static String ClaveMunicipio = null;
          public static String ClaveParroquia= null;
          public static DefaultTableModel modelo = new DefaultTableModel(); 
          public static int cont = 0;
          public static String ForaneaPropietarioSeleccionado = null;
          public static String SNombrePropietarioSeleccionado = null;
          public static String SapellidoPropietarioSeleccionado= null;
          public static String ParroquiaPropietarioSeleccionado =null;
          public static String MunicipioPropietarioSeleccionado =null;
          public static String EstadoPropietarioSeleccionado =null;
          public static String ClaveActualPropietario= null;
          
    public VentanaMenuPropietario() throws SQLException {
          initComponents();
          PanelFormulario.setBorder(BorderFactory.createLineBorder(Color.black));
          
          PanelFormulario.setVisible(false);
          Panel2.setVisible(false);
          cargarInterfaz();
          jButton3.setVisible(false);
          
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ComboOpcion = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PanelFormulario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXTSApellido = new javax.swing.JTextField();
        TXTPApellido = new javax.swing.JTextField();
        TXTSNombre = new javax.swing.JTextField();
        TXTPNombre = new javax.swing.JTextField();
        TXTClave = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox();
        ComboMunicipio = new javax.swing.JComboBox();
        ComboParroquia = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel1.setText("Menu Propietario");

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear Propietario", "Mostrar Propietarios", "Editar Propietarios", "Eliminar Propietarios" }));

        jLabel2.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione la operacion que desea realizar");

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("FreeSans", 0, 18)); // NOI18N
        jLabel3.setText("Rellene el formulario los campos con * son obligatorios");

        jLabel8.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        jLabel8.setText("Numero de Identificacion (*)");

        jLabel4.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        jLabel4.setText("Primer nombre  (*)");

        jLabel5.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        jLabel5.setText("Segundo Nombre");

        jLabel6.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        jLabel6.setText("Primer Apellido (*)");

        jLabel7.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        jLabel7.setText("Segundo Apellido");

        TXTSApellido.setText("jTextField4");

        TXTPApellido.setText("jTextField3");

        TXTSNombre.setText("jTextField2");

        TXTPNombre.setText("jTextField1");

        TXTClave.setText("jTextField5");

        jLabel9.setFont(new java.awt.Font("FreeSans", 0, 15)); // NOI18N
        jLabel9.setText("Estado (*)");

        jLabel10.setText("Municipio (*)");

        jLabel11.setText("Parroquia (*)");

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboEstadoMouseClicked(evt);
            }
        });

        ComboMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboMunicipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboMunicipioMouseClicked(evt);
            }
        });

        ComboParroquia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelFormularioLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                            .addComponent(TXTClave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormularioLayout.createSequentialGroup()
                            .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addGap(116, 116, 116)
                            .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TXTPNombre)
                                .addComponent(TXTPApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(TXTSNombre)
                                .addComponent(TXTSApellido)
                                .addComponent(ComboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboParroquia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TXTClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXTPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXTSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXTPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TXTSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ComboParroquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Finalizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Panel2.setOpaque(false);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Identificacion", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jLabel12.setText("Datos Generales de los Propietarios");

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addGap(0, 867, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButton1))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void LimpiarJTable(){
          int a =modelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    modelo.removeRow(i);
          }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
          LimpiarJTable();
              try {
                  VentanaMenuPropietarioControlador.RellenaTablaSQL();
              } catch (SQLException ex) {
                  Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
              }
          Opcion = ComboOpcion.getSelectedIndex();
            if (Opcion==0){
                jButton3.setVisible(true);
                jLabel3.setText("Rellene el formulario los campos con * son obligatorios.");
                jButton3.setText("Agregar");
                ActivaCombo=true;
                PanelFormulario.setVisible(true);
                TXTClave.setText("");
                TXTPNombre.setText("");
                TXTSNombre.setText("");
                TXTPApellido.setText("");
                TXTSApellido.setText("");
                ComboEstado.removeAllItems();
                ComboMunicipio.removeAllItems();
                ComboParroquia.removeAllItems();
                ComboEstado.setEnabled(true);
                ComboMunicipio.setEnabled(true);
                ComboParroquia.setEnabled(true);
            try {
                VentanaMenuPropietarioControlador.llenarListaEstados();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            }
                for (String n : VentanaMenuPropietarioControlador.Estados){
                    ComboEstado.addItem(n);
                }
                
            }
            if (Opcion == 1){
                    jButton3.setVisible(false);
                    PanelFormulario.setVisible(true);
                    Panel2.setVisible(false);
                    jLabel3.setText("Se muestran los datos detallados de cada propietario.");
                    Panel2.setVisible(true);
                    TXTClave.setText("");
                    TXTPNombre.setText("");
                    TXTSNombre.setText("");
                    TXTPApellido.setText("");
                    TXTSApellido.setText("");
                    ComboEstado.removeAllItems();
                    ComboMunicipio.removeAllItems();
                    ComboParroquia.removeAllItems();
                    ComboEstado.setEnabled(false);
                    ComboMunicipio.setEnabled(false);
                    ComboParroquia.setEnabled(false);
            }
                    if (Opcion == 2){
                              jButton3.setVisible(true);
                              jButton3.setText("Actualizar");
                              ActivaCombo=true;
                              JOptionPane.showMessageDialog(rootPane,"Seleccione en la tabla el propietario que desea Editar.");
                              PanelFormulario.setVisible(true);
                              Panel2.setVisible(false);
                              jLabel3.setText("Actualice los valores que desea cambiar..");
                              Panel2.setVisible(true);
                              TXTClave.setText("");
                              TXTPNombre.setText("");
                              TXTSNombre.setText("");
                              TXTPApellido.setText("");
                              TXTSApellido.setText("");
                              ComboEstado.removeAllItems();
                              ComboMunicipio.removeAllItems();
                              ComboParroquia.removeAllItems();
                              ComboEstado.setEnabled(true);
                              ComboMunicipio.setEnabled(true);
                              ComboParroquia.setEnabled(true);
                    }
                    if (Opcion == 3){
                              jButton3.setText("Eliminar");
                              jButton3.setVisible(true);
                              ActivaCombo=false;
                              JOptionPane.showMessageDialog(rootPane,"Seleccione en la tabla el propietario que desea Eliminar.");
                              PanelFormulario.setVisible(true);
                              Panel2.setVisible(false);
                              jLabel3.setText("Datos del Propietario a Eliminar.");
                              Panel2.setVisible(true);
                              TXTClave.setText("");
                              TXTPNombre.setText("");
                              TXTSNombre.setText("");
                              TXTPApellido.setText("");
                              TXTSApellido.setText("");
                              ComboEstado.removeAllItems();
                              ComboMunicipio.removeAllItems();
                              ComboParroquia.removeAllItems();
                              ComboEstado.setEnabled(false);
                              ComboMunicipio.setEnabled(false);
                              ComboParroquia.setEnabled(false);
                    }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboMunicipioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboMunicipioMouseClicked

           if (ActivaCombo){
                String MunicipioSeleccionado = (String) ComboMunicipio.getSelectedItem();
                ComboParroquia.removeAllItems();
                try {
                    ClaveMunicipio = Util.Consultar_PKPorNombreMunicipios("LUGAR","LUG_CLAVE",MunicipioSeleccionado,"LUG_NOMBRE",ClaveEstado);
                    VentanaMenuEdificioControlador.llenarListaParroquias(ClaveMunicipio);    
                    for (String x :VentanaMenuEdificioControlador.Parroquias ){
                        ComboParroquia.addItem(x);
                    }
                }catch (SQLException ex) {
                        Logger.getLogger(VentanaMenuEdificio.class.getName()).log(Level.SEVERE, null, ex);
                }
          }    
    }//GEN-LAST:event_ComboMunicipioMouseClicked

    private void ComboEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboEstadoMouseClicked
            
          if (ActivaCombo){
                    int fk = ComboEstado.getSelectedIndex();
                    fk++;
                    ClaveEstado =Integer.toString(fk);
                    ComboMunicipio.removeAllItems();
                    try{
                              VentanaMenuEdificioControlador.llenarListaMunicipios(ClaveEstado);
                              for (String x: VentanaMenuEdificioControlador.Municipios){
                                        ComboMunicipio.addItem(x);
                              }
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(rootPane,"Error al llenar lista municipios ->"+e);
                    }
          }
        
    }//GEN-LAST:event_ComboEstadoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
          try{
                    if (Opcion == 0){
                              String Clave = TXTClave.getText();
                              String PNombre = TXTPNombre.getText();
                              String SNombre = TXTSNombre.getText();
                              String PApellido =  TXTPApellido.getText();
                              String SApellido = TXTSApellido.getText();
                              String ParroquiaSeleccionada = (String) ComboParroquia.getSelectedItem();
                              ClaveParroquia = Util.Consultar_PKPorNombreParroquia("LUGAR","LUG_CLAVE",ParroquiaSeleccionada,"LUG_NOMBRE",ClaveMunicipio);
                              VentanaMenuPropietarioControlador.insertaPropietarioSQL(Clave, PNombre, SNombre, PApellido, SApellido,ClaveParroquia);
                              JOptionPane.showMessageDialog(rootPane,"Propietario Agregado Correctamente");
                              VentanaMenuPropietario reinicia = new VentanaMenuPropietario();
                              reinicia.setVisible(true);
                              this.dispose();
                              JOptionPane.showMessageDialog(rootPane,"Propietario Agregado Correctamente");
                    }
                    if (Opcion == 1) {
                    }
                    if (Opcion == 2){
                        
                                JOptionPane.showMessageDialog(rootPane,"Entre1");
                              String Clave = TXTClave.getText();
                              String PNombre = TXTPNombre.getText();
                              String SNombre = TXTSNombre.getText();
                              String PApellido =  TXTPApellido.getText();
                              String SApellido = TXTSApellido.getText();
                              String ParroquiaSeleccionada = (String) ComboParroquia.getSelectedItem();
                              JOptionPane.showMessageDialog(rootPane,"Entre2");
                              ClaveParroquia = Util.Consultar_PKPorNombreParroquia("LUGAR","LUG_CLAVE",ParroquiaSeleccionada,"LUG_NOMBRE",ClaveMunicipio);
                              JOptionPane.showMessageDialog(rootPane,"Entre3");
                              VentanaMenuPropietarioControlador.ActualizaPropietarioSQL(Clave, PNombre, SNombre, PApellido, SApellido,ClaveParroquia);
                              JOptionPane.showMessageDialog(rootPane,"PropietarioActualizado.");
                              VentanaMenuPropietario reinicia = new VentanaMenuPropietario();
                              reinicia.setVisible(true);
                              this.dispose();
                    }
                    if (Opcion == 3){
                              VentanaMenuPropietarioControlador.EliminaPropietarioSQL();
                              JOptionPane.showMessageDialog(rootPane,"PropietarioEliminado.");
                              VentanaMenuPropietario reinicia = new VentanaMenuPropietario();
                              reinicia.setVisible(true);
                              this.dispose();
                    }    
                            
          }catch (Exception e){
          JOptionPane.showMessageDialog(rootPane,"Error, debe llenar los campos obligatorios"+e);
          }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked

        
                
          if( ( Tabla.getSelectedRows().length > 0 ) && ((Opcion == 1) || (Opcion ==3)) ) {
                        
                    int num = Tabla.getSelectedRow();
                    String Clave = (String) Tabla.getValueAt(num,0);
                    String Pnombre=(String)Tabla.getValueAt(num,1);
                    String PApellido=(String)Tabla.getValueAt(num,2);
                    this.TXTPNombre.setText(Pnombre);
                    this.TXTPApellido.setText(PApellido);
                    this.TXTClave.setText(Clave);
                        
                    try {
                              VentanaMenuPropietarioControlador.RellenaCamposFaltantes(Clave);
                    }catch (SQLException ex) {
                              JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta 'rellena campos faltantes' ->"+ex);
                              Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.TXTSNombre.setText(SNombrePropietarioSeleccionado);
                    this.TXTSApellido.setText(SapellidoPropietarioSeleccionado);
                 
                    try {
                              VentanaMenuPropietarioControlador.RellenaComboParroquiaPropietarioSeleccionado(this.ForaneaPropietarioSeleccionado);
                    } catch (SQLException ex) {
                              Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.ComboEstado.removeAllItems();
                    this.ComboMunicipio.removeAllItems();
                    this.ComboParroquia.removeAllItems();
                    this.ComboEstado.addItem(EstadoPropietarioSeleccionado);
                    this.ComboMunicipio.addItem(MunicipioPropietarioSeleccionado);
                    this.ComboParroquia.addItem(ParroquiaPropietarioSeleccionado);
                    this.ComboEstado.setSelectedIndex(0);
                    this.ComboMunicipio.setSelectedIndex(0);
                    this.ComboParroquia.setSelectedIndex(0);

          }
          if( ( Tabla.getSelectedRows().length > 0 ) && ((Opcion == 2)) ) {
                    int num = Tabla.getSelectedRow();
                    String Clave = (String) Tabla.getValueAt(num,0);
                    ClaveActualPropietario = Clave;
                    String Pnombre=(String)Tabla.getValueAt(num,1);
                    String PApellido=(String)Tabla.getValueAt(num,2);
                    this.TXTPNombre.setText(Pnombre);
                    this.TXTPApellido.setText(PApellido);
                    this.TXTClave.setText(Clave);
                    try {
                              VentanaMenuPropietarioControlador.RellenaCamposFaltantes(Clave);
                    }catch (SQLException ex) {
                              JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta 'rellena campos faltantes' ->"+ex);
                              Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.TXTSNombre.setText(SNombrePropietarioSeleccionado);
                    this.TXTSApellido.setText(SapellidoPropietarioSeleccionado);
                    this.ComboEstado.removeAllItems();
                    this.ComboMunicipio.removeAllItems();
                    this.ComboParroquia.removeAllItems();
                    try {
                              VentanaMenuPropietarioControlador.llenarListaEstados();
                    }catch (SQLException ex) {
                              JOptionPane.showMessageDialog(rootPane,"Error al cargar los estados a la lista. ->"+ex);
                              Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (String n : VentanaMenuPropietarioControlador.Estados)
                              ComboEstado.addItem(n);
                    this.ComboEstado.setSelectedIndex(0);

          }          
          
    }//GEN-LAST:event_TablaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void cargarInterfaz(){
        String x[][]={};
        String columnas[]={"Identificacion","Nombre","Apellido"};
        modelo = new DefaultTableModel(x, columnas);
        Tabla.setModel(modelo);
        //RellenaTablaSQL();
    }
    

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
            java.util.logging.Logger.getLogger(VentanaMenuPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaMenuPropietario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboEstado;
    private javax.swing.JComboBox ComboMunicipio;
    private javax.swing.JComboBox ComboOpcion;
    private javax.swing.JComboBox ComboParroquia;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JTextField TXTClave;
    private javax.swing.JTextField TXTPApellido;
    private javax.swing.JTextField TXTPNombre;
    private javax.swing.JTextField TXTSApellido;
    private javax.swing.JTextField TXTSNombre;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
