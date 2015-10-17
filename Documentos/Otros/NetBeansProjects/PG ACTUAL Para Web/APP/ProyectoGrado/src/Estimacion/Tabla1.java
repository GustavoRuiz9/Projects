package Estimacion;

import Vista.GUIObservacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public final class Tabla1 extends javax.swing.JDialog {

    public static int c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, pf, porcemas, porcemenos;
    DecimalFormat formateador = new DecimalFormat("####.00");
    JTable tabla;

    public Tabla1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jTable1.setToolTipText("Solo Puede Modificar la Columna 'Cantidad'");

        //Eventos Para al pulsar la tecla ENTER calcule
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        ;
        });
         
        jTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calcular();
                }
            }
        });
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
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0), null, new java.awt.Color(204, 204, 204)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ILF", "10", null, null},
                {"ELF", "7", null, null},
                {"EI", "4", null, null},
                {"EO", "5", null, null},
                {"EQ", "4", null, null},
                {null, null, "PF", null},
                {null, "PF2", "20%", null},
                {null, "PF1", "-20%", null},
                {null, null, null, null}
            },
            new String [] {
                "Elemento", "Peso", "Cantidad", "Total: Cantidad * Peso"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 204, 255), new java.awt.Color(153, 255, 255), null, null));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estimación por Puntos Funcionales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton1.setText("Calcular");

        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTable1.getValueAt(0, 3) != null && jTable1.getValueAt(1, 3) != null
                && jTable1.getValueAt(2, 3) != null && jTable1.getValueAt(4, 3) != null
                && jTable1.getValueAt(5, 3) != null && jTable1.getValueAt(6, 3) != null) {

            this.setVisible(false);
            Tabla2 a = new Tabla2(null, rootPaneCheckingEnabled);
            a.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "No puede Seguir sin antes Calcular o Haber ingresado las cantidades",
                    "Ingrese Cantidad de PF", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        jTable1.setColumnSelectionInterval(0, 2);
        jTable1.setEditingColumn(2);
        jTable1.setSelectionBackground(Color.yellow);
        jTable1.setSelectionForeground(Color.black);

    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solamente Números");
        }

    }//GEN-LAST:event_jTable1KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void calcular() {

        if (jTable1.getValueAt(0, 2) == null) {

            JOptionPane.showMessageDialog(null, "Ingrese Todas Las Cantidades Antes de Calcular",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } else if (jTable1.getValueAt(1, 2) == null) {

            JOptionPane.showMessageDialog(null, "Ingrese Todas Las Cantidades Antes de Calcular",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } else if (jTable1.getValueAt(2, 2) == null) {

            JOptionPane.showMessageDialog(null, "Ingrese Todas Las Cantidades Antes de Calcular",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } else if (jTable1.getValueAt(3, 2) == null) {

            JOptionPane.showMessageDialog(null, "Ingrese Todas Las Cantidades Antes de Calcular",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } else if (jTable1.getValueAt(4, 2) == null) {

            JOptionPane.showMessageDialog(null, "Ingrese Todas Las Cantidades Antes de Calcular",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {


            c1 = Integer.parseInt(jTable1.getValueAt(0, 1) + "");
            c2 = Integer.parseInt(jTable1.getValueAt(0, 2) + "");

            c1 *= c2;
            jTable1.setValueAt(c1, 0, 3);

            c3 = Integer.parseInt(jTable1.getValueAt(1, 1) + "");
            c4 = Integer.parseInt(jTable1.getValueAt(1, 2) + "");

            c3 *= c4;
            jTable1.setValueAt(c3, 1, 3);

            c5 = Integer.parseInt(jTable1.getValueAt(2, 1) + "");
            c6 = Integer.parseInt(jTable1.getValueAt(2, 2) + "");

            c5 *= c6;
            jTable1.setValueAt(c5, 2, 3);

            c7 = Integer.parseInt(jTable1.getValueAt(3, 1) + "");
            c8 = Integer.parseInt(jTable1.getValueAt(3, 2) + "");

            c7 *= c8;
            jTable1.setValueAt(c7, 3, 3);

            c9 = Integer.parseInt(jTable1.getValueAt(4, 1) + "");
            c10 = Integer.parseInt(jTable1.getValueAt(4, 2) + "");

            c9 *= c10;
            jTable1.setValueAt(c9, 4, 3);

            pf = c1 + c3 + c5 + c7 + c9;
            jTable1.setValueAt(pf, 5, 3);

            porcemas = pf * 20 / 100;
            porcemas = pf + porcemas;

            jTable1.setValueAt(porcemas, 6, 3);

            porcemenos = pf * 20 / 100;
            porcemenos = pf - porcemenos;
            jTable1.setValueAt(porcemenos, 7, 3);

        }

    }

    //Solamente Números en JtextField
    public void SoloNumeros(JTable a) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
