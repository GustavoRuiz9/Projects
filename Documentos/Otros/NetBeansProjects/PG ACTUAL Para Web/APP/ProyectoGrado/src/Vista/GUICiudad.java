
package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Tavo
 */
public class GUICiudad extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarCiudad nuevaCiudad;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();

    public GUICiudad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        modeloTable = new MiModelo();
        tablaCiudades.setModel(modeloTable);

        //consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select CIUDAD.codigo_ciudad as \"CODIGO\", CIUDAD.nombre_ciudad as \"CIUDAD\", "
                + "departamento.nombre_depart as \"DEPARTAMENTO\" \n"
                + "FROM CIUDAD, DEPARTAMENTO WHERE CIUDAD.departamento = DEPARTAMENTO.codigo_depart order by CIUDAD.codigo_ciudad";

        funcionesComunes.cargarTabla(modeloTable);
        
        this.setTitle("Ciudades");
        this.setIconImage(logo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCiudades = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btoAgre = new javax.swing.JButton();
        btoBorrar = new javax.swing.JButton();
        btoMod = new javax.swing.JButton();
        btoMen = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CIUDADES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tablaCiudades.setBackground(new java.awt.Color(0, 153, 153));
        tablaCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCiudades.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaCiudades.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaCiudades);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btoAgre.setText("Agregar");
        btoAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAgreActionPerformed(evt);
            }
        });

        btoBorrar.setText("Borrar");
        btoBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoBorrarActionPerformed(evt);
            }
        });

        btoMod.setText("Modificar");
        btoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoModActionPerformed(evt);
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btoAgre)
                .addGap(30, 30, 30)
                .addComponent(btoBorrar)
                .addGap(30, 30, 30)
                .addComponent(btoMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                .addComponent(btoMen)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAgre)
                    .addComponent(btoBorrar)
                    .addComponent(btoMod)
                    .addComponent(btoMen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        nuevaCiudad = new GUIAgregarCiudad(null, true, modeloTable, tablaCiudades);
        nuevaCiudad.setVisible(true);

    }//GEN-LAST:event_btoAgreActionPerformed

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed

        String campo = null;
        ejecucionBD.sql = "select * from ciudad order by CIUDAD.codigo_ciudad";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaCiudades.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select CIUDAD.codigo_ciudad as \"CODIGO\", CIUDAD.nombre_ciudad as \"CIUDAD\", "
                    + "departamento.codigo_depart as \"DEPARTAMENTO\" \n"
                    + "FROM CIUDAD, DEPARTAMENTO WHERE CIUDAD.departamento = DEPARTAMENTO.codigo_depart "
                    + "and codigo_ciudad = " + campo;

            if (ejecucionBD.ejecutarConsulta()) {
                nuevaCiudad = new GUIAgregarCiudad(null, true, modeloTable, tablaCiudades, ejecucionBD.obtenerObjeto());
                nuevaCiudad.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione una Ciudad!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btoModActionPerformed

    private void btoMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoMenActionPerformed

//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.ciudades.setVisible(false);
        
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);

    }//GEN-LAST:event_btoMenActionPerformed

    private void btoBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoBorrarActionPerformed

        try {
            String titulo = null;
            String campo = null;
            ejecucionBD.sql = "select * from ciudad order by CIUDAD.codigo_ciudad";
            ejecucionBD.ejecutarConsulta();

            campo = ejecucionBD.ubicarCursor(tablaCiudades.getSelectedRow());

            if (tablaCiudades.getSelectedRow() != -1) {
                titulo = ejecucionBD.result.getString("nombre_ciudad");
            }

            if (campo != null) {

                ejecucionBD.sql = "select * from cliente where ciudad ='" + campo + "'";
                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() == 0) {

                    ejecucionBD.sql = "select * from personal where codigo_ciudad ='" + campo + "'";
                    ejecucionBD.ejecutarConsulta();

                    if (ejecucionBD.cantidadRegistros() == 0) {

                        if (JOptionPane.showConfirmDialog(null, "Desea borrar la Ciudad " + titulo) == 0) {
                            if (ejecucionBD.ejecutarDelete("Ciudad", campo, "codigo_ciudad")) {

                                ejecucionBD.sql = "select CIUDAD.codigo_ciudad as \"CODIGO\", CIUDAD.nombre_ciudad as \"CIUDAD\", "
                                        + "departamento.nombre_depart as \"DEPARTAMENTO\" \n"
                                        + "FROM CIUDAD, DEPARTAMENTO WHERE CIUDAD.departamento = DEPARTAMENTO.codigo_depart order by CIUDAD.codigo_ciudad";

                                modeloTable = new MiModelo();

                                funcionesComunes.cargarTabla(modeloTable);
                                tablaCiudades.setModel(modeloTable);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La ciudad " + titulo + " tiene asociado Desarrolladores, para poder eliminarlo\n"
                                + "primero borre esa relacion",
                                "Alerta", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La ciudad " + titulo + " tiene asociado clientes, para poder eliminarlo\n"
                            + "primero borre esa relacion",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Antes de borrar, seleccione una Ciudad!", "Atencion", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Error en Borrar Ciudad");
        }

    }//GEN-LAST:event_btoBorrarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAgre;
    private javax.swing.JButton btoBorrar;
    private javax.swing.JButton btoMen;
    private javax.swing.JButton btoMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCiudades;
    // End of variables declaration//GEN-END:variables
}
