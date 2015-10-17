/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.MiModelo;
import java.awt.Image;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author CarlosMito
 */
public class GUIAgregarObservaciones extends javax.swing.JDialog {

    static Modelo.Observaciones nuevaObs = new Modelo.Observaciones();
    boolean agregar = true;
    MiModelo modeloTabla;
    JTable tabla;
    Image logo = null;
    String llave = null;
    NumberFormat a = NumberFormat.getNumberInstance();
    public static String codigoproy;
    public static JTextField textcodigo = new JTextField();
    public static JTextField textvrdefinitivo = new JTextField();

    /**
     * Creates new form GUIAgregarObservaciones
     */
    public GUIAgregarObservaciones(java.awt.Frame parent, boolean modal, String codigo) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(0);
        setTitle("Observacion");
        codigoproy = codigo;
        textProyecto.setEditable(false);
        textDefinitivo.setEditable(false);
        textDefinitivo.setText(GUIAgregarProyecto.jtexto2.getText());
        try {
            ejecucionBD.sql = "select titulo from proyecto where codigo_proy ='" + codigo + "'";
            ejecucionBD.ejecutarConsulta();
            String codigo1 = ejecucionBD.result.getString(1);
            textProyecto.setText(codigo1);
        } catch (Exception e) {
            System.out.println("Error al tratar de poner el titulo en observacion" + e.getMessage());
        }

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setIconImage(logo);
    }

    public GUIAgregarObservaciones(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();
        textProyecto.setEditable(false);
        textDefinitivo.setEditable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        agregar = false;
        textProyecto.setEditable(false);
        textDefinitivo.setEditable(false);

        //se cargan los arrays y las listas desplegables en un array y en el combobox


        llave = registros[0];
        try {
            ejecucionBD.sql = "select titulo from proyecto where codigo_proy = " + registros[0];

            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                textProyecto.setText(ejecucionBD.result.getString("titulo").trim());
            } else {
                System.out.println("nada en Observaciones");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar" + e.getMessage());
        }
        textDescripcion.setText(registros[1].trim());
        textDefinitivo.setText(registros[2]);

        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setIconImage(logo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        textDefinitivo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btoAceptar = new javax.swing.JButton();
        textProyecto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Observaciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(193, 193, 193))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Proyecto");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descripcion");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Vr. Definitivo");

        textDescripcion.setColumns(20);
        textDescripcion.setRows(5);
        jScrollPane1.setViewportView(textDescripcion);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btoAceptar.setText("Aceptar");
        btoAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btoAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btoAceptar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(textDefinitivo)
                    .addComponent(textProyecto))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textDefinitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAceptarActionPerformed
        // TODO add your handling code here:

        try {
            nuevaObs.setCodigo_proy(codigoproy);
        } catch (Exception e) {
            if (textProyecto.getText().trim().equals("")) {
                textProyecto.setText("");
                //jTextField2.requestFocus();
            } else {
                textProyecto.requestFocus();
                return;
            }
        }

        String desc = textDescripcion.getText().trim();
        if (!validacionDatos.caracteresNumeros(desc)) {
            textDescripcion.requestFocus();
            if (validacionDatos.campoVacio(desc)) {
                JOptionPane.showMessageDialog(null, "Campo Vacio", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Campo Descripcion Invalido, solo numeros y letras", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        } else {
            nuevaObs.setDescripcion(desc);
        }



        try {
            Double vrd = Double.parseDouble(textDefinitivo.getText().trim());
            nuevaObs.setVr_definitivo(vrd);
            GUIAgregarProyecto.jtexto2.setText(vrd + "");
        } catch (Exception e) {
            if (textDefinitivo.getText().trim().equals("")) {
                textDefinitivo.setText("");
            } else {
                textDefinitivo.requestFocus();
                return;
            }

        }

        if (agregar) {

            if (ejecucionBD.ejecutarInsert(nuevaObs, "observacion")) {
                this.setVisible(false);

            }
        } else {

            if (ejecucionBD.ejecutarUpdate(nuevaObs, "observacion", llave)) {
                this.setVisible(false);

                if (this.tabla != null) {
                    modeloTabla = new MiModelo();
                    tabla.setModel(modeloTabla);

                    ejecucionBD.sql = "select PROYECTO.titulo as \"PROYECTO\", DESCRIPCION as \"DESCRIPCION\",  vr_definitivo as \"VR. DEFINITIVO\""
                            + " from observacion, proyecto where observacion.codigo_proy = proyecto.codigo_proy order by observacion.codigo_proy";

                    funcionesComunes.cargarTabla(modeloTabla);
                }
            }
        }


    }//GEN-LAST:event_btoAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAceptar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textDefinitivo;
    private javax.swing.JTextArea textDescripcion;
    private javax.swing.JTextField textProyecto;
    // End of variables declaration//GEN-END:variables
}
