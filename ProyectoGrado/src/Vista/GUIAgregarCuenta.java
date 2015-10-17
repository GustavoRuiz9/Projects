package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.transBDSesion;
import Control.validacionDatos;
import Modelo.MiModelo;
import Modelo.Cuenta;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Tavo
 */
public class GUIAgregarCuenta extends java.awt.Dialog {

    static Cuenta nuevaCuenta = new Cuenta();
    java.util.ArrayList personal = null;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    Image logo = null;
    String llave = "";
    int cont = 0;
    String usua;

    public GUIAgregarCuenta(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        personal = new ArrayList();

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(personal, comboPersonal, "personal ", "nombre", "codigo_personal");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nueva Cuenta");

    }

    public GUIAgregarCuenta(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        personal = new ArrayList();
        agregar = false;

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(personal, comboPersonal, "personal  ", "nombre", "codigo_personal");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Cuenta");

        llave = registros[0];
        textUsu.setText(registros[1]);
        textCont.setText(registros[2].split("-")[0]);
        usua = registros[1];

        try {
            ejecucionBD.sql = "select nombre, apellido from personal where codigo_personal = '" + registros[0] + "'";
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboPersonal.setSelectedItem(ejecucionBD.result.getString("nombre"));
                comboPersonal.setEnabled(false);
                jLabel1.setText("Cuenta " + ejecucionBD.result.getString("nombre") + " " + ejecucionBD.result.getString("apellido"));
                //nombre = ejecucionBD.result.getString("nombre");
            } else {
                System.out.println("nada en personal");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        comboPersonal = new javax.swing.JComboBox();
        textUsu = new javax.swing.JTextField();
        textCont = new javax.swing.JPasswordField();
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
        jLabel1.setText("CUENTA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(129, 129, 129))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Personal");

        jLabel3.setText("Nombre Usuario");

        Contraseña.setText("Contraseña");

        comboPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(Contraseña))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboPersonal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textUsu)
                    .addComponent(textCont, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contraseña)
                    .addComponent(textCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
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
                .addGap(86, 86, 86)
                .addComponent(btoAcep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btoCanc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAcep)
                    .addComponent(btoCanc))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btoAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAcepActionPerformed

        if (agregar) {
            ejecucionBD.sql = "select * from cuenta where nombre_usuario = '" + textUsu.getText().trim() + "'";
            ejecucionBD.ejecutarConsulta();
            if (ejecucionBD.cantidadRegistros() > 0) {
                textUsu.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Nombre Usuario ya existe");
                return;
            }
        } else {
            if (!usua.equals(textUsu.getText())) {
                ejecucionBD.sql = "select * from cuenta where nombre_usuario = '" + textUsu.getText().trim() + "'";
                ejecucionBD.ejecutarConsulta();
                if (ejecucionBD.cantidadRegistros() > 0) {
                    textUsu.requestFocus();
                    JOptionPane.showMessageDialog(null, "Campo Nombre Usuario ya existe");
                    return;
                }
            }
        }


        String pers = comboPersonal.getSelectedItem().toString();
        if (validacionDatos.campoVacio(pers)) {
            comboPersonal.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Persona Vacio");
            return;
        } else {
            nuevaCuenta.setPersonal(this.personal.get((comboPersonal.getSelectedIndex() - 1)).toString());
        }

//        nuevaCuenta.setPersonal(llave);

        String usuario = textUsu.getText().trim();
        if (validacionDatos.validarCantidadCyN(usuario)) {
            nuevaCuenta.setNombre_usua(usuario);
        } else {
            textUsu.requestFocus();
            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Usuario Obligatorio");
            } else {
                if (!validacionDatos.caracteresNumeros(usuario)) {
                    JOptionPane.showMessageDialog(null, "Campo Usuario Invalido");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Usuario Demasiado corto");
                }
            }
            return;
        }

        String contrasena = textCont.getText().trim();
        if (validacionDatos.validarCantidadCyN(contrasena)) {
            contrasena += "-" + transBDSesion.getStringMessageDigest(transBDSesion.getStringMessageDigest(contrasena, transBDSesion.MD2), transBDSesion.MD5);
            nuevaCuenta.setContrasena(contrasena);
        } else {
            textCont.requestFocus();
            if (contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Contrasena Obligatorio");
            } else {
                if (!validacionDatos.caracteresNumeros(contrasena)) {
                    JOptionPane.showMessageDialog(null, "Campo Contrasena Invalido");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Contrasena Demasiado corto");
                }
            }
            return;
        }

        if (agregar) {

            if (ejecucionBD.ejecutarInsert(nuevaCuenta, "Cuenta")) {
                ejecucionBD.ejecutarUpdateEstCuenta(nuevaCuenta.getPersonal());
                this.setVisible(false);

                if (modeloTabla != null) {
                    modeloTabla = new MiModelo();
                    tabla.setModel(modeloTabla);

                    ejecucionBD.sql = "select personal.nombre as \"PERSONAL\", cuenta.nombre_usuario as \"USUARIO\", "
                            + "contrasena as \"CONTRASEÑA\" from cuenta, personal\n"
                            + "Where personal.codigo_personal = cuenta.personal order by personal.codigo_personal";

                    funcionesComunes.cargarTabla(modeloTabla);

                    //Sacar la contraseña sin encriptar y ponerla en la tabla
                    while (cont < ejecucionBD.cantidadRegistros()) {
                        tabla.setValueAt(tabla.getValueAt(cont, 2).toString().split("-")[0], cont, 2);
                        cont++;
                    }
                    cont = 0;
                }

            }

        } else {

            if (ejecucionBD.ejecutarUpdate(nuevaCuenta, "Cuenta", llave)) {
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select personal.nombre as \"PERSONAL\", cuenta.nombre_usuario as \"USUARIO\", "
                        + "contrasena as \"CONTRASEÑA\" from cuenta, personal\n"
                        + "Where personal.codigo_personal = cuenta.personal order by personal.codigo_personal";

                funcionesComunes.cargarTabla(modeloTabla);

                //Sacar la contraseña sin encriptar y ponerla en la tabla
                while (cont < ejecucionBD.cantidadRegistros()) {
                    tabla.setValueAt(tabla.getValueAt(cont, 2).toString().split("-")[0], cont, 2);
                    cont++;
                }
                cont = 0;

            }

        }
    }//GEN-LAST:event_btoAcepActionPerformed
    private void btoCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoCancActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btoCancActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JButton btoAcep;
    private javax.swing.JButton btoCanc;
    private javax.swing.JComboBox comboPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField textCont;
    private javax.swing.JTextField textUsu;
    // End of variables declaration//GEN-END:variables
}
