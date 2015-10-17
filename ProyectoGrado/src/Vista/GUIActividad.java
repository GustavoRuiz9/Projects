package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteActividad;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author tavo
 */
public class GUIActividad extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarActividad nuevaActividad;
    int contC = 0;
    DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUIActividad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        modeloTable = new MiModelo();
        tablaAct.setModel(modeloTable);

        //consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select actividad.codigo_actividad as \"CODIGO\", actividad.titulo, proyecto.titulo as \"PROYECTO\" "
                + ",entrega.titulo as \"ENTREGA\", to_char(actividad.fecha_ini, 'dd/MM/yyyy') as \"INICIO\","
                + "to_char (actividad.fecha_fin, 'dd/MM/yyyy') as \"FIN\", personal.nombre as \"RESPONSABLE\","
                + " actividad.estado from personal, actividad, entrega, proyecto where personal.codigo_personal = actividad.responsable "
                + "and actividad.entrega = entrega.codigo_entrega and entrega.proyecto = proyecto.codigo_proy order by actividad.codigo_actividad,proyecto.codigo_proy";
        funcionesComunes.cargarTabla(modeloTable);

        this.setIconImage(logo);
        this.setTitle("Actividades");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btoAgre = new javax.swing.JButton();
        btoBorr = new javax.swing.JButton();
        btoMod = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btoSal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAct = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ACTIVIDADES POR ENTREGAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(349, 349, 349))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btoAgre.setText("Agregar");
        btoAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAgreActionPerformed(evt);
            }
        });

        btoBorr.setText("Borrar");
        btoBorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoBorrActionPerformed(evt);
            }
        });

        btoMod.setText("Modificar");
        btoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoModActionPerformed(evt);
            }
        });

        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btoSal.setText("Menu");
        btoSal.setActionCommand("volver");
        btoSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoSalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btoAgre)
                .addGap(30, 30, 30)
                .addComponent(btoBorr)
                .addGap(30, 30, 30)
                .addComponent(btoMod)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btoSal)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoMod)
                    .addComponent(btoBorr)
                    .addComponent(btoAgre)
                    .addComponent(jButton1)
                    .addComponent(btoSal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        tablaAct.setBackground(new java.awt.Color(0, 153, 153));
        tablaAct.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablaAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAct.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaAct.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaAct);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        if ((JOptionPane.showOptionDialog(this, "¿Desea cerrar la App o ir a Menu?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Cerrar App", "Menu"}, "Cerrar")) == 0) {
            System.exit(0);
        } else {
            this.setVisible(false);
//            GUISesion.pantallaMenuDirector.setVisible(true);
        }
    }//GEN-LAST:event_closeDialog

    private void btoAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAgreActionPerformed
        nuevaActividad = new GUIAgregarActividad(null, true, modeloTable, tablaAct);
        nuevaActividad.setVisible(true);
    }//GEN-LAST:event_btoAgreActionPerformed

    private void btoBorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoBorrActionPerformed

        try {
            String titulo = null;
            String campo = null;
            String responsable = null;
            String entrega = null;

            ejecucionBD.sql = "select * from actividad order by codigo_actividad";
            ejecucionBD.ejecutarConsulta();

            if (tablaAct.getSelectedRow() != -1) {
                campo = ejecucionBD.ubicarCursor(tablaAct.getSelectedRow());
                titulo = ejecucionBD.result.getString("TITULO");
            }

            if (campo != null) {

                ejecucionBD.sql = "select responsable, entrega from actividad where codigo_actividad = " + campo;
                ejecucionBD.ejecutarConsulta();

                responsable = ejecucionBD.result.getString(1);
                entrega = ejecucionBD.result.getString(2);

                ejecucionBD.sql = "select estado from actividad where codigo_actividad = " + campo;
                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.result.getString(1).equals("En Desarrollo")) {

                    if (JOptionPane.showConfirmDialog(null, "Desea borrar la Actividad " + titulo) == 0) {

                        if (ejecucionBD.ejecutarDelete("Actividad", campo, "codigo_actividad")) {

                            ejecucionBD.sql = "select * from Actividad where responsable = " + responsable
                                    + " and entrega = '" + entrega + "'";

                            ejecucionBD.ejecutarConsulta();

                            if (ejecucionBD.cantidadRegistros() == 0) {
                                ejecucionBD.ejecutarUpdateEstado_Rolx(responsable, entrega, false);
                            }
                            ejecucionBD.sql = "select actividad.codigo_actividad as \"CODIGO\", actividad.titulo, proyecto.titulo as \"PROYECTO\" "
                                    + ",entrega.titulo as \"ENTREGA\", to_char(actividad.fecha_ini, 'dd/MM/yyyy') as \"INICIO\","
                                    + "to_char (actividad.fecha_fin, 'dd/MM/yyyy') as \"FIN\", personal.nombre as \"RESPONSABLE\","
                                    + " actividad.estado from personal, actividad, entrega, proyecto where personal.codigo_personal = actividad.responsable "
                                    + "and actividad.entrega = entrega.codigo_entrega and entrega.proyecto = proyecto.codigo_proy order by actividad.codigo_actividad";

                            modeloTable = new MiModelo();

                            funcionesComunes.cargarTabla(modeloTable);
                            tablaAct.setModel(modeloTable);
                        } else {
                            System.out.println("No se pudo borrar revise drop en actividad");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Esta actividad esta Terminada no se puede Borrar!", "Atencion", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione una Actividad!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error en Borrar Actividad");
        }

    }//GEN-LAST:event_btoBorrActionPerformed

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed

        String campo = null;
        ejecucionBD.sql = "select * from actividad order by actividad.codigo_actividad";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaAct.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select actividad.codigo_actividad, actividad.titulo, entrega.titulo, "
                    + "to_char(actividad.fecha_ini, 'dd/MM/yyyy'), to_char (actividad.fecha_fin, 'dd/MM/yyyy'), "
                    + "to_char (actividad.fecha_fin_real, 'dd/MM/yyyy'), actividad.estado,"
                    + " personal.nombre, responsable, entrega.codigo_entrega from personal, actividad, entrega where personal.codigo_personal = actividad.responsable "
                    + "and actividad.entrega = entrega.codigo_entrega and codigo_actividad ='" + campo + "' ";

            if (ejecucionBD.ejecutarConsulta()) {
                nuevaActividad = new GUIAgregarActividad(null, true, modeloTable, tablaAct, ejecucionBD.obtenerObjeto());
                nuevaActividad.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione una Actividad!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btoModActionPerformed

    private void btoSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoSalActionPerformed

//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.Actividades.setVisible(false);
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);

    }//GEN-LAST:event_btoSalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reporteActividad reporteActividad = new reporteActividad("Actividades Best Mind Software", "ReporteActividades.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteActividad.abrirPDF();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAgre;
    private javax.swing.JButton btoBorr;
    private javax.swing.JButton btoMod;
    private javax.swing.JButton btoSal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAct;
    // End of variables declaration//GEN-END:variables
}
