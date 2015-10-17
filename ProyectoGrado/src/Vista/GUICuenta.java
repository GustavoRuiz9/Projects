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
public class GUICuenta extends java.awt.Dialog {

    MiModelo modeloTable;
    GUIAgregarCuenta nuevaCuenta;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();
    int cont = 0;

    public GUICuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        modeloTable = new MiModelo();
        tablaCuenta.setModel(modeloTable);

        //consulta de proyectos para el Director que inicio sesion
        ejecucionBD.sql = "select personal.nombre as \"PERSONAL\", cuenta.nombre_usuario as \"USUARIO\", "
                + "contrasena as \"CONTRASEÑA\" from cuenta, personal\n"
                + "Where personal.codigo_personal = cuenta.personal order by personal.codigo_personal";

        funcionesComunes.cargarTabla(modeloTable);

        //Sacar la contraseña sin encriptar y ponerla en la tabla
       while (cont < ejecucionBD.cantidadRegistros()) {
            tablaCuenta.setValueAt(tablaCuenta.getValueAt(cont, 2).toString().split("-")[0], cont, 2);
            cont++;
        }
        cont = 0;

        this.setTitle("Cuentas Personal");
        this.setIconImage(logo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuenta = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btoAgre = new javax.swing.JButton();
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
        jLabel1.setText("CUENTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        tablaCuenta.setBackground(new java.awt.Color(0, 153, 153));
        tablaCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCuenta.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaCuenta.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaCuenta);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btoAgre.setText("Agregar");
        btoAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAgreActionPerformed(evt);
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
                .addComponent(btoMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btoMen)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAgre)
                    .addComponent(btoMod)
                    .addComponent(btoMen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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

    private void btoMenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoMenActionPerformed

//        this.setVisible(false);
//        GUISesion.pantallaMenuDirector.setVisible(true);
//        GUIMenuDirector.cuentas.setVisible(false);
        this.dispose();
        new GUIMenuDirector(null, true).setVisible(true);

    }//GEN-LAST:event_btoMenActionPerformed

    private void btoAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAgreActionPerformed

        nuevaCuenta = new GUIAgregarCuenta(null, true, modeloTable, tablaCuenta);
        nuevaCuenta.setVisible(true);

    }//GEN-LAST:event_btoAgreActionPerformed

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed
        String campo = null;
        ejecucionBD.sql = "select * from cuenta order by cuenta.personal";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaCuenta.getSelectedRow());

        if (campo != null) {
            ejecucionBD.sql = "select * from cuenta where personal ='" + campo + "'";
            if (ejecucionBD.ejecutarConsulta()) {
                nuevaCuenta = new GUIAgregarCuenta(null, true, modeloTable, tablaCuenta, ejecucionBD.obtenerObjeto());
                nuevaCuenta.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione una Cuenta!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btoModActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAgre;
    private javax.swing.JButton btoMen;
    private javax.swing.JButton btoMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCuenta;
    // End of variables declaration//GEN-END:variables
}
