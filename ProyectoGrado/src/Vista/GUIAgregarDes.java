/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.MiModelo;
import Modelo.Personal;
import com.toedter.calendar.IDateEditor;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Samsung
 */
public class GUIAgregarDes extends java.awt.Dialog {

    /**
     * Creates new form nuevoDes
     */
    //inicializan los objetos necesarios 
    static Personal nuevoDes = new Personal();
    java.util.ArrayList ciudad = null;
    java.util.ArrayList rol = null;
    IDateEditor focusFecha;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    Image logo = null;
    String llave = "";
    String cedula = "";
    //Cambios
    GUIAgregarCuenta nuevaCuenta;

    public GUIAgregarDes(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        ciudad = new ArrayList();
        rol = new ArrayList();

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(ciudad, comboCiudad, "ciudad", "nombre_ciudad", "codigo_ciudad");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nuevo Desarrollador");

    }

    public GUIAgregarDes(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        ciudad = new ArrayList();
        rol = new ArrayList();
        agregar = false;


        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(ciudad, comboCiudad, "ciudad", "nombre_ciudad", "codigo_ciudad");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Desarrollador");

        llave = registros[0];
        cedula = registros[1];

//        ejecucionBD.sql = "select * from rolxent_per where personal = '" + llave + "'";
//        ejecucionBD.ejecutarConsulta();
//        if (ejecucionBD.cantidadRegistros() > 0) {
//            textCedula.disable();
//        }
//
//        ejecucionBD.sql = "select * from sesion where sesion.personal = '" + llave + "'";
//        ejecucionBD.ejecutarConsulta();
//        if (ejecucionBD.cantidadRegistros() > 0) {
//            textCedula.disable();
//        }

        textCedula.setText(registros[1]);
        textNombre.setText(registros[2]);
        textApellido.setText(registros[3]);
        textTel.setText(registros[4]);
        textCelular.setText(registros[5]);
        textCorreo.setText(registros[6]);
        textEdad.setText(registros[7]);
        textDir.setText(registros[8]);

        try {
            ejecucionBD.sql = "select nombre_ciudad from ciudad where codigo_ciudad = " + registros[9];
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboCiudad.setSelectedItem(ejecucionBD.result.getString("nombre_ciudad"));
            } else {
                System.out.println("nada en ciudad");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textCedula = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textCelular = new javax.swing.JTextField();
        textCorreo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        textTel = new javax.swing.JTextField();
        textEdad = new javax.swing.JTextField();
        textDir = new javax.swing.JTextField();
        comboCiudad = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btonAcep = new javax.swing.JButton();
        btonCan = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTitulo.setText("DESARROLLADORES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(113, 113, 113))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cedula");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 13, -1, -1));

        jLabel2.setText("Nombre");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 42, -1, -1));

        jLabel3.setText("Apellido");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 71, -1, -1));

        jLabel5.setText("Telefono");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 101, -1, 13));

        jLabel6.setText("Celular");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 129, 50, -1));

        jLabel7.setText("Correo");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 158, 50, -1));

        jLabel8.setText("Edad");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 187, 41, -1));
        jPanel3.add(textCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 10, 131, -1));
        jPanel3.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 39, 209, -1));
        jPanel3.add(textCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 126, 132, -1));
        jPanel3.add(textCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 155, 209, -1));

        jLabel10.setText("Direccion");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 216, -1, -1));

        jLabel11.setText("Ciudad");
        jLabel11.setToolTipText("");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 246, -1, -1));
        jPanel3.add(textApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 68, 208, -1));
        jPanel3.add(textTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 97, 132, -1));
        jPanel3.add(textEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 184, 79, -1));
        jPanel3.add(textDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 213, 209, -1));

        comboCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jPanel3.add(comboCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 242, 209, -1));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btonAcep.setText("Aceptar");
        btonAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonAcepActionPerformed(evt);
            }
        });

        btonCan.setText("Cancelar");
        btonCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btonAcep)
                .addGap(18, 18, 18)
                .addComponent(btonCan)
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btonCan)
                    .addComponent(btonAcep))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btonAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonAcepActionPerformed

        // valida los datos que se ingresaron en el formulario y se setean en el obj de tipo proyecto

        //se valida un campo vacio true si lo esta false si no.

        if (agregar) {
            ejecucionBD.sql = "select * from personal where cedula = '" + textCedula.getText().trim() + "'";
            ejecucionBD.ejecutarConsulta();
            if (ejecucionBD.cantidadRegistros() > 0) {
                textCedula.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Cedula ya existe");
                return;
            }
        } else {
            if (!cedula.equals(textCedula.getText())) {
                ejecucionBD.sql = "select * from personal where cedula = '" + textCedula.getText().trim() + "'";
                ejecucionBD.ejecutarConsulta();
                if (ejecucionBD.cantidadRegistros() > 0) {
                    textCedula.requestFocus();
                    JOptionPane.showMessageDialog(null, "Campo Cedula ya existe");
                    return;
                }
            }
        }

        nuevoDes.setCod_personal("cod_per.NextVal");

        String ced = null;
        try {
            ced = textCedula.getText().trim();
            if (validacionDatos.vrEntero(ced)) {
                nuevoDes.setCedula(ced);
            } else {
                textCedula.requestFocus();
                if (ced.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Cedula Obligatorio");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Cedula Invalido");
                }
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo cedula");
            return;
        }

        String nom = textNombre.getText().trim();
        if (validacionDatos.caracteres(nom)) {
            nuevoDes.setNombre(nom);
        } else {
            textNombre.requestFocus();
            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Nombre Obligatorio");
            } else {
                if (!validacionDatos.caracteres(nom)) {
                    JOptionPane.showMessageDialog(null, "Campo Nombre Invalido");
                }
            }
            return;
        }

        String apellido = textApellido.getText().trim();
        if (validacionDatos.caracteres(apellido)) {
            nuevoDes.setApellido(apellido);
        } else {
            textApellido.requestFocus();
            if (apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Apellido Obligatorio");
            } else {
                JOptionPane.showMessageDialog(null, "Campo Apellido Invalido");
            }
            return;
        }

        String tel = null;
        try {
            tel = textTel.getText().trim();
            if (validacionDatos.validarDatosTelefonicos(tel, 7) || validacionDatos.campoVacio(tel)) {
                nuevoDes.setTelefono(tel);
            } else {
                textTel.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Telefono Invalido");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo telefono");
            return;
        }

        String cel = null;
        try {
            cel = textCelular.getText().trim();
            if (validacionDatos.validarDatosTelefonicos(cel, 10)) {
                nuevoDes.setCelular(cel);
            } else {
                textCelular.requestFocus();
                if (cel.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Celular Obligatorio");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Celular Invalido");
                }
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo Celular");
            return;
        }

        String correo = textCorreo.getText().trim();
        if (validacionDatos.esEmail(correo)) {
            nuevoDes.setCorreo(correo);
        } else {
            textCorreo.requestFocus();
            if (correo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Correo Obligatorio");
            } else {
                JOptionPane.showMessageDialog(null, "Campo Correo Invalido");
            }
            return;
        }

        String edad = null;
        try {
            edad = textEdad.getText().trim();
            if (validacionDatos.validarCantidad(edad, 3)) {
                nuevoDes.setEdad(Integer.parseInt(edad));
            } else {
                textEdad.requestFocus();
                if (edad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo Edad Obligatorio");
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Edad Invalido");
                }
                return;
            }
        } catch (Exception e) {
            System.out.println("Error en campo Edad");
            return;
        }

        String dir = textDir.getText().trim();
        if (!validacionDatos.campoVacio(dir)) {
            if (!validacionDatos.vrEntero(dir)) {
                nuevoDes.setDireccion(dir);
            } else {
                textDir.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Direccion Invalido");
                return;
            }
        } else {
            textDir.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Direccion Obligatorio");
            return;
        }

        /*se obtiene la descripcion seleccionada en el combobox y se valida si esta vacia o no la seleccion
         si no lo esta se setea la categoria al obj proy con el valor segun el index escojido en el combobox*/

        String ciudad = comboCiudad.getSelectedItem().toString();
        if (validacionDatos.campoVacio(ciudad)) {
            comboCiudad.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Ciudad Obligatorio");
            return;
        } else {
            nuevoDes.setCodigoCiudad(Integer.parseInt(this.ciudad.get((comboCiudad.getSelectedIndex() - 1)).toString()));
        }

        if (agregar) {

            nuevoDes.setCuentaAct("no");

            if (ejecucionBD.ejecutarInsert(nuevoDes, "personal")) {
                this.setVisible(false);
                
                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular, correo, "
                        + "cuenta_Activa as cuenta from personal where not codigo_personal = 1 order by codigo_personal";
                funcionesComunes.cargarTabla(modeloTabla);

                //Cambios
                nuevaCuenta = new GUIAgregarCuenta(null, true, null, null);
                nuevaCuenta.setVisible(true);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular, correo, "
                        + "cuenta_Activa as cuenta from personal where not codigo_personal = 1 order by codigo_personal";
                funcionesComunes.cargarTabla(modeloTabla);



            }
        } else {

            ejecucionBD.sql = "select * from cuenta where personal = " + llave;
            ejecucionBD.ejecutarConsulta();
            if (ejecucionBD.cantidadRegistros() > 0) {
                nuevoDes.setCuentaAct("si");
            } else {
                nuevoDes.setCuentaAct("no");
            }

            if (ejecucionBD.ejecutarUpdate(nuevoDes, "personal", llave)) { //Se modifica
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select codigo_personal as codigo, cedula, nombre, apellido, celular, correo, "
                        + "cuenta_Activa as cuenta from personal where not codigo_personal = 1 order by codigo_personal";
                funcionesComunes.cargarTabla(modeloTabla);

            }

        }
    }//GEN-LAST:event_btonAcepActionPerformed

    private void btonCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCanActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btonCanActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btonAcep;
    private javax.swing.JButton btonCan;
    private javax.swing.JComboBox comboCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCedula;
    private javax.swing.JTextField textCelular;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textDir;
    private javax.swing.JTextField textEdad;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTel;
    // End of variables declaration//GEN-END:variables
}
