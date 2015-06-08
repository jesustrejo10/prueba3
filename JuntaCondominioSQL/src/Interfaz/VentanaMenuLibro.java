/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Controlador.VentanaMenuReclamoControlador ;
import Controlador.VentanaMenuJuntaCondominioControlador;
import Controlador.VentanaMenuLibroControlador;
import Controlador.VentanaMenuPropietarioControlador;
import static Interfaz.MenuBienesRaices.ModeloApartamentosComprados;
import static Interfaz.MenuBienesRaices.Opcion;
import static Interfaz.VentanaMenuPropietario.ClaveMunicipio;
import static Interfaz.VentanaMenuPropietario.ClaveParroquia;
import static Interfaz.VentanaMenuPropietario.Opcion;
import Modelo.ConexionOracle;
import Modelo.Util;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Luis
 */
public class VentanaMenuLibro extends javax.swing.JFrame {
  DateFormat df = DateFormat.getDateInstance();
 public static DefaultTableModel ModeloContratos = new DefaultTableModel();
 public static DefaultTableModel ModeloLibros = new DefaultTableModel();
 public static DefaultTableModel ModeloMiembros = new DefaultTableModel();
 public static DefaultTableModel ModeloEscrituras = new DefaultTableModel();
 public static int Opcion = 0;
  public static int cont= 0;
  public static int contAPT= 0;
  public static int contMIE= 0;
   public static int fase = 1;
   public static Date prueba;

  
 public VentanaMenuLibro() {
     initComponents();
       PanelContratos.setVisible(false);
                 PanelLibroM.setVisible(false);
                 PanelLibros.setVisible(false);
                 PanelMiembros.setVisible(false);
               jButton2.setVisible(false);
               setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconbuil.png")).getImage() );
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        this.PanelPrincipal.add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());    

     
       }  
public void cargarInterfazContratos(){
        String x[][]={}; 
        String columnas[]={"Identificacion","Monto","FechaEmision","FechaVenci","QuorumMin"};
        ModeloContratos = new DefaultTableModel(x, columnas);
        TablaContratos.setModel(ModeloContratos);
     }
    
public void cargarInterfazLibros(){
        String x[][]={}; 
        String columnas[]={"Identificacion","Tipo"};
        ModeloLibros = new DefaultTableModel(x, columnas);
        TablaLibro.setModel(ModeloLibros);
     }

public void cargarInterfazMiembros(){
        String x[][]={}; 
        String columnas[]={"Identificacion","Nombre","Apellido","Cargo"};
        ModeloMiembros = new DefaultTableModel(x, columnas);
        TablaMiembros.setModel(ModeloMiembros);
     }

public void cargarInterfazEscrituras(){
        String x[][]={}; 
        String columnas[]={"Identificacion","Descripcion","Fecha"};
        ModeloEscrituras = new DefaultTableModel(x, columnas);
        TablaLibro.setModel(ModeloEscrituras);
}
     
    
public  String ConvierteFechas(String FechaInicio){
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
                    JOptionPane.showMessageDialog(null,"Error al convertir la fecha."+e.getMessage());
          }                        
        return null;
    
        
       //insert into RECLAMO VALUES (SQ_PK_RECLAMO.NEXTVAL,'"+VARIABLE+"',TO_DATE('20150525','YYYYMMDD'),2,1,'TITULO');
        
    };
public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) { //CONVIERTE UTIL.DATE A SQL.DATE
        return new java.sql.Date(date.getTime());
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelContratos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaContratos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        PanelLibroM = new javax.swing.JPanel();
        CampoFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TXTDESCRIPCION = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        PanelLibros = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaLibro = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        PanelMiembros = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaMiembros = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        ComboOpcion = new javax.swing.JComboBox();

        TablaLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaLibros);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelPrincipal.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        PanelPrincipal.setMaximumSize(new java.awt.Dimension(50, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("Menu Libros");

        PanelContratos.setBackground(new java.awt.Color(255, 255, 255));
        PanelContratos.setBorder(javax.swing.BorderFactory.createTitledBorder("Contratos"));

        TablaContratos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TablaContratos.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaContratosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaContratos);

        javax.swing.GroupLayout PanelContratosLayout = new javax.swing.GroupLayout(PanelContratos);
        PanelContratos.setLayout(PanelContratosLayout);
        PanelContratosLayout.setHorizontalGroup(
            PanelContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContratosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PanelContratosLayout.setVerticalGroup(
            PanelContratosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContratosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        PanelLibroM.setBackground(new java.awt.Color(255, 255, 255));
        PanelLibroM.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario Libro"));

        jLabel4.setText("Fecha Libro");

        TXTDESCRIPCION.setColumns(20);
        TXTDESCRIPCION.setRows(5);
        jScrollPane5.setViewportView(TXTDESCRIPCION);

        jLabel2.setText("    Texto");

        javax.swing.GroupLayout PanelLibroMLayout = new javax.swing.GroupLayout(PanelLibroM);
        PanelLibroM.setLayout(PanelLibroMLayout);
        PanelLibroMLayout.setHorizontalGroup(
            PanelLibroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLibroMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLibroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CampoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(PanelLibroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        PanelLibroMLayout.setVerticalGroup(
            PanelLibroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLibroMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLibroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(PanelLibroMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(PanelLibroM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(PanelLibroM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelLibros.setBackground(new java.awt.Color(255, 255, 255));
        PanelLibros.setBorder(javax.swing.BorderFactory.createTitledBorder("Libros"));

        TablaLibro.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaLibroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaLibro);

        javax.swing.GroupLayout PanelLibrosLayout = new javax.swing.GroupLayout(PanelLibros);
        PanelLibros.setLayout(PanelLibrosLayout);
        PanelLibrosLayout.setHorizontalGroup(
            PanelLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        PanelLibrosLayout.setVerticalGroup(
            PanelLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLibrosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Finalizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        PanelMiembros.setBackground(new java.awt.Color(255, 255, 255));
        PanelMiembros.setBorder(javax.swing.BorderFactory.createTitledBorder("Miembros"));
        PanelMiembros.setMinimumSize(new java.awt.Dimension(100, 0));
        PanelMiembros.setPreferredSize(new java.awt.Dimension(100, 243));

        TablaMiembros.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaMiembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMiembrosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaMiembros);

        javax.swing.GroupLayout PanelMiembrosLayout = new javax.swing.GroupLayout(PanelMiembros);
        PanelMiembros.setLayout(PanelMiembrosLayout);
        PanelMiembrosLayout.setHorizontalGroup(
            PanelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelMiembrosLayout.setVerticalGroup(
            PanelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMiembrosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la Operacion a Realizar"));

        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Agregar Libro Junta", "Agregar Libro Oficina", "Mostrar Libro" }));
        ComboOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboOpcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(PanelContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PanelLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelMiembros, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelContratos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaContratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaContratosMouseClicked
        if ((Opcion == 0) &&  ( TablaContratos.getSelectedRows().length > 0 )){
            
          cargarInterfazMiembros();  
          cargarInterfazLibros();
            try{
                int num2 = TablaContratos.getSelectedRow();
                String ClavePropietario2 =((String)TablaContratos.getValueAt(num2,0));
                VentanaMenuLibroControlador.RellenaTablaLibrosJSQL(ClavePropietario2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelLibros,"error al asignar la columnaasdasdas"+e);
            }
          
          try{
                int num2 = TablaContratos.getSelectedRow();
                String ClavePropietario2 =((String)TablaContratos.getValueAt(num2,0));
                VentanaMenuLibroControlador.RellenaTablaMiembrosSQL(ClavePropietario2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelMiembros,"error al asignar la columnaasdasdas"+e);
            }

        }
        
        if ((Opcion == 1) &&  ( TablaContratos.getSelectedRows().length > 0 )){
            
                                PanelMiembros.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

          cargarInterfazMiembros();  
          cargarInterfazLibros();
            try{
                int num2 = TablaContratos.getSelectedRow();
                String ClavePropietario2 =((String)TablaContratos.getValueAt(num2,0));
                VentanaMenuLibroControlador.RellenaTablaLibrosOSQL(ClavePropietario2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelLibros,"error al asignar la columnaasdasdas"+e);
            }
          
          try{
                int num2 = TablaContratos.getSelectedRow();
                String ClavePropietario2 =((String)TablaContratos.getValueAt(num2,0));
                VentanaMenuLibroControlador.RellenaTablaOFIEMPSQL(ClavePropietario2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelMiembros,"error al asignar la columnaasdasdas"+e);
            }

        }
        
        
        if ((Opcion == 2) &&  ( TablaContratos.getSelectedRows().length > 0 )){
            

          cargarInterfazLibros();
            try{
                int num2 = TablaContratos.getSelectedRow();
                String ClavePropietario2 =((String)TablaContratos.getValueAt(num2,0));
                VentanaMenuLibroControlador.RellenaTablaLibrosSQL(ClavePropietario2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelLibros,"error al asignar la columnaasdasdas"+e);
            }
            fase = 1;  
        }

      

    }//GEN-LAST:event_TablaContratosMouseClicked

    private void ComboOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboOpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboOpcionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Opcion = ComboOpcion.getSelectedIndex();
        if (Opcion==0){
            jButton2.setVisible(true);
             PanelContratos.setVisible(true);
             PanelMiembros.setVisible(true);
             PanelLibros.setVisible(true);
             jButton2.setVisible(true);

          //  PanelPropietarios.setVisible(true);
           // PanelReclamo.setVisible(true);
            cargarInterfazContratos();
            try {
                VentanaMenuLibroControlador.RellenaTablaContratosSQL();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
        
 if (Opcion==1){
            jButton2.setVisible(true);
             PanelContratos.setVisible(true);
             PanelMiembros.setVisible(true);
             PanelLibros.setVisible(true);
             jButton2.setVisible(true);
             PanelMiembros.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));
          //  PanelPropietarios.setVisible(true);
           // PanelReclamo.setVisible(true);
            cargarInterfazContratos();
            try {
                VentanaMenuLibroControlador.RellenaTablaContratosSQL();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 


// TODO add your handling code here:
        if (Opcion==2){
                 
                 PanelLibroM.setVisible(false);
                 PanelMiembros.setVisible(false);
                 jButton2.setVisible(false);
                 PanelLibros.setVisible(true);
                 PanelContratos.setVisible(true);

           // cargarInterfazPropietarios();
           // CampoFechaInicio.setText("");
            TXTDESCRIPCION.setText("");
            
               cargarInterfazContratos();
            try {
                VentanaMenuLibroControlador.RellenaTablaContratosSQL();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaMenuPropietario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaMiembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMiembrosMouseClicked
   PanelLibroM.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_TablaMiembrosMouseClicked

    private void TablaLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaLibroMouseClicked
      if (((Opcion == 2)) && (fase ==1) &&  ( TablaLibro.getSelectedRows().length > 0 )) {
            try{
             PanelLibros.setBorder(javax.swing.BorderFactory.createTitledBorder("Escrituras"));
                int num2 = TablaLibro.getSelectedRow();
                                System.out.print(num2);

                 String ClaveLIB2 = Integer.toString((Integer)TablaLibro.getValueAt(num2,0));
                 cargarInterfazEscrituras();
                 VentanaMenuLibroControlador.RellenaTablasEscriturasSQL(ClaveLIB2);
                 fase = 2;
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(PanelLibros,"error al asignar la columnaasdasdas"+e);
            }

        }
         if ((Opcion == 2) && (fase == 2) && ( TablaLibro.getSelectedRows().length > 0 )){
                  PanelLibroM.setVisible(true);
                   PanelLibros.setBorder(javax.swing.BorderFactory.createTitledBorder("Escrituras"));
            //cargarInterfazEscrituras ();
           int num2 = TablaLibro.getSelectedRow();
                    System.out.print(num2);
                    String ClaveLibroSeleccionado = Integer.toString((Integer)TablaLibro.getValueAt(num2,0));
                    String TITULO=(String)TablaLibro.getValueAt(num2,1);
                    this.TXTDESCRIPCION.setText(TITULO);
                    
                     try {
                              VentanaMenuLibroControlador.RellenaCamposFaltantes(ClaveLibroSeleccionado);
                              
                    }catch (SQLException ex) {
                              JOptionPane.showMessageDialog(rootPane,"Error al ejecutar la consulta 'rellena campos faltantes' ->"+ex);
                              Logger.getLogger(VentanaMenuReclamo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.CampoFechaInicio.setDate(prueba);      
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TablaLibroMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              try{
         if (Opcion == 0){
            String DESCRIPCION = TXTDESCRIPCION.getText();
            String FechaInicio = df.format(CampoFechaInicio.getDate());
            String FechaInicioString = ConvierteFechas(FechaInicio);
                               

            int ColumnaSeleccionadaTablaLibro = TablaLibro.getSelectedRow();
            String ClaveLibroSeleccionado = Integer.toString((Integer)TablaLibro.getValueAt(ColumnaSeleccionadaTablaLibro,0));
            int ColumnaSeleccionadaTablaMiembros = TablaMiembros.getSelectedRow();
            String ClaveMiembroSeleccionado = Integer.toString((Integer)TablaMiembros.getValueAt(ColumnaSeleccionadaTablaMiembros,0));
           // JOptionPane.showMessageDialog(PanelComprados,"Titulo->"+TITULO);
            //JOptionPane.showMessageDialog(PanelComprados,"Descripcion->"+DESCRIPCION);
            //JOptionPane.showMessageDialog(PanelComprados,"FECHA->"+FechaInicioString);
            //JOptionPane.showMessageDialog(PanelComprados,"Clave Prop->"+ClaveApartamentoSeleccionado);
            
            
                VentanaMenuLibroControlador.InsertarLibroMSQL(DESCRIPCION,FechaInicioString,ClaveMiembroSeleccionado,ClaveLibroSeleccionado);
        }
        

      if (Opcion == 1){
            String DESCRIPCION = TXTDESCRIPCION.getText();
            String FechaInicio = df.format(CampoFechaInicio.getDate());
            String FechaInicioString = ConvierteFechas(FechaInicio);
                               

            int ColumnaSeleccionadaTablaLibro = TablaLibro.getSelectedRow();
            String ClaveLibroSeleccionado = Integer.toString((Integer)TablaLibro.getValueAt(ColumnaSeleccionadaTablaLibro,0));
            int ColumnaSeleccionadaTablaMiembros = TablaMiembros.getSelectedRow();
            String ClaveMiembroSeleccionado = Integer.toString((Integer)TablaMiembros.getValueAt(ColumnaSeleccionadaTablaMiembros,0));
           // JOptionPane.showMessageDialog(PanelComprados,"Titulo->"+TITULO);
            //JOptionPane.showMessageDialog(PanelComprados,"Descripcion->"+DESCRIPCION);
            //JOptionPane.showMessageDialog(PanelComprados,"FECHA->"+FechaInicioString);
            //JOptionPane.showMessageDialog(PanelComprados,"Clave Prop->"+ClaveApartamentoSeleccionado);
            
            
                VentanaMenuLibroControlador.InsertarLibroESQL(DESCRIPCION,FechaInicioString,ClaveMiembroSeleccionado,ClaveLibroSeleccionado);
        }
                          JOptionPane.showMessageDialog(rootPane,"Libro Agregado Correctamente");  
        
        
        }
          catch (SQLException e) {
                 Logger.getLogger(VentanaMenuLibro.class.getName()).log(Level.SEVERE, null, e);
        }
        





    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  JOptionPane.showMessageDialog(rootPane,"Todos los cambios no guardados han sido borrados.");
        try {
            VentanaMenuPrincipal cambio = new VentanaMenuPrincipal();
            cambio.setVisible(true);
           
        } catch (SQLException ex) {
            Logger.getLogger(VentanaMenuLibro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"Error, Debe Ingresar desde el LogIn");
        }
        this.dispose();      // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(VentanaMenuLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMenuLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CampoFechaInicio;
    private javax.swing.JComboBox ComboOpcion;
    private javax.swing.JPanel PanelContratos;
    private javax.swing.JPanel PanelLibroM;
    private javax.swing.JPanel PanelLibros;
    private javax.swing.JPanel PanelMiembros;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JTextArea TXTDESCRIPCION;
    private javax.swing.JTable TablaContratos;
    private javax.swing.JTable TablaLibro;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JTable TablaMiembros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    
}
