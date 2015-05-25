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
import javax.swing.JOptionPane;
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
        VentanaMenuRolesControlador.RellenaTablaSQL();
    
        P1.setVisible(false);
        P2.setVisible(false);
        P3.setVisible(false);
        P4.setVisible(false);
        P5.setVisible(false);
        P6.setVisible(false);
        LBLPermisos.setVisible(false);
        LBLTabla.setVisible(false);
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
        LBLCreaPermiso = new javax.swing.JLabel();
        BTNContinuar = new javax.swing.JButton();
        Combo = new javax.swing.JComboBox();
        P1 = new javax.swing.JCheckBox();
        P2 = new javax.swing.JCheckBox();
        P3 = new javax.swing.JCheckBox();
        P4 = new javax.swing.JCheckBox();
        P5 = new javax.swing.JCheckBox();
        P6 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        LBLTabla = new javax.swing.JLabel();
        LBLPermisos = new javax.swing.JLabel();
        BTNFinal = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        LBLNombre = new javax.swing.JLabel();
        TXTNombre = new javax.swing.JTextField();
        LBLDescripcion = new javax.swing.JLabel();
        TXTDescripcion = new javax.swing.JTextField();
        BTNVolver2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBLTituloPrincipal.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        LBLTituloPrincipal.setText("Menu Roles");

        LBLCreaPermiso.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLCreaPermiso.setText("Seleccione la operacion que desea Realizar");

        BTNContinuar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        BTNContinuar.setText("Continuar");
        BTNContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNContinuarActionPerformed(evt);
            }
        });

        Combo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        Combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crear rol", "Editar Rol", "Eliminar Rol", "Mostrar los Roles", " " }));

        P1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P1.setText("Usuarios");
        P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1ActionPerformed(evt);
            }
        });

        P2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P2.setText("Edificio");

        P3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P3.setText("Propietario");

        P4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P4.setText("JuntaCondominio");

        P5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P5.setText("Bienes Raices");

        P6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        P6.setText("Contrato");

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

        LBLTabla.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLTabla.setText("Lista De Roles");

        LBLPermisos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLPermisos.setText("Permisos Disponibles");

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

        LBLNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLNombre.setText("Indique El nombre Del Rol");

        TXTNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        TXTNombre.setText("TXTNombre");

        LBLDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        LBLDescripcion.setText("Indique la descripcion del Rol");

        TXTDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        TXTDescripcion.setText("TXTDescripcion");

        BTNVolver2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        BTNVolver2.setText("Atras");
        BTNVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNVolver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(LBLTituloPrincipal)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBLCreaPermiso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBLTabla)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P1)
                                    .addComponent(P2)
                                    .addComponent(jButton3)
                                    .addComponent(BTNVolver2))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBLPermisos)
                                    .addComponent(BTNContinuar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(P3)
                                            .addComponent(P4))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(P6)
                                            .addComponent(P5)))))
                            .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(BTNFinal)
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(LBLNombre)
                                    .addGap(185, 185, 185)))
                            .addComponent(LBLDescripcion)
                            .addComponent(TXTDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LBLTituloPrincipal)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLTabla)
                    .addComponent(LBLCreaPermiso))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(LBLNombre))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTNVolver2)
                        .addComponent(BTNContinuar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLPermisos)
                    .addComponent(TXTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1)
                    .addComponent(P3)
                    .addComponent(P5)
                    .addComponent(LBLDescripcion))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2)
                    .addComponent(P4)
                    .addComponent(P6)
                    .addComponent(TXTDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNFinal)
                    .addComponent(jButton3))
                .addGap(25, 25, 25))
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
                LBLPermisos.setVisible(true);
                LBLTabla.setVisible(true);
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
                LBLPermisos.setVisible(true);
                LBLTabla.setVisible(true);
                LBLNombre.setVisible(true);
                LBLDescripcion.setVisible(true);
                Tabla.setVisible(true);
                BTNFinal.setVisible(true);
                TXTNombre.setVisible(true);
                TXTDescripcion.setVisible(true);
                }
        if (opcion == 3){
                LBLTabla.setVisible(true);
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
        LBLPermisos.setVisible(false);
        LBLTabla.setVisible(false);
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
    private javax.swing.JLabel LBLCreaPermiso;
    private javax.swing.JLabel LBLDescripcion;
    private javax.swing.JLabel LBLNombre;
    private javax.swing.JLabel LBLPermisos;
    private javax.swing.JLabel LBLTabla;
    private javax.swing.JLabel LBLTituloPrincipal;
    private javax.swing.JCheckBox P1;
    private javax.swing.JCheckBox P2;
    private javax.swing.JCheckBox P3;
    private javax.swing.JCheckBox P4;
    private javax.swing.JCheckBox P5;
    private javax.swing.JCheckBox P6;
    private javax.swing.JTextField TXTDescripcion;
    private javax.swing.JTextField TXTNombre;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
