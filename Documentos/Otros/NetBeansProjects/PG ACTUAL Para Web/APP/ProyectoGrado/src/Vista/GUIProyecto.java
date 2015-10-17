package Vista;

import Control.reporteProyectos;
import Control.ejecucionBD;
import Control.funcionesComunes;
import javax.swing.JOptionPane;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author tavo
 */
public class GUIProyecto extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarProyecto nuevoProyecto;
    int contC = 0;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUIProyecto(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        modeloTable = new MiModelo();
        tablaProyectos.setModel(modeloTable);

//        consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select codigo_proy as \"PROYECTO\", titulo as \"TITULO\", CLIENTE.nombre as \"CLIENTE\","
                + "cant_personas as \"NUM. DESARROLLADORES\", num_entregas as \"NUM. ENTREGAS\",\n"
                + "TO_CHAR (fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (fecha_fin,'dd/MM/yyyy') "
                + "as \"FIN\", valor_final as \"VALOR FINAL\" from proyecto, cliente where "
                + "proyecto.cliente = cliente.codigo_cliente order by proyecto.codigo_proy";


        funcionesComunes.cargarTabla(modeloTable);



        this.setTitle("Proyectos");
        this.setIconImage(logo);
//        labelNumProy.setText("Proyectos: " + ejecucionBD.cantidadRegistros());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProyectos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        botonAdd = new javax.swing.JButton();
        btoDrop = new javax.swing.JButton();
        btoUpd = new javax.swing.JButton();
        btonView = new javax.swing.JButton();
        btonView1 = new javax.swing.JButton();
        btonClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tituloPantProy = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaProyectos.setBackground(new java.awt.Color(0, 153, 153));
        tablaProyectos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaProyectos.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tablaProyectos.setForeground(new java.awt.Color(51, 51, 51));
        tablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProyectos.setAlignmentX(0.0F);
        tablaProyectos.setAlignmentY(0.0F);
        tablaProyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaProyectos.setGridColor(new java.awt.Color(0, 255, 51));
        tablaProyectos.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaProyectos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaProyectos);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        botonAdd.setText("Agregar");
        botonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddActionPerformed(evt);
            }
        });

        btoDrop.setText("Borrar");
        btoDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoDropActionPerformed(evt);
            }
        });

        btoUpd.setText("Modificar");
        btoUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoUpdActionPerformed(evt);
            }
        });

        btonView.setText("Visualizar");
        btonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonViewActionPerformed(evt);
            }
        });

        btonView1.setText("Observaciones");
        btonView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonView1ActionPerformed(evt);
            }
        });

        btonClose.setText("Menu");
        btonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(botonAdd)
                .addGap(30, 30, 30)
                .addComponent(btoDrop)
                .addGap(30, 30, 30)
                .addComponent(btoUpd)
                .addGap(30, 30, 30)
                .addComponent(btonView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btonView1)
                .addGap(30, 30, 30)
                .addComponent(btonClose)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAdd)
                    .addComponent(btoDrop)
                    .addComponent(btoUpd)
                    .addComponent(btonView)
                    .addComponent(btonView1)
                    .addComponent(btonClose))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tituloPantProy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tituloPantProy.setText("PROYECTOS BMS");
        tituloPantProy.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(tituloPantProy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(tituloPantProy)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        if ((JOptionPane.showOptionDialog(this, "¿Desea cerrar la App o ir a Menu?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Cerrar App", "Menu"}, "Cerrar")) == 0) {
            System.exit(0);
        } else {
            this.dispose();
            new GUIMenuDirector(null, true).setVisible(true);
        }
    }//GEN-LAST:event_closeDialog

    private void botonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddActionPerformed

        nuevoProyecto = new GUIAgregarProyecto(null, true, modeloTable, tablaProyectos);
        nuevoProyecto.setVisible(true);

    }//GEN-LAST:event_botonAddActionPerformed

    private void btoUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoUpdActionPerformed

        String campo = null;
        ejecucionBD.sql = "select * from proyecto order by codigo_proy";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaProyectos.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select codigo_proy, cant_personas, est_cant_pers, num_entregas, titulo, categoria, cliente, "
                    + "TO_CHAR (fecha_inicio,'dd/MM/yyyy') as \"FECHA_INICIO\", TO_CHAR (fecha_fin,'dd/MM/yyyy') as \"FECHA_FIN\","
                    + " TO_CHAR(fecha_fin_real,'dd/MM/yyyy') as \"FECHA_FIN_REAL\", valor_estimado, valor_final, "
                    + "estado, rangopf from proyecto where codigo_proy='" + campo + "'";

            if (ejecucionBD.ejecutarConsulta()) {
                nuevoProyecto = new GUIAgregarProyecto(null, true, modeloTable, tablaProyectos, ejecucionBD.obtenerObjeto());
                nuevoProyecto.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione un Proyecto!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btoUpdActionPerformed

    private void btonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCloseActionPerformed

        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);
//        GUIMenuDirector.Proyectos.setVisible(false);

    }//GEN-LAST:event_btonCloseActionPerformed

    private void btoDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoDropActionPerformed
        try {
            String titulo = null;
            String campo = null;
            ejecucionBD.sql = "select * from proyecto order by codigo_proy";
            ejecucionBD.ejecutarConsulta();

            campo = ejecucionBD.ubicarCursor(tablaProyectos.getSelectedRow());

            if (tablaProyectos.getSelectedRow() != -1) {
                titulo = ejecucionBD.result.getString("TITULO");
            }

            if (campo != null) {

                ejecucionBD.sql = "select * from entrega where proyecto ='" + campo + "'";
                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() == 0) {

                    ejecucionBD.sql = "select * from observacion where codigo_proy ='" + campo + "'";
                    ejecucionBD.ejecutarConsulta();

                    if (ejecucionBD.cantidadRegistros() > 0) {

                        if (JOptionPane.showConfirmDialog(null, "Desea borrar el proyecto " + titulo + " y su Observacion") == 0) {
                            if (ejecucionBD.ejecutarDelete("Observacion", campo, "codigo_proy")) {
                                if (ejecucionBD.ejecutarDelete("Proyecto", campo, "codigo_proy")) {

                                    ejecucionBD.sql = "select codigo_proy as \"PROYECTO\", titulo as \"TITULO\", CLIENTE.nombre as \"CLIENTE\","
                                            + "cant_personas as \"NUM. DESARROLLADORES\", num_entregas as \"NUM. ENTREGAS\",\n"
                                            + "TO_CHAR (fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (fecha_fin,'dd/MM/yyyy') "
                                            + "as \"FIN\", valor_final as \"VALOR FINAL\" from proyecto, cliente where "
                                            + "proyecto.cliente = cliente.codigo_cliente order by proyecto.codigo_proy";

                                    modeloTable = new MiModelo();

                                    funcionesComunes.cargarTabla(modeloTable);
                                    tablaProyectos.setModel(modeloTable);
                                }
                            }
                        }

                    } else {

                        if (JOptionPane.showConfirmDialog(null, "Desea borrar el proyecto " + titulo) == 0) {
                            if (ejecucionBD.ejecutarDelete("Proyecto", campo, "codigo_proy")) {

                                ejecucionBD.sql = "select codigo_proy as \"PROYECTO\", titulo as \"TITULO\", CLIENTE.nombre as \"CLIENTE\","
                                        + "cant_personas as \"NUM. DESARROLLADORES\", num_entregas as \"NUM. ENTREGAS\",\n"
                                        + "TO_CHAR (fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (fecha_fin,'dd/MM/yyyy') "
                                        + "as \"FIN\", valor_final as \"VALOR FINAL\" from proyecto, cliente where "
                                        + "proyecto.cliente = cliente.codigo_cliente";

                                modeloTable = new MiModelo();

                                funcionesComunes.cargarTabla(modeloTable);
                                tablaProyectos.setModel(modeloTable);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El proyecto " + titulo + " tiene asociado entregas, para poder eliminarlo\n"
                            + "primero borre esas entregas",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione un Proyecto!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Error en Borrar Proyecto");
        }

    }//GEN-LAST:event_btoDropActionPerformed

    private void btonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonViewActionPerformed

        reporteProyectos reporteProyecto = new reporteProyectos("Proyectos Best Mind Software", "ReporteProyectos.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteProyecto.abrirPDF();
        }

    }//GEN-LAST:event_btonViewActionPerformed

    private void btonView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonView1ActionPerformed
        // TODO add your handling code here:
        GUIObservacion a = new GUIObservacion(null, true);
        a.setVisible(true);
    }//GEN-LAST:event_btonView1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAdd;
    private javax.swing.JButton btoDrop;
    private javax.swing.JButton btoUpd;
    private javax.swing.JButton btonClose;
    private javax.swing.JButton btonView;
    private javax.swing.JButton btonView1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProyectos;
    private javax.swing.JLabel tituloPantProy;
    // End of variables declaration//GEN-END:variables
}
