package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.Ciudad;
import Modelo.MiModelo;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Tavo
 */
public class GUIAgregarCiudad extends java.awt.Dialog {

    static Ciudad nuevaCiudad = new Ciudad();
    java.util.ArrayList departamento = null;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    Image logo = null;
    String llave = "";

    public GUIAgregarCiudad(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        departamento = new ArrayList();

        funcionesComunes.cargarLista(departamento, comboDep, "departamento", "nombre_depart", "codigo_depart");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Nueva Ciudad");
    }

    public GUIAgregarCiudad(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        departamento = new ArrayList();
        agregar = false;

        funcionesComunes.cargarLista(departamento, comboDep, "departamento", "nombre_depart", "codigo_depart");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
        this.setTitle("Modificar Ciudad");

        llave = registros[0];
        textNombre.setText(registros[1]);
        try {
            ejecucionBD.sql = "select nombre_depart from departamento where codigo_depart = " + registros[2];
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboDep.setSelectedItem(ejecucionBD.result.getString("nombre_depart"));
            } else {
                System.out.println("vacio en departamento");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboDep = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        broAcep = new javax.swing.JButton();
        btoCan = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CIUDAD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Departamento");

        comboDep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        broAcep.setText("Aceptar");
        broAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                broAcepActionPerformed(evt);
            }
        });

        btoCan.setText("Cancelar");
        btoCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(broAcep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btoCan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoCan)
                    .addComponent(broAcep))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btoCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btoCanActionPerformed

    private void broAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_broAcepActionPerformed

        nuevaCiudad.setCodigoCiudad("cod_ciudad.NextVal");

        String nombre = textNombre.getText().trim();
        if (validacionDatos.caracteres(nombre)) {
            nuevaCiudad.setNombreCiudad(nombre);
        } else {
            textNombre.requestFocus();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo Nombre Ciudad Obligatorio");
            } else {
                if (!validacionDatos.caracteres(nombre)) {
                    JOptionPane.showMessageDialog(null, "Campo Nombre Ciudad Invalido");
                }
            }
            return;
        }

        String departamento = comboDep.getSelectedItem().toString();
        if (validacionDatos.campoVacio(departamento)) {
            comboDep.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Departamento Obligatorio");
            return;
        } else {
            nuevaCiudad.setDepartamento(Integer.parseInt(this.departamento.get((comboDep.getSelectedIndex() - 1)).toString()));
        }

        if (agregar) {

            if (ejecucionBD.ejecutarInsert(nuevaCiudad, "Ciudad")) {
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);

                ejecucionBD.sql = "select CIUDAD.codigo_ciudad as \"CODIGO\", CIUDAD.nombre_ciudad as \"CIUDAD\", "
                        + "departamento.nombre_depart as \"DEPARTAMENTO\" \n"
                        + "FROM CIUDAD, DEPARTAMENTO WHERE CIUDAD.departamento = DEPARTAMENTO.codigo_depart order by CIUDAD.codigo_ciudad";


                funcionesComunes.cargarTabla(modeloTabla);
            }
        } else {

            if (ejecucionBD.ejecutarUpdate(nuevaCiudad, "Ciudad", llave)) {
                this.setVisible(false);

                modeloTabla = new MiModelo();
                tabla.setModel(modeloTabla);
                ejecucionBD.sql = "select CIUDAD.codigo_ciudad as \"CODIGO\", CIUDAD.nombre_ciudad as \"CIUDAD\", "
                        + "departamento.nombre_depart as \"DEPARTAMENTO\" \n"
                        + "FROM CIUDAD, DEPARTAMENTO WHERE CIUDAD.departamento = DEPARTAMENTO.codigo_depart order by CIUDAD.codigo_ciudad";

                funcionesComunes.cargarTabla(modeloTabla);

            }

        }
    }//GEN-LAST:event_broAcepActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton broAcep;
    private javax.swing.JButton btoCan;
    private javax.swing.JComboBox comboDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
