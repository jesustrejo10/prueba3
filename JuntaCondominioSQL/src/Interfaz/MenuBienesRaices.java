/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.MenuBienesRaicesControlador;
import static Controlador.MenuBienesRaicesControlador.RellenaTablaApartamentosSQL;
import Controlador.VentanaMenuEdificioControlador;
import static Interfaz.VentanaMenuEdificio.modelo;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class MenuBienesRaices extends javax.swing.JFrame {

    /**
     * Creates new form AsignacionAPT_Prop
     */
    public static DefaultTableModel ModeloEdificios = new DefaultTableModel(); 
    public static DefaultTableModel ModeloApartamentos = new DefaultTableModel();
    public static DefaultTableModel modeloPropietarios = new DefaultTableModel();
    public static DefaultTableModel modeloOficinas = new DefaultTableModel();
    public static DefaultTableModel ModeloApartamentosComprados = new DefaultTableModel();
    public static int Opcion = 0;
    public static int cont= 0;
    public static int contAPT= 0;
    public static int fase = 0;
    public static String ClaveTrampa= null;
    public static boolean FinEnabled = false;
    DateFormat df = DateFormat.getDateInstance();

    //public static 
    
public MenuBienesRaices() {
        initComponents();
        btnfin.setVisible(false);
        PanelPrecio.setVisible(false);
        PanelPropietarios.setVisible(false);
        PanelComprados.setVisible(false);
        PanelTablaPrincipal.setVisible(false);
    }

public static void LimpiarJTable(DefaultTableModel Nombremodelo){
          int a =Nombremodelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    Nombremodelo.removeRow(i);
          }
        }
    
public void CargarInterfazEdificiosDisponibles(){
        String x[][]={};
        String columnas[]={"Rif","Nombre"};
        ModeloEdificios = new DefaultTableModel(x, columnas);
        Tabla.setModel(ModeloEdificios);
     }

public void CargarInterfazApartamentosComprados(){
        String x[][]={};
        String columnas[]={"Edificio","Medidas","Alicuota","Piso","Codigo","Precio"};
        ModeloApartamentosComprados = new DefaultTableModel(x, columnas);
        TablaComprados.setModel(ModeloApartamentosComprados);
     }

public void CargarInterfazApartamentosDisponibles(){
        String x[][]={};
        String columnas[]={"Codigo","Piso","Alicuota","Medidas","Precio"};
        ModeloApartamentos = new DefaultTableModel(x, columnas);
        Tabla.setModel(ModeloApartamentos);
     }

public void cargarInterfazPropietarios(){
        String x[][]={};
        String columnas[]={"Identificacion","Nombre","Apellido"};
        modeloPropietarios = new DefaultTableModel(x, columnas);
        TablaPropietarios.setModel(modeloPropietarios);
     }
    
public void cargarInterfazOficina(){
        String x[][]={};
        String columnas[]={"Identificacion","Nombre","Correo","Direccion"};
        modeloOficinas = new DefaultTableModel(x, columnas);
        TablaPropietarios.setModel(modeloOficinas);
        }
  
         public void cargarInterfazOficina3(){
        String x[][]={};
        String columnas[]={"Identificacion","Nombre","Correo","Direccion"};
        modeloOficinas = new DefaultTableModel(x, columnas);
        Tabla.setModel(modeloOficinas);
        }
      
      public void cargarInterfazOficina2(){
        String x[][]={};
        String columnas[]={"Identificacion","Nombre","Correo","Direccion"};
        modeloOficinas = new DefaultTableModel(x, columnas);
        TablaComprados.setModel(modeloOficinas);
     }
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelOpcion = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        PanelTablaPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        PanelPropietarios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPropietarios = new javax.swing.JTable();
        PanelComprados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaComprados = new javax.swing.JTable();
        lblpanel3 = new javax.swing.JLabel();
        btnfin = new javax.swing.JButton();
        PanelPrecio = new javax.swing.JPanel();
        lblPrecio = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcomi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Bienes Raices", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Mono", 0, 36))); // NOI18N

        PanelOpcion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione la operacion que desea Realizar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Mono", 0, 18))); // NOI18N

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compra de APT por parte de un propietario", "Mostrar Apartamentos Por Propietario", "Poner en venta APT por Propietario", "Comprar APT por parte de una Oficina", "Mostrar Apartamentos Por Oficina", "Poner en venta APT por Oficina" }));
        ComboOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOpcionActionPerformed(evt);
            }
        });

        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelOpcionLayout = new javax.swing.GroupLayout(PanelOpcion);
        PanelOpcion.setLayout(PanelOpcionLayout);
        PanelOpcionLayout.setHorizontalGroup(
            PanelOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOpcionLayout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelOpcionLayout.setVerticalGroup(
            PanelOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addContainerGap())
        );

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

        jButton2.setText("Siguiente");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTablaPrincipalLayout = new javax.swing.GroupLayout(PanelTablaPrincipal);
        PanelTablaPrincipal.setLayout(PanelTablaPrincipalLayout);
        PanelTablaPrincipalLayout.setHorizontalGroup(
            PanelTablaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPrincipalLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(jButton2))
            .addGroup(PanelTablaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelTablaPrincipalLayout.setVerticalGroup(
            PanelTablaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTablaPrincipalLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaPropietarios.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPropietariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaPropietarios);

        javax.swing.GroupLayout PanelPropietariosLayout = new javax.swing.GroupLayout(PanelPropietarios);
        PanelPropietarios.setLayout(PanelPropietariosLayout);
        PanelPropietariosLayout.setHorizontalGroup(
            PanelPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPropietariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
        PanelPropietariosLayout.setVerticalGroup(
            PanelPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPropietariosLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaComprados.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaComprados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCompradosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaComprados);

        lblpanel3.setText("Datos De los apartamentos.");

        javax.swing.GroupLayout PanelCompradosLayout = new javax.swing.GroupLayout(PanelComprados);
        PanelComprados.setLayout(PanelCompradosLayout);
        PanelCompradosLayout.setHorizontalGroup(
            PanelCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCompradosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpanel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        PanelCompradosLayout.setVerticalGroup(
            PanelCompradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCompradosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblpanel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnfin.setText("Realizar Compra");
        btnfin.setOpaque(true);
        btnfin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinActionPerformed(evt);
            }
        });

        PanelPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Medium", 0, 18))); // NOI18N

        lblPrecio.setText("Indique el precio por el cual quiere Vender");

        jLabel7.setText("Indique el Porcentaje de ganancia de la ADM");

        txtcomi.setText("10");

        jLabel8.setText("Indique la fecha de la negociacion");

        javax.swing.GroupLayout PanelPrecioLayout = new javax.swing.GroupLayout(PanelPrecio);
        PanelPrecio.setLayout(PanelPrecioLayout);
        PanelPrecioLayout.setHorizontalGroup(
            PanelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrecioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrecioLayout.createSequentialGroup()
                        .addGroup(PanelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPrecioLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(PanelPrecioLayout.createSequentialGroup()
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(PanelPrecioLayout.createSequentialGroup()
                        .addComponent(txtcomi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(PanelPrecioLayout.createSequentialGroup()
                        .addComponent(lblPrecio)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelPrecioLayout.setVerticalGroup(
            PanelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrecioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(PanelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(lblPrecio)
                .addGap(18, 18, 18)
                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Volver");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPrincipalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(PanelOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(PanelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(PanelTablaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelComprados, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfin)
                .addGap(50, 50, 50))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelPropietarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTablaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelComprados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfin)
                    .addComponent(jButton3))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboOpcionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Opcion =  ComboOpcion.getSelectedIndex();
          LimpiarJTable(modelo);
          LimpiarJTable(modeloOficinas);
          LimpiarJTable(modeloPropietarios);
          LimpiarJTable(ModeloApartamentos);
          LimpiarJTable(ModeloApartamentosComprados);
          LimpiarJTable(ModeloEdificios);
          if (Opcion == 0){
                    CargarInterfazEdificiosDisponibles();
                    fase =1;
                    btnfin.setVisible(true);
                    PanelTablaPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Edifcicios con Apartamentos en Venta"));
                    Tabla.setBorder(javax.swing.BorderFactory.createSoftBevelBorder(2));
                    PanelPrecio.setVisible(false);
                    PanelTablaPrincipal.setVisible(true);
                    PanelPropietarios.setVisible(true);
                    PanelPropietarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Propietarios en el sistema"));
                    
                    PanelComprados.setVisible(false);
          try {
                MenuBienesRaicesControlador.RellenaTablaSQL();
          } catch (SQLException ex) {
                    Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
          }
        }       
        if (Opcion ==1){
                    btnfin.setVisible(false);
                    PanelPropietarios.setVisible(true);
                    PanelComprados.setVisible(true);
                    PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de apartamentos pertenecientes al propietario seleccionado"));
                    
                    PanelTablaPrincipal.setVisible(false);
                    cargarInterfazPropietarios();
                    PanelPropietarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Propietarios en el sistema"));
                    
                    PanelPrecio.setVisible(false);
                    try {          
                              MenuBienesRaicesControlador.RellenaTablaPropietariosSQL();
                     } catch (SQLException ex) {
                               Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta." +ex);
                     }
          }
        if (Opcion ==2){
                    btnfin.setVisible(false);
                    PanelPropietarios.setVisible(true);
                    PanelComprados.setVisible(true);
                    PanelTablaPrincipal.setVisible(false);
                    cargarInterfazPropietarios();
                    PanelPropietarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Propietarios en el sistema"));
                    
                    PanelPrecio.setVisible(false);
                    try {          
                              MenuBienesRaicesControlador.RellenaTablaPropietariosSQL();
                     } catch (SQLException ex) {
                               Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta." +ex);
                     }
          }
        if (Opcion ==3){ //COMPRA APT POR PARTE DE UNA OFICINA
                    CargarInterfazEdificiosDisponibles();
                    fase =1;
                    btnfin.setVisible(true);
                    PanelPrecio.setVisible(false);
                    PanelTablaPrincipal.setVisible(true);
                    PanelPropietarios.setVisible(true);
                    PanelComprados.setVisible(false);
                    
          try {
                    MenuBienesRaicesControlador.RellenaTablaSQL();
          } catch (SQLException ex) {
                    Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        if (Opcion ==4){
                    btnfin.setVisible(false);
                    PanelPropietarios.setVisible(true);
                    PanelComprados.setVisible(true);
                    PanelTablaPrincipal.setVisible(false);
                    cargarInterfazOficina();
                    PanelPrecio.setVisible(false);
                    try {          
                              MenuBienesRaicesControlador.RellenaTablaOficinasSQL();
                     } catch (SQLException ex) {
                               Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta." +ex);
                     }
          }
          if (Opcion ==5){
                    btnfin.setVisible(false);
                    PanelPropietarios.setVisible(true);
                    PanelComprados.setVisible(true);
                    PanelTablaPrincipal.setVisible(false);
                    cargarInterfazOficina();
                    PanelPrecio.setVisible(false);
                    try {          
                              MenuBienesRaicesControlador.RellenaTablaOficinasSQL();
                     } catch (SQLException ex) {
                               Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta." +ex);
                     }
          }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

          if (((Opcion == 0)) &&(fase == 1)){
                    fase =2;
                    PanelPrecio.setVisible(true);
                    lblPrecio.setVisible(false);
                    txtprecio.setVisible(false);
                    PanelTablaPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Apartamentos en Venta"));
                    PanelComprados.setVisible(true);
                    PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Oficinas en el sistema"));
                    lblpanel3.setText("Seleccione la oficina intermediaria");

                    //txtAPT.setText("");
                    int num = Tabla.getSelectedRow();
                    String nomb=(String)Tabla.getValueAt(num,1);
                    String rif =(String)Tabla.getValueAt(num,0);
                    cargarInterfazPropietarios();
                    cargarInterfazOficina2();
                    try {
                              MenuBienesRaicesControlador.ConsultaClaveEdificioSeleccionadoSQL(rif);
//                              JOptionPane.showMessageDialog(rootPane,"la clave del edifcio seleccionado es: "+ClaveTrampa);
                              CargarInterfazApartamentosDisponibles();
                              RellenaTablaApartamentosSQL();
                              MenuBienesRaicesControlador.RellenaTablaPropietariosSQL();
                              MenuBienesRaicesControlador.RellenaTablaOficinasSQL();
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
          if ((Opcion == 0) && (fase == 2)){
                    cargarInterfazPropietarios();
                    try {          
                              MenuBienesRaicesControlador.RellenaTablaPropietariosSQL();
                     } catch (SQLException ex) {
                               Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta." +ex);
                     }
          }
          if (((Opcion == 3)) &&(fase == 1)){
                    fase =2;
                    int num = Tabla.getSelectedRow();
                    String nomb=(String)Tabla.getValueAt(num,1);
                    String rif =(String)Tabla.getValueAt(num,0);
                    cargarInterfazOficina();
                    try {
                              MenuBienesRaicesControlador.ConsultaClaveEdificioSeleccionadoSQL(rif);
                              JOptionPane.showMessageDialog(rootPane,"la clave del edifcio seleccionado es: "+ClaveTrampa);
                              CargarInterfazApartamentosDisponibles();
                              RellenaTablaApartamentosSQL();
                              MenuBienesRaicesControlador.RellenaTablaOficinasSQL();
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
          }
          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TablaPropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPropietariosMouseClicked
          if (Opcion == 0){  
                    FinEnabled = true;
          }
          if ((Opcion == 1) &&  ( TablaPropietarios.getSelectedRows().length > 0 )){
                    CargarInterfazApartamentosComprados();
                    String ClavePropietario = null;
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    ClavePropietario = (String)TablaPropietarios.getValueAt(num2,0);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columna"+e.getMessage());
                    }              
                    try {

                              MenuBienesRaicesControlador.RellenaTablaApartamentosCompradosSQL(ClavePropietario);
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
          if ((Opcion == 2) &&  ( TablaPropietarios.getSelectedRows().length > 0 )){
                    JOptionPane.showMessageDialog(null,"Seleccione el Apartamento que desea colocar en venta");
                    CargarInterfazApartamentosComprados();
                    PanelComprados.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Apartamentos pertenecientes al Propietario"));
                    lblPrecio.setVisible(true);
                    txtprecio.setVisible(true);
                    String ClavePropietario2 = null;
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    ClavePropietario2 = (String)TablaPropietarios.getValueAt(num2,0);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columna"+e.getMessage());
                    }              
                    try {

                              MenuBienesRaicesControlador.RellenaTablaApartamentosCompradosSQL(ClavePropietario2);
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                        
          }
          if ((Opcion == 4) &&  ( TablaPropietarios.getSelectedRows().length > 0 )){
                    JOptionPane.showMessageDialog(PanelComprados,"Seleccione el Apartamento que desea colocar en venta");
                    CargarInterfazApartamentosComprados();
                    int ClavePropietario2 = 0;
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    ClavePropietario2 = (int)TablaPropietarios.getValueAt(num2,0);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columna"+e.getMessage());
                    }              
                    try {

                              MenuBienesRaicesControlador.RellenaTablaApartamentosCompradosOficinaSQL(Integer.toString(ClavePropietario2));
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                        
          }
          if ((Opcion == 5) &&  ( TablaPropietarios.getSelectedRows().length > 0 )){
                    JOptionPane.showMessageDialog(PanelComprados,"Seleccione el Apartamento que desea colocar en venta");
                    CargarInterfazApartamentosComprados();
                    int ClavePropietario2 = 0;
                    try{
                    int num2 = TablaPropietarios.getSelectedRow();
                    ClavePropietario2 = (int)TablaPropietarios.getValueAt(num2,0);
                    }catch(Exception e){
                              JOptionPane.showMessageDialog(PanelComprados,"error al asignar la columna"+e.getMessage());
                    }              
                    try {
                              MenuBienesRaicesControlador.RellenaTablaApartamentosCompradosOficinaSQL(Integer.toString(ClavePropietario2));
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                        
          }
// TODO add your handling code here:
    }//GEN-LAST:event_TablaPropietariosMouseClicked
    
    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) { //CONVIERTE UTIL.DATE A SQL.DATE
        return new java.sql.Date(date.getTime()); }

    public String ConvierteFechas(String FechaInicio){
          try{
                                        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 
                                        java.util.Date fecha=sdf.parse(FechaInicio); 
                                        java.sql.Date FechaNegociacion = convertJavaDateToSqlDate(fecha); //CONVERSIONES A TIPO SQL.DATE
                                        String intento;
                                        intento = (String) FechaNegociacion.toString();
                                        String[] intento2 =intento.split("-");
                                        String intento3 = intento2[0]+intento2[1]+intento2[2];
                                        return (intento3);
          }catch(Exception e){
                    JOptionPane.showMessageDialog(PanelComprados,"Error al convertir la fecha."+e.getMessage());
          }                        
        return null;
    
    };
    
    private void btnfinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinActionPerformed

           if (FinEnabled){
                    if(( Tabla.getSelectedRows().length > 0 ) && (TablaPropietarios.getSelectedRows().length > 0 ) && (TablaComprados.getSelectedRows().length > 0 )){
                            
                              int num = Tabla.getSelectedRow();
                              int ClaveAptDet = (Integer) Tabla.getValueAt(num,0);
                              String ClaveAptDet2 = Integer.toString(ClaveAptDet);
                              String  precio = (String)Tabla.getValueAt(num, 4);
                              int PrecioInt = Integer.parseInt(precio);
                              int num3 = TablaComprados.getSelectedRow();
                              int ClaveOficina = (Integer) TablaComprados.getValueAt(num3,0);
                              String ClaveOficina2 = Integer.toString(ClaveOficina);
                              //System.out.print("gola");
                              int num2 = TablaPropietarios.getSelectedRow();
                              String ClavePropietario = (String)TablaPropietarios.getValueAt(num2,0);

                              try {
                                        JOptionPane.showMessageDialog(PanelComprados, ClaveAptDet2+ClavePropietario);
                                        MenuBienesRaicesControlador.AsignaApartamentoAPropietario(ClaveAptDet2, ClavePropietario);
                                        
                                        String FechaInicio = df.format(Fecha.getDate());
                                        String FechaString = ConvierteFechas(FechaInicio);
                                        String comi = txtcomi.getText();
                                        int Comision = Integer.parseInt(comi);
                                        float LComision =   (Comision / PrecioInt) * 100;
                                        MenuBienesRaicesControlador.RegistrarTransaccionBienesRaices(LComision, ClaveAptDet2, ClaveOficina2, FechaString);
                                        JOptionPane.showMessageDialog(PanelComprados,"Compra Concretada");
                                        MenuBienesRaices reset = new MenuBienesRaices();
                                        reset.setVisible(true);
                                        this.dispose();
                              }catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(PanelComprados,"Error al ejecutar el UPDATE->"+ex.getMessage());
                                        Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                              }
                    }

          }
          if (Opcion ==2 ){
                    if(( TablaComprados.getSelectedRows().length > 0 ) && (Tabla.getSelectedRows().length > 0 )){
                              int num = TablaComprados.getSelectedRow();
                              int ClaveAptDet = (Integer) TablaComprados.getValueAt(num,4);
                              String ClaveAptDet2 = Integer.toString(ClaveAptDet);
                              int num2 = Tabla.getSelectedRow();
                              int ClaveOficina = (Integer) Tabla.getValueAt(num2,0);
                              String ClaveOfi = Integer.toString(ClaveOficina);
                              String FechaInicio = df.format(Fecha.getDate());
                              String FechaString = ConvierteFechas(FechaInicio);
                              float nuevoprecio= 0;
                              float comision =0;
                              PanelPrecio.setVisible(true);
                              JOptionPane.showMessageDialog(PanelComprados,"Actualice el precio.");

                              try{
                                        nuevoprecio = Float.parseFloat(txtprecio.getText());
                                        comision = Float.parseFloat(txtcomi.getText());
                              }catch(Exception e){
                                      JOptionPane.showMessageDialog(PanelComprados,"Error, debe ingresar el precio expresado en numeros.");
                              }
                              try {
                                        comision = (comision / nuevoprecio) * 100;
                                        JOptionPane.showMessageDialog(PanelComprados,"Apartamento puesto en venta correctamente.");
                                        MenuBienesRaicesControlador.ColocarApartamentoEnVentaPropietario(ClaveAptDet2, Float.toString(nuevoprecio));
                                        MenuBienesRaicesControlador.RegistrarTransaccionBienesRaices(comision, ClaveAptDet2, ClaveOfi, FechaString);
                                        MenuBienesRaices refresh = new MenuBienesRaices();
                                        refresh.setVisible(true);
                                        this.dispose();
                              } catch (SQLException ex) {
                                        Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                                        JOptionPane.showMessageDialog(PanelComprados,"Error al realizar la consulta ->"+ ex.getMessage());
                              }
                    }    
           }
          
          
          
          if (Opcion ==3){
          
                    if(( Tabla.getSelectedRows().length > 0 ) && (TablaPropietarios.getSelectedRows().length > 0 )){
                            
                              int num = Tabla.getSelectedRow();
                              int ClaveAptDet = (Integer) Tabla.getValueAt(num,0);
                              String ClaveAptDet2 = Integer.toString(ClaveAptDet);
                              int num2 = TablaPropietarios.getSelectedRow();
                              int ClavePropietario = (Integer)TablaPropietarios.getValueAt(num2,0);
                              try {
                                        MenuBienesRaicesControlador.AsignaApartamentoAOficina(ClaveAptDet2,Integer.toString(ClavePropietario));
                                        JOptionPane.showMessageDialog(PanelComprados,"Compra Concretada");
                                        MenuBienesRaices reset = new MenuBienesRaices();
                                        reset.setVisible(true);
                                        this.dispose();
                              }catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(PanelComprados,"Error al ejecutar el UPDATE->"+ex.getMessage());
                                        Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                              }
                    }

          
          }
          if (Opcion ==5 ){
                    JOptionPane.showMessageDialog(PanelComprados,"Actualice el precio.");
                    if( TablaComprados.getSelectedRows().length > 0 ){
                              int num = TablaComprados.getSelectedRow();
                              int ClaveAptDet = (Integer) TablaComprados.getValueAt(num,4);
                              String ClaveAptDet2 = Integer.toString(ClaveAptDet);
                              JOptionPane.showMessageDialog(PanelComprados,"La clave del apartamento seleccionado es:"+ClaveAptDet2);
                              float nuevoprecio= 0;
                              PanelPrecio.setVisible(true);
                              try{
                                        nuevoprecio = Float.parseFloat(txtprecio.getText());
                                     //   JOptionPane.showMessageDialog(PanelComprados,"El nuevo precio es:"+nuevoprecio);
                              }catch(Exception e){
                                      JOptionPane.showMessageDialog(PanelComprados,"Error, debe ingresar el precio expresado en numeros.");
                              }
                              try {
                                        JOptionPane.showMessageDialog(PanelComprados,"Apartamento puesto en venta correctamente.");
                                        MenuBienesRaicesControlador.ColocarApartamentoEnVentaPropietario(ClaveAptDet2, Float.toString(nuevoprecio));
                                        MenuBienesRaices refresh = new MenuBienesRaices();
                                        refresh.setVisible(true);
                                        this.dispose();
                              } catch (SQLException ex) {
                                        Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                                        JOptionPane.showMessageDialog(PanelComprados,"Error al realizar la consulta ->"+ ex.getMessage());
                              }
                    }    
           }
          
    }//GEN-LAST:event_btnfinActionPerformed

    private void TablaCompradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCompradosMouseClicked
          if ((Opcion == 2) &&  ( TablaComprados.getSelectedRows().length > 0 )){
                    int num = TablaComprados.getSelectedRow();
                    int ClaveAptDet = (Integer) TablaComprados.getValueAt(num,4);
                    PanelPrecio.setVisible(true);
                    btnfin.setVisible(true);
                    PanelTablaPrincipal.setVisible(true);
                    cargarInterfazOficina3();
                    PanelTablaPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Oficinas existentes en el sistema"));
              try {
                  MenuBienesRaicesControlador.RellenaTablaOficinasSQL();
              } catch (SQLException ex) {
                  Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
              }

                    
                    
          }
          if ((Opcion == 5) &&  ( TablaComprados.getSelectedRows().length > 0 )){
                    int num = TablaComprados.getSelectedRow();
                    int ClaveAptDet = (Integer) TablaComprados.getValueAt(num,4);
                    PanelPrecio.setVisible(true);
                    btnfin.setVisible(true);
                   
          }
    }//GEN-LAST:event_TablaCompradosMouseClicked

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            
          VentanaMenuPrincipal nueva = null;
          try {
                    nueva = new VentanaMenuPrincipal();
          } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(PanelComprados,"ERROR, DEBE INGRESAR DESDE EL LogIN");
                    Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
          }
          nueva.setVisible(true);
          this.dispose();
            
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
            java.util.logging.Logger.getLogger(MenuBienesRaices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBienesRaices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBienesRaices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBienesRaices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBienesRaices().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboOpcion;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JPanel PanelComprados;
    private javax.swing.JPanel PanelOpcion;
    private javax.swing.JPanel PanelPrecio;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelPropietarios;
    private javax.swing.JPanel PanelTablaPrincipal;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable TablaComprados;
    private javax.swing.JTable TablaPropietarios;
    private javax.swing.JButton btnfin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblpanel3;
    private javax.swing.JTextField txtcomi;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}