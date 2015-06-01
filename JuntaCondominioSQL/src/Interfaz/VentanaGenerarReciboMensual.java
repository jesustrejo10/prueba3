/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.VentanaGenerarContratoControlador;
import Controlador.VentanaGenerarReciboMensualControlador;
import static Interfaz.VentanaMenuTrabajo.ModeloEdificios;
import Modelo.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class VentanaGenerarReciboMensual extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGenerarReciboMensual
     */
    public static int Opcion;
    public static int cont= 0;
    public static DefaultTableModel ModeloEdificios = new DefaultTableModel();
    public static DefaultTableModel ModeloTrabajosDisponibles = new DefaultTableModel();
    public static DefaultTableModel ModeloTrabajosAsignados = new DefaultTableModel();
    public static String TrabajosSeleccionados = "";
    public static String ClaveEdificio ="";
    public static DateFormat df = DateFormat.getDateInstance();
    public static Float PrecioRecibo;
    public void cargarInterfazEdificios(){
          String x[][]={};
          String columnas[]={"Rif","Nombre","Direccion"};
          ModeloEdificios = new DefaultTableModel(x, columnas);
          Tabla1.setModel(ModeloEdificios);
    }
    
    public void cargarInterfazTrabajosDisponibles(){
          String x[][]={};
          String columnas[]={"Clave","Descripcion","Fecha de Realizacion", "Monto", "Tipo"};
          ModeloTrabajosDisponibles = new DefaultTableModel(x, columnas);
          Tabla2.setModel(ModeloTrabajosDisponibles);
    }
    
    public void cargarInterfazTrabajosAsignados(){
          String x[][]={};
          String columnas[]={"Clave","Descripcion","Fecha de Realizacion", "Monto", "Tipo"};
          ModeloTrabajosAsignados = new DefaultTableModel(x, columnas);
          Tabla3.setModel(ModeloTrabajosAsignados);
    }
    
    public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date) { //CONVIERTE UTIL.DATE A SQL.DATE
        return new java.sql.Date(date.getTime()); }

    public static String ConvierteFechas(String FechaInicio){
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
    
    }
    
    public static String CalculaJuntaActual(String Clave) throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select JC_CLAVE \n" +
                                                                              " from JUNTACONDOMINIO, EDIFICIO E\n" +
                                                                              " where \n" +
                                                                              " E.EDI_CLAVE = JUNTACONDOMINIO.JC_FK_EDIFICIO AND\n" +
                                                                              " E.EDI_CLAVE = "+Clave+" AND\n" +
                                                                          "    JC_FECHA_FIN = (select MAX(JC_FECHA_FIN)\n" +    
                                                                          "                                     FROM JUNTACONDOMINIO) " );
          while (Valores.next()){
                    return Integer.toString(Valores.getInt(1));
          }     
          return ("0");
     }; 
     
    public static String CalculaClaveRecibo() throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery(" select max(RECI_CLAVE)\n" +
                                                                             " FROM RECIBOMENSUAL" );
          while (Valores.next()){
                    return Integer.toString(Valores.getInt(1));
          }     
          return ("0");
     }; 
     
    public VentanaGenerarReciboMensual() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        PanelFormulario = new javax.swing.JPanel();
        Mes = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Recibos Mensuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Medium", 0, 24))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la opcion"));

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Generar Recibo" }));

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Edificios Administrados en el sistema"));

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

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
        jLabel1.setText("Seleccione el Edificio al cual desea agregar un recibo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de trabajos pertenecientes al edificio Sin pagar."));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista De trabajos Asignados"));

        Tabla3.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabla3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        PanelFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Rellene La Informacion Solicitada"));

        jLabel2.setText("Seleccione El mes Al cual desea Realizar el recibo");

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setText("Monto Total");

        txtMonto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMonto.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jLabel3)
                    .addComponent(txtMonto)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMonto)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if (Opcion == 0){//ARMAR RECIBO A MANO
                    cargarInterfazEdificios();
                    try {
                              VentanaGenerarReciboMensualControlador.RellenaTablaEdificiosSQL();
                    } catch (SQLException ex) {
                              Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
          }
          
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseClicked

          if (Opcion == 0){
                    int num = Tabla1.getSelectedRow();
                    String RifEdificioSelec = (String) Tabla1.getValueAt(num,0);
                    String NombreEdifSelec = (String)Tabla1.getValueAt(num,1);
                    //JOptionPane.showMessageDialog(null, RifEdificioSelec+NombreEdifSelec);
                    try {
                              ClaveEdificio = VentanaGenerarContratoControlador.ConsultaClaveEdificioSeleccionadoSQL2(NombreEdifSelec, RifEdificioSelec);
                              //JOptionPane.showMessageDialog(null, "LA CLAVE DEL EDIF ES:"+ClaveEdificio);
                              cargarInterfazTrabajosDisponibles();
                              VentanaGenerarReciboMensualControlador.RellenaTablaTrabajosDisponiblesSQL(ClaveEdificio);

                    
                    }catch (SQLException ex) {
                              Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
          
          
          
          
          }
        
    }//GEN-LAST:event_Tabla1MouseClicked
    
    public static void LimpiarJTable(DefaultTableModel Nombremodelo){
          int a =Nombremodelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    Nombremodelo.removeRow(i);
          }
        }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

          String ClaveJuntaActual  = "35";
          try {
                    ClaveJuntaActual = CalculaJuntaActual(ClaveEdificio);
                    String FRealizado = df.format(Mes.getDate());
                    String FechaRealizadoString = ConvierteFechas(FRealizado);
                    VentanaGenerarReciboMensualControlador.InsertaReciboMensualSQL(ClaveJuntaActual,FechaRealizadoString);
                    PrecioRecibo = Float.parseFloat(CalculaPrecioRecibo2());
                    String ClaveRecibcoMensual = CalculaClaveRecibo();
                    VentanaGenerarReciboMensualControlador.InsertaAvisoCobroSQL(ClaveRecibcoMensual);
                    String [] TrabajosSeparados = TrabajosSeleccionados.split(",");
                    int tamano = TrabajosSeparados.length;
                    for (int factor = 0 ; factor < tamano ; factor++){
                              VentanaGenerarReciboMensualControlador.ActualizaTrabajoAPasado(ClaveRecibcoMensual, TrabajosSeparados[factor]);
                    }
                    
                    
                    
          } catch (SQLException ex) {
                    Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(Level.SEVERE, null, ex);
         }
          JOptionPane.showMessageDialog(null, "La Clave es: "+ClaveJuntaActual);
       
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla2MouseClicked
          if (Opcion==0){
                    int num = Tabla2.getSelectedRow();
                    String ClaveTrabajoSeleccionado = Integer.toString((Integer)Tabla2.getValueAt(num, 0));
                    if (TrabajosSeleccionados.equalsIgnoreCase("")){
                              TrabajosSeleccionados =ClaveTrabajoSeleccionado;
                    }
                    else{
                              TrabajosSeleccionados = TrabajosSeleccionados+","+ClaveTrabajoSeleccionado;
                    }
                    LimpiarJTable(ModeloTrabajosDisponibles);
                    LimpiarJTable(ModeloTrabajosAsignados);
                    cargarInterfazTrabajosAsignados();
                    try {
                              VentanaGenerarReciboMensualControlador.RellenaTablaTrabajosDisponiblesSQL2(ClaveEdificio);
                              VentanaGenerarReciboMensualControlador.RellenaTablaTrabajosDisponiblesSQL3(ClaveEdificio);
                              String ParaImprimir = CalculaPrecioRecibo2();
                              txtMonto.setText(ParaImprimir);
                    } catch (SQLException ex) {
                              Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
    }//GEN-LAST:event_Tabla2MouseClicked
    
    public static String CalculaPrecioRecibo2() throws SQLException{
          ConexionOracle Conexion= new ConexionOracle();
          Connection Con=Conexion.Conectar();
          Statement st= Con.createStatement();
          ResultSet Valores= st.executeQuery("    SELECT SUM(T.TRA_MONTO) AS MONTORECIBO\n" +
                                                                            "     from TRABAJO T  \n" +
                                                                            "    WHERE (T.TRA_CLAVE IN ("+TrabajosSeleccionados+"))");
          while (Valores.next()){
                    return Float.toString(Valores.getFloat(1));
          }     
          float returnx = 0;
          return ("0");
     };
    
    private void Tabla3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla3MouseClicked

          if (Opcion == 0){
                    int num = Tabla3.getSelectedRow();
                    String ClaveTrabajoSeleccionado = Integer.toString((Integer)Tabla3.getValueAt(num, 0));
                    String[] Separado =TrabajosSeleccionados.split(",");
                    int tamano = Separado.length;
                    String Nuevo = "";
                    //System.out.println(tamano);
                    for (int factor = 0 ; factor < tamano ; factor++){
                              if (!(ClaveTrabajoSeleccionado.equalsIgnoreCase(Separado[factor]))){
                      //                  System.out.println("FACTORIA"+Separado[factor]);
                                        if (Nuevo.equalsIgnoreCase("")){
                                                  Nuevo =Separado[factor];
                                        }
                                        else{
                                                  Nuevo = Nuevo+","+Separado[factor];
                                        }
                              }
                    }
                    TrabajosSeleccionados=Nuevo;
                    if (TrabajosSeleccionados.equalsIgnoreCase(""))
                              TrabajosSeleccionados = "999999";
                    //System.out.println("SANGANA"+TrabajosSeleccionados);
                    LimpiarJTable(ModeloTrabajosDisponibles);
                    LimpiarJTable(ModeloTrabajosAsignados);
                    cargarInterfazTrabajosAsignados();
                    cargarInterfazTrabajosDisponibles();
                    try {
                              VentanaGenerarReciboMensualControlador.RellenaTablaTrabajosDisponiblesSQL2(ClaveEdificio);
                              VentanaGenerarReciboMensualControlador.RellenaTablaTrabajosDisponiblesSQL3(ClaveEdificio);
                              String ParaImprimir = CalculaPrecioRecibo2();
                              txtMonto.setText(ParaImprimir);
                    } catch (SQLException ex) {
                              Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }    
    }//GEN-LAST:event_Tabla3MouseClicked

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
            java.util.logging.Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGenerarReciboMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGenerarReciboMensual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboOpcion;
    private com.toedter.calendar.JDateChooser Mes;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JTable Tabla1;
    private javax.swing.JTable Tabla2;
    private javax.swing.JTable Tabla3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel txtMonto;
    // End of variables declaration//GEN-END:variables
}
