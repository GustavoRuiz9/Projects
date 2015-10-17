package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteCliente;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Tavo
 */
public class GUICliente extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarCliente nuevoCliente;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUICliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        modeloTable = new MiModelo();
        tablaCliente.setModel(modeloTable);

        ejecucionBD.sql = "select codigo_cliente as \"CODIGO\", cedula, nombre, apellido, ciudad.nombre_ciudad as \"CIUDAD\", "
                + "telefono, correo, nom_empresa as \"EMPRESA\"\n"
                + "from cliente, ciudad where ciudad.codigo_ciudad = cliente.ciudad order by codigo_cliente";

        funcionesComunes.cargarTabla(modeloTable);

        this.setIconImage(logo);
        this.setTitle("Clientes");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btoAcep = new javax.swing.JButton();
        btoBorr = new javax.swing.JButton();
        btoMod = new javax.swing.JButton();
        btoVis = new javax.swing.JButton();
        btoMen = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CLIENTES BMS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        tablaCliente.setBackground(new java.awt.Color(0, 153, 153));
        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCliente.setSelectionBackground(new java.awt.Color(102, 255, 255));
        tablaCliente.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaCliente);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btoAcep.setText("Agregar");
        btoAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAcepActionPerformed(evt);
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

        btoVis.setText("Visulizar");
        btoVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoVisActionPerformed(evt);
            }
        });

        btoMen.setText("Menu");
        btoMen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoMenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btoAcep)
                .addGap(30, 30, 30)
                .addComponent(btoBorr)
                .addGap(30, 30, 30)
                .addComponent(btoMod)
                .addGap(36, 36, 36)
                .addComponent(btoVis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btoMen)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAcep)
                    .addComponent(btoBorr)
                    .addComponent(btoMod)
                    .addComponent(btoVis)
                    .addComponent(btoMen))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btoAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAcepActionPerformed

        nuevoCliente = new GUIAgregarCliente(null, true, modeloTable, tablaCliente);
        nuevoCliente.setVisible(true);

    }//GEN-LAST:event_btoAcepActionPerformed

    private void btoBorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoBorrActionPerformed

        try {
            String nombre = null;
            String campo = null;
            ejecucionBD.sql = "select codigo_cliente as \"CODIGO\", cedula, nombre, apellido, ciudad.nombre_ciudad as \"CIUDAD\", "
                    + "telefono, correo, nom_empresa as \"EMPRESA\"\n"
                    + "from cliente, ciudad where ciudad.codigo_ciudad = cliente.ciudad order by codigo_cliente";

            ejecucionBD.ejecutarConsulta();

            campo = ejecucionBD.ubicarCursor(tablaCliente.getSelectedRow());
            if (tablaCliente.getSelectedRow() != -1) {
                nombre = ejecucionBD.result.getString("nombre");
            }

            if (campo != null) {

                ejecucionBD.sql = "select * from proyecto where cliente ='" + campo + "'";
                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() == 0) {
                    if (JOptionPane.showConfirmDialog(null, "Desea borrar al Cliente " + nombre) == 0) {

                        if (ejecucionBD.ejecutarDelete("Cliente", campo, "codigo_cliente")) {
                            ejecucionBD.sql = "select codigo_cliente as \"CODIGO\", cedula, nombre, apellido, ciudad.nombre_ciudad as \"CIUDAD\", "
                                    + "telefono, correo, nom_empresa as \"EMPRESA\"\n"
                                    + "from cliente, ciudad where ciudad.codigo_ciudad = cliente.ciudad order by codigo_cliente";

                            modeloTable = new MiModelo();

                            funcionesComunes.cargarTabla(modeloTable);
                            tablaCliente.setModel(modeloTable);
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "El Cliente " + nombre + " esta registrado en uno o varios Proyectos, para poder eliminarlo\n"
                            + "primero borre esos Proyectos",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione un Cliente!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error en Borrar Cliente");
        }

    }//GEN-LAST:event_btoBorrActionPerformed

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed

        String campo = null;
        ejecucionBD.sql = "select * from cliente order by codigo_cliente";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaCliente.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select * from cliente where codigo_cliente ='" + campo + "'";
            if (ejecucionBD.ejecutarConsulta()) {
                nuevoCliente = new GUIAgregarCliente(null, true, modeloTable, tablaCliente, ejecucionBD.obtenerObjeto());
                nuevoCliente.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione un Cliente!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btoModActionPerformed

    private void btoMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoMenActionPerformed
//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.clientes.setVisible(false);
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);
    }//GEN-LAST:event_btoMenActionPerformed

    private void btoVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoVisActionPerformed

        reporteCliente reporteCliente = new reporteCliente("Clientes Best Mind Software", "ReporteClientes.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteCliente.abrirPDF();
        }

    }//GEN-LAST:event_btoVisActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAcep;
    private javax.swing.JButton btoBorr;
    private javax.swing.JButton btoMen;
    private javax.swing.JButton btoMod;
    private javax.swing.JButton btoVis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCliente;
    // End of variables declaration//GEN-END:variables
}
