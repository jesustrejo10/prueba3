/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import Controlador.MenuBienesRaicesControlador;
import Controlador.VentanaGestionCuentaControlador;
import Controlador.VentanaMenuPagoControlador;
import static Controlador.VentanaMenuPagoControlador.ActualizarFondos;
import static Controlador.VentanaMenuPagoControlador.ActualizarFondos2;
import static Controlador.VentanaMenuPagoControlador.ActualizarFondos3;
import static Controlador.VentanaMenuPagoControlador.RellenaTablaContratos;
import static Interfaz.MenuBienesRaices.ModeloApartamentosComprados;
import static Interfaz.MenuBienesRaices.Opcion;
import static Interfaz.VentanaGestionCuenta.ModeloAvisos;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * @author Jesus
 */
public class VentanaMenuPagos extends javax.swing.JFrame {

    public static int Opcion;
    
    public static DefaultTableModel modeloPropietarios = new DefaultTableModel();
    public static DefaultTableModel ModeloAvisos = new DefaultTableModel();
    public static DefaultTableModel modeloApt = new DefaultTableModel();
    public static DefaultTableModel modeloContratos = new DefaultTableModel();
    public static DefaultTableModel ModeloTrabajos = new DefaultTableModel();
    
    public static int cont;
    public static String Monto="25000";
    public static String ClaveAvisoCobro="1";
    public static int Fase = 1;
    public static String ClaveAvisoSeleccionado;
    public static String ClaveTarjeta= "NULL";
    public static String ClaveCheque= "NULL";
    DateFormat df = DateFormat.getDateInstance();
    public static String ClaveAptSeleccionado;
    public static String ClaveContFond;
    public static String ClavePropietarioSeleccionado;
    public static String ClaveContrato;
    public static String ClaveTrabajo;
    public static String ClaveOficina;
    
    
    /**
     * Creates new form VentanaMenuPagos
     */
    public VentanaMenuPagos(/*String Monto, String ClaveAvisoCobro*/) {
          initComponents();
         setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconbuil.png")).getImage() );
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/fondo2.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
          Panel1.setVisible(false);
          PanelInfo.setVisible(false);
          PanelPago.setVisible(false);
          PanelCheque.setVisible(false);
          PanelTarjet.setVisible(false);
          
    }

      public void cargarInterfazPropietarios(){
        String x[][]={};
        String columnas[]={"Identificacion","Nombre","Apellido","Direccion"};
        modeloPropietarios = new DefaultTableModel(x, columnas);
        Tabla1.setModel(modeloPropietarios);
    }

      public void cargarInterfazContratosVigentes(){
        String x[][]={};
        String columnas[]={"ContratoVigente","Rif Edifcio","Nombre Edif","Direccion"};
        modeloContratos = new DefaultTableModel(x, columnas);
        Tabla1.setModel(modeloContratos);
    }
      
     public void cargarInterfazTrabajos(){
        String x[][]={};
        String columnas[]={"ID Trabajo","Clasificacion","Descripcion","Proveedor","Monto"};
        ModeloTrabajos = new DefaultTableModel(x, columnas);
        Tabla1.setModel(ModeloTrabajos);
    }
      
      public void CargarInterfazApartamentosComprados(){
        String x[][]={};
        String columnas[]={"Edificio","Medidas","Alicuota","Piso","Codigo","Precio"};
        modeloApt = new DefaultTableModel(x, columnas);
        Tabla1.setModel(modeloApt);
     }
    
    public void CargarInterfazAvisosDecobro(){
        String x[][]={};
        String columnas[]={"Codigo","Monto","Estado","MesEmision"};
        ModeloAvisos = new DefaultTableModel(x, columnas);
        Tabla1.setModel(ModeloAvisos);
     }
      
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
                    JOptionPane.showMessageDialog(null,"Error al convertir la fecha."+e.getMessage());
          }                        
        return null;
    
    };

    
     public static void LimpiarJTable(DefaultTableModel Nombremodelo){
          int a =Nombremodelo.getRowCount()-1;
          for(int i=a;i>=0;i--){ 
                    Nombremodelo.removeRow(i);
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

        jPanel1 = new javax.swing.JPanel();
        PanelInfo = new javax.swing.JPanel();
        lblPNombre = new javax.swing.JLabel();
        lbltrabajo = new javax.swing.JLabel();
        lblPape = new javax.swing.JLabel();
        LblClaveApt = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelApe = new javax.swing.JLabel();
        lblprov = new javax.swing.JLabel();
        Lbldireccion = new javax.swing.JLabel();
        LblMonto = new javax.swing.JLabel();
        LabelMonto = new javax.swing.JLabel();
        PanelPago = new javax.swing.JPanel();
        BTNPagar = new javax.swing.JButton();
        PanelTarjet = new javax.swing.JPanel();
        LabelCombo1 = new javax.swing.JLabel();
        TXTNumeroDeTarjeta = new javax.swing.JTextField();
        LabelCombo4 = new javax.swing.JLabel();
        ComboTipo = new javax.swing.JComboBox();
        LabelMontoTarjeta = new javax.swing.JLabel();
        TXTMontoConTarjeta = new javax.swing.JTextField();
        PanelCheque = new javax.swing.JPanel();
        LabelCombo3 = new javax.swing.JLabel();
        TxtNumerocheque = new javax.swing.JTextField();
        LabelCombo2 = new javax.swing.JLabel();
        ComboEndoso = new javax.swing.JComboBox();
        LabelMontoCheque = new javax.swing.JLabel();
        TXTMontoCheque = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescrip = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        ComboPago = new javax.swing.JComboBox();
        SeleccionCombo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ComboOpcion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        Panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(null);
        jPanel1.setMaximumSize(new java.awt.Dimension(1233, 842));
        jPanel1.setMinimumSize(new java.awt.Dimension(1233, 842));
        jPanel1.setOpaque(false);

        PanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        PanelInfo.setOpaque(false);

        lblPNombre.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPNombre.setText("jLabel1");

        lbltrabajo.setText("Apartamento #");

        lblPape.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPape.setText("jLabel3");

        LblClaveApt.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        LblClaveApt.setText("jLabel4");

        LabelNombre.setText("PrimerNombre:");

        LabelApe.setText("Primer Apellido:");

        lblprov.setText("Direccion");

        Lbldireccion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        Lbldireccion.setText("jLabel1");

        LblMonto.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        LblMonto.setForeground(new java.awt.Color(98, 1, 1));
        LblMonto.setText("MONTO TOTAL");

        LabelMonto.setText("Monto a Pagar");

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addComponent(LabelApe, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPape, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addComponent(LabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltrabajo)
                    .addComponent(lblprov, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Lbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LblClaveApt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelMonto)
                    .addComponent(LblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addComponent(LabelNombre)
                        .addGap(21, 21, 21)
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelApe)
                            .addComponent(lblPape)))
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprov)
                            .addComponent(Lbldireccion)
                            .addComponent(LabelMonto)
                            .addComponent(lblPNombre))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltrabajo)
                            .addComponent(LblClaveApt)
                            .addComponent(LblMonto))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu Opciones de Pago"));
        PanelPago.setOpaque(false);

        BTNPagar.setText("PAGAR");
        BTNPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPagarActionPerformed(evt);
            }
        });

        PanelTarjet.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarjeta"));
        PanelTarjet.setOpaque(false);

        LabelCombo1.setText("Numero De Tarjeta/Cheque");

        TXTNumeroDeTarjeta.setText("373815992000");

        LabelCombo4.setText("Tipo Tarjeta/Cheque");

        ComboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Credito", "Debito" }));

        LabelMontoTarjeta.setText("Monto Tarjeta");

        TXTMontoConTarjeta.setText("2500");
        TXTMontoConTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTMontoConTarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTarjetLayout = new javax.swing.GroupLayout(PanelTarjet);
        PanelTarjet.setLayout(PanelTarjetLayout);
        PanelTarjetLayout.setHorizontalGroup(
            PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTarjetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelMontoTarjeta))
                .addGap(31, 31, 31)
                .addGroup(PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TXTNumeroDeTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(ComboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TXTMontoConTarjeta))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        PanelTarjetLayout.setVerticalGroup(
            PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTarjetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTNumeroDeTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCombo4)
                    .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelTarjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMontoTarjeta)
                    .addComponent(TXTMontoConTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelCheque.setBorder(javax.swing.BorderFactory.createTitledBorder("Cheque"));
        PanelCheque.setOpaque(false);

        LabelCombo3.setText("Numero de Cheque");

        TxtNumerocheque.setText("02213351235");

        LabelCombo2.setText("Es Endosable?");

        ComboEndoso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));

        LabelMontoCheque.setText("Monto Cheque");

        TXTMontoCheque.setText("1400");

        javax.swing.GroupLayout PanelChequeLayout = new javax.swing.GroupLayout(PanelCheque);
        PanelCheque.setLayout(PanelChequeLayout);
        PanelChequeLayout.setHorizontalGroup(
            PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChequeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCombo3)
                    .addComponent(LabelCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelMontoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTMontoCheque)
                    .addGroup(PanelChequeLayout.createSequentialGroup()
                        .addComponent(ComboEndoso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TxtNumerocheque, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelChequeLayout.setVerticalGroup(
            PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChequeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCombo3)
                    .addComponent(TxtNumerocheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCombo2)
                    .addComponent(ComboEndoso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelChequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMontoCheque)
                    .addComponent(TXTMontoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario General"));
        jPanel6.setOpaque(false);

        jLabel2.setText("Indique la fecha de la transaccion");

        jLabel3.setText("Descripcion");

        txtDescrip.setText("Pago Mes 5 del condominio");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescrip)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione"));
        jPanel7.setOpaque(false);

        ComboPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHEQUE", "TARJETA", "COMBINADO" }));

        SeleccionCombo.setText("Seleccionar");
        SeleccionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione La Forma de Pago de su");

        jLabel4.setText("Conveniencia");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(ComboPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SeleccionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(ComboPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(SeleccionCombo)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPagoLayout = new javax.swing.GroupLayout(PanelPago);
        PanelPago.setLayout(PanelPagoLayout);
        PanelPagoLayout.setHorizontalGroup(
            PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPagoLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPagoLayout.createSequentialGroup()
                        .addComponent(PanelTarjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(PanelCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelPagoLayout.setVerticalGroup(
            PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelTarjet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCheque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNPagar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la Operacion a Realizar"));
        jPanel2.setOpaque(false);

        ComboOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Realizar Pago Aviso de Cobro", "Realizar Pago de Trabajos" }));

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
                .addContainerGap(111, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione El Propietario"));
        Panel1.setMaximumSize(new java.awt.Dimension(36, 461));
        Panel1.setMinimumSize(new java.awt.Dimension(36, 461));
        Panel1.setOpaque(false);

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

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PanelPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel5.setText("Menu de Pago");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Fase= 1;
          Opcion = ComboOpcion.getSelectedIndex();
          if (Opcion==0){
                    Panel1.setVisible(true);
                    PanelInfo.setVisible(false);
                    PanelPago.setVisible(false);
                    cargarInterfazPropietarios();
                    try {
                              VentanaMenuPagoControlador.RellenaTablaPropietarioSQL();
                    } catch (SQLException ex) {
                               Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }if (Opcion ==1){
                    Panel1.setVisible(true);
                    cargarInterfazContratosVigentes();
                    try {
                              RellenaTablaContratos();
                    } catch (SQLException ex) {
                              Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
          }
          
          
          
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseClicked

          if ((Opcion == 0) && (Fase == 1)&& ( Tabla1.getSelectedRows().length > 0 ) ){
                    Fase = 2;
                    int fila  = Tabla1.getSelectedRow();
                    String ClavePropietario = (String)Tabla1.getValueAt(fila,0);
                    ClavePropietarioSeleccionado = ClavePropietario;
                    lblPNombre.setText((String)Tabla1.getValueAt(fila, 1));
                    lblPape.setText((String)Tabla1.getValueAt(fila, 2));
                    Lbldireccion.setText((String)Tabla1.getValueAt(fila, 3));
                    CargarInterfazApartamentosComprados();
                    try {
                              VentanaMenuPagoControlador.RellenaTablaApartamentosCompradosSQL(ClavePropietario);
                              Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Apartamentos Pertenecientes AL propietario"));
                              
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
          if ((Opcion == 0) && (Fase == 2)&& ( Tabla1.getSelectedRows().length > 0 ) ){
                    Fase = 3;
                    int fila  = Tabla1.getSelectedRow();
                    ClaveAptSeleccionado = Integer.toString((Integer)Tabla1.getValueAt(fila,4));
                    LblClaveApt.setText(ClaveAptSeleccionado);
                    try {
                              CargarInterfazAvisosDecobro();
                              VentanaMenuPagoControlador.RellenaTablaAvisosSQL(ClaveAptSeleccionado);
                              PanelInfo.setVisible(true);
                             
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
           if ((Opcion == 0) && (Fase == 3)&& ( Tabla1.getSelectedRows().length > 0 ) ){
                    Fase = 3;
                    int fila  = Tabla1.getSelectedRow();
                    ClaveAvisoSeleccionado = ((String)Tabla1.getValueAt(fila,0));
                    Float n = Float.parseFloat((String)Tabla1.getValueAt(fila, 1));
                    LblMonto.setText(Float.toString(n));
                    PanelPago.setVisible(true);
          }
          if ((Opcion == 1) && (Fase == 1)&& ( Tabla1.getSelectedRows().length > 0 ) ){
                    //PanelInfo.setVisible(true);
                    LabelNombre.setText("Rif Edificio");
                    LabelNombre.setText("Nombre Edificio");
                    Fase = 2;
                    int fila  = Tabla1.getSelectedRow();
                    ClaveContrato =Integer.toString((Integer)Tabla1.getValueAt(fila,0));
                    
                    
                    
                    lblPNombre.setText((String)Tabla1.getValueAt(fila, 1));
                    lblPape.setText((String)Tabla1.getValueAt(fila, 2));
                    Lbldireccion.setText((String)Tabla1.getValueAt(fila, 3));
                    cargarInterfazTrabajos();
                    try {
                              VentanaMenuPagoControlador.RellenaTablaTrabajos();
                              Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Trabajos Pertenecientes AL Edificio"));
                              
                    } catch (SQLException ex) {
                              Logger.getLogger(MenuBienesRaices.class.getName()).log(Level.SEVERE, null, ex);
                    }
          }
          if ((Opcion == 1) && (Fase == 2)&& ( Tabla1.getSelectedRows().length > 0 ) ){
                    PanelInfo.setVisible(true);
                    LabelNombre.setText("Tipo de Trabajo");
                    LabelApe.setText("Descripcion del Trabajo");
                    lblprov.setText("Nombre Proveedor");
                    lbltrabajo.setText("ClaveTrabajo");
                    int fila  = Tabla1.getSelectedRow();
                    ClaveTrabajo =Integer.toString((Integer)Tabla1.getValueAt(fila,0));
                    LblClaveApt.setText(ClaveTrabajo);
                    PanelPago.setVisible(true);
                    ComboPago.setEnabled(false);
                    lblPNombre.setText((String)Tabla1.getValueAt(fila, 1));
                    lblPape.setText((String)Tabla1.getValueAt(fila, 2));
                    Lbldireccion.setText((String)Tabla1.getValueAt(fila, 3));
                    String p =(((String) Tabla1.getValueAt(fila,4)));
                    LblMonto.setText((p));
                    Monto = (p);
                    //Monto=Float.toStr();
                    
          }


       
           
    }//GEN-LAST:event_Tabla1MouseClicked

    private void SeleccionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionComboActionPerformed

          if((ComboPago.getSelectedIndex() == 1))
          {    
                    PanelTarjet.setVisible(true);
                    PanelCheque.setVisible(false);
          }
          if((ComboPago.getSelectedIndex() == 0))
          {    
                    PanelTarjet.setVisible(false);
                    PanelCheque.setVisible(true);
          }
          if((ComboPago.getSelectedIndex() == 2))
          {    
                    PanelTarjet.setVisible(true);
                    PanelCheque.setVisible(true);
          }
    }//GEN-LAST:event_SeleccionComboActionPerformed

    private void TXTMontoConTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTMontoConTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTMontoConTarjetaActionPerformed

    private void BTNPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPagarActionPerformed
          boolean error = false;
          if((ComboPago.getSelectedIndex() == 1))
          {    
                    float PrecioTotal = Float.parseFloat(LblMonto.getText());
                    float MontoTarjeta = Float.parseFloat(TXTMontoConTarjeta.getText());
                    //validacion 1
                    float p1 = PrecioTotal +5;
                    float p2 = PrecioTotal -5;
                    //JOptionPane.showMessageDialog(null,PrecioTotal);
                    if (((p1) > MontoTarjeta) && ((p2) < MontoTarjeta)){
                              error = false;
                              JOptionPane.showMessageDialog(LabelCombo1,"Correcto");
                    }
                    else{
                                error = true;
                              JOptionPane.showMessageDialog(LabelCombo1,"Error, Los montos No Coinciden.");
                    }
                    if (!error){
                               String Descripcion = txtDescrip.getText();
                               String NumeroTarjeta = TXTNumeroDeTarjeta.getText();
                               String TipoTarjeta;
                               if(ComboTipo.getSelectedIndex() == 0){
                                        TipoTarjeta = "CREDITO";
                               }else
                                        TipoTarjeta = "DEBITO";
                              try {
                                        VentanaMenuPagoControlador.InsertarTarjetaSQL(Descripcion, Float.toString(MontoTarjeta), NumeroTarjeta, TipoTarjeta);
                                        VentanaMenuPagoControlador.CalcularClaveTarjeta();
                              } catch (SQLException ex) {
                                        Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
          }
          if((ComboPago.getSelectedIndex() == 0))
          {    
                    float PrecioTotal = Float.parseFloat(LblMonto.getText());
                    float MontoTarjeta = Float.parseFloat(TXTMontoCheque.getText());
                    //validacion 1
                    float p1 = PrecioTotal +5;
                    float p2 = PrecioTotal -5;
                    //JOptionPane.showMessageDialog(null,PrecioTotal);
                    if (((p1) > MontoTarjeta) && ((p2) < MontoTarjeta)){
                              error = false;
                              JOptionPane.showMessageDialog(LabelCombo1,"Correcto");
                    }
                    else{
                              error = true;
                              JOptionPane.showMessageDialog(LabelCombo1,"Error, Los montos No Coinciden.");
                    }
                    if (!error){
                               String Descripcion = txtDescrip.getText();
                               String NumeroCheque = TxtNumerocheque.getText();
                               String EndosoCheque;
                               if(ComboEndoso.getSelectedIndex() == 0){
                                        EndosoCheque = "ENDOSABLE";
                               }else
                                        EndosoCheque = "NO_ENDOSABLE";
                              try {
                                        VentanaMenuPagoControlador.InsertarChequeSQL(Descripcion, Float.toString(MontoTarjeta), EndosoCheque, NumeroCheque);
                                        VentanaMenuPagoControlador.CalcularClaveCheque();
                              } catch (SQLException ex) {
                                        Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
          }
          if((ComboPago.getSelectedIndex() == 2))
          {    
                    float PrecioTotal = Float.parseFloat(LblMonto.getText());
                    float MontoCheque = Float.parseFloat(TXTMontoCheque.getText());
                    //validacion 1
                    float p1 = PrecioTotal +5;
                    float p2 = PrecioTotal -5;
                    //JOptionPane.showMessageDialog(null,PrecioTotal);
                    
                    float MontoTarjeta = Float.parseFloat(TXTMontoConTarjeta.getText());
                    //validacion 1
                    
                    
                    if (((p1) >( MontoCheque +MontoTarjeta)) && ((p2) <(MontoCheque + MontoTarjeta))){
                              error = false;
                              JOptionPane.showMessageDialog(LabelCombo1,"Correcto");
                    }
                    else{
                              error = true;
                              JOptionPane.showMessageDialog(LabelCombo1,"Error, La suma de los sub pagos, debe ser igual al monto Total.");
                    }
                    if (!error){
                               String Descripcion = txtDescrip.getText();
                               String NumeroCheque = TxtNumerocheque.getText();
                               String EndosoCheque;
                               if(ComboEndoso.getSelectedIndex() == 0){
                                        EndosoCheque = "ENDOSABLE";
                               }else
                                        EndosoCheque = "NO_ENDOSABLE";
                              String NumeroTarjeta = TXTNumeroDeTarjeta.getText();
                              String TipoTarjeta;
                              if(ComboTipo.getSelectedIndex() == 0){
                                        TipoTarjeta = "CREDITO";
                              }else
                                        TipoTarjeta = "DEBITO";

                               
                               
                               try {
                                        VentanaMenuPagoControlador.InsertarChequeSQL(Descripcion, Float.toString(MontoCheque), EndosoCheque, NumeroCheque);
                                        VentanaMenuPagoControlador.CalcularClaveCheque();

                                        VentanaMenuPagoControlador.InsertarTarjetaSQL(Descripcion, Float.toString(MontoTarjeta), NumeroTarjeta, TipoTarjeta);
                                        VentanaMenuPagoControlador.CalcularClaveTarjeta();

                               } catch (SQLException ex) {
                                        Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
                    
          }
          if (!error){
                    if(Opcion == 0){
                              String FechaInicio = df.format(Fecha.getDate());
                              String FechaString = ConvierteFechas(FechaInicio);
                              String Description = txtDescrip.getText();
                              String Monto = LblMonto.getText();
                              JOptionPane.showMessageDialog(LabelCombo1,"ClaveTarjeta"+ClaveTarjeta);
                              JOptionPane.showMessageDialog(LabelCombo1,"ClaveCheque"+ClaveCheque);
                              try {
                                        VentanaMenuPagoControlador.CalcularClaveContFondo();
                                        VentanaMenuPagoControlador.InsertarPAGOSQL(Monto, FechaString,ClaveContFond, ClavePropietarioSeleccionado,  ClaveCheque,ClaveTarjeta,Description);
                                        ActualizarFondos(Float.parseFloat(Monto));
                                        JOptionPane.showMessageDialog(LabelCombo1,"Aviso Pagado Correctamente");
                                        VentanaMenuPagos nuevo = new VentanaMenuPagos();
                                        nuevo.setVisible(true);
                                        this.dispose();
                              } catch (SQLException ex) {
                                        Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                              }
                    }
                    if(Opcion == 1){
                              String FechaInicio = df.format(Fecha.getDate());
                              String FechaString = ConvierteFechas(FechaInicio);
                              String Description = txtDescrip.getText();
                              String Monto = LblMonto.getText();
                              JOptionPane.showMessageDialog(LabelCombo1,"ClaveTarjeta"+ClaveTarjeta);
                              JOptionPane.showMessageDialog(LabelCombo1,"ClaveCheque"+ClaveCheque);
                              try {
                                        VentanaMenuPagoControlador.CalcularClaveContFondo();
                                        VentanaMenuPagoControlador.InsertarPAGOS2QL(Monto, FechaString,ClaveContFond, ClaveOficina,  ClaveCheque,ClaveTarjeta,Description);
                                        ActualizarFondos2(Float.parseFloat(Monto));
                                        ActualizarFondos3();
                                        JOptionPane.showMessageDialog(LabelCombo1,"Trabajo Pagado Correctamente");
                                        VentanaMenuPagos nuevo = new VentanaMenuPagos();
                                        nuevo.setVisible(true);
                                        this.dispose();
                              } catch (SQLException ex) {
                                        Logger.getLogger(VentanaMenuPagos.class.getName()).log(Level.SEVERE, null, ex);
                              }
                    }
          }
    }//GEN-LAST:event_BTNPagarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VentanaMenuPrincipal nueva;
        try {
            nueva = new VentanaMenuPrincipal();
            nueva.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error, Debe Ingresar Desde el LogIn");
            VentanaLogIn nuevas = new VentanaLogIn();
            nuevas.setVisible(true);
            dispose();
            
        }
        
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(VentanaMenuPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMenuPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNPagar;
    private javax.swing.JComboBox ComboEndoso;
    private javax.swing.JComboBox ComboOpcion;
    private javax.swing.JComboBox ComboPago;
    private javax.swing.JComboBox ComboTipo;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JLabel LabelApe;
    private javax.swing.JLabel LabelCombo1;
    private javax.swing.JLabel LabelCombo2;
    private javax.swing.JLabel LabelCombo3;
    private javax.swing.JLabel LabelCombo4;
    private javax.swing.JLabel LabelMonto;
    private javax.swing.JLabel LabelMontoCheque;
    private javax.swing.JLabel LabelMontoTarjeta;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LblClaveApt;
    private javax.swing.JLabel LblMonto;
    private javax.swing.JLabel Lbldireccion;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel PanelCheque;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelPago;
    private javax.swing.JPanel PanelTarjet;
    private javax.swing.JButton SeleccionCombo;
    private javax.swing.JTextField TXTMontoCheque;
    private javax.swing.JTextField TXTMontoConTarjeta;
    private javax.swing.JTextField TXTNumeroDeTarjeta;
    private javax.swing.JTable Tabla1;
    private javax.swing.JTextField TxtNumerocheque;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPNombre;
    private javax.swing.JLabel lblPape;
    private javax.swing.JLabel lblprov;
    private javax.swing.JLabel lbltrabajo;
    private javax.swing.JTextField txtDescrip;
    // End of variables declaration//GEN-END:variables
}
