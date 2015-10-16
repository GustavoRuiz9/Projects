package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.reporteDesarrolladores;
import Control.reporteObservaciones;
import Control.transBDSesion;
import Modelo.MiModelo;
import javax.swing.JOptionPane;

/**
 *
 * @author tavo
 */
public class GUIMenuDes extends java.awt.Dialog {

    MiModelo modeloTable;
    public static String desarrollador;

    public GUIMenuDes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        desarrollador = transBDSesion.personalSesion.getCedula();
        setlabelTitulo();
        modeloTable = new MiModelo();
        tablaProy.setModel(modeloTable);

        //consulta de proyectos para el Desarrollador que inicio sesion
//        ejecucionBD.sql = "select proyecto.* from proyecto, personal, entrega, ROLxENT_PER \n"
//                + "where proyecto.codigo_proy = entrega.proyecto and entrega.codigo_entrega = ROLxENT_PER.entrega \n"
//                + "and " + transBDSesion.personalSesion.getCedula() + "= ROLxENT_PER.personal \n"
//                + "group by proyecto.codigo_proy, proyecto.titulo, proyecto.categoria, proyecto.cliente, proyecto.fecha_inicio, \n"
//                + "proyecto.fecha_fin, proyecto.fecha_fin_real, proyecto.valor_estimado, proyecto.valor_total, proyecto.fin,\n"
//                + "proyecto.estado";

        ejecucionBD.sql = "select PROYECTO.titulo as proyecto, ENTREGA.titulo as Entrega, ACTIVIDAD.titulo as Actividad, Actividad.estado, TO_CHAR(ACTIVIDAD.FECHA_INI,'dd/MM/yyyy') as \"FECHA INICIO\", TO_CHAR(ACTIVIDAD.FECHA_FIN,'dd/MM/yyyy') as \"FECHA FIN\"  from PROYECTO,ENTREGA,ACTIVIDAD,ROLxENT_PER\n"
                + "WHERE proyecto.codigo_proy = entrega.proyecto and entrega.codigo_entrega = actividad.entrega and actividad.responsable=" + transBDSesion.personalSesion.getCod_personal() + " and Rolxent_per.entrega = Entrega.codigo_entrega group by Actividad.estado, PROYECTO.titulo, ENTREGA.titulo, ACTIVIDAD.titulo, ACTIVIDAD.FECHA_INI, ACTIVIDAD.FECHA_FIN";

        funcionesComunes.cargarTabla(modeloTable);
        this.setTitle("Sesion Iniciada");

    }

    public void setlabelTitulo() {

        this.labelTitulo.setText("Bienvenido " + transBDSesion.personalSesion.getNombre() + " " + transBDSesion.personalSesion.getApellido());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProy = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaProy.setBackground(new java.awt.Color(0, 153, 153));
        tablaProy.setBorder(new javax.swing.border.MatteBorder(null));
        tablaProy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProy.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablaProy.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tablaProy);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );

        labelTitulo.setText("Bienvenido Predeterminado");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Cerrar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Visualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new GUISesion().setVisible(true);
        GUISesion.nuevoDes.setVisible(false);
        System.out.println("\nSesion = false");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        reporteDesarrolladores reporteDesarrollador = new reporteDesarrolladores("Best Mind Software", "ReporteDesarrollador" + desarrollador + ".pdf");
        int respuesta = JOptionPane.showConfirmDialog(null, "Se ha generado el documento, ¿Desea abrirlo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            reporteDesarrollador.abrirPDF();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tablaProy;
    // End of variables declaration//GEN-END:variables
}
