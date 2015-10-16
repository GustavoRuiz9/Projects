package Vista;

import Control.transBDSesion;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tavo
 */
public class GUIMenuDirector extends java.awt.Dialog {

//    static GUIProyecto Proyectos;
//    static GUIEntrega Entregas;
//    static GUIActividad Actividades;
//    static GUIADesarrolladores Desarrolladores;
//    static GUIRegistrarAEntrega registrarDes;
//    static GUICiudad ciudades;
//    static GUICliente clientes;
//    static GUICuenta cuentas;
    Image logo = new ImageIcon(getClass().getResource("/Imagen/logo_director.png")).getImage();

    public GUIMenuDirector(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        this.setIconImage(logo);
        this.setTitle("Director");

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        setlabelTitulo();
//        setIconImage(logo);
    }

    public void setlabelTitulo() {
        this.lableTitulo.setText(transBDSesion.personalSesion.getNombre().toUpperCase()
                + " " + transBDSesion.personalSesion.getApellido().toUpperCase());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelProy = new javax.swing.JLabel();
        LabelEntrega = new javax.swing.JLabel();
        labelActividades = new javax.swing.JLabel();
        labeDesarro = new javax.swing.JLabel();
        labelDes = new javax.swing.JLabel();
        lableCuenta = new javax.swing.JLabel();
        labelCiudad = new javax.swing.JLabel();
        labelClient = new javax.swing.JLabel();
        lableTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botonCerrar = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelProy.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        labelProy.setForeground(new java.awt.Color(102, 102, 255));
        labelProy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_proyecto.png"))); // NOI18N
        labelProy.setText("Proyectos");
        labelProy.setToolTipText("Visualizar, Agregar, Modificar y Borrar Proyectos");
        labelProy.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        labelProy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelProyMouseClicked(evt);
            }
        });

        LabelEntrega.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        LabelEntrega.setForeground(new java.awt.Color(102, 102, 255));
        LabelEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_entrega.png"))); // NOI18N
        LabelEntrega.setText("Gestion Entregas");
        LabelEntrega.setToolTipText("Visualizar, Agregar, Modificar y Borrar Entregas");
        LabelEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelEntregaMouseClicked(evt);
            }
        });

        labelActividades.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        labelActividades.setForeground(new java.awt.Color(102, 102, 255));
        labelActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_actividad.png"))); // NOI18N
        labelActividades.setText("Gestion Actividades");
        labelActividades.setToolTipText("Visualizar, Agregar, Modificar y Borrar Actividades");
        labelActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelActividadesMouseClicked(evt);
            }
        });

        labeDesarro.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        labeDesarro.setForeground(new java.awt.Color(102, 102, 255));
        labeDesarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_desarrollador.png"))); // NOI18N
        labeDesarro.setText("Gestion Desarrolladores");
        labeDesarro.setToolTipText("Visualizar, Agregar, Modificar y Borrar Desarrolladores");
        labeDesarro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labeDesarroMouseClicked(evt);
            }
        });

        labelDes.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        labelDes.setForeground(new java.awt.Color(102, 102, 255));
        labelDes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_registrar_des_a_entrega.png"))); // NOI18N
        labelDes.setText("Registrar Desarrollador a Entrega");
        labelDes.setToolTipText("Visualizar, Agregar, Modificar y Borrar Desarrolladores de las Entregas");
        labelDes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDesMouseClicked(evt);
            }
        });

        lableCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lableCuenta.setForeground(new java.awt.Color(102, 102, 255));
        lableCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_cuenta.png"))); // NOI18N
        lableCuenta.setText("Gestion Cuentas");
        lableCuenta.setToolTipText("Visualizar, Agregar, Modificar y Borrar Cuentas");
        lableCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lableCuentaMouseClicked(evt);
            }
        });

        labelCiudad.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        labelCiudad.setForeground(new java.awt.Color(102, 102, 255));
        labelCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_ciudad.png"))); // NOI18N
        labelCiudad.setText("Gestion Ciudades");
        labelCiudad.setToolTipText("Visualizar, Agregar, Modificar y Borrar Ciudades");
        labelCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCiudadMouseClicked(evt);
            }
        });

        labelClient.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        labelClient.setForeground(new java.awt.Color(102, 102, 255));
        labelClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_cliente.png"))); // NOI18N
        labelClient.setText("Gestion Clientes");
        labelClient.setToolTipText("Visualizar, Agregar, Modificar y Borrar Clientes");
        labelClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelClientMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelProy, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(labeDesarro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelEntrega)
                        .addGap(43, 43, 43)
                        .addComponent(labelDes))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelActividades)
                            .addComponent(labelCiudad))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lableCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labeDesarro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lableCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelClient))
                .addGap(10, 10, 10))
        );

        lableTitulo.setBackground(new java.awt.Color(102, 102, 255));
        lableTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lableTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lableTitulo.setText("x");
        lableTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCerrar.setBackground(new java.awt.Color(255, 0, 0));
        botonCerrar.setText("Cerrar Sesion");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lableTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lableTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        if ((JOptionPane.showOptionDialog(this, "¿Desea cerrar la app o Cerrar Sesion?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Cerrar App", "Cerrar Sesion"}, "Cerrar")) == 0) {
            System.exit(0);
        } else {
            this.dispose();
            new GUISesion().setVisible(true);
        }

    }//GEN-LAST:event_closeDialog

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed

        this.dispose();
        new GUISesion().setVisible(true);
        System.out.println("\nSesion = false");

    }//GEN-LAST:event_botonCerrarActionPerformed

    private void labelProyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProyMouseClicked


//        GUISesion.pantallaMenuDirector.setVisible(false);
        this.dispose();
        new GUIProyecto(null, true).setVisible(true);

//        Proyectos.setVisible(true);

    }//GEN-LAST:event_labelProyMouseClicked

    private void LabelEntregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelEntregaMouseClicked
//        Entregas = new GUIEntrega(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        Entregas.setVisible(true);
        this.dispose();
        new GUIEntrega(null, true).setVisible(true);
    }//GEN-LAST:event_LabelEntregaMouseClicked

    private void labelActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelActividadesMouseClicked

//        Actividades = new GUIActividad(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        Actividades.setVisible(true);
        this.dispose();
        new GUIActividad(null, true).setVisible(true);

    }//GEN-LAST:event_labelActividadesMouseClicked

    private void labeDesarroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labeDesarroMouseClicked

//        Desarrolladores = new GUIADesarrolladores(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        Desarrolladores.setVisible(true);
        this.dispose();
        new GUIADesarrolladores(null, true).setVisible(true);

    }//GEN-LAST:event_labeDesarroMouseClicked

    private void labelDesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDesMouseClicked

//        registrarDes = new GUIRegistrarAEntrega(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        registrarDes.setVisible(true);
        this.dispose();
        new GUIRegistrarAEntrega(null, true).setVisible(true);

    }//GEN-LAST:event_labelDesMouseClicked

    private void labelCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCiudadMouseClicked

//        ciudades = new GUICiudad(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        ciudades.setVisible(true);
        this.dispose();
        new GUICiudad(null, true).setVisible(true);

    }//GEN-LAST:event_labelCiudadMouseClicked

    private void labelClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelClientMouseClicked
//
//        clientes = new GUICliente(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        clientes.setVisible(true);
        this.dispose();
        new GUICliente(null, true).setVisible(true);

    }//GEN-LAST:event_labelClientMouseClicked

    private void lableCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lableCuentaMouseClicked
//        cuentas = new GUICuenta(null, true);
////        GUISesion.pantallaMenuDirector.setVisible(false);
//        cuentas.setVisible(true);
        this.dispose();
        new GUICuenta(null, true).setVisible(true);
    }//GEN-LAST:event_lableCuentaMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelEntrega;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labeDesarro;
    private javax.swing.JLabel labelActividades;
    private javax.swing.JLabel labelCiudad;
    private javax.swing.JLabel labelClient;
    private javax.swing.JLabel labelDes;
    private javax.swing.JLabel labelProy;
    private javax.swing.JLabel lableCuenta;
    private javax.swing.JLabel lableTitulo;
    // End of variables declaration//GEN-END:variables
}
