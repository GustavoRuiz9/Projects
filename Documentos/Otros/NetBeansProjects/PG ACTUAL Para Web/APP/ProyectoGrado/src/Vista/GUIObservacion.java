/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteObservaciones;
import Modelo.MiModelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author CarlosMito
 */
public class GUIObservacion extends javax.swing.JDialog {

    /**
     * Creates new form GUIObservacion
     */
    GUIAgregarObservaciones observaciones;
    MiModelo modeloTable;
    int contC = 0;
    DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();// Para centar columnas
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana.png")).getImage();
    GUIMenuDirector dial = new GUIMenuDirector(null, rootPaneCheckingEnabled);

    public GUIObservacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setTitle("Nueva Observacion");
        modeloTable = new MiModelo();
        tablaObservacion.setModel(modeloTable);

        ejecucionBD.sql = "select PROYECTO.titulo as \"PROYECTO\", DESCRIPCION as \"DESCRIPCION\",  vr_definitivo as \"VR. DEFINITIVO\""
                + " from observacion, proyecto where observacion.codigo_proy = proyecto.codigo_proy order by observacion.codigo_proy";

        funcionesComunes.cargarTabla(modeloTable);


        this.setTitle("Observaciones");
        this.setIconImage(logo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btoMod = new javax.swing.JButton();
        btoAtras = new javax.swing.JButton();
        btoVisualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaObservacion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("GESTION DE OBSERVACIONES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btoMod.setText("Modificar");
        btoMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoModActionPerformed(evt);
            }
        });

        btoAtras.setText("Atras");
        btoAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAtrasActionPerformed(evt);
            }
        });

        btoVisualizar.setText("Visualizar");
        btoVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btoMod)
                .addGap(80, 80, 80)
                .addComponent(btoVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(btoAtras)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAtras)
                    .addComponent(btoMod)
                    .addComponent(btoVisualizar))
                .addGap(20, 20, 20))
        );

        tablaObservacion.setBackground(new java.awt.Color(0, 153, 153));
        tablaObservacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaObservacion.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaObservacion.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaObservacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoModActionPerformed
        // TODO add your handling code here:

        String campo = null;
        ejecucionBD.sql = "select * from observacion order by observacion.codigo_proy";
        ejecucionBD.ejecutarConsulta();
        campo = ejecucionBD.ubicarCursor(tablaObservacion.getSelectedRow());


        if (campo != null) {
            ejecucionBD.sql = "select * from observacion where codigo_proy =" + campo + "";

            if (ejecucionBD.ejecutarConsulta()) {
                observaciones = new GUIAgregarObservaciones(null, true, modeloTable, tablaObservacion, ejecucionBD.obtenerObjeto());
                observaciones.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de modificar, seleccione una Observación!", "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btoModActionPerformed

    private void btoAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btoAtrasActionPerformed

    private void btoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoVisualizarActionPerformed
        // TODO add your handling code here:
        reporteObservaciones reporteObservacion = new reporteObservaciones("Proyectos Best Mind Software", "ReporteObservaciones.pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteObservacion.abrirPDF();
        }


    }//GEN-LAST:event_btoVisualizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAtras;
    private javax.swing.JButton btoMod;
    private javax.swing.JButton btoVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaObservacion;
    // End of variables declaration//GEN-END:variables
}
