package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.MiModelo;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author tavo
 */
public class GUIAgregarActividad extends java.awt.Dialog {

    /**
     * Creates new form agregarAct
     */
    static Modelo.Actividad nuevaActividad = new Modelo.Actividad();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    java.util.ArrayList entregas = null;
    java.util.ArrayList responsables = null;
    java.util.ArrayList proyectos = null;
    IDateEditor focusFecha;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    String antResp = "";
    String antEnt = "";
    Image logo = null;
    String llave = null;
    String ffr;

    public GUIAgregarActividad(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        entregas = new ArrayList();
        responsables = new ArrayList();
        proyectos = new ArrayList();

//        se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(proyectos, comboProy, "proyecto ", "titulo", "codigo_proy");
//        funcionesComunes.cargarLista(entregas, comboEntrega, "entrega", "titulo", "codigo_entrega");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Deshabilitar el TextField de los JdateChooser
        ((JTextFieldDateEditor) dateFI.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFF.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFFR.getDateEditor()).setEditable(false);
        dateFFR.getCalendarButton().setEnabled(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nueva Actividad");

    }

    public GUIAgregarActividad(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        entregas = new ArrayList();
        responsables = new ArrayList();
        proyectos = new ArrayList();
        agregar = false;

//        se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(proyectos, comboProy, "proyecto ", "titulo", "codigo_proy");
//   aqui!     funcionesComunes.cargarLista(entregas, comboEntrega, "entrega", "titulo", "codigo_entrega");


        this.setLocationRelativeTo(null);
        this.setResizable(false);
        comboEstado.addItem("Terminado");

        // Deshabilitar el TextField de los JdateChooser
        ((JTextFieldDateEditor) dateFI.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFF.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFFR.getDateEditor()).setEditable(false);
        dateFFR.getCalendarButton().setEnabled(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Actividad");


        ejecucionBD.sql = "select proyecto.titulo from proyecto where "
                + "proyecto.codigo_proy = (select entrega.proyecto from entrega where "
                + "entrega.codigo_entrega = " + registros[9] + ")";
        ejecucionBD.ejecutarConsulta();

        try {
            comboProy.setSelectedItem(ejecucionBD.result.getString(1));
        } catch (Exception e) {
            System.out.println("Error en el constructor de modificar GUIAgrRegEnt");
        }

        llave = registros[0];

        textTitulo.setText(registros[1]);
        comboEntrega.setSelectedItem(registros[2]);

        comboEstado.setSelectedItem(registros[6]);

        antEnt = registros[9];
        antResp = registros[8];


        try {
            ejecucionBD.sql = "select nombre from personal where personal.codigo_personal = " + antResp;

            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboRespo.setSelectedItem(ejecucionBD.result.getString("nombre"));
            } else {
                System.out.println("personal vacio");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

        try {
            if (registros[3] == null) {
                dateFI.setDate(null);
            } else {
                dateFI.setDate(formatoFecha.parse(registros[3]));
            }

            if (registros[4] == null) {
                dateFF.setDate(null);
            } else {
                dateFF.setDate(formatoFecha.parse(registros[4]));
            }

            if (registros[5] == null) {
                dateFFR.setDate(null);
            } else {
                dateFFR.setDate(formatoFecha.parse(registros[5]));
                ffr = registros[5];
            }

        } catch (Exception e) {
            System.out.println("Error en fechas");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dateFI = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateFF = new com.toedter.calendar.JDateChooser();
        dateFFR = new com.toedter.calendar.JDateChooser();
        comboEntrega = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        comboResp = new javax.swing.JLabel();
        comboRespo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboProy = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btoAcep = new javax.swing.JButton();
        btoCanc = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ACTIVIDAD");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Entrega");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha Inicio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha Fin");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Fecha Real");

        comboEntrega.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntregaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Titulo");

        comboResp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboResp.setText("Responsable");

        comboRespo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboRespo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRespoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Estado");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Desarrollo" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Proyecto");

        comboProy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboResp)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboRespo, 0, 126, Short.MAX_VALUE)
                            .addComponent(comboProy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboEntrega, 0, 126, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateFF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateFFR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFI, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(comboProy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(dateFI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(comboEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(comboRespo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboResp))
                    .addComponent(dateFFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btoAcep.setText("Aceptar");
        btoAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAcepActionPerformed(evt);
            }
        });

        btoCanc.setText("Cancelar");
        btoCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoCancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btoAcep)
                .addGap(26, 26, 26)
                .addComponent(btoCanc)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAcep)
                    .addComponent(btoCanc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btoAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAcepActionPerformed

        nuevaActividad.setCodigo_actividad("cod_act.NextVal");

        String titulo = textTitulo.getText().trim();
        if (validacionDatos.caracteres(titulo) && validacionDatos.validarCantidad(titulo) == 1) {
            nuevaActividad.setTitulo(titulo);
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

        String proyecto = comboProy.getSelectedItem().toString();
        if (validacionDatos.campoVacio(proyecto)) {
            comboProy.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Proyecto Vacio");
            return;
        }

        String entrega = comboEntrega.getSelectedItem().toString();
        if (validacionDatos.campoVacio(entrega)) {
            comboEntrega.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Entrega Obligatorio");
            return;
        } else {
            nuevaActividad.setEntrega((this.entregas.get((comboEntrega.getSelectedIndex() - 1)).toString()));
        }

        String responsable = comboRespo.getSelectedItem().toString();
        if (validacionDatos.campoVacio(responsable)) {
            comboRespo.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Responsable Obligatorio");
            return;
        } else {
            nuevaActividad.setResponsable(this.responsables.get((comboRespo.getSelectedIndex() - 1)).toString());
        }

        String Estado = comboEstado.getSelectedItem().toString();
        if (validacionDatos.campoVacio(Estado.toString())) {
            comboEstado.requestFocus();
            return;
        } else {
            nuevaActividad.setEstado(Estado);
        }

//        try {
//            //se obtiene el obj IDateEditor de los jdatechooser para luego poder enfocar el campo de la fecha
//            focusFecha = (IDateEditor) dateFI.getDateEditor();
//
//            String fechaI = formatoFecha.format(dateFI.getDate());
//
//            if (formatoFecha.format(new Date()).equals(fechaI)) {
//                nuevaActividad.setFecha_ini(fechaI);
//            } else {
//                if (dateFI.getDate().before(new Date())) {
//                    focusFecha.getUiComponent().requestFocus();
//                    labelMsj.setText("Campo Fecha Inicio ya paso");
//                    return;
//                } else {
//                    nuevaActividad.setFecha_ini(fechaI);
//                }
//            }
//
//        } catch (Exception e) {
//            focusFecha.getUiComponent().requestFocus();
//            labelMsj.setText("Campo Fecha Inicio Obligatorio");
//            dateFI.setDate(null);
//            return;
//        }
//Validacion fechas coscu      

        try {
            //se obtiene el obj IDateEditor de los jdatechooser para luego poder enfocar el campo de la fecha
            focusFecha = (IDateEditor) dateFI.getDateEditor();

            String codigo = this.entregas.get((comboEntrega.getSelectedIndex() - 1)).toString();
            String fechaI = formatoFecha.format(dateFI.getDate());
            Date fechinin = formatoFecha.parse(fechaI);
            ejecucionBD.sql = "select TO_CHAR(fecha_inicio,'dd/MM/yyyy') as \"fechaI\" from entrega where codigo_entrega = '" + codigo + "'";
            ejecucionBD.ejecutarConsulta();
            Date fechaIII = formatoFecha.parse(ejecucionBD.result.getString("fechaI"));


            if (fechinin.before(fechaIII)) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Fecha Inicio de la entrega es " + formatoFecha.format(fechaIII));
                return;
            } else {
                nuevaActividad.setFecha_ini(fechaI);
            }

        } catch (Exception e) {
            focusFecha.getUiComponent().requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Fecha Inicio Obligatorio");
            dateFI.setDate(null);
            return;
        }

        //Validacion fechas coscu 

        try {
            focusFecha = (IDateEditor) dateFF.getDateEditor();
            String codigo = this.entregas.get((comboEntrega.getSelectedIndex() - 1)).toString();
            String fechaIF = formatoFecha.format(dateFF.getDate());
            Date fechfinn = formatoFecha.parse(fechaIF);
            ejecucionBD.sql = "select TO_CHAR(fecha_inicio,'dd/MM/yyyy') as \"fechaI\", TO_CHAR(fecha_fin,'dd/MM/yyyy') as \"fechaF\"  from entrega where codigo_entrega = '" + codigo + "'";
            ejecucionBD.ejecutarConsulta();

            Date fechaFFF = formatoFecha.parse(ejecucionBD.result.getString("fechaF"));
            if (dateFF.getDate().before(dateFI.getDate()) || dateFF.getDate().equals(dateFI.getDate())) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Fin menor o igual a Fecha Inicio");
                return;
            } else if (fechfinn.after(fechaFFF)) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Fecha Fin debe ser Menor o igual a la fecha Fin de la Entrega " + formatoFecha.format(fechaFFF));
                return;
            } else {
                nuevaActividad.setFecha_fin(fechaIF);
            }

        } catch (Exception e) {
            focusFecha.getUiComponent().requestFocus();
            dateFF.setDate(null);
            return;
        }

        String fechaFFR;
        try {
            focusFecha = (IDateEditor) dateFFR.getDateEditor();
            fechaFFR = formatoFecha.format(dateFFR.getDate());
            if (dateFFR.getDate().before(dateFI.getDate())) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Fin Real menor a Fecha Inicio");
                comboEstado.setSelectedIndex(0);
                dateFFR.setDate(null);
                return;
            } else {
                nuevaActividad.setFecha_fin_real(fechaFFR);
            }

        } catch (Exception e) {
            fechaFFR = "";
            nuevaActividad.setFecha_fin_real(fechaFFR);
        }


        if (agregar) {
            if (ejecucionBD.ejecutarInsert(nuevaActividad, "Actividad")) {
                ejecucionBD.ejecutarUpdateEstado_Rolx(nuevaActividad.getResponsable(), nuevaActividad.getEntrega(), true);
                this.setVisible(false);

                ejecucionBD.ejecutarUpdateEstEnt(nuevaActividad.getEntrega(), "En Desarrollo");
                ejecucionBD.sql = "select proyecto from entrega where codigo_entrega = " + nuevaActividad.getEntrega();
                ejecucionBD.ejecutarConsulta();
                try {
                    ejecucionBD.ejecutarUpdateEstProy(ejecucionBD.result.getString(1), "En Desarrollo");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);

                ejecucionBD.sql = "select actividad.codigo_actividad as \"ACTIVIDAD\", actividad.titulo, proyecto.titulo as \"PROYECTO\" "
                        + ",entrega.titulo as \"ENTREGA\", to_char(actividad.fecha_ini, 'dd/MM/yyyy') as \"INICIO\","
                        + "to_char (actividad.fecha_fin, 'dd/MM/yyyy') as \"FIN\", personal.nombre as \"RESPONSABLE\","
                        + " actividad.estado from personal, actividad, entrega, proyecto where personal.codigo_personal = actividad.responsable "
                        + "and actividad.entrega = entrega.codigo_entrega and entrega.proyecto = proyecto.codigo_proy order by actividad.codigo_actividad,proyecto.codigo_proy";

                funcionesComunes.cargarTabla(modeloTabla);
            }
        } else {

            if (ejecucionBD.ejecutarUpdate(nuevaActividad, "Actividad", llave)) { //Se modifica
                this.setVisible(false);

                if (nuevaActividad.getEstado().equals("En Desarrollo")) {
                    ejecucionBD.ejecutarUpdateEstEnt(nuevaActividad.getEntrega(), "En Desarrollo");
                    ejecucionBD.sql = "select proyecto from entrega where codigo_entrega = " + nuevaActividad.getEntrega();
                    ejecucionBD.ejecutarConsulta();
                    try {
                        ejecucionBD.ejecutarUpdateEstProy(ejecucionBD.result.getString(1), "En Desarrollo");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ejecucionBD.sql = "select * from actividad where entrega = '" + llave + "'";
                    ejecucionBD.ejecutarConsulta();
                    if (ejecucionBD.cantidadRegistros() > 0) {
                        ejecucionBD.sql = "select * from actividad where entrega = '" + llave + "' and estado = 'En Desarrollo';";
                        ejecucionBD.ejecutarConsulta();
                        if (ejecucionBD.cantidadRegistros() < 1) {
                            ejecucionBD.ejecutarUpdateEstEnt(llave, "Terminado");
                        }
                    }
                }

                ejecucionBD.sql = "select * from Actividad where responsable = " + antResp
                        + " and entrega = '" + antEnt + "'";

                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() == 0) {
                    ejecucionBD.ejecutarUpdateEstado_Rolx(antResp, antEnt, false);
                }

//                ejecucionBD.ejecutarUpdateEstado_Rolx(antResp, antEnt, false);
                ejecucionBD.ejecutarUpdateEstado_Rolx(nuevaActividad.getResponsable(), nuevaActividad.getEntrega(), true);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);

                ejecucionBD.sql = "select actividad.codigo_actividad as \"ACTIVIDAD\", actividad.titulo, proyecto.titulo as \"PROYECTO\" "
                        + ",entrega.titulo as \"ENTREGA\", to_char(actividad.fecha_ini, 'dd/MM/yyyy') as \"INICIO\","
                        + "to_char (actividad.fecha_fin, 'dd/MM/yyyy') as \"FIN\", personal.nombre as \"RESPONSABLE\","
                        + " actividad.estado from personal, actividad, entrega, proyecto where personal.codigo_personal = actividad.responsable "
                        + "and actividad.entrega = entrega.codigo_entrega and entrega.proyecto = proyecto.codigo_proy order by actividad.codigo_actividad,proyecto.codigo_proy";

                funcionesComunes.cargarTabla(modeloTabla);

            }
        }
    }//GEN-LAST:event_btoAcepActionPerformed

    private void btoCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoCancActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btoCancActionPerformed

    private void comboEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntregaActionPerformed

        comboRespo.removeAllItems();
        comboRespo.addItem(" ");

        try {
            ejecucionBD.sql = "select Personal.nombre, personal.codigo_personal from Personal, rolxent_per where rolxent_per.entrega = '" + entregas.get(comboEntrega.getSelectedIndex() - 1)
                    + "' and rolxent_per.personal = personal.codigo_personal";

            responsables.clear();
            funcionesComunes.cargarLista(responsables, comboRespo);
        } catch (Exception e) {
            System.out.println("No selecciono nada");
        }

    }//GEN-LAST:event_comboEntregaActionPerformed

    private void comboProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProyActionPerformed

        comboEntrega.removeAllItems();
        comboEntrega.addItem(" ");

        try {
            ejecucionBD.sql = "select Entrega.titulo, Entrega.codigo_entrega from Entrega where "
                    + "entrega.proyecto = '" + proyectos.get(comboProy.getSelectedIndex() - 1) + "'";

            entregas.clear();
            funcionesComunes.cargarLista(entregas, comboEntrega);
        } catch (Exception e) {
            System.out.println("No selecciono nada");
        }

    }//GEN-LAST:event_comboProyActionPerformed

    private void comboRespoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRespoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRespoActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed

        try {
            if (comboEstado.getSelectedIndex() == 1) {

                // Si estaba vacio la FFR

                if (ffr == null) {
                    dateFFR.setDate(formatoFecha.parse(formatoFecha.format(new Date())));
                    nuevaActividad.setFecha_fin_real(formatoFecha.format(new Date()));
                } else {
                    dateFFR.setDate(formatoFecha.parse(ffr));
                    nuevaActividad.setFecha_fin_real(ffr);
                }

                textTitulo.setEnabled(false);
                comboProy.setEnabled(false);
                comboEntrega.setEnabled(false);
                comboRespo.setEnabled(false);
                dateFI.getCalendarButton().setEnabled(false);
                dateFF.getCalendarButton().setEnabled(false);

            } else {
                textTitulo.setEnabled(true);
                comboProy.setEnabled(true);
                comboEntrega.setEnabled(true);
                comboRespo.setEnabled(true);
                dateFI.getCalendarButton().setEnabled(true);
                dateFF.getCalendarButton().setEnabled(true);
                dateFFR.setDate(null);
                nuevaActividad.setFecha_fin_real(null);
            }
        } catch (Exception e) {
            System.out.println("Error en actionperformed de comboestado");
        }

    }//GEN-LAST:event_comboEstadoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAcep;
    private javax.swing.JButton btoCanc;
    private javax.swing.JComboBox comboEntrega;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JComboBox comboProy;
    private javax.swing.JLabel comboResp;
    private javax.swing.JComboBox comboRespo;
    private com.toedter.calendar.JDateChooser dateFF;
    private com.toedter.calendar.JDateChooser dateFFR;
    private com.toedter.calendar.JDateChooser dateFI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
