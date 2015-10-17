package Vista;

import Control.ejecucionBD;
import Control.transBDSesion;
import Control.validacionDatos;
import java.awt.Color;
//import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author tavo
 */
public class GUISesion extends JFrame {

//    public static GUISesion Sesion;
//    static GUIMenuDirector pantallaMenuDirector;
    static GUIMenuDes nuevoDes;
//    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_sesion.png")).getImage();

    public GUISesion() {
        initComponents();
//        setIconImage(logo);
        setTitle("Iniciar Sesion");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        System.out.println(ejecucionBD.conectarOracle());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textContras = new javax.swing.JPasswordField();
        textUsuario = new javax.swing.JTextField();
        labelMsj = new javax.swing.JLabel();
        botonOk = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(182, 182, 182));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("*Usuario");

        jLabel2.setText("*Contraseña");

        textContras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textContrasActionPerformed(evt);
            }
        });

        textUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        textUsuario.setFocusCycleRoot(true);
        textUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textUsuarioMouseClicked(evt);
            }
        });

        labelMsj.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        labelMsj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMsj.setText("(*)Obligatorio");
        labelMsj.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelMsj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textContras, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labelMsj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textContras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMsj)
                .addGap(6, 6, 6))
        );

        botonOk.setBackground(botonOk.getBackground());
        botonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/entrar.png"))); // NOI18N
        botonOk.setBorderPainted(false);
        botonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOkActionPerformed(evt);
            }
        });

        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/salir.png"))); // NOI18N
        botonSalir.setBorderPainted(false);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textUsuarioMouseClicked
        textUsuario.selectAll();
    }//GEN-LAST:event_textUsuarioMouseClicked

    private void botonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOkActionPerformed

        String usuario = textUsuario.getText();
        String contras = textContras.getText();
        labelMsj.setText("(*)Obligatorio");
        labelMsj.setForeground(Color.BLACK);

        if (!(validacionDatos.campoVacio(usuario)) && !(validacionDatos.campoVacio(contras))) {

            ejecucionBD.sql = "select * from cuenta where NOMBRE_USUARIO = '" + usuario
                    + "' and CONTRASENA = '" + textContras.getText() + "-"
                    + transBDSesion.getStringMessageDigest(transBDSesion.getStringMessageDigest(contras, transBDSesion.MD2), transBDSesion.MD5) + "'";

            ejecucionBD.ejecutarConsulta();

            if (transBDSesion.existeUser()) {

                textUsuario.setText("");
                textContras.setText("");

//                System.out.println("Sesion " + usuario + " = true");

                consultarRol();

            } else {
                System.out.println("Sesion " + usuario + " = false");
                labelMsj.setText("User o Pass Incorrecto");
            }

        } else {

            labelMsj.setForeground(Color.red);

            if (validacionDatos.campoVacio(textUsuario.getText())) {
                labelMsj.setText("Campo Usuario Vacio");
                textUsuario.requestFocus();
            } else {
                labelMsj.setText("Campo Contrasena Vacio");
                textContras.requestFocus();
            }
        }

    }//GEN-LAST:event_botonOkActionPerformed

    //Metodo encargado de mostrar la pantalla segun el Rol que inicio sesion
    public void consultarRol() {
        try {

            if (transBDSesion.validarRolDirector().equals("1")) {

                System.out.println("Rol = Director");
//                pantallaMenuDirector = new GUIMenuDirector(this, rootPaneCheckingEnabled);
                this.dispose();
                new GUIMenuDirector(this, true).setVisible(true);

//                pantallaMenuDirector.setVisible(true);

            } else {
                System.out.println("Rol = Desarrollador");
                nuevoDes = new GUIMenuDes(this, rootPaneCheckingEnabled);

                this.dispose();
                nuevoDes.setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(" Error en obtener Rol = " + e.getMessage());
        }

    }

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed

        ejecucionBD.desconectarBD();
        System.exit(0);

    }//GEN-LAST:event_botonSalirActionPerformed

    private void textContrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textContrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textContrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUISesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUISesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUISesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUISesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUISesion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonOk;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelMsj;
    private javax.swing.JPasswordField textContras;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
