package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteRegistrarAEnt;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tavo
 */
public class GUIRegistrarAEntrega extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarRegAEnt nuevaAsigEnt;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUIRegistrarAEntrega(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        modeloTable = new MiModelo();
        tablaRolxEnt.setModel(modeloTable);

        //consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                + "from rolxent_per, rol_esp, personal, entrega "
                + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";
        funcionesComunes.cargarTabla(modeloTable);

        this.setTitle("Registrar a Entregas");
        this.setIconImage(logo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRolxEnt = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btoAgre = new javax.swing.JButton();
        btoBorr = new javax.swing.JButton();
        btoMod = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btoSal = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tablaRolxEnt.setBackground(new java.awt.Color(0, 153, 153));
        tablaRolxEnt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaRolxEnt.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaRolxEnt.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaRolxEnt);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DESARROLLADORES EN ENTREGAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btoAgre.setText("Agregar");
        btoAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAgreActionPerformed(evt);
            }
        });
        jPanel4.add(btoAgre, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 22, -1, -1));

        btoBorr.setText("Borrar");
        btoBorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoBorrActionPerformed(evt);
            }
        });
        jPanel4.add(btoBorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 22, -1, -1));

        btoMod.setText("Modificar");
        btoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoModActionPerformed(evt);
            }
        });
        jPanel4.add(btoMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 22, -1, -1));

        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 22, -1, -1));

        btoSal.setText("Menu");
        btoSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoSalActionPerformed(evt);
            }
        });
        jPanel4.add(btoSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        nuevaAsigEnt = new GUIAgregarRegAEnt(null, true, modeloTable, tablaRolxEnt);
        nuevaAsigEnt.setVisible(true);
    }//GEN-LAST:event_btoAgreActionPerformed

    private void btoBorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoBorrActionPerformed

        try {
            String campo = null;
            String campo2 = null;
            String estado = null;
            String nombre = null;

            ejecucionBD.sql = "select rolxent_per.* from rolxent_per order by rolxent_per.personal,rolxent_per.entrega";
            ejecucionBD.ejecutarConsulta();

            campo = ejecucionBD.ubicarCursor(tablaRolxEnt.getSelectedRow());

            if (tablaRolxEnt.getSelectedRow() != -1) {
                nombre = tablaRolxEnt.getValueAt(tablaRolxEnt.getSelectedRow(), 0).toString();
                estado = tablaRolxEnt.getValueAt(tablaRolxEnt.getSelectedRow(), 3).toString();
                campo2 = ejecucionBD.result.getString(3);
            }

            if (campo != null) {

                ejecucionBD.sql = "select estado from rolxent_per where personal ='" + campo + "' and entrega = '" + campo2 + "'";
                ejecucionBD.ejecutarConsulta();

                if (estado.equals("inactivo")) {
                    if (JOptionPane.showConfirmDialog(null, "Desea borrar Asignacion de " + nombre) == 0) {

                        if (ejecucionBD.ejecutarDelete("rolxent_per", campo, "personal", campo2, "entrega")) {

                            ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                                    + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                                    + "from rolxent_per, rol_esp, personal, entrega "
                                    + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                                    + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";

                            modeloTable = new MiModelo();

                            funcionesComunes.cargarTabla(modeloTable);
                            tablaRolxEnt.setModel(modeloTable);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El desarrollador " +nombre+ " tiene asociado actividades por lo tanto esta activo, para poder borrar esta asignación primero borre las responsabilidades que lo atan a la entrega",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione una Entrega!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Error en Borrar Proyecto");
        }

    }//GEN-LAST:event_btoBorrActionPerformed

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed

        String campo = null;
        String campo2 = null;
        ejecucionBD.sql = "select rolxent_per.* from rolxent_per order by rolxent_per.personal,rolxent_per.entrega";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaRolxEnt.getSelectedRow());

        try {
            campo2 = ejecucionBD.result.getString(3);
        } catch (Exception e) {
            System.out.println("Campo2 entregaxper");
        }


        if (campo != null) {
            ejecucionBD.sql = "select personal, estado, entrega, rol from rolxent_per "
                    + "where personal ='" + campo + "' and entrega = '" + campo2 + "' order by rolxent_per.personal,rolxent_per.entrega";
            if (ejecucionBD.ejecutarConsulta()) {
                nuevaAsigEnt = new GUIAgregarRegAEnt(null, true, modeloTable, tablaRolxEnt, ejecucionBD.obtenerObjeto());
                nuevaAsigEnt.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione una Entrega!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btoModActionPerformed

    private void btoSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoSalActionPerformed

//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.registrarDes.setVisible(false);
        
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);
    }//GEN-LAST:event_btoSalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reporteRegistrarAEnt reporteRegistrarAEnt = new reporteRegistrarAEnt("Registros a Entregas Best Mind Software", "ReporteRegistrosAEntregas.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteRegistrarAEnt.abrirPDF();
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
    private javax.swing.JTable tablaRolxEnt;
    // End of variables declaration//GEN-END:variables
}
