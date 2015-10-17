package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteEstimacion;
import Control.validacionDatos;
import Estimacion.Inicio;
import Estimacion.Tabla1;
import Modelo.Proyecto;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Modelo.MiModelo;
import java.awt.Image;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author tavo
 */
public class GUIAgregarProyecto extends java.awt.Dialog {

    //inicializan los objetos necesarios 
    static Proyecto nuevoProyecto = new Proyecto();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    java.util.ArrayList categoria = null;
    java.util.ArrayList cliente = null;
    IDateEditor focusFecha;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    Image logo = null;
    String llave = "";
    Date FecInic;
    String ffr;
    Double vrfinal;
    public static JTextField jtexto = new JTextField();
    public static JTextField jtexto2 = new JTextField();
    public static JTextField titulos = new JTextField();
    public static JTextField numdess = new JTextField();
    public static JLabel jlabel15 = new JLabel();
    public static JLabel jlabel14 = new JLabel();
    public static JLabel jlabel13 = new JLabel();
    public static String codigo1;
    //Clase constructor para instanciar e iniciar un objeto de este tip

    public GUIAgregarProyecto(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        jtexto = (JTextField) textCosEst;
        jtexto2 = (JTextField) textCosFin;
        titulos = (JTextField) textTitulo;
        numdess = (JTextField) textNumEstDes;
        jlabel15 = (JLabel) pf1;
        jlabel14 = (JLabel) pf;
        jlabel13 = (JLabel) pf2;

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        categoria = new ArrayList();
        cliente = new ArrayList();

//        textCosEst.setText(1700000.0 + ""); // PA PROBAR

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(categoria, comboCateg, "categoria_proyecto", "descripcion", "codigo_cat");
        funcionesComunes.cargarLista(cliente, comboCliente, "cliente", "nombre", "codigo_cliente");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Desabilitar el TextField de los JdateChooser
        ((JTextFieldDateEditor) dateFI.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFF.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFFR.getDateEditor()).setEditable(false);
        dateFFR.getCalendarButton().setEnabled(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nuevo Proyecto");

    }

    public GUIAgregarProyecto(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        categoria = new ArrayList();
        cliente = new ArrayList();
        agregar = false;
        jtexto2 = (JTextField) textCosFin;

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(categoria, comboCateg, "categoria_proyecto", "descripcion", "codigo_cat");
        funcionesComunes.cargarLista(cliente, comboCliente, "cliente", "nombre", "codigo_cliente");

        this.setLocationRelativeTo(null);
        this.setResizable(false);


        try {
            ejecucionBD.sql = "select count(entrega.codigo_entrega) as \"Terminado\" from entrega, proyecto"
                    + " where entrega.proyecto = proyecto.codigo_proy and "
                    + "entrega.proyecto = " + registros[0] + " and entrega.estado = 'Terminado'";

            ejecucionBD.ejecutarConsulta();

            int entTerminadas = ejecucionBD.result.getInt(1);

            if (Integer.parseInt(registros[3]) == entTerminadas) {
                comboEstado.addItem("Terminado");
            }
        } catch (Exception e) {
            System.out.println("Error Estado Terminado en los proy a modificar");
        }


        // Desabilitar el TextField de los JdateChooser
        ((JTextFieldDateEditor) dateFI.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFF.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFFR.getDateEditor()).setEditable(false);
        dateFFR.getCalendarButton().setEnabled(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Proyecto");

        llave = registros[0];
        textNumDes.setText(registros[1]);
        textNumEstDes.setText(registros[2]);
        textNumEnt.setText(registros[3]);
        textTitulo.setText(registros[4]);
        comboCateg.setSelectedIndex(Integer.parseInt(registros[5]));

        try {
            ejecucionBD.sql = "select nombre from cliente where codigo_cliente = " + registros[6];
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboCliente.setSelectedItem(ejecucionBD.result.getString("nombre"));
            } else {
                System.out.println("nada en cliente");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

        try {
            if (registros[7] == null) {
                dateFI.setDate(null);
            } else {
                dateFI.setDate(formatoFecha.parse(registros[7]));
                FecInic = formatoFecha.parse(registros[7]);
            }

            if (registros[8] == null) {
                dateFF.setDate(null);
            } else {
                dateFF.setDate(formatoFecha.parse(registros[8]));
            }

            if (registros[9] == null) {
                dateFFR.setDate(null);
            } else {
                dateFFR.setDate(formatoFecha.parse(registros[9]));
                ffr = registros[9];
            }

            textCosEst.setText(registros[10]);
            textCosFin.setText(registros[11]);
            vrfinal = Double.parseDouble(registros[11]);
            comboEstado.setSelectedItem(registros[12]);

            String pfs[] = registros[13].split("-");
            pf1.setText(pfs[0]);
            pf.setText(pfs[1]);
            pf2.setText(pfs[2]);

            //Si el estado es Terminado Todo se desabilita menos estado
            if (registros[12].equals("Terminado")) {
                textTitulo.disable();
                comboCateg.disable();
                comboCliente.disable();
                textNumEnt.disable();
                textNumDes.disable();
                textCosFin.disable();
                dateFI.getCalendarButton().setEnabled(false);
                dateFF.getCalendarButton().setEnabled(false);
            }

            ejecucionBD.sql = "select codigo_entrega from entrega where proyecto = " + llave;
            ejecucionBD.ejecutarConsulta();

            if (ejecucionBD.cantidadRegistros() > 0) {
                textNumEnt.setEditable(false);
                textCosFin.setEditable(false);
                jButton1.setEnabled(false);
                dateFI.getCalendarButton().setEnabled(false);
                dateFF.getCalendarButton().setEnabled(false);
            }

        } catch (Exception e) {
            System.out.println("Error en fechas");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textNumEnt = new javax.swing.JTextField();
        textTitulo = new javax.swing.JTextField();
        textCosEst = new javax.swing.JTextField();
        textCosFin = new javax.swing.JTextField();
        textNumDes = new javax.swing.JTextField();
        comboCateg = new javax.swing.JComboBox();
        comboCliente = new javax.swing.JComboBox();
        dateFI = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dateFF = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        dateFFR = new com.toedter.calendar.JDateChooser();
        comboEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        textNumEstDes = new javax.swing.JTextField();
        pf2 = new javax.swing.JLabel();
        pf = new javax.swing.JLabel();
        pf1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btonAcep = new javax.swing.JButton();
        btonCan = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTitulo.setText("PROYECTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Num. Entregas");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Titulo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Costo Estimado");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Costo Final");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Num. Desarrolladores");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Estado");

        textNumEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumEntActionPerformed(evt);
            }
        });

        textCosEst.setEditable(false);
        textCosEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCosEstActionPerformed(evt);
            }
        });

        textNumDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumDesActionPerformed(evt);
            }
        });

        comboCateg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategActionPerformed(evt);
            }
        });

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha Inicio");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fecha Fin");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Fecha Fin Real");
        jLabel11.setToolTipText("");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Desarrollo" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        jButton1.setText("Estimar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Num. Des. Estimado");

        textNumEstDes.setText(" ");
        textNumEstDes.setEnabled(false);

        pf2.setText("pf2");

        pf.setText("pf");

        pf1.setText("pf1");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Rangos de la Estimacion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(44, 44, 44)
                                .addComponent(textCosEst, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(69, 69, 69)
                                    .addComponent(textCosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(pf1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pf, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pf2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10)
                                .addComponent(textNumDes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(111, 111, 111)
                                .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNumEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(108, 108, 108)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dateFI, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(textNumEstDes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(dateFFR, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(61, 61, 61))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNumEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(textNumEstDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNumDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(textCosEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1)
                    .addComponent(dateFFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCosFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pf1)
                            .addComponent(pf)
                            .addComponent(pf2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btonAcep.setText("Aceptar");
        btonAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonAcepActionPerformed(evt);
            }
        });

        btonCan.setText("Cancelar");
        btonCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btonAcep)
                .addGap(83, 83, 83)
                .addComponent(btonCan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btonCan)
                    .addComponent(btonAcep))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void textNumEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumEntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumEntActionPerformed

    private void btonCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCanActionPerformed

        this.setVisible(false);

    }//GEN-LAST:event_btonCanActionPerformed

    private void btonAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonAcepActionPerformed

        nuevoProyecto.setCodigo("cod_proy.NextVal");
        // valida los datos que se ingresaron en el formulario y se setean en el obj de tipo proyecto

        //se valida un campo vacio true si lo esta false si no.

        String titulo = textTitulo.getText().trim();
        if (validacionDatos.caracteres(titulo) && validacionDatos.validarCantidad(titulo) == 1) {
            nuevoProyecto.setTitulo(titulo);
        } else {
            textTitulo.requestFocus();
            if (titulo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Titulo Obligatorio");
            } else {
                if (!validacionDatos.caracteres(titulo)) {
                    JOptionPane.showMessageDialog(null, "Campo Titulo Invalido");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Titulo Demasiado corto");
                }
            }
            return;
        }

        /*se obtiene la descripcion seleccionada en el combobox y se valida si esta vacia o no la seleccion
         si no lo esta se setea la categoria al obj proy con el valor segun el index escojido en el combobox*/

        String categoria = comboCateg.getSelectedItem().toString();
        if (validacionDatos.campoVacio(categoria)) {
            comboCateg.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Categoria Obligatorio");
            return;
        } else {
            nuevoProyecto.setCategoria(Integer.parseInt(this.categoria.get((comboCateg.getSelectedIndex() - 1)).toString()));
        }

        String cliente = comboCliente.getSelectedItem().toString();
        if (validacionDatos.campoVacio(cliente)) {
            comboCliente.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Cliente Obligatorio");
            return;
        } else {
            nuevoProyecto.setCliente((this.cliente.get((comboCliente.getSelectedIndex() - 1)).toString()));
        }

        String numEntregas = null;
        try {
            numEntregas = textNumEnt.getText().trim();
            if (validacionDatos.validarCantidad(numEntregas, 0)) {
                nuevoProyecto.setNum_entregas(Integer.parseInt(numEntregas));
            } else {
                textNumEnt.requestFocus();
                if (numEntregas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Num. Entregas Obligatorio");
                } else {
                    if (validacionDatos.vrEntero(numEntregas)) {
                        JOptionPane.showMessageDialog(null, "Campo Num. Entregas Ilogico o Exagerado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Num. Entregas Invalido");
                    }
                }
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo num ent");
            return;
        }

        try {
            nuevoProyecto.setEst_cantidad_pers(Integer.parseInt(textNumEstDes.getText().trim()));
        } catch (Exception e) {
            nuevoProyecto.setCant_Desarrolladores(0);
        }

        //CAMBIO dentro se valida la disponibilidad de el num de Des q se ingresan
        if (!agregar) {
            ejecucionBD.sql = "select personal from rolxent_per\n"
                    + " where rolxent_per.entrega in (Select entrega.codigo_entrega from\n"
                    + " entrega where entrega.proyecto = " + llave + ") group by personal";

            ejecucionBD.ejecutarConsulta();
        }

        String numDesarrolladores = null;
        try {

            numDesarrolladores = textNumDes.getText().trim();
            if (validacionDatos.validarCantidad(numDesarrolladores, 1)) {

                if (!agregar) {
                    ejecucionBD.sql = "select personal from rolxent_per\n"
                            + " where rolxent_per.entrega in (Select entrega.codigo_entrega from\n"
                            + " entrega where entrega.proyecto = " + llave + ") group by personal";

                    ejecucionBD.ejecutarConsulta();

                    if (Integer.parseInt(numDesarrolladores) < ejecucionBD.cantidadRegistros()) {
                        textNumDes.requestFocus();
                        JOptionPane.showMessageDialog(null, "Num. Desarrolladores ya Registrados " + ejecucionBD.cantidadRegistros());
                        return;
                    }
                }

                ejecucionBD.sql = "select count(cedula) as \"Cantidad\" from personal,cuenta where not codigo_personal = 1 "
                        + "and personal.codigo_personal = cuenta.personal"; // *
                if (ejecucionBD.ejecutarConsulta()) {
                    if (Integer.parseInt(numDesarrolladores) > ejecucionBD.result.getInt(1)) {
                        textNumDes.requestFocus();
                        JOptionPane.showMessageDialog(null, "Num. Personal Desarrollador con Cuenta Inexistente en el Sistema");
                        return;
                    } else {
                        nuevoProyecto.setCant_Desarrolladores(Integer.parseInt(numDesarrolladores));
                    }
                } // *

            } else {
                textNumDes.requestFocus();
                if (numDesarrolladores.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Num. Desarrolladores Obligatorio");
                } else {
                    if (validacionDatos.vrEntero(numDesarrolladores)) {
                        JOptionPane.showMessageDialog(null, "Campo Num. Desarrolladores Ilogico");
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Num. Desarrolladores Invalido");
                    }
                }
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo num ent");
            return;
        }


        try {

            if (textCosEst.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "El Campo De Estimacion Obligatorio , Click en boton 'Estimar' ");
                textCosEst.requestFocus();
                return;
            } else {
                nuevoProyecto.setCosto_estimado(Double.parseDouble(textCosEst.getText()));
                nuevoProyecto.setRangopf(pf1.getText() + "-" + pf.getText() + "-" + pf2.getText());
            }

        } catch (Exception e) {
            System.out.println("Error en estimacion " + e.getMessage());

        }

        nuevoProyecto.setEst_cantidad_pers(Double.parseDouble(textNumEstDes.getText()));

        try {
            Double costo_final = Double.parseDouble(textCosFin.getText().trim());
            if (costo_final < Double.parseDouble(pf1.getText())) {
                JOptionPane.showMessageDialog(null, "Campo Costo Final Muy Bajo");
                textCosFin.requestFocus();
                return;
            } else {
                nuevoProyecto.setCosto_final(costo_final);
            }

        } catch (Exception e) {
            textCosFin.requestFocus();
            if (textCosFin.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Campo Costo Final Obligatorio");
            } else {
                JOptionPane.showMessageDialog(null, "Campo Costo Final Invalido");
            }
            return;
        }

        //se valida que el obj de tipo String que se obtiene de el campo no contenga numeros
        String Estado = comboEstado.getSelectedItem().toString();
        nuevoProyecto.setEstado(Estado);



        try {
            //se obtiene el obj IDateEditor de los jdatechooser para luego poder enfocar el campo de la fecha
            focusFecha = (IDateEditor) dateFI.getDateEditor();

            String fechaI = formatoFecha.format(dateFI.getDate());
            String fechaH = formatoFecha.format(new Date());

            if (!agregar) {
                fechaH = formatoFecha.format(FecInic);
            }

            if (fechaI.equals(fechaH) || !(dateFI.getDate().before(formatoFecha.parse(fechaH)))) {
                nuevoProyecto.setFecha_inicio(fechaI);
            } else {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Inicio Caducada con respecto a la fecha de ingreso o mod");
                return;
            }

        } catch (Exception e) {
            focusFecha.getUiComponent().requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Fecha Inicio Obligatorio");
            dateFI.setDate(null);
            return;
        }

        try {
            focusFecha = (IDateEditor) dateFF.getDateEditor();
            String fechaF = formatoFecha.format(dateFF.getDate());
            Date FF = dateFF.getDate();
            Date FI = dateFI.getDate();

            if (FF.before(FI) || formatoFecha.parse(formatoFecha.format(FF)).getTime() == formatoFecha.parse(formatoFecha.format(FI)).getTime()) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Fin menor o igual a Fecha Inicio");
                return;
            } else {
                nuevoProyecto.setFecha_fin(fechaF);
            }

        } catch (Exception e) {
            focusFecha.getUiComponent().requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Fecha Fin Obligatorio");
            dateFF.setDate(null);
            return;
        }

        String fechaFFR;
        try {
            focusFecha = (IDateEditor) dateFFR.getDateEditor();
            fechaFFR = formatoFecha.format(dateFFR.getDate());
            if (dateFFR.getDate().before(dateFI.getDate()) || formatoFecha.parse(formatoFecha.format(dateFFR.getDate())).getTime() == formatoFecha.parse(formatoFecha.format(dateFI.getDate())).getTime()) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Fin Real menor o igual a Fecha Inicio");
                comboEstado.setSelectedIndex(0);
                dateFFR.setDate(null);
                return;
            } else {
                nuevoProyecto.setFecha_finreal(fechaFFR);
            }

        } catch (Exception e) {
            fechaFFR = "";
            nuevoProyecto.setFecha_finreal(fechaFFR);
        }

        if (agregar) {

            if (ejecucionBD.ejecutarInsert(nuevoProyecto, "Proyecto")) {
                this.setVisible(false);


                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);

                ejecucionBD.sql = "select codigo_proy as \"PROYECTO\", titulo as \"TITULO\", CLIENTE.nombre as \"CLIENTE\","
                        + "cant_personas as \"NUM. DESARROLLADORES\", num_entregas as \"NUM. ENTREGAS\",\n"
                        + "TO_CHAR (fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (fecha_fin,'dd/MM/yyyy') "
                        + "as \"FIN\", valor_final as \"VALOR FINAL\" from proyecto, cliente where "
                        + "proyecto.cliente = cliente.codigo_cliente order by proyecto.codigo_proy";


                funcionesComunes.cargarTabla(modeloTabla);

                try {
                    Double costo_final = Double.parseDouble(textCosFin.getText().trim());
                    Double costo_estimado = Double.parseDouble(textCosEst.getText().trim());
                    ejecucionBD.sql = "select cod_proy.currval from dual";
                    ejecucionBD.ejecutarConsulta();
                    codigo1 = ejecucionBD.result.getString(1);
                    if (costo_final > Double.parseDouble(pf2.getText())) {
                        GUIAgregarObservaciones a = new GUIAgregarObservaciones(null, true, codigo1);
                        a.setVisible(true);
                    }
                } catch (Exception e) {
                    System.out.println("Error" + e.getMessage());
                }

                reporteEstimacion reporteEstimacion = new reporteEstimacion("Proyectos Best Mind Software ", "ReporteEstimacion-" + nuevoProyecto.getTitulo() + "-" + codigo1 + ".pdf");
                int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {
                    reporteEstimacion.abrirPDF();
                }
            }

        } else {

            if (ejecucionBD.ejecutarUpdate(nuevoProyecto, "Proyecto", llave)) {
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select codigo_proy as \"PROYECTO\", titulo as \"TITULO\", CLIENTE.nombre as \"CLIENTE\","
                        + "cant_personas as \"NUM. DESARROLLADORES\", num_entregas as \"NUM. ENTREGAS\",\n"
                        + "TO_CHAR (fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (fecha_fin,'dd/MM/yyyy') "
                        + "as \"FIN\", valor_final as \"VALOR FINAL\" from proyecto, cliente where "
                        + "proyecto.cliente = cliente.codigo_cliente order by proyecto.codigo_proy";

                funcionesComunes.cargarTabla(modeloTabla);

                try {
                    Double costo_final = Double.parseDouble(textCosFin.getText().trim());
//                    Double.parseDouble (new DecimalFormat("###.###").format(costo_final.doubleValue()));

                    ejecucionBD.ejecutarUpdateEstObs(costo_final + "", llave);


                    if (vrfinal != Double.parseDouble(new DecimalFormat("###.###").format(costo_final.doubleValue()))) {
                        if (Double.parseDouble(new DecimalFormat("###.###").format(costo_final.doubleValue())) > Double.parseDouble(pf2.getText())) {

                            ejecucionBD.sql = "select * from observacion where codigo_proy = '" + llave + "'";

                            ejecucionBD.ejecutarConsulta();
                            if (ejecucionBD.cantidadRegistros() > 0) {
                                GUIAgregarObservaciones a = new GUIAgregarObservaciones(null, true, null, null, ejecucionBD.obtenerObjeto());
                                a.setVisible(true);
                            } else {
                                GUIAgregarObservaciones a = new GUIAgregarObservaciones(null, true, llave);
                                a.setVisible(true);
                            }
                        } else {
                            ejecucionBD.ejecutarDelete("observacion", llave, "codigo_proy");
                        }

                    } else {
                        System.out.println("Es igual");
                    }


                } catch (Exception e) {
                    System.out.println("Eroror" + e.getMessage());
                }

            }

        }

    }//GEN-LAST:event_btonAcepActionPerformed

    private void textCosEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCosEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCosEstActionPerformed

    private void textNumDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNumDesActionPerformed

    private void comboCategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (dateFI.toString().equals("")) {
            focusFecha = (IDateEditor) dateFI.getDateEditor();
            focusFecha.getUiComponent().requestFocus();

        } else {
            if (dateFF.toString().equals("")) {
                focusFecha = (IDateEditor) dateFF.getDateEditor();
                focusFecha.getUiComponent().requestFocus();
            } else {
                Inicio a = new Inicio(null, true);
                a.setVisible(true);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        try {
            if (comboEstado.getSelectedIndex() == 1) {

                // Si estaba vacio la FFR

                if (ffr == null) {
                    dateFFR.setDate(formatoFecha.parse(formatoFecha.format(new Date())));
                    nuevoProyecto.setFecha_finreal(formatoFecha.format(new Date()));
                } else {
                    dateFFR.setDate(formatoFecha.parse(ffr));
                    nuevoProyecto.setFecha_finreal(ffr);
                }

                textTitulo.setEnabled(false);
                comboCateg.setEnabled(false);
                comboCliente.setEnabled(false);
                textNumEnt.setEnabled(false);
                textNumDes.setEnabled(false);
                textCosFin.setEnabled(false);
                dateFI.getCalendarButton().setEnabled(false);
                dateFF.getCalendarButton().setEnabled(false);

            } else {
                textTitulo.setEnabled(true);
                comboCateg.setEnabled(true);
                comboCliente.setEnabled(true);
                textNumEnt.setEnabled(true);
                textNumDes.setEnabled(true);
                textCosFin.setEnabled(true);
                dateFI.getCalendarButton().setEnabled(true);
                dateFF.getCalendarButton().setEnabled(true);
                dateFFR.setDate(null);
                nuevoProyecto.setFecha_finreal(null);
            }
        } catch (Exception e) {
            System.out.println("Error en actionperformed de comboestado");
        }
    }//GEN-LAST:event_comboEstadoActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btonAcep;
    private javax.swing.JButton btonCan;
    private javax.swing.JComboBox comboCateg;
    private javax.swing.JComboBox comboCliente;
    private javax.swing.JComboBox comboEstado;
    private com.toedter.calendar.JDateChooser dateFF;
    private com.toedter.calendar.JDateChooser dateFFR;
    private com.toedter.calendar.JDateChooser dateFI;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel pf;
    private javax.swing.JLabel pf1;
    private javax.swing.JLabel pf2;
    private javax.swing.JTextField textCosEst;
    private javax.swing.JTextField textCosFin;
    private javax.swing.JTextField textNumDes;
    private javax.swing.JTextField textNumEnt;
    private javax.swing.JTextField textNumEstDes;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
