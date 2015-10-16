package Vista;

import Control.ejecucionBD;
import Control.funcionesComunes;
import Control.validacionDatos;
import Modelo.Rol_Ent_Per;
import Modelo.MiModelo;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Samsung
 */
public class GUIAgregarRegAEnt extends java.awt.Dialog {

    //inicializan los objetos necesarios 
    static Rol_Ent_Per nuevaAsigEnt = new Rol_Ent_Per();
    java.util.ArrayList personal = null;
    java.util.ArrayList entregas = null;
    java.util.ArrayList roles = null;
    java.util.ArrayList proyectos = null;
    MiModelo modeloTabla;
    JTable tabla;
    boolean agregar = true;
    String entregaMod;
    String nombre;
    String estado;
    String cod_per;
    String tituloEnt;
    int codigoProy;
    int cantPersProy;
    int cantPersVan;
    Image logo = null;

    public GUIAgregarRegAEnt(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla) {
        super(parent, modal);
        initComponents();

        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        personal = new ArrayList();
        entregas = new ArrayList();
        roles = new ArrayList();
        proyectos = new ArrayList();
        comboEstado.setEnabled(false);

        //se cargan los arrays y las listas desplegables en un array y en el combobox
        funcionesComunes.cargarLista(roles, comboRol, "rol_esp", "nombre_rol", "codigo_rol");
        funcionesComunes.cargarLista(proyectos, comboProy, "proyecto ", "titulo", "codigo_proy");

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_agregar.png")).getImage();
        this.setTitle("Ingresar Registro a Entrega");
        this.setIconImage(logo);
    }

    public GUIAgregarRegAEnt(java.awt.Frame parent, boolean modal, MiModelo modeloTabla, JTable tabla, String registros[]) {
        super(parent, modal);
        initComponents();
        logo = new ImageIcon(getClass().getResource("/Imagen/logo_ventana_modificar.png")).getImage();
        this.setTitle("Modificar Registro a Entrega");
        this.setIconImage(logo);
        this.modeloTabla = modeloTabla;
        this.tabla = tabla;
        personal = new ArrayList();
        entregas = new ArrayList();
        roles = new ArrayList();
        proyectos = new ArrayList();
        comboEstado.setEnabled(false);
        agregar = false;
        cod_per = registros[0];

        //se cargan los arrays y las listas desplegables en un array y en el combobox

        funcionesComunes.cargarLista(proyectos, comboProy, "proyecto ", "titulo", "codigo_proy");
        funcionesComunes.cargarLista(roles, comboRol, "rol_esp", "nombre_rol", "codigo_rol");

        this.setLocationRelativeTo(null);
        this.setResizable(false);


        entregaMod = registros[2];

        ejecucionBD.sql = "select proyecto.titulo from proyecto where "
                + "proyecto.codigo_proy = (select entrega.proyecto from entrega where "
                + "entrega.codigo_entrega = " + registros[2] + ")";
        ejecucionBD.ejecutarConsulta();

        try {
            comboProy.setSelectedItem(ejecucionBD.result.getString(1));
        } catch (Exception e) {
            System.out.println("Error en el constructor de modificar GUIAgrRegEnt");
        }

        if (registros[1].equalsIgnoreCase("activo")) {
            comboPers.setEnabled(false);
        }
        comboEnt.setEnabled(false);
        comboProy.setEnabled(false);

        try {
            ejecucionBD.sql = "select titulo from entrega where codigo_entrega = " + entregaMod;

            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboEnt.setSelectedItem(ejecucionBD.result.getString("titulo"));
                tituloEnt = ejecucionBD.result.getString("titulo");
            } else {
                System.out.println("nada en entrega");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

        try {
            ejecucionBD.sql = "select nombre from personal where codigo_personal = '" + registros[0] + "'";
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboPers.setSelectedItem(ejecucionBD.result.getString("nombre"));
                nombre = ejecucionBD.result.getString("nombre");
            } else {
                System.out.println("nada en personal");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

        comboEnt.setSelectedItem(registros[2]);
        comboEstado.setSelectedItem(registros[1]);
        estado = registros[1];

        try {
            ejecucionBD.sql = "select nombre_rol from rol_esp where codigo_rol = '" + registros[3] + "'";
            if (ejecucionBD.ejecutarConsulta() && ejecucionBD.result.first()) {
                comboRol.setSelectedItem(ejecucionBD.result.getString("nombre_rol"));
            } else {
                System.out.println("nada en rol_esp");
            }
        } catch (Exception e) {
            System.out.println("Error en cargar combobox al modificar");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboPers = new javax.swing.JComboBox();
        comboEstado = new javax.swing.JComboBox();
        comboEnt = new javax.swing.JComboBox();
        comboRol = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboProy = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btoAcep = new javax.swing.JButton();
        btoCanc = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ASIGNAR DESARROLLADOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Personal");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Entrega");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Estado");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Rol");

        comboPers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPersActionPerformed(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "inactivo", "activo" }));

        comboEnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntActionPerformed(evt);
            }
        });

        comboRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Proyecto");

        comboProy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboProy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(comboProy, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboPers, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboProy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btoAcep.setText("Aceptar");
        btoAcep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoAcepActionPerformed(evt);
            }
        });

        btoCanc.setText("Cancelar");
        btoCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoCancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btoAcep)
                .addGap(44, 44, 44)
                .addComponent(btoCanc)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btoAcep)
                    .addComponent(btoCanc))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btoAcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoAcepActionPerformed

        String proyecto = comboProy.getSelectedItem().toString();
        if (validacionDatos.campoVacio(proyecto)) {
            comboProy.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Proyecto Vacio");
            return;
        }

        String entrega = comboEnt.getSelectedItem().toString();
        if (validacionDatos.campoVacio(entrega)) {
            comboEnt.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Entrega Vacio");
            return;
        } else {
            nuevaAsigEnt.setEntrega(this.entregas.get((comboEnt.getSelectedIndex() - 1)).toString());
        }

        String pers = comboPers.getSelectedItem().toString();
        if (validacionDatos.campoVacio(pers)) {
            comboPers.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Persona Vacio");
            return;
        } else {
            nuevaAsigEnt.setPersonal(this.personal.get((comboPers.getSelectedIndex() - 1)).toString());
        }

        String Estado = comboEstado.getSelectedItem().toString();
        if (validacionDatos.campoVacio(Estado.toString())) {
            comboEstado.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Estado Vacio");
            return;
        } else {
            nuevaAsigEnt.setEstado(Estado);
        }

        String rol = comboRol.getSelectedItem().toString();
        if (validacionDatos.campoVacio(rol)) {
            comboRol.requestFocus();
            JOptionPane.showMessageDialog(null, "Campo Rol Vacio");
            return;
        } else {
            nuevaAsigEnt.setRol(Integer.parseInt(this.roles.get(comboRol.getSelectedIndex() - 1).toString()));
        }


        try {
            ejecucionBD.sql = "select proyecto.codigo_proy from proyecto where "
                    + "proyecto.codigo_proy = (select entrega.proyecto from entrega where "
                    + "entrega.codigo_entrega = " + nuevaAsigEnt.getEntrega() + ")";
            ejecucionBD.ejecutarConsulta();

            codigoProy = ejecucionBD.result.getInt(1);

            ejecucionBD.sql = "select proyecto.cant_personas from proyecto where "
                    + "proyecto.codigo_proy = " + codigoProy;
            ejecucionBD.ejecutarConsulta();

            cantPersProy = ejecucionBD.result.getInt(1);

            ejecucionBD.sql = "select personal from rolxent_per "
                    + "where rolxent_per.entrega in (Select entrega.codigo_entrega from "
                    + "entrega where entrega.proyecto = " + codigoProy + ") group by personal";

            ejecucionBD.ejecutarConsulta();

            cantPersVan = ejecucionBD.cantidadRegistros();
        } catch (Exception e) {
            System.out.println("Errror linea GUIAgregarRegAEnt");
        }


        if (agregar) {

            try {

                ejecucionBD.sql = "select rolxent_per.personal,entrega.proyecto from "
                        + "rolxent_per, entrega "
                        + "where rolxent_per.entrega = entrega.codigo_entrega and personal = "
                        + nuevaAsigEnt.getPersonal() + " and proyecto = " + codigoProy;

                ejecucionBD.ejecutarConsulta();

                if (ejecucionBD.cantidadRegistros() > 0) {

                    if (ejecucionBD.ejecutarInsert(nuevaAsigEnt, "rolxent_per")) {
                        this.setVisible(false);

                        modeloTabla = new MiModelo();
                        tabla.setModel(modeloTabla);
                        ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                                + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                                + "from rolxent_per, rol_esp, personal, entrega "
                                + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                                + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";
                        funcionesComunes.cargarTabla(modeloTabla);
                    }

                } else {

                    if (cantPersProy >= cantPersVan + 1) {

                        if (ejecucionBD.ejecutarInsert(nuevaAsigEnt, "rolxent_per")) {
                            this.setVisible(false);

                            modeloTabla = new MiModelo();
                            tabla.setModel(modeloTabla);
                            ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                                    + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                                    + "from rolxent_per, rol_esp, personal, entrega "
                                    + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                                    + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";
                            funcionesComunes.cargarTabla(modeloTabla);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Cantidad Personal desarrollador para el Proyecto " + cantPersProy + " Cantidad Personal Actual en el Proyecto " + cantPersVan);
                    }

                }

            } catch (Exception e) {
                System.out.println("Error GUIAgregarREgAENT");
            }


        } else {

            if (estado.equals("inactivo")) {

                try {
                    ejecucionBD.sql = "select rolxent_per.personal,entrega.proyecto from "
                            + "rolxent_per, entrega "
                            + "where rolxent_per.entrega = entrega.codigo_entrega and personal = "
                            + nuevaAsigEnt.getPersonal() + " and proyecto = " + codigoProy;

                    ejecucionBD.ejecutarConsulta();


                    if (ejecucionBD.cantidadRegistros() > 0) {

                        if (ejecucionBD.ejecutarUpdateDosLLaves(nuevaAsigEnt, "rolxent_per", entregaMod, cod_per)) {
                            this.setVisible(false);
                            modeloTabla = new MiModelo();
                            tabla.setModel(modeloTabla);
                            ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                                    + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                                    + "from rolxent_per, rol_esp, personal, entrega "
                                    + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                                    + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";
                            funcionesComunes.cargarTabla(modeloTabla);
                        }


                    } else {

                        ejecucionBD.sql = "select personal from rolxent_per where personal = " + comboPers.getSelectedItem().toString() + " and ENTREGA = " + entregaMod;
                        ejecucionBD.ejecutarConsulta();
                        if (ejecucionBD.cantidadRegistros() > 0) {
                            cantPersVan = cantPersVan - 1;
                        }

                        if (cantPersProy >= cantPersVan + 1) {

                            if (ejecucionBD.ejecutarUpdateDosLLaves(nuevaAsigEnt, "rolxent_per", entregaMod, cod_per)) {
                                this.setVisible(false);
                                modeloTabla = new MiModelo();
                                tabla.setModel(modeloTabla);
                                ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                                        + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                                        + "from rolxent_per, rol_esp, personal, entrega "
                                        + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                                        + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";
                                funcionesComunes.cargarTabla(modeloTabla);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad Personal desarrollador para el Proyecto " + cantPersProy + " Cantidad Personal Actual en el Proyecto " + cantPersVan);
                        }

                    }

                } catch (Exception e) {
                    System.out.println("Errorr en modificar GuiAgregarRegAEnt");
                }

            } else {
                if (nuevaAsigEnt.getEntrega().equals(entregaMod) && nuevaAsigEnt.getPersonal().equals(cod_per)) {
                    if (ejecucionBD.ejecutarUpdateDosLLaves(nuevaAsigEnt, "rolxent_per", entregaMod)) {
                        this.setVisible(false);
                        modeloTabla = new MiModelo();
                        tabla.setModel(modeloTabla);
                        ejecucionBD.sql = "select personal.nombre as \"DESARROLLADOR\", proyecto.titulo as \"PROYECTO\", entrega.titulo as \"ENTREGA\","
                                + "rolxent_per.estado, rol_esp.nombre_rol as \"ROL\""
                                + "from rolxent_per, rol_esp, personal, entrega "
                                + ", proyecto where personal.codigo_personal = rolxent_per.personal and rol_esp.codigo_rol = rolxent_per.rol "
                                + "and entrega.codigo_entrega = rolxent_per.entrega and entrega.proyecto = proyecto.codigo_proy order by rolxent_per.personal,rolxent_per.entrega";
                        funcionesComunes.cargarTabla(modeloTabla);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Desarrollador " + nombre + " esta Activo no se puede modificar de la Entrega " + tituloEnt + "por que esta asociado a actividades de la misma",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btoAcepActionPerformed

    private void btoCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoCancActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btoCancActionPerformed

    private void comboEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntActionPerformed
        if (agregar) {
            comboPers.removeAllItems();
            comboPers.addItem(" ");

            try {

                ejecucionBD.sql = "select personal.nombre, personal.codigo_personal from "
                        + " personal,cuenta where personal.codigo_personal not in (select rolxent_per.personal from rolxent_per"
                        + " where rolxent_per.entrega = " + entregas.get(comboEnt.getSelectedIndex() - 1)
                        + " ) and personal.codigo_personal != 1 and personal.codigo_personal = cuenta.personal";

                personal.clear();
                funcionesComunes.cargarLista(personal, comboPers);
            } catch (Exception e) {
                System.out.println("No selecciono nada");
            }
        } else {
            comboPers.removeAllItems();
            comboPers.addItem(" ");


            try {

                ejecucionBD.sql = "select personal.nombre, personal.codigo_personal from "
                        + " personal, cuenta where personal.codigo_personal not in (select rolxent_per.personal from rolxent_per"
                        + " where rolxent_per.entrega = " + entregas.get(comboEnt.getSelectedIndex() - 1)
                        + " and personal.codigo_personal != " + cod_per + ") and personal.codigo_personal != 1"
                        + " and personal.codigo_personal = cuenta.personal";

                personal.clear();
                funcionesComunes.cargarLista(personal, comboPers);
            } catch (Exception e) {
                System.out.println("No selecciono nada");
            }

        }

    }//GEN-LAST:event_comboEntActionPerformed

    private void comboProyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProyActionPerformed
        comboEnt.removeAllItems();
        comboEnt.addItem(" ");

        try {
            ejecucionBD.sql = "select Entrega.titulo, Entrega.codigo_entrega from Entrega where "
                    + "entrega.proyecto = '" + proyectos.get(comboProy.getSelectedIndex() - 1) + "'";

            entregas.clear();
            funcionesComunes.cargarLista(entregas, comboEnt);
        } catch (Exception e) {
            System.out.println("No selecciono nada");
        }

    }//GEN-LAST:event_comboProyActionPerformed

    private void comboPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPersActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btoAcep;
    private javax.swing.JButton btoCanc;
    private javax.swing.JComboBox comboEnt;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JComboBox comboPers;
    private javax.swing.JComboBox comboProy;
    private javax.swing.JComboBox comboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
