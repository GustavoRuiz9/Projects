package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.MiModelo;
import Modelo.Entrega;
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
public class GUIAgregarEntrega extends java.awt.Dialog {

    //inicializan los objetos necesarios 
    static Entrega nuevaEntrega = new Entrega();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    java.util.ArrayList proyectos = null;
    IDateEditor focusFecha;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    Image logo = null;
    String llave = "";
    int numEnt;
    String vrFinal;
    int max;
    int cuantasvan = 0;
    int sumaPorc = 0;
    String ffr;

    public GUIAgregarEntrega(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        proyectos = new ArrayList();

        if (comboProy.getSelectedItem().toString().equals("")) {
            textPorc.setEditable(false);
        }

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(proyectos, comboProy, "proyecto", "titulo", "codigo_proy");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

//        textPorc.setEditable(false);

        // Desabilitar el TextField de los JdateChooser
        ((JTextFieldDateEditor) dateFI.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFF.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFFR.getDateEditor()).setEditable(false);
        dateFFR.getCalendarButton().setEnabled(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nueva Entrega");
    }

    public GUIAgregarEntrega(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        proyectos = new ArrayList();
        agregar = false;
//        max = 100; si va a modificar y ya todas estan ingresdas false para el textPorc

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(proyectos, comboProy, "proyecto ", "titulo", "codigo_proy");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        try {
            ejecucionBD.sql = "select count(codigo_actividad) from actividad where entrega = '" + registros[0] + "' and estado = 'Terminado'";

            ejecucionBD.ejecutarConsulta();

            int entTerminadas = ejecucionBD.result.getInt(1);

            ejecucionBD.sql = "select count(codigo_actividad) from actividad where entrega = '" + registros[0] + "'";

            ejecucionBD.ejecutarConsulta();

            int totalAct = ejecucionBD.result.getInt(1);

            if (totalAct == entTerminadas && totalAct > 0) {
                comboEstado.addItem("Terminado");
            }

        } catch (Exception e) {
            System.out.println("Error en donde se pone el Estado Terminado en los proy a modificar");
        }

        ejecucionBD.sql = "select * from actividad where actividad.entrega = '" + registros[0] + "'";
        ejecucionBD.ejecutarConsulta();
        if (ejecucionBD.cantidadRegistros() > 0) {
            comboProy.setEnabled(false);
        }

        // Desabilitar el TextField de los JdateChooser
        ((JTextFieldDateEditor) dateFI.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFF.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor) dateFFR.getDateEditor()).setEditable(false);
        dateFFR.getCalendarButton().setEnabled(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Entrega");

        llave = registros[0];

        textTitulo.setText(registros[1]);
        textPorc.setText(registros[2]);

        try {
            ejecucionBD.sql = "select titulo from proyecto where codigo_proy = '" + registros[3] + "'";
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboProy.setSelectedItem(ejecucionBD.result.getString("titulo"));
            } else {
                System.out.println("nada en proyecto");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

        if (numEnt == cuantasvan) {
            textPorc.setEnabled(false);
        }

        try {
            if (registros[4] == null) {
                dateFI.setDate(null);
            } else {
                dateFI.setDate(formatoFecha.parse(registros[4]));
            }

            if (registros[5] == null) {
                dateFF.setDate(null);
            } else {
                dateFF.setDate(formatoFecha.parse(registros[5]));
            }

            if (registros[6] == null) {
                dateFFR.setDate(null);
            } else {
                dateFFR.setDate(formatoFecha.parse(registros[6]));
                ffr = registros[6];
            }

        } catch (Exception e) {
            System.out.println("Error en fechas");
        }

        comboEstado.setSelectedItem(registros[7]);
        textVr.setText(registros[8]);

        ejecucionBD.sql = "select codigo_actividad from actividad where entrega = " + llave;
        ejecucionBD.ejecutarConsulta();

        if (ejecucionBD.cantidadRegistros() > 0) {
            dateFI.getCalendarButton().setEnabled(false);
            dateFF.getCalendarButton().setEnabled(false);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateFI = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        textVr = new javax.swing.JTextField();
        dateFF = new com.toedter.calendar.JDateChooser();
        dateFFR = new com.toedter.calendar.JDateChooser();
        comboProy = new javax.swing.JComboBox();
        comboEstado = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        textPorc = new javax.swing.JTextField();
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
        jLabel1.setText("ENTREGA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(204, 204, 204))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Titulo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Proyecto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha Inicio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha Fin");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Fecha Real");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Estado");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Valor");

        textVr.setEditable(false);

        comboProy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProyActionPerformed(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Desarrollo" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Porcentaje");
        jLabel10.setToolTipText("");

        textPorc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textPorcKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboProy, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateFFR, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textVr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPorc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFI, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5))
                    .addComponent(dateFI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboProy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textPorc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateFFR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(textVr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addGap(148, 148, 148)
                .addComponent(btoAcep)
                .addGap(7, 7, 7)
                .addComponent(btoCanc))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btoAcep)
                    .addComponent(btoCanc))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btoAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAcepActionPerformed

        nuevaEntrega.setCodigoEnt("cod_ent.NextVal");

        String titulo = textTitulo.getText().trim();
        if (validacionDatos.caracteres(titulo) && validacionDatos.validarCantidad(titulo) == 1) {
            nuevaEntrega.setTitulo(titulo);
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

        String Proyecto = comboProy.getSelectedItem().toString();
        if (validacionDatos.campoVacio(Proyecto)) {
            comboProy.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Proyecto Obligatorio");
            return;
        } else {
            nuevaEntrega.setProyecto((this.proyectos.get((comboProy.getSelectedIndex() - 1)).toString()));
        }

        String porcentaje = null;
        try {
            porcentaje = textPorc.getText();
            if (validacionDatos.validarPorcentaje(porcentaje, max)) {
                nuevaEntrega.setPorcentaje(Integer.parseInt(porcentaje));
            } else {
                textPorc.requestFocus();
                if (porcentaje.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Porcentaje Obligatorio");
                } else {
                    if (validacionDatos.vrEntero(porcentaje)) {
                        JOptionPane.showMessageDialog(null, "Campo Porcentaje Ilogico o Exagerado min 10 y max " + max);
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Porcentaje Invalido");
                    }
                }
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo Valor Porcentaje");
            return;
        }

        String Estado = comboEstado.getSelectedItem().toString();
        if (validacionDatos.campoVacio(Estado.toString())) {
            comboEstado.requestFocus();
            return;
        } else {
            nuevaEntrega.setEstado(Estado);
        }

        try {
            Double valor = Double.parseDouble(textVr.getText());
            nuevaEntrega.setValor(valor);
        } catch (Exception e) {
            if (textVr.getText().trim().equals("")) {
                textVr.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Valor Vacio");
                return;
            } else {
                textVr.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Valor Invalido");
            }
        }


        try {
            //se obtiene el obj IDateEditor de los jdatechooser para luego poder enfocar el campo de la fecha
            focusFecha = (IDateEditor) dateFI.getDateEditor();
//            String fecha = "";

            String codigo = this.proyectos.get((comboProy.getSelectedIndex() - 1)).toString();
            String fechaI = formatoFecha.format(dateFI.getDate());
            Date FechaI = formatoFecha.parse(fechaI);
            ejecucionBD.sql = "select TO_CHAR(fecha_inicio,'dd/MM/yyyy') as \"finicio\" from proyecto where codigo_proy = '" + codigo + "'";
            ejecucionBD.ejecutarConsulta();
            String fechaIni = ejecucionBD.result.getString("finicio").toString();


            Date fechaInic = formatoFecha.parse(fechaIni);


            if (FechaI.before(fechaInic)) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Error en Fecha Inicio, debe Ser Mayor a la fecha Inicio del Proyecto " + fechaIni);
                return;
            } else {
                nuevaEntrega.setFecha_inicio(fechaI);
            }
        } catch (Exception e) {
            focusFecha.getUiComponent().requestFocus();
            System.out.println("Campo Fecha Inicio Obligatorio " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Campo Fecha Inicio Obligatorio ");
            dateFI.setDate(null);
            return;
        }

        try {

            focusFecha = (IDateEditor) dateFF.getDateEditor();
            String codigo = this.proyectos.get((comboProy.getSelectedIndex() - 1)).toString();
            ejecucionBD.sql = "select TO_CHAR(fecha_FIN,'dd/MM/yyyy') as \"ffin\"  from proyecto where codigo_proy = '" + codigo + "'";
            ejecucionBD.ejecutarConsulta();
            String fechaF = formatoFecha.format(dateFF.getDate());
            Date FechaFF = formatoFecha.parse(fechaF);
            String fechaFin = ejecucionBD.result.getString("ffin").toString();
            Date fechafinn = formatoFecha.parse(fechaFin);
            if (dateFF.getDate().before(dateFI.getDate()) || dateFF.getDate().equals(dateFI.getDate())) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Fin menor o igual a Fecha Inicio de la Entrega");
                return;
            } else if (FechaFF.after(fechafinn)) {
                focusFecha = (IDateEditor) dateFF.getDateEditor();
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Fecha Fin debe ser Menor o igual a la fecha Fin del proyecto " + fechaFin);
                return;
            }
            {
                nuevaEntrega.setFecha_fin(fechaF);
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
            if (dateFFR.getDate().before(dateFI.getDate()) || formatoFecha.parse(formatoFecha.format(dateFFR.getDate())).getTime() == formatoFecha.parse(formatoFecha.format(dateFI.getDate())).getTime()) {
                focusFecha.getUiComponent().requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Fecha Fin Real menor o igual a Fecha Inicio");
                comboEstado.setSelectedIndex(0);
                dateFFR.setDate(null);
                return;
            } else {
                nuevaEntrega.setFecha_finReal(fechaFFR);
            }

        } catch (Exception e) {
            fechaFFR = "";
            nuevaEntrega.setFecha_finReal(fechaFFR);
        }


        if (agregar) {

            if (ejecucionBD.ejecutarInsert(nuevaEntrega, "Entrega")) {
                this.setVisible(false);

                ejecucionBD.ejecutarUpdateEstProy(nuevaEntrega.getProyecto(), "En Desarrollo");

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select entrega.codigo_entrega as \"CODIGO\", entrega.titulo as \"TITULO\", proyecto.titulo as \"PROYECTO\", entrega.porcentaje as "
                        + "\"PORCENTAJE\", TO_CHAR (entrega.fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (entrega.fecha_fin,'dd/MM/yyyy') as \"FIN\", entrega.estado as \"ESTADO\", entrega.valor as \"VALOR\"\n"
                        + "From entrega, proyecto where proyecto.codigo_proy = entrega.proyecto order by entrega.proyecto, entrega.codigo_entrega";
                funcionesComunes.cargarTabla(modeloTabla);
            }
        } else {

            if (ejecucionBD.ejecutarUpdate(nuevaEntrega, "Entrega", llave)) { //Se modifica
                this.setVisible(false);

                if (nuevaEntrega.getEstado().equals("En Desarrollo")) {
                    ejecucionBD.ejecutarUpdateEstProy(nuevaEntrega.getProyecto(), "En Desarrollo");
                }

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select entrega.codigo_entrega as \"CODIGO\", entrega.titulo as \"TITULO\", proyecto.titulo as \"PROYECTO\", entrega.porcentaje as "
                        + "\"PORCENTAJE\", TO_CHAR (entrega.fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (entrega.fecha_fin,'dd/MM/yyyy') as \"FIN\", entrega.estado as \"ESTADO\", entrega.valor as \"VALOR\"\n"
                        + "From entrega, proyecto where proyecto.codigo_proy = entrega.proyecto order by entrega.proyecto, entrega.codigo_entrega";
                funcionesComunes.cargarTabla(modeloTabla);

            }

        }
    }//GEN-LAST:event_btoAcepActionPerformed

    private void btoCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoCancActionPerformed

        this.setVisible(false);

    }//GEN-LAST:event_btoCancActionPerformed

    private void textPorcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPorcKeyReleased

        if (validacionDatos.vrDecimal(textPorc.getText())) {
            textVr.setText(Double.parseDouble(textPorc.getText()) * Integer.parseInt(vrFinal) / 100 + "");
        } else {
            textVr.setText("");
        }

    }//GEN-LAST:event_textPorcKeyReleased

    private void comboProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProyActionPerformed

        if (comboProy.getSelectedIndex() == 0) {
            textPorc.setEditable(false);
        } else {
            textPorc.setEditable(true);
        }


        if (agregar) {

            if (comboProy.getSelectedIndex() != 0) {
                String codProy = proyectos.get(comboProy.getSelectedIndex() - 1).toString();

                ejecucionBD.sql = "select num_entregas, valor_final from proyecto where codigo_proy = " + codProy;
                ejecucionBD.ejecutarConsulta();

                try {
                    numEnt = ejecucionBD.result.getInt(1);
                    vrFinal = ejecucionBD.result.getString(2);

                    ejecucionBD.sql = "select sum(porcentaje) from entrega where proyecto = " + codProy;
                    ejecucionBD.ejecutarConsulta();
                    sumaPorc = ejecucionBD.result.getInt(1);

                    if (numEnt == 1) {
                        textPorc.setText(100 + "");
                        textPorc.setEditable(false);
                        textVr.setText(vrFinal + ".0");
                    } else {
                        ejecucionBD.sql = "select count(codigo_entrega) from entrega where proyecto = " + codProy;
                        ejecucionBD.ejecutarConsulta();
                        cuantasvan = ejecucionBD.result.getInt(1);

                        if (ejecucionBD.result.getInt(1) + 1 == numEnt) {

                            textPorc.setText((100 - sumaPorc) + "");
                            textVr.setText(Double.parseDouble(textPorc.getText()) * Integer.parseInt(vrFinal) / 100 + "");
                            textPorc.setEditable(false);
                        } else {
                            textPorc.setText(null);
                            textPorc.setEditable(true);
                            textVr.setText(null);
                        }
                    }

                    max = ((100 - sumaPorc) - ((numEnt - (cuantasvan + 1)) * 10));

                } catch (Exception e) {
                    System.out.println(" Error en Actionperformed de comboProy en agregar entrega");
                }

            } else {
                textPorc.setText(null);
                textVr.setText(null);
                textPorc.setEditable(false);
            }

        } else {
            try {

                String codProy = proyectos.get(comboProy.getSelectedIndex() - 1).toString();

                comboProy.setEnabled(false);


                ejecucionBD.sql = "select num_entregas, valor_final from proyecto where codigo_proy = " + codProy;
                ejecucionBD.ejecutarConsulta();

                numEnt = ejecucionBD.result.getInt(1);
                vrFinal = ejecucionBD.result.getString(2);

                ejecucionBD.sql = "select sum(porcentaje) from entrega where proyecto = " + codProy;
                ejecucionBD.ejecutarConsulta();
                sumaPorc = ejecucionBD.result.getInt(1);

                ejecucionBD.sql = "select count(codigo_entrega) from entrega where proyecto = " + codProy;
                ejecucionBD.ejecutarConsulta();
                cuantasvan = ejecucionBD.result.getInt(1);

                if (sumaPorc == 100) {
                    max = 100;
                    textPorc.setEditable(false);
                } else {
                    max = ((100 - (sumaPorc - Integer.parseInt(textPorc.getText()))) - ((numEnt - (cuantasvan)) * 10));
                }

            } catch (Exception e) {
                System.out.println("Error en modificar de el combobox de proyecto de la GUI Agregar entrega");
            }
        }
    }//GEN-LAST:event_comboProyActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed

        try {
            if (comboEstado.getSelectedIndex() == 1) {

                // Si estaba vacio la FFR

                if (ffr == null) {
                    dateFFR.setDate(formatoFecha.parse(formatoFecha.format(new Date())));
                    nuevaEntrega.setFecha_finReal(formatoFecha.format(new Date()));
                } else {
                    dateFFR.setDate(formatoFecha.parse(ffr));
                    nuevaEntrega.setFecha_finReal(ffr);
                }

                textTitulo.setEnabled(false);
                textPorc.setEnabled(false);
                textVr.setEnabled(false);
                dateFI.getCalendarButton().setEnabled(false);
                dateFF.getCalendarButton().setEnabled(false);

            } else {
                textTitulo.setEnabled(true);
                textPorc.setEnabled(true);
                textVr.setEnabled(true);
                dateFI.getCalendarButton().setEnabled(true);
                dateFF.getCalendarButton().setEnabled(true);
                dateFFR.setDate(null);
                nuevaEntrega.setFecha_finReal(null);
            }
        } catch (Exception e) {
            System.out.println("Error en actionperformed de comboestado");
        }

    }//GEN-LAST:event_comboEstadoActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAcep;
    private javax.swing.JButton btoCanc;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JComboBox comboProy;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField textPorc;
    private javax.swing.JTextField textTitulo;
    private javax.swing.JTextField textVr;
    // End of variables declaration//GEN-END:variables
}
