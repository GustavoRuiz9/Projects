/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estimacion;

import static Estimacion.PARAMETROS_ESTIMACION_DURACION.strResultado2;
import Vista.GUIObservacion;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author CarlosMito
 */
public class PARAMETROS_ESTIMACION_ESFUERZO extends javax.swing.JDialog {

    public static Double strResultado1 = 0.0, strResultado3 = 0.0;
    public static TableModel tablaModelo;

    /**
     * Creates new form PARAMETROS_ESTIMACION_ESFUERZO
     */
    public PARAMETROS_ESTIMACION_ESFUERZO(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jTable1.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "MF", "49.02", "0.736"},
                {"2", "MR ", "78.88", "0.646"},
                {"3", "PC", "48.9", "0.661"},
                {"4", "Multi", "16.01", "0.865"},
                {"5", "3GL", "54.65", "0.717"},
                {"6", "4GL", "29.5", "0.759"},
                {"7", "GenAp", "68.11", "0.66"},
                {"8", "Mantenimiento", "52.58", "0.683"},
                {"9", "Nuevo", "39.05", "0.731"},
                {"10", "MF-3GL", "65.37", "0.705"},
                {"11", "MF-4GL", "52.09", "0.64"},
                {"12", "MF-GenAp", "65.68", "0.692"},
                {"13", "MR-3GL", "126.3", "0.565"},
                {"14", "MR-4GL", "62.53", "0.694"},
                {"15", "PC-3GL", "60.46", "0.648"},
                {"16", "PC-4GL", "36.48", "0.694"},
                {"17", "Multi 3GL", "19.82", "0.666"},
                {"18", "Multi 4GL", "6.49", "0.983"},
                {"19", "MF-3GL-Mantenimiento", "83.27", "0.65"},
                {"20", "MF-3GL-Nuevo", "59.21", "0.745"},
                {"21", "MF-4GL-Mantenimiento", "69.37", "0.538"},
                {"22", "MF-4GL-Nuevo", "102.8", "0.546"},
                {"23", "MF-GenAp-Nuevo", "65.68", "0.692"},
                {"24", "MR-3GL-Mantenimiento", "123.2", "0.585"},
                {"25", "MR-3GL-Nuevo", "81.36", "0.623"},
                {"26", "MR-4GL-Mantenimiento", "96.31", "0.616"},
                {"27", "PC-3GL-Mantenimiento", "83.66", "0.528"},
                {"28", "PC-3GL-Nuevo", "48.6", "0.699"},
                {"29", "PC-4GL-Mantenimiento", "29.84", "0.731"},
                {"30", "PC-4GL-Nuevo", "42.58", "0.668"},
                {"31", "Multi-3GL-Mantenimiento", "5.05", "1.135"},
                {"32", "Multi-3GL-Nuevo", "58.16", "0.664"},
                {"33", "Multi-4GL-Mantenimiento", "115.8", "0.45"}
            },
            new String [] {
                "Nº", "Caracteristica", "C", "E"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PARAMETROS ESTIMACION ESFUERZO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(23, 23, 23))
        );

        jButton1.setText("C");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("E");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(129, 129, 129)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(678, 678, 678))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        verificarDatos();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        verificarDatos2();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        
            
            
        int row = jTable1.rowAtPoint(evt.getPoint());

        int col = jTable1.columnAtPoint(evt.getPoint());
        int row2=0,row1=0,col2=0,col1=0;

        if (col == 0) {
            row2 = jTable1.rowAtPoint(evt.getPoint());

            col2 = jTable1.columnAtPoint(evt.getPoint()) + 2;
            strResultado2 = Double.parseDouble(jTable1.getValueAt(row2, col2).toString());
            Tabla2.tablaModelo1.setValueAt(strResultado2, 0, 0);

            row1 = jTable1.rowAtPoint(evt.getPoint());

            col1 = jTable1.columnAtPoint(evt.getPoint()) + 3;

            strResultado2 = Double.parseDouble(jTable1.getValueAt(row1, col1).toString());
            Tabla2.tablaModelo1.setValueAt(strResultado2, 0, 1);
            Tabla2.tablaModelo2.setValueAt("", 0, 1);
            Tabla2.tablaModelo2.setValueAt("", 1, 1);
            Tabla2.tablaModelo2.setValueAt("", 2, 1);

        } else if (col == 1) {
            row2 = jTable1.rowAtPoint(evt.getPoint());
            col2 = jTable1.columnAtPoint(evt.getPoint()) + 1;
            strResultado2 = Double.parseDouble(jTable1.getValueAt(row2, col2).toString());
            Tabla2.tablaModelo1.setValueAt(strResultado2, 0, 0);
            
            row1 = jTable1.rowAtPoint(evt.getPoint());

            col1 = jTable1.columnAtPoint(evt.getPoint()) + 2;

            strResultado2 = Double.parseDouble(jTable1.getValueAt(row1, col1).toString());
            Tabla2.tablaModelo1.setValueAt(strResultado2, 0, 1);
            Tabla2.tablaModelo2.setValueAt("", 0, 1);
            Tabla2.tablaModelo2.setValueAt("", 1, 1);
            Tabla2.tablaModelo2.setValueAt("", 2, 1);
        } else if (col == 2) {
             row2 = jTable1.rowAtPoint(evt.getPoint());
             col2 = jTable1.columnAtPoint(evt.getPoint());
            strResultado2 = Double.parseDouble(jTable1.getValueAt(row2, col2).toString());
            Tabla2.tablaModelo1.setValueAt(strResultado2, 0, 0);
            
             row1 = jTable1.rowAtPoint(evt.getPoint());

             col1 = jTable1.columnAtPoint(evt.getPoint()) + 1;

            strResultado2 = Double.parseDouble(jTable1.getValueAt(row1, col1).toString());
            Tabla2.tablaModelo1.setValueAt(strResultado2, 0, 1);
            Tabla2.tablaModelo2.setValueAt("", 0, 1);
            Tabla2.tablaModelo2.setValueAt("", 1, 1);
            Tabla2.tablaModelo2.setValueAt("", 2, 1);
        }

        JLabel customFontText = new JLabel();
        customFontText.setFont(new Font("Calibri", Font.BOLD, 15));
        customFontText.setText(" Los Valores Seleccionados Fueron : " + " En  'C' " + jTable1.getValueAt(row2, col2).toString()
                + " En 'E' " + jTable1.getValueAt(row1, col1).toString());
        
        JOptionPane.showMessageDialog(null, customFontText,
                "Valores", JOptionPane.INFORMATION_MESSAGE);


        dispose();
        
    }//GEN-LAST:event_jTable1MouseClicked

    public void verificarDatos() {


        tablaModelo = (TableModel) jTable1.getModel();

        boolean avanzar = true;

        int fila, columna;
        fila = jTable1.getSelectedRow();
        columna = jTable1.getSelectedColumn();

        if (fila == -1) {
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            strResultado1 = Double.parseDouble(tablaModelo.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString());
            JOptionPane.showMessageDialog(null, "Dato seleccionado : " + strResultado1);
            System.out.println("Dato 1 " + strResultado1);
            Tabla2.tablaModelo1.setValueAt(strResultado1, 0, 0);


        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");
        }



    }

    public void verificarDatos2() {

//        TableModel tablaModelo; 
        tablaModelo = (TableModel) jTable1.getModel();

        boolean avanzar = true;

        int fila, columna;
        fila = jTable1.getSelectedRow();
        columna = jTable1.getSelectedColumn();

        if (fila == -1) {
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            strResultado3 = Double.parseDouble(tablaModelo.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString());
            JOptionPane.showMessageDialog(null, "Dato seleccionado : " + strResultado3);
            Tabla2.tablaModelo1.setValueAt(strResultado3, 0, 1);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");
        }



    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
