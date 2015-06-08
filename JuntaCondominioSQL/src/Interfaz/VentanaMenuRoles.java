/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.VentanaMenuRolesControlador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Trejo
 */
public class VentanaMenuRoles extends javax.swing.JFrame {

    
    public static ArrayList<String> AuxiliarPermisos = new ArrayList();
    public static int ClaveRol =0;
    public static DefaultTableModel modelo = new DefaultTableModel(); 
    public static int cont = 0;

    
    
    /**
     * Creates new form VentanaMenuRoles
     */
    public VentanaMenuRoles() throws SQLException {
        initComponents();
        cargarInterfaz();
            setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconbuil.png")).getImage() );
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo1.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());  
    
        VentanaMenuRolesControlador.RellenaTablaSQL();
    
        P1.setVisible(false);
        P2.setVisible(false);
        P3.setVisible(false);
        P4.setVisible(false);
        P5.setVisible(false);
        P6.setVisible(false);
       // LBLPermisos.setVisible(false);
       // LBLTabla.setVisible(false);
        LBLNombre.setVisible(false);
        LBLDescripcion.setVisible(false);
        Tabla.setEnabled(false);
        BTNFinal.setVisible(false);
        TXTNombre.setVisible(false);
        TXTDescripcion.setVisible(false);
        BTNVolver2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        LBLTituloPrincipal = new javax.swing.JLabel();
        BTNFinal = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Combo = new javax.swing.JComboBox();
        BTNVolver2 = new javax.swing.JButton();
        BTNContinuar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        LBLNombre = new javax.swing.JLabel();
        TXTNombre = new javax.swing.JTextField();
        LBLDescripcion = new javax.swing.JLabel();
        TXTDescripcion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        P6 = new javax.swing.JCheckBox();
        P5 = new javax.swing.JCheckBox();
        P3 = new javax.swing.JCheckBox();
        P4 = new javax.swing.JCheckBox();
        P2 = new javax.swing.JCheckBox();
        P1 = new javax.swing.JCheckBox();
        P7 = new javax.swing.JCheckBox();
        P8 = new javax.swing.JCheckBox();
        P9 = new javax.swing.JCheckBox();
        P10 = new javax.swing.JCheckBox();
        P11 = new javax.swing.JCheckBox();
        P12 = new javax.swing.JCheckBox();
        P13 = new javax.swing.JCheckBox();

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBLTituloPrincipal.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        LBLTituloPrincipal.setText("Menu Roles");

        BTNFinal.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        BTNFinal.setText("Confirmar");
        BTNFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNFinalActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione la opcion que desea Realizar"));

        Combo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        Combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear Rol" }));

        BTNVolver2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        BTNVolver2.setText("Reiniciar");
        BTNVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVolver2ActionPerformed(evt);
            }
        });

        BTNContinuar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        BTNContinuar.setText("Continuar");
        BTNContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNVolver2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNContinuar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNVolver2)
                    .addComponent(BTNContinuar)))
        );

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Roles Existentes"));

        Tabla.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario para el Rol"));

        LBLNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLNombre.setText("Indique El nombre Del Rol");

        TXTNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        TXTNombre.setText("TXTNombre");

        LBLDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLDescripcion.setText("Indique la descripcion del Rol");

        TXTDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        TXTDescripcion.setText("TXTDescripcion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBLNombre)
                            .addComponent(LBLDescripcion))
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(LBLDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(TXTDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de permisos Disponibles"));

        P6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P6.setText("Contrato");

        P5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P5.setText("Bienes Raices");

        P3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P3.setText("Propietario");

        P4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P4.setText("JuntaCondominio");

        P2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P2.setText("Edificio");

        P1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P1.setText("Usuarios");
        P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1ActionPerformed(evt);
            }
        });

        P7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P7.setText("Trabajos");

        P8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P8.setText("Cuenta");

        P9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P9.setText("Asambleas");

        P10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P10.setText("Reclamos");

        P11.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P11.setText("Libros");

        P12.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P12.setText("Pagos");

        P13.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P13.setText("Fondos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P1)
                                    .addComponent(P2))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P3)
                                    .addComponent(P4)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P7)
                                    .addComponent(P10))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P11)
                                    .addComponent(P8))))
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P9)
                            .addComponent(P5)
                            .addComponent(P6)
                            .addComponent(P12))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(P13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1)
                    .addComponent(P3)
                    .addComponent(P5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2)
                    .addComponent(P4)
                    .addComponent(P6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P7)
                    .addComponent(P8)
                    .addComponent(P9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P10)
                    .addComponent(P11)
                    .addComponent(P12))
                .addGap(18, 18, 18)
                .addComponent(P13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LBLTituloPrincipal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTNFinal)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLTituloPrincipal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(BTNFinal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarInterfaz(){
    String x[][]={};
    String columnas[]={"Nombre","Descripcion"};
    modelo = new DefaultTableModel(x, columnas);
    Tabla.setModel(modelo);
    //RellenaTablaSQL();
    }
    
    private void P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_P1ActionPerformed

    private void BTNContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNContinuarActionPerformed

        int opcion;
        opcion = Combo.getSelectedIndex();
        
            if (opcion == 0){
                P1.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(true);
          //      LBLPermisos.setVisible(true);
            //    LBLTabla.setVisible(true);
                LBLNombre.setVisible(true);
                LBLDescripcion.setVisible(true);
                Tabla.setVisible(true);
                BTNFinal.setVisible(true);
                TXTNombre.setVisible(true);
                TXTDescripcion.setVisible(true);
                BTNContinuar.setEnabled(false);
                BTNVolver2.setVisible(true);
            }
            if (opcion == 1){
                BTNContinuar.setEnabled(false);
                BTNVolver2.setVisible(true);
                P1.setVisible(true);
                P2.setVisible(true);
                P3.setVisible(true);
                P4.setVisible(true);
                P5.setVisible(true);
                P6.setVisible(true);
              //  LBLPermisos.setVisible(true);
               // LBLTabla.setVisible(true);
                LBLNombre.setVisible(true);
                LBLDescripcion.setVisible(true);
                Tabla.setVisible(true);
                BTNFinal.setVisible(true);
                TXTNombre.setVisible(true);
                TXTDescripcion.setVisible(true);
                }
        if (opcion == 3){
                //LBLTabla.setVisible(true);
                Tabla.setVisible(true);
                BTNContinuar.setEnabled(false);
                BTNVolver2.setVisible(true);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNContinuarActionPerformed

    private void BTNVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNVolver2ActionPerformed

        P1.setVisible(false);
        P2.setVisible(false);
        P3.setVisible(false);
        P4.setVisible(false);
        P5.setVisible(false);
        P6.setVisible(false);
        //LBLPermisos.setVisible(false);
        //LBLTabla.setVisible(false);
        LBLNombre.setVisible(false);
        LBLDescripcion.setVisible(false);
        Tabla.setVisible(false);
        BTNFinal.setVisible(false);
        TXTNombre.setVisible(false);
        TXTDescripcion.setVisible(false);
        BTNVolver2.setVisible(false);
        BTNContinuar.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNVolver2ActionPerformed

    private void BTNFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNFinalActionPerformed

        String nombre = TXTNombre.getText();
        AuxiliarPermisos.clear();
        boolean valido = false;
        
        if (P1.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 1");
             valido = true;
             AuxiliarPermisos.add("1");
        }
        if (P2.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 1");
             valido = true;
             AuxiliarPermisos.add("2");
        }
        if (P3.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("4");
        }
        if (P4.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("5");
        }
        if (P5.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("6");
        }
        if (P6.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("3");
        }
        if (P7.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 1");
             valido = true;
             AuxiliarPermisos.add("7");
        }
        if (P8.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 1");
             valido = true;
             AuxiliarPermisos.add("8");
        }
        if (P9.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("9");
        }
        if (P10.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("10");
        }
        if (P11.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("11");
             
        }
        if (P12.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("12");
        }
        if (P13.isSelected()){
             //JOptionPane.showMessageDialog(rootPane,"SE LE DIO CLICK AL 3");
             valido = true;
             AuxiliarPermisos.add("13");
        }
        
        
        if (valido){
            
            try {
                VentanaMenuRolesControlador.InsertarRolBD(nombre,nombre);
                VentanaMenuRolesControlador.InsertarRol_PERBD();
                //aqui se realizara la insercion en la base de datos
                JOptionPane.showMessageDialog(rootPane,"Rol Creado Correctamente");
                VentanaMenuUsuario nueva = new VentanaMenuUsuario();
                nueva.setVisible(true);
                this.dispose();
                // TODO add your handling code here:
            } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuRoles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(rootPane,"ERROR, DEBE SELECCIONAR AL MENOS 1 PERMISO");
        
    }//GEN-LAST:event_BTNFinalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                VentanaMenuUsuario nuevo = null;
        try {
            nuevo = new VentanaMenuUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
                nuevo.setVisible(true);
                this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMenuRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaMenuRoles().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMenuRoles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNContinuar;
    private javax.swing.JButton BTNFinal;
    private javax.swing.JButton BTNVolver2;
    private javax.swing.JComboBox Combo;
    private javax.swing.JLabel LBLDescripcion;
    private javax.swing.JLabel LBLNombre;
    private javax.swing.JLabel LBLTituloPrincipal;
    private javax.swing.JCheckBox P1;
    private javax.swing.JCheckBox P10;
    private javax.swing.JCheckBox P11;
    private javax.swing.JCheckBox P12;
    private javax.swing.JCheckBox P13;
    private javax.swing.JCheckBox P2;
    private javax.swing.JCheckBox P3;
    private javax.swing.JCheckBox P4;
    private javax.swing.JCheckBox P5;
    private javax.swing.JCheckBox P6;
    private javax.swing.JCheckBox P7;
    private javax.swing.JCheckBox P8;
    private javax.swing.JCheckBox P9;
    private javax.swing.JTextField TXTDescripcion;
    private javax.swing.JTextField TXTNombre;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
