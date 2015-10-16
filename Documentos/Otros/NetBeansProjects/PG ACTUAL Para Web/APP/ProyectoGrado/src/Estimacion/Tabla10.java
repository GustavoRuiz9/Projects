/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estimacion;

import Control.reporteEstimacion;
import Control.reporteProyectos;
import Vista.GUIAgregarProyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class Tabla10 extends javax.swing.JDialog {

    public static BigDecimal calc, calc1, puntf, calc2, calc3, puntf1, calc4, calc5, calc6, calc7, calc8, calc9, calc10, calc11, puntf2, puntf4, puntf5, puntf3;
    public static BigDecimal calc12, calc13, calc14, calc15, calc16, calc17, calc18, calc19, calc20, calc21, calc22, calc23, calc24, calc25, calc26, calc27, calc28, calc29, calc30, calc31, calc32, calc33;
    public static BigDecimal puntf6, puntf7, puntf8, puntf9, puntf10, puntf11, puntf12, puntf13, puntf14, puntf15, puntf16, puntf17, calc34, calc35, pf1suma, pfsuma, pf2suma;
    DecimalFormat formateador = new DecimalFormat("####.00");
    NumberFormat formato = NumberFormat.getNumberInstance();
    public static TableModel tablaModelo;
    public static Double strResultado2 = 0.0;
    public static BigDecimal cien = new BigDecimal(100);

    public Tabla10(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setIconImage(null);
        jTableMaMitA.setEnabled(false);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        ;
        });
        
        jTableMaMitA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calcular();
                }
            }
        });
    }

    public void calcular() {

        calc = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(0, 1) + ""));
        calc1 = Tabla5.v1;
        puntf = calc.multiply(calc1).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf), 0, 2);

        calc2 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(0, 1) + ""));
        calc3 = Tabla5.v2;
        puntf1 = calc2.multiply(calc3).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf1), 0, 3);

        calc4 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(0, 1) + ""));
        calc5 = Tabla5.v3;
        puntf2 = calc4.multiply(calc5).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf2), 0, 4);

        calc6 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(1, 1) + ""));
        calc7 = Tabla5.v1;
        puntf3 = calc6.multiply(calc7).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf3), 1, 2);

        calc8 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(1, 1) + ""));
        calc9 = Tabla5.v2;
        puntf4 = calc8.multiply(calc9).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf4), 1, 3);

        calc10 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(1, 1) + ""));
        calc11 = Tabla5.v3;
        puntf5 = calc10.multiply(calc11).divide(cien);

        jTableMaMitA.setValueAt(formato.format(puntf5), 1, 4);

        calc12 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(2, 1) + ""));
        calc13 = Tabla5.v1;
        puntf6 = calc12.multiply(calc13).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf6), 2, 2);

        calc14 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(2, 1) + ""));
        calc15 = Tabla5.v2;
        puntf7 = calc14.multiply(calc15).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf7), 2, 3);

        calc16 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(2, 1) + ""));
        calc17 = Tabla5.v3;
        puntf8 = calc16.multiply(calc17).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf8), 2, 4);

        calc18 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(3, 1) + ""));
        calc19 = Tabla5.v1;
        puntf9 = calc18.multiply(calc19).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf9), 3, 2);

        calc20 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(3, 1) + ""));
        calc21 = Tabla5.v2;
        puntf10 = calc20.multiply(calc21).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf10), 3, 3);

        calc22 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(3, 1) + ""));
        calc23 = Tabla5.v3;
        puntf11 = calc22.multiply(calc23).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf11), 3, 4);

        calc24 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(4, 1) + ""));
        calc25 = Tabla5.v1;
        puntf12 = calc24.multiply(calc25).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf12), 4, 2);

        calc26 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(4, 1) + ""));
        calc27 = Tabla5.v2;
        puntf13 = calc26.multiply(calc27).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf13), 4, 3);

        calc28 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(4, 1) + ""));
        calc29 = Tabla5.v3;
        puntf14 = calc28.multiply(calc29).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf14), 4, 4);

        calc30 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(5, 1) + ""));
        calc31 = Tabla5.v1;
        puntf15 = calc30.multiply(calc31).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf15), 5, 2);

        calc32 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(5, 1) + ""));
        calc33 = Tabla5.v2;
        puntf16 = calc32.multiply(calc33).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf16), 5, 3);

        calc34 = new BigDecimal(Double.parseDouble(jTableMaMitA.getValueAt(5, 1) + ""));
        calc35 = Tabla5.v3;
        puntf17 = calc34.multiply(calc35).divide(cien);
        jTableMaMitA.setValueAt(formato.format(puntf17), 5, 4);


        pf1suma = puntf.add(puntf3).add(puntf6).add(puntf9).add(puntf12).add(puntf15);
//        jTableMaMitA.setValueAt( "$ "+formato.format(pf1suma), 6, 2);
        pfsuma = puntf1.add(puntf4).add(puntf7).add(puntf10).add(puntf13).add(puntf16);
//        jTableMaMitA.setValueAt( "$ "+formato.format(pfsuma), 6, 3);
        pf2suma = puntf2.add(puntf5).add(puntf8).add(puntf11).add(puntf14).add(puntf17);
//        jTableMaMitA.setValueAt( "$ "+formato.format(pf2suma), 6, 4);

        jLabel3.setText(formato.format(pf1suma));
        jLabel4.setText(formato.format(pfsuma));
        jLabel5.setText(formato.format(pf2suma));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaMitA = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableMaMitA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PLANIFICACION", "9", null, null, null},
                {"ESPECIFICACION", "11", null, null, null},
                {"DISEÑO", "15", null, null, null},
                {"CONSTRUCCION", "43", null, null, null},
                {"PRUEBAS", "16", null, null, null},
                {"IMPLEMENTACION", "6", null, null, null}
            },
            new String [] {
                "Fase", "Porcentaje %", "PF1", "PF", "PF2"
            }
        ));
        jScrollPane1.setViewportView(jTableMaMitA);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COSTE X FASE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(213, 213, 213))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jButton1.setText("Calcular");
        jButton1.setToolTipText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.setToolTipText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("TOTAL");

        jLabel3.setText("$");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("$");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setText("$");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton5)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Tabla9 a = new Tabla9(null, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static String obtnerValor(String vrcon) {
        String valores[] = vrcon.split(",");
        String vrsin = valores[0].replace(".", "");
//        System.out.println(jLabel3.getText().split(","));
        return vrsin;
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked



        GUIAgregarProyecto.jtexto.setText(obtnerValor(jLabel3.getText()));
        GUIAgregarProyecto.jtexto2.setText(obtnerValor(jLabel3.getText()));
        GUIAgregarProyecto.jlabel15.setText(obtnerValor(jLabel3.getText()));
        GUIAgregarProyecto.jlabel14.setText(obtnerValor(jLabel4.getText()));
        GUIAgregarProyecto.jlabel13.setText(obtnerValor(jLabel5.getText()));
        GUIAgregarProyecto.numdess.setText(Tabla4.personas2+"");

        dispose();

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        GUIAgregarProyecto.jtexto.setText(obtnerValor(jLabel4.getText()));
        GUIAgregarProyecto.jtexto2.setText(obtnerValor(jLabel4.getText()));
        GUIAgregarProyecto.jlabel15.setText(obtnerValor(jLabel3.getText()));
        GUIAgregarProyecto.jlabel14.setText(obtnerValor(jLabel4.getText()));
        GUIAgregarProyecto.jlabel13.setText(obtnerValor(jLabel5.getText()));
        GUIAgregarProyecto.numdess.setText(Tabla4.personas2+"");

        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:

        GUIAgregarProyecto.jtexto.setText(obtnerValor(jLabel5.getText()));
        GUIAgregarProyecto.jtexto2.setText(obtnerValor(jLabel5.getText()));
        GUIAgregarProyecto.jlabel15.setText(obtnerValor(jLabel3.getText()));
        GUIAgregarProyecto.jlabel14.setText(obtnerValor(jLabel4.getText()));
        GUIAgregarProyecto.jlabel13.setText(obtnerValor(jLabel5.getText()));
        GUIAgregarProyecto.numdess.setText(Tabla4.personas2+"");

        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void verificarDatos3() {


//        TableModel tablaModelo; 
        tablaModelo = (TableModel) jTableMaMitA.getModel();

        boolean avanzar = true;

        int fila, columna;
        fila = jTableMaMitA.getSelectedRow();
        columna = jTableMaMitA.getSelectedColumn();

        if (fila == -1) {
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            tablaModelo.getValueAt(jTableMaMitA.getSelectedRow(), jTableMaMitA.getSelectedColumn()).toString();
            JOptionPane.showMessageDialog(null, "Dato seleccionado : " + tablaModelo.getValueAt(jTableMaMitA.getSelectedRow(), jTableMaMitA.getSelectedColumn()).toString());
            GUIAgregarProyecto.jtexto.setText(tablaModelo.getValueAt(jTableMaMitA.getSelectedRow(), jTableMaMitA.getSelectedColumn()).toString() + "");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");
        }



    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaMitA;
    // End of variables declaration//GEN-END:variables
}
