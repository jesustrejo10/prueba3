/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.VentanaMenuPrincipalControlador;
import Modelo.Util;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Trejo
 */
public class VentanaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMenuPrincipal
     */
    public VentanaMenuPrincipal() throws SQLException {
        initComponents();
        BTNUsuarios.setEnabled(false);
        BTNPropietario.setEnabled (false);
        BTN2.setEnabled(false);
        BTNJunta.setEnabled(false);
        btnbienes.setEnabled(false);
        BtnContrato.setEnabled(false);
        ActivaPermisos(VentanaLogIn.Logeado);
        
        for (String x : VentanaMenuPrincipalControlador.permisos){
            if(Integer.parseInt(x)==1){
                BTNUsuarios.setEnabled(true);
            }
             if(Integer.parseInt(x)==2){
                BTN2.setEnabled(true);
            }
              if(Integer.parseInt(x)==3){
                BtnContrato.setEnabled(true);
              }
             if(Integer.parseInt(x)==4){
                BTNPropietario.setEnabled(true);
            }
                if(Integer.parseInt(x)==5){
                BTNJunta.setEnabled(true);
            }
                if(Integer.parseInt(x)==6){
                btnbienes.setEnabled(true);
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

        LBLUsuarios = new javax.swing.JLabel();
        BTNUsuarios = new javax.swing.JButton();
        LBLTituloPrincipal = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BTN2 = new javax.swing.JButton();
        lblprop = new javax.swing.JLabel();
        BTNPropietario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BTNJunta = new javax.swing.JButton();
        btnbienes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnContrato = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnTrabajo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LBLUsuarios.setText("Menu Usuarios");

        BTNUsuarios.setText("Usuarios");
        BTNUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNUsuariosActionPerformed(evt);
            }
        });

        LBLTituloPrincipal.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        LBLTituloPrincipal.setText("Menu Principal");

        LogOut.setText("Salir");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        jLabel1.setText("Menu Edificio");

        BTN2.setText("Edificio");
        BTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN2ActionPerformed(evt);
            }
        });

        lblprop.setText("Menu Propietario");

        BTNPropietario.setText("Propietario");
        BTNPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPropietarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Menu JuntaCondominio");

        BTNJunta.setText("JuntaCondominio");
        BTNJunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNJuntaActionPerformed(evt);
            }
        });

        btnbienes.setText("Bienes Raices");
        btnbienes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbienesActionPerformed(evt);
            }
        });

        jLabel3.setText("Menu Bienes Raices");

        jLabel4.setText("Asignacion de Contratos");

        BtnContrato.setText("Contratos");
        BtnContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnContratoActionPerformed(evt);
            }
        });

        jLabel5.setText("Registrar Trabajo");

        BtnTrabajo.setText("Trabajos");
        BtnTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTrabajoActionPerformed(evt);
            }
        });

        jLabel6.setText("Gestion de Cuentas");

        jButton1.setText("Cuentas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Gestion de Asambleas");

        jButton2.setText("Asambleas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(LBLTituloPrincipal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BTNUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LBLUsuarios)
                                .addComponent(LogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)
                            .addComponent(btnbienes)
                            .addComponent(jLabel7)
                            .addComponent(jButton2))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(BTN2)
                            .addComponent(jLabel4)
                            .addComponent(BtnContrato))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprop)
                            .addComponent(BTNPropietario)
                            .addComponent(jLabel5)
                            .addComponent(BtnTrabajo))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTNJunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLTituloPrincipal)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLUsuarios)
                    .addComponent(jLabel1)
                    .addComponent(lblprop)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNUsuarios)
                    .addComponent(BTN2)
                    .addComponent(BTNPropietario)
                    .addComponent(BTNJunta))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnContrato)
                    .addComponent(btnbienes)
                    .addComponent(BtnTrabajo)
                    .addComponent(jButton1))
                .addGap(41, 41, 41)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(LogOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNUsuariosActionPerformed

        VentanaMenuUsuario nueva = null;
        try {
            nueva = new VentanaMenuUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNUsuariosActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        VentanaLogIn nuevo = new VentanaLogIn();
        nuevo.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_LogOutActionPerformed

    private void BTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN2ActionPerformed
        VentanaMenuEdificio nuevo = null;
        try {
            nuevo = new VentanaMenuEdificio();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        nuevo.setVisible(true);
        this.dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_BTN2ActionPerformed

    private void BTNPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPropietarioActionPerformed

        VentanaMenuPropietario nueva = null;
        try {
            nueva = new VentanaMenuPropietario();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_BTNPropietarioActionPerformed

    private void BTNJuntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNJuntaActionPerformed
        VentanaMenuJuntaCondominio nueva = null;
       try {
           nueva = new VentanaMenuJuntaCondominio();
       } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        nueva.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BTNJuntaActionPerformed

    private void btnbienesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbienesActionPerformed
            MenuBienesRaices nueva = new MenuBienesRaices();
            nueva.setVisible(true);
            this.dispose();
        
    }//GEN-LAST:event_btnbienesActionPerformed

    private void BtnContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContratoActionPerformed
            VentanaGenerarContrato nueva = new VentanaGenerarContrato();
            nueva.setVisible(true);
            this.dispose();    
    }//GEN-LAST:event_BtnContratoActionPerformed

    private void BtnTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTrabajoActionPerformed
          VentanaMenuTrabajo nueva = new VentanaMenuTrabajo();
          nueva.setVisible(true);
          this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnTrabajoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            VentanaGestionCuenta nuevo = new VentanaGestionCuenta();
            nuevo.setVisible(true);
            this.dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaGestiondeAsambleas nuevo = new VentanaGestiondeAsambleas();
        nuevo.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void ActivaPermisos(String Usu) throws SQLException{
        String PKUsuario =Util.Consultar_PKPorNombre("USUARIO", "USU_CLAVE",Usu,"USU_USUARIO");
        //JOptionPane.showMessageDialog(null,"PASO 01 CON :"+PKUsuario);
        VentanaMenuPrincipalControlador.EncuentraPermisosSQL(PKUsuario);
            
        
        
    }
    
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
            java.util.logging.Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaMenuPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN2;
    private javax.swing.JButton BTNJunta;
    private javax.swing.JButton BTNPropietario;
    private javax.swing.JButton BTNUsuarios;
    private javax.swing.JButton BtnContrato;
    private javax.swing.JButton BtnTrabajo;
    private javax.swing.JLabel LBLTituloPrincipal;
    private javax.swing.JLabel LBLUsuarios;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton btnbienes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblprop;
    // End of variables declaration//GEN-END:variables
}
