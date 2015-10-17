/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteEntrega;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tavo
 */
public class GUIEntrega extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarEntrega nuevaEntrega;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUIEntrega(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        modeloTable = new MiModelo();
        tablaEnt.setModel(modeloTable);

        //consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select entrega.codigo_entrega as \"CODIGO\", entrega.titulo as \"TITULO\", proyecto.titulo as \"PROYECTO\", entrega.porcentaje as "
                + "\"PORCENTAJE\", TO_CHAR (entrega.fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (entrega.fecha_fin,'dd/MM/yyyy') as \"FIN\", entrega.estado as \"ESTADO\", entrega.valor as \"VALOR\"\n"
                + "From entrega, proyecto where proyecto.codigo_proy = entrega.proyecto order by entrega.proyecto, entrega.codigo_entrega";
        funcionesComunes.cargarTabla(modeloTable);

        this.setTitle("Entregas");
        this.setIconImage(logo);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btoAgre = new javax.swing.JButton();
        btoBorr = new javax.swing.JButton();
        btoMod = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btoSal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEnt = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ENTREGAS POR PROYECTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(375, 375, 375))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
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
                    .addComponent(btoSal))
                .addGap(10, 10, 10))
        );

        tablaEnt.setBackground(new java.awt.Color(0, 153, 153));
        tablaEnt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaEnt.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaEnt.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaEnt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btoBorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoBorrActionPerformed

        try {
            String titulo = null;
            String campo = null;
            ejecucionBD.sql = "select * from entrega order by proyecto,codigo_entrega";
            ejecucionBD.ejecutarConsulta();

            campo = ejecucionBD.ubicarCursor(tablaEnt.getSelectedRow());

            if (tablaEnt.getSelectedRow() != -1) {
                titulo = ejecucionBD.result.getString("titulo");
            }

            if (campo != null) {

                ejecucionBD.sql = "select * from rolxent_per where entrega ='" + campo + "'";
                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() == 0) {

                    ejecucionBD.sql = "select * from actividad where entrega ='" + campo + "'";
                    ejecucionBD.ejecutarConsulta();

                    if (ejecucionBD.cantidadRegistros() == 0) {
                        if (JOptionPane.showConfirmDialog(null, "Desea borrar la Entrega " + titulo) == 0) {

                            if (ejecucionBD.ejecutarDelete("Entrega", campo, "codigo_entrega")) {
                                ejecucionBD.sql = "select entrega.codigo_entrega as \"CODIGO\", entrega.titulo as \"TITULO\", proyecto.titulo as \"PROYECTO\", entrega.porcentaje as "
                                        + "\"PORCENTAJE\", TO_CHAR (entrega.fecha_inicio,'dd/MM/yyyy') as \"INICIO\", TO_CHAR (entrega.fecha_fin,'dd/MM/yyyy') as \"FIN\", entrega.estado as \"ESTADO\", entrega.valor as \"VALOR\"\n"
                                        + "From entrega, proyecto where proyecto.codigo_proy = entrega.proyecto order by entrega.proyecto, entrega.codigo_entrega";
                                modeloTable = new MiModelo();

                                funcionesComunes.cargarTabla(modeloTable);
                                tablaEnt.setModel(modeloTable);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La Entrega " + titulo + " tiene asociada actividades, para poder eliminarlo\n"
                                + "primero borre esas actividades",
                                "Alerta", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La Entrega " + titulo + " tiene registrado Desesarrolladores, para poder eliminarlo\n"
                            + "primero borre esos registros de la ventana registrar Desarrollador a entrega",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione una Entrega!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Error en Borrar Entrega");
        }
    }//GEN-LAST:event_btoBorrActionPerformed
    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed

        String campo = null;
        ejecucionBD.sql = "select * from entrega order by entrega.proyecto, entrega.codigo_entrega";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaEnt.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select codigo_entrega, titulo, porcentaje, proyecto, to_char (fecha_inicio, 'dd/MM/yyyy'),"
                    + "to_char (fecha_fin, 'dd/MM/yyyy'), to_char (fecha_fin_real, 'dd/MM/yyyy'),estado,valor from entrega "
                    + "where codigo_entrega ='" + campo + "' order by entrega.proyecto, entrega.codigo_entrega";
            if (ejecucionBD.ejecutarConsulta()) {
                nuevaEntrega = new GUIAgregarEntrega(null, true, modeloTable, tablaEnt, ejecucionBD.obtenerObjeto());
                nuevaEntrega.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione una Entrega!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btoModActionPerformed

    private void btoSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoSalActionPerformed

//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.Entregas.setVisible(false);
        
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);

    }//GEN-LAST:event_btoSalActionPerformed

    private void btoAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAgreActionPerformed

        nuevaEntrega = new GUIAgregarEntrega(null, true, modeloTable, tablaEnt);
        nuevaEntrega.setVisible(true);

    }//GEN-LAST:event_btoAgreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        reporteEntrega reporteEntrega = new reporteEntrega("Entregas Best Mind Software", "ReporteEntregas.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteEntrega.abrirPDF();
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEnt;
    // End of variables declaration//GEN-END:variables
}
