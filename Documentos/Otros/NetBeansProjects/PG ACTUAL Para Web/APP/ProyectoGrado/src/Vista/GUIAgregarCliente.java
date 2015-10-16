/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.Cliente;
import Modelo.MiModelo;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Samsung
 */
public class GUIAgregarCliente extends java.awt.Dialog {

    static Cliente nuevoCliente = new Cliente();
    java.util.ArrayList ciudad = null;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    Image logo = null;
    String llave = "";
    String cedula = "";

    public GUIAgregarCliente(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        ciudad = new ArrayList();

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(ciudad, comboCiudad, "ciudad", "nombre_ciudad", "codigo_ciudad");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nuevo Cliente");
    }

    public GUIAgregarCliente(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        ciudad = new ArrayList();
        agregar = false;


        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(ciudad, comboCiudad, "ciudad", "nombre_ciudad", "codigo_ciudad");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Cliente");

        llave = registros[0];
        cedula = registros[1];

//        ejecucionBD.sql = "select * from proyecto where cliente = '" + llave + "'";
//        ejecucionBD.ejecutarConsulta();
//        if (ejecucionBD.cantidadRegistros() > 0) {
//            textCedula.disable();
//        }

        textCedula.setText(registros[1]);
        textNombre.setText(registros[2]);
        textApellido.setText(registros[3]);
        comboSex.setSelectedItem(registros[4]);
        textTel.setText(registros[6]);
        textCorreo.setText(registros[7]);
        textEmpresa.setText(registros[8]);
        textNit.setText(registros[9]);

        try {
            ejecucionBD.sql = "select nombre_ciudad from ciudad where codigo_ciudad = " + registros[5];
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
        textCorreo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        textTel = new javax.swing.JTextField();
        textEmpresa = new javax.swing.JTextField();
        textNit = new javax.swing.JTextField();
        comboCiudad = new javax.swing.JComboBox();
        comboSex = new javax.swing.JComboBox();
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
        labelTitulo.setText("CLIENTE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(150, 150, 150))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel5.setText("Telefono");

        jLabel6.setText("Sexo");

        jLabel7.setText("Correo");

        jLabel8.setText("Empresa");

        jLabel10.setText("Nit");

        jLabel11.setText("Ciudad");
        jLabel11.setToolTipText("");

        comboCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        comboSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Masculino", "Femenino" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textTel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboSex, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textNit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel11))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
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

    private void btonAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonAcepActionPerformed

        if (agregar) {
            ejecucionBD.sql = "select * from cliente where cedula = '" + textCedula.getText().trim() + "'";
            ejecucionBD.ejecutarConsulta();
            if (ejecucionBD.cantidadRegistros() > 0) {
                textCedula.requestFocus();
                JOptionPane.showMessageDialog(null, "Campo Cedula ya existe");
                return;
            }
        } else {
            if (!cedula.equals(textCedula.getText())) {
                ejecucionBD.sql = "select * from cliente where cedula = '" + textCedula.getText().trim() + "'";
                ejecucionBD.ejecutarConsulta();
                if (ejecucionBD.cantidadRegistros() > 0) {
                    textCedula.requestFocus();
                    JOptionPane.showMessageDialog(null, "Campo Cedula ya existe");
                    return;
                }
            }
        }

        nuevoCliente.setCodCliente("cod_cli.NextVal");

        String ced = null;
        try {
            ced = textCedula.getText().trim();
            if (validacionDatos.vrEntero(ced)) {
                nuevoCliente.setCedula(ced);
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
            nuevoCliente.setNombreCli(nom);
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
            nuevoCliente.setApellidoCli(apellido);
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

            if (validacionDatos.validarDatosTelefonicos(tel, 7)) {
                nuevoCliente.setTelefonoCli(tel);
            } else {
                if (tel.isEmpty()) {
                    textTel.requestFocus();
                    JOptionPane.showMessageDialog(null, "Campo Telefono Obligatorio");
                    return;
                } else {
                    textTel.requestFocus();
                    JOptionPane.showMessageDialog(null, "Campo Telefono Invalido");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en campo telefono");
            return;
        }

        String sexo = comboSex.getSelectedItem().toString();
        if (validacionDatos.campoVacio(sexo)) {
            comboSex.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Sexo Obligatorio");
            return;
        } else {
            nuevoCliente.setSexoCli(sexo);
        }

        String correo = textCorreo.getText().trim();
        if (validacionDatos.esEmail(correo)) {
            nuevoCliente.setCorreoCli(correo);
        } else {
            textCorreo.requestFocus();
            if (correo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Correo Obligatorio");
            } else {
                JOptionPane.showMessageDialog(null, "Campo Correo Invalido");
            }
            return;
        }

        String empresa = textEmpresa.getText().trim();
        if (!validacionDatos.vrEntero(empresa)) {
            nuevoCliente.setNom_empresa(empresa);
        } else {
            textEmpresa.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Empresa Invalido");
            return;
        }

        String nit = textNit.getText().trim();
        if (!validacionDatos.campoVacio(nit)) {
            nuevoCliente.setNit_empresa(nit);
        }

        String ciudad = comboCiudad.getSelectedItem().toString();
        if (validacionDatos.campoVacio(ciudad)) {
            comboCiudad.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Ciudad Obligatorio");
            return;
        } else {
            nuevoCliente.setCiudadCli(Integer.parseInt(this.ciudad.get((comboCiudad.getSelectedIndex() - 1)).toString()));
        }


        if (agregar) {

            if (ejecucionBD.ejecutarInsert(nuevoCliente, "cliente")) {
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select codigo_cliente as \"CODIGO\", cedula, nombre, apellido, ciudad.nombre_ciudad as \"CIUDAD\", "
                        + "telefono, correo, nom_empresa as \"EMPRESA\"\n"
                        + "from cliente, ciudad where ciudad.codigo_ciudad = cliente.ciudad order by codigo_cliente";
                funcionesComunes.cargarTabla(modeloTabla);
            }
        } else {

            if (ejecucionBD.ejecutarUpdate(nuevoCliente, "cliente", llave)) { //Se modifica
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select codigo_cliente as \"CODIGO\", cedula, nombre, apellido, ciudad.nombre_ciudad as \"CIUDAD\", "
                        + "telefono, correo, nom_empresa as \"EMPRESA\"\n"
                        + "from cliente, ciudad where ciudad.codigo_ciudad = cliente.ciudad order by codigo_cliente";
                funcionesComunes.cargarTabla(modeloTabla);

            }

        }
    }//GEN-LAST:event_btonAcepActionPerformed

    private void btonCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCanActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btonCanActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btonAcep;
    private javax.swing.JButton btonCan;
    private javax.swing.JComboBox comboCiudad;
    private javax.swing.JComboBox comboSex;
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
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textNit;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTel;
    // End of variables declaration//GEN-END:variables
}
