package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteDes;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Tavo
 */
public class GUIADesarrolladores extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarDes nuevoDes;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUIADesarrolladores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        modeloTable = new MiModelo();
        tablaDes.setModel(modeloTable);

        //consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular, correo, cuenta_Activa as cuenta"
                + " from personal where not codigo_personal = 1 order by codigo_personal";
        funcionesComunes.cargarTabla(modeloTable);
        
        this.setTitle("Desarrolladores");
        this.setIconImage(logo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btoAgre = new javax.swing.JButton();
        btoBorr = new javax.swing.JButton();
        btoMod = new javax.swing.JButton();
        btoVisualizar = new javax.swing.JButton();
        btoSal = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PERSONAL DESARROLLADOR BMS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tablaDes.setBackground(new java.awt.Color(0, 153, 153));
        tablaDes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDes.setSelectionBackground(new java.awt.Color(102, 255, 255));
        tablaDes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaDes);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setAlignmentX(getAlignmentX());

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

        btoVisualizar.setText("Visualizar");
        btoVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoVisualizarActionPerformed(evt);
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
                .addGap(43, 43, 43)
                .addComponent(btoAgre)
                .addGap(30, 30, 30)
                .addComponent(btoBorr)
                .addGap(39, 39, 39)
                .addComponent(btoMod)
                .addGap(35, 35, 35)
                .addComponent(btoVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(btoSal)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAgre)
                    .addComponent(btoBorr)
                    .addComponent(btoMod)
                    .addComponent(btoVisualizar)
                    .addComponent(btoSal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        nuevoDes = new GUIAgregarDes(null, true, modeloTable, tablaDes);
        nuevoDes.setVisible(true);
    }//GEN-LAST:event_btoAgreActionPerformed

    private void btoBorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoBorrActionPerformed

        try {
            int persMin = 0;
            int persHay = 0;
            String nombre = null;
            String campo = null;
            ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular, correo, "
                    + "cuenta_Activa as cuenta "
                    + "from personal where not codigo_personal = 1  order by codigo_personal";
            ejecucionBD.ejecutarConsulta();


            campo = ejecucionBD.ubicarCursor(tablaDes.getSelectedRow());
            if (tablaDes.getSelectedRow() != -1) {
                nombre = ejecucionBD.result.getString("nombre");
            }



            ejecucionBD.sql = "select max (cant_personas) as \"cantidad\" from proyecto";
            ejecucionBD.ejecutarConsulta();

            if (ejecucionBD.cantidadRegistros() > 0) {
                persMin = ejecucionBD.result.getInt(1);
            }



            if (campo != null) {

                ejecucionBD.sql = "select * from actividad where responsable ='" + campo + "'";
                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() == 0) {

                    ejecucionBD.sql = "select * from rolxent_per where personal ='" + campo + "'";
                    ejecucionBD.ejecutarConsulta();

                    if (ejecucionBD.cantidadRegistros() == 0) {

                        ejecucionBD.sql = "select * from cuenta where personal ='" + campo + "'";
                        ejecucionBD.ejecutarConsulta();

                        if (ejecucionBD.cantidadRegistros() == 0) {
                            if (JOptionPane.showConfirmDialog(null, "Desea borrar al Desarrollador " + nombre) == 0) {
                                if (ejecucionBD.ejecutarDelete("Personal", campo, "codigo_personal")) {
                                    ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular, correo,"
                                            + " cuenta_Activa as cuenta "
                                            + "from personal where not codigo_personal = 1 order by codigo_personal";
                                    modeloTable = new MiModelo();

                                    funcionesComunes.cargarTabla(modeloTable);
                                    tablaDes.setModel(modeloTable);
                                }
                            }
                        } else {

                            ejecucionBD.sql = "select count(personal.codigo_personal) from personal, cuenta " + "where not codigo_personal = 1 and cuenta.personal = personal.codigo_personal";

                            ejecucionBD.ejecutarConsulta();

                            if (ejecucionBD.cantidadRegistros() > 0) {
                                persHay = ejecucionBD.result.getInt(1);
                            }

                            if ((persHay - 1) >= persMin) {


                                if (JOptionPane.showConfirmDialog(null, "Desea borrar al Desarrollador " + nombre + " y su cuenta") == 0) {

                                    if (ejecucionBD.ejecutarDelete("Cuenta", campo, "personal")) {
                                        if (ejecucionBD.ejecutarDelete("Personal", campo, "codigo_personal")) {
                                            ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular,"
                                                    + " correo, cuenta_Activa as cuenta from personal where not codigo_personal = 1 order by codigo_personal";
                                            modeloTable = new MiModelo();

                                            funcionesComunes.cargarTabla(modeloTable);
                                            tablaDes.setModel(modeloTable);
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El Minimo de Desarrolladores con cuenta es " + persMin + "\n" + "ya que ya se tiene en cuenta para uno o varios proyectos", "Alerta", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "El Desarrollador " + nombre + " esta registrado en una o varias Entregas, para poder eliminarlo\n"
                                + "primero borre esas relaciones de la ventana registrar Desarrollador a Entrega",
                                "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Desarrollador " + nombre + " tiene registrada una o varias actividades, para poder eliminarlo\n"
                            + "primero borre esas actividades",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione un Desarrollador!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error en Borrar Desarrollador");
        }
    }//GEN-LAST:event_btoBorrActionPerformed

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed

        String campo = null;
        ejecucionBD.sql = "select personal.* from personal where not codigo_personal = 1 order by codigo_personal";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaDes.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select * from personal where codigo_personal ='" + campo + "'";
            if (ejecucionBD.ejecutarConsulta()) {
                nuevoDes = new GUIAgregarDes(null, true, modeloTable, tablaDes, ejecucionBD.obtenerObjeto());
                nuevoDes.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione un Desarrollador!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btoModActionPerformed

    private void btoSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoSalActionPerformed

//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.Desarrolladores.setVisible(false);
        
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);
    }//GEN-LAST:event_btoSalActionPerformed

    private void btoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoVisualizarActionPerformed
        reporteDes reporteDes = new reporteDes("Desarrolladores Best Mind Software", "ReporteDesarrolladores.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteDes.abrirPDF();
        }
    }//GEN-LAST:event_btoVisualizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAgre;
    private javax.swing.JButton btoBorr;
    private javax.swing.JButton btoMod;
    private javax.swing.JButton btoSal;
    private javax.swing.JButton btoVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDes;
    // End of variables declaration//GEN-END:variables
}
