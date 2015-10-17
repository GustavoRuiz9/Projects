//Clase que se encarga de ejecutar de forma general el cargado de listas y tablas.
package Control;

import static Control.ejecucionBD.ejecutarConsulta;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author tavo
 */
public class funcionesComunes {

    // Cargar culaquier tabla
    static int contC = 1;
    static int contR = 1;
    static int cantidadRegistro = 0;
    public static int cantidadColumnas = 0;
    static ResultSetMetaData columnas;
    static String desCol[];
    static DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();

    //Metodo que obtiene la cantidad de columnas de un registro
    public static void setCantidadColumnas() {
        try {
            columnas = ejecucionBD.result.getMetaData();
            cantidadColumnas = columnas.getColumnCount();
        } catch (Exception e) {
            System.out.println("Error en setCantidadColumnas " + e.getMessage());
        }
    }

    //Metodo para cargar las tablas del sistema
    public static void cargarTabla(javax.swing.table.DefaultTableModel Modelotabla) {
        if (ejecutarConsulta()) {
            cantidadRegistro = ejecucionBD.cantidadRegistros();
            cargarColumnas(Modelotabla);
            cargarRegistros(Modelotabla);
        }
    }

    //Metodo para cargar las colmnas del sistema
    public static void cargarColumnas(javax.swing.table.DefaultTableModel tabla) {

        setCantidadColumnas();
        //desCol = new String[cantidadColumnas];
        try {
            while (cantidadColumnas >= contC) {
                tabla.addColumn(columnas.getColumnName(contC));
                //desCol[contC - 1] = columnas.getColumnName(contC);
                ++contC;
            }
            contC = 1;
        } catch (Exception e) {
            System.out.println("\nError en cargarColumna = " + e.getMessage());
        }
    }

    //Metodo para obtener los nombres de las columnas de una consulta.
    public static void nombreColumnas() {

        setCantidadColumnas();
        desCol = new String[cantidadColumnas];
        try {
            while (cantidadColumnas >= contC) {
                desCol[contC - 1] = columnas.getColumnName(contC);
                ++contC;
            }
            contC = 1;
        } catch (Exception e) {
            System.out.println("\nError en nombreColumna = " + e.getMessage());
        }
    }

    //Metodo para cargar los registros de las tablas.
    public static void cargarRegistros(javax.swing.table.DefaultTableModel tabla) {

        String registro[] = new String[cantidadColumnas];
        try {
            while ((contR <= cantidadRegistro)) {
                while (cantidadColumnas >= contC) {
                    if (!(ejecucionBD.result.getString(contC) == null)) {
                        registro[contC - 1] = ejecucionBD.result.getObject(contC).toString();
                    } else {
                        registro[contC - 1] = "";
                    }
                    ++contC;
                }

                contC = 1;

                tabla.addRow(registro);

                if (ejecucionBD.result.next()) {
                    ++contR;
                } else {
                    contR = cantidadRegistro + 1;
                }
            }

            contR = 1;
        } catch (Exception e) {
            System.out.println("Error en cargarRegistros " + e.getMessage());
        }
    }

    //Metodo utilzado para cargar una lista desplegable.
    public static void cargarLista(ArrayList contenido, JComboBox listaD, String tabla, String campo1, String campo2) {

        if (!tabla.trim().equals("personal")) {
            if (tabla.trim().equals("proyecto")) {
                if (tabla.equals("proyecto")) {
                    ejecucionBD.sql = "select t0.codigo_proy, t0.titulo from proyecto t0\n"
                            + "where t0.num_entregas > (Select count (t2.codigo_entrega) from \n"
                            + "proyecto t1, entrega t2 where t2.proyecto = t1.codigo_proy and\n"
                            + "t1.codigo_proy = t0.codigo_proy) ";
                } else {
                    ejecucionBD.sql = "select * from proyecto";
                }
            } else {
                ejecucionBD.sql = "select * from " + tabla;
            }
        } else {

            if (tabla.equals("personal")) {
                ejecucionBD.sql = "select * from " + tabla + ", cuenta "
                        + "where not " + tabla + ".codigo_personal = 1 and personal.codigo_personal = cuenta.personal";
            } else {
                if (tabla.equals("personal ")) {
                    ejecucionBD.sql = "select * from personal t0 where t0.codigo_personal "
                            + "not in (select cuenta.personal from cuenta where cuenta.personal = t0.codigo_personal)";
                } else {
                    ejecucionBD.sql = "select * from " + tabla;
                }
            }
        }

        if (ejecucionBD.ejecutarCons()) {

            try {
                while (ejecucionBD.result.next()) {

                    listaD.addItem(ejecucionBD.result.getString(campo1));
                    contenido.add(ejecucionBD.result.getString(campo2));

                }
            } catch (Exception e) {
                System.out.println("Error en cargarLista =" + e.getMessage());
            }
        }
    }

    //Metodo utilizado para cargar una lista desplegable.
    public static void cargarLista(ArrayList contenido, JComboBox listaD) {
        if (ejecucionBD.ejecutarCons()) {
            try {
                while (ejecucionBD.result.next()) {
                    listaD.addItem(ejecucionBD.result.getString(1));
                    contenido.add(ejecucionBD.result.getString(2));
                }
            } catch (Exception e) {
                System.out.println("Error en cargarLista =" + e.getMessage());
            }
        }
    }
}
