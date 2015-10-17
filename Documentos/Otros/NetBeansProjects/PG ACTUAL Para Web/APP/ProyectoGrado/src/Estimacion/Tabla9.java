/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estimacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author CarlosMito
 */
public class Tabla9 extends javax.swing.JDialog {

    public static double calc, calc1, puntf, calc2, calc3, puntf1, calc4, calc5, calc6, calc7, calc8, calc9, calc10, calc11, puntf2, puntf4, puntf5, puntf3;
    public static double calc12, calc13, calc14, calc15, calc16, calc17, calc18, calc19, calc20, calc21, calc22, calc23, calc24, calc25, calc26, calc27, calc28, calc29, calc30, calc31, calc32, calc33;
    public static double sumapf, sumapf2, sumapf1, puntf6, puntf7, puntf8, puntf9, puntf10, puntf11, puntf12, puntf13, puntf14, puntf15, puntf16, puntf17, calc34, calc35;
    DecimalFormat formateador = new DecimalFormat("####.00");
    NumberFormat formato = NumberFormat.getNumberInstance();

    /**
     * Creates new form Tabla9
     */
    public Tabla9(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jTableMaMi.setEnabled(false);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        ;
        });
        
        jTableMaMi.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calcular();

                }
            }
        });
    }

    public void calcular() {

        calc = Double.parseDouble(jTableMaMi.getValueAt(0, 1) + "");
        calc1 = Tabla3.pfd1;
        puntf = calc * calc1 / 100;
        jTableMaMi.setValueAt(formato.format(puntf), 0, 2);

        calc2 = Double.parseDouble(jTableMaMi.getValueAt(0, 1) + "");
        calc3 = Tabla3.pdf;
        puntf1 = calc2 * calc3 / 100;
        jTableMaMi.setValueAt(formato.format(puntf1), 0, 3);

        calc4 = Double.parseDouble(jTableMaMi.getValueAt(0, 1) + "");
        calc5 = Tabla3.pfd2;
        puntf2 = calc4 * calc5 / 100;
        jTableMaMi.setValueAt(formato.format(puntf2), 0, 4);

        calc6 = Double.parseDouble(jTableMaMi.getValueAt(1, 1) + "");
        calc7 = Tabla3.pfd1;
        puntf3 = calc6 * calc7 / 100;
        jTableMaMi.setValueAt(formato.format(puntf3), 1, 2);

        calc8 = Double.parseDouble(jTableMaMi.getValueAt(1, 1) + "");
        calc9 = Tabla3.pdf;
        puntf4 = calc8 * calc9 / 100;
        jTableMaMi.setValueAt(formato.format(puntf4), 1, 3);

        calc10 = Double.parseDouble(jTableMaMi.getValueAt(1, 1) + "");
        calc11 = Tabla3.pfd2;
        puntf5 = calc10 * calc11 / 100;
        jTableMaMi.setValueAt(formato.format(puntf5), 1, 4);

        calc12 = Double.parseDouble(jTableMaMi.getValueAt(2, 1) + "");
        calc13 = Tabla3.pfd1;
        puntf6 = calc12 * calc13 / 100;
        jTableMaMi.setValueAt(formato.format(puntf6), 2, 2);

        calc14 = Double.parseDouble(jTableMaMi.getValueAt(2, 1) + "");
        calc15 = Tabla3.pdf;
        puntf7 = calc14 * calc15 / 100;
        jTableMaMi.setValueAt(formato.format(puntf7), 2, 3);

        calc16 = Double.parseDouble(jTableMaMi.getValueAt(2, 1) + "");
        calc17 = Tabla3.pfd2;
        puntf8 = calc16 * calc17 / 100;
        jTableMaMi.setValueAt(formato.format(puntf8), 2, 4);

        calc18 = Double.parseDouble(jTableMaMi.getValueAt(3, 1) + "");
        calc19 = Tabla3.pfd1;
        puntf9 = calc18 * calc19 / 100;
        jTableMaMi.setValueAt(formato.format(puntf9), 3, 2);

        calc20 = Double.parseDouble(jTableMaMi.getValueAt(3, 1) + "");
        calc21 = Tabla3.pdf;
        puntf10 = calc20 * calc21 / 100;
        jTableMaMi.setValueAt(formato.format(puntf10), 3, 3);

        calc22 = Double.parseDouble(jTableMaMi.getValueAt(3, 1) + "");
        calc23 = Tabla3.pfd2;
        puntf11 = calc22 * calc23 / 100;
        jTableMaMi.setValueAt(formato.format(puntf11), 3, 4);

        calc24 = Double.parseDouble(jTableMaMi.getValueAt(4, 1) + "");
        calc25 = Tabla3.pfd1;
        puntf12 = calc24 * calc25 / 100;
        jTableMaMi.setValueAt(formato.format(puntf12), 4, 2);

        calc26 = Double.parseDouble(jTableMaMi.getValueAt(4, 1) + "");
        calc27 = Tabla3.pdf;
        puntf13 = calc26 * calc27 / 100;
        jTableMaMi.setValueAt(formato.format(puntf13), 4, 3);

        calc28 = Double.parseDouble(jTableMaMi.getValueAt(4, 1) + "");
        calc29 = Tabla3.pfd2;
        puntf14 = calc28 * calc29 / 100;
        jTableMaMi.setValueAt(formato.format(puntf14), 4, 4);

        calc30 = Double.parseDouble(jTableMaMi.getValueAt(5, 1) + "");
        calc31 = Tabla3.pfd1;
        puntf15 = calc30 * calc31 / 100;
        jTableMaMi.setValueAt(formato.format(puntf15), 5, 2);

        calc32 = Double.parseDouble(jTableMaMi.getValueAt(5, 1) + "");
        calc33 = Tabla3.pdf;
        puntf16 = calc32 * calc33 / 100;
        jTableMaMi.setValueAt(formato.format(puntf16), 5, 3);

        calc34 = Double.parseDouble(jTableMaMi.getValueAt(5, 1) + "");
        calc35 = Tabla3.pfd2;
        puntf17 = calc34 * calc35 / 100;
        jTableMaMi.setValueAt(formato.format(puntf17), 5, 4);


        sumapf1 = puntf + puntf3 + puntf6 + puntf9 + puntf12 + puntf15;
        jTableMaMi.setValueAt("$ " + formato.format(sumapf1), 6, 2);
        sumapf = puntf1 + puntf4 + puntf7 + puntf10 + puntf13 + puntf16;
        jTableMaMi.setValueAt("$ " + formato.format(sumapf), 6, 3);
        sumapf2 = puntf2 + puntf5 + puntf8 + puntf11 + puntf14 + puntf17;
        jTableMaMi.setValueAt("$ " + formato.format(sumapf2), 6, 4);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaMi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableMaMi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PLANIFICACION", "9", null, null, null},
                {"ESPECIFICACION", "11", null, null, null},
                {"DISEÑO", "15", null, null, null},
                {"CONSTRUCCION", "43", null, null, null},
                {"PRUEBAS", "16", null, null, null},
                {"IMPLEMENTACION", "6", null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fase", "Porcentaje %", "PF1", "PF", "PF2"
            }
        ));
        jScrollPane1.setViewportView(jTableMaMi);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DURACION X FASE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Calcular");
        jButton1.setToolTipText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         if (jTableMaMi.getValueAt(0, 2) != null || jTableMaMi.getValueAt(1, 2) != null
                || jTableMaMi.getValueAt(2, 2) != null || jTableMaMi.getValueAt(3, 2) != null
                || jTableMaMi.getValueAt(4, 2) != null || jTableMaMi.getValueAt(5, 2) != null
                || jTableMaMi.getValueAt(0, 3) != null || jTableMaMi.getValueAt(1, 3) != null
                || jTableMaMi.getValueAt(2, 3) != null || jTableMaMi.getValueAt(3, 3) != null
                || jTableMaMi.getValueAt(4, 3) != null || jTableMaMi.getValueAt(5, 3) != null
                || jTableMaMi.getValueAt(0, 4) != null || jTableMaMi.getValueAt(1, 4) != null
                || jTableMaMi.getValueAt(2, 4) != null || jTableMaMi.getValueAt(3, 4) != null
                || jTableMaMi.getValueAt(4, 4) != null || jTableMaMi.getValueAt(5, 4) != null) {

            this.setVisible(false);
            Tabla10 a = new Tabla10(null, rootPaneCheckingEnabled);
            a.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "No puede Seguir sin antes Calcular",
                    "Calculo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaMi;
    // End of variables declaration//GEN-END:variables
}
