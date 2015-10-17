package Control;
//Clase que conecta la App con la Base de Datos y gestiona diferentes acciones a la base de datos.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ejecucionBD {

    static public String sql = "";
    static private Connection conn;
    static Statement st;
    static String driver = "oracle.jdbc.driver.OracleDriver";
    static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    static String user = "tavo";
    static String pass = "447656";
    static public ResultSet result;

    //metodo para obtener la conexion a la Base de Datos.
    public static Connection getConn() {
        if (conn == null) {
            conectarOracle();
        }
        return conn;
    }

    //metodo para realizar la conexion a la Base de Datos oracle XE.
    public static String conectarOracle() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return estadoConexion() + "\nBD = " + true;
        } catch (Exception e) {
            System.out.println("Error en el Metodo Conectar de la Clase ejecucionBD = " + e.getMessage());
            return estadoConexion() + "\nBD = " + false + "\n";
        } 

    }

    //Metodo que retorna el estado actual de la conexion
    public static String estadoConexion() {

        try {
            boolean estado = conn.isClosed();
            if (estado) {
                return "\nConexion:" + false;
            } else {
                return "\nConexion:" + true;
            }
        } catch (Exception e) {
            System.out.println("Error en el Metodo estadoConexion = " + e.getMessage());
            return "Conexion:" + false;
        }

    }

    //Metodo que desconecta la Base de datos.
    public static void desconectarBD() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error en desconectar BD = " + e.getMessage());
        } finally {
            System.out.println(estadoConexion() + "\nBD = false");
        }


    }

    //Metodo que lanza una consulta a la BD.
    public static boolean ejecutarConsulta() {

        try {
            System.out.println("\n" + sql);
            result = st.executeQuery(sql);
            System.out.println("consulta = " + true);
            System.out.println("cantidad Registros = " + cantidadRegistros());
            return true;

        } catch (Exception e) {
            System.out.println("consulta = " + false);
            System.out.println("Error en ejecutarConsulta = " + e.getMessage());
            return false;
        } finally {
        }
    }

    public static boolean ejecutarCons() {

        try {
            System.out.println("\n" + sql);
            result = st.executeQuery(sql);
            System.out.println("consulta = " + true);
            return true;

        } catch (Exception e) {
            System.out.println("consulta = " + false);
            System.out.println("Error en ejecutarConsulta = " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un insert a la BD.
    public static boolean ejecutarInsert(Object obj, String tabla) {
        String campos[] = null;
        sql = "insert into " + tabla + " values (";
        campos = obj.toString().split(",");

        for (String contents : campos) {
            if (contents.equals("null")) {
                sql += contents + ",";
            } else {
                if (contents.equals("0") || contents.equals("0.0")) {
                    sql += "null,";
                } else {
                    if (validacionDatos.vrDecimal(contents)) {
                        sql += contents + ",";
                    } else {
                        if (contents.contains(".NextVal")) {
                            sql += contents + ",";
                        } else {
                            sql += "'" + contents + "',";
                        }
                    }
                }

            }
        }

        sql = sql.substring(0, sql.length() - 1) + ")";
        System.out.println("\n" + sql);

        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("insert = " + false);
                return false;
            } else {
                System.out.println("insert = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("insert = " + false);
            System.out.println("Error en ejecutarInsert " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un update a la BD.
    public static boolean ejecutarUpdate(Object obj, String tabla, String registro) {
        String campos[] = null;
        int cont = 0;

        campos = obj.toString().split(",");
        String llave = "";

        ejecucionBD.sql = "select * from " + tabla;
        ejecutarConsulta();

        funcionesComunes.nombreColumnas();

        ejecucionBD.sql = "update " + tabla + " set ";

        for (String contents : campos) {
            if (cont != 0) {
                ejecucionBD.sql += funcionesComunes.desCol[cont] + " = ";
                if (contents.equals("null")) {
                    sql += contents + ",";
                } else {
                    if (contents.equals("0") || contents.equals("0.0")) {
                        sql += "null,";
                    } else {
                        if (validacionDatos.vrDecimal(contents)) {
                            sql += contents + ",";
                        } else {
                            if (contents.contains(".NextVal")) {
                                sql += contents + ",";
                            } else {
                                sql += "'" + contents + "',";
                            }
                        }
                    }

                }
            } else {
                llave = funcionesComunes.desCol[cont];
            }
            cont++;
        }

        sql = sql.substring(0, sql.length() - 1) + " ";
        sql += " where " + llave + " = '" + registro + "'";

        System.out.println("\n" + sql);

        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un update a la BD de el vr. definitivo de la tabla observacion.
    public static boolean ejecutarUpdateEstObs(String vr, String llave) {
        String sql = "update observacion set VR_DEFINITIVO = " + vr + "where CODIGO_PROY = " + llave;
        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un update a la BD de el estado de la tabla entrega. 
    public static boolean ejecutarUpdateEstEnt(String llave, String estado) {
        String sql = "update entrega set Estado = '" + estado + "' where CODIGO_ENTREGA = " + llave;
        System.out.println("EL UP es " + sql);
        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                if (estado.equals("En Desarrollo")) {
                    sql = "update entrega set FECHA_FIN_REAL = '' where CODIGO_ENTREGA = " + llave;
                    st.executeUpdate(sql);
                }
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un update a la BD de el estado de la tabla proyecto. 
    public static boolean ejecutarUpdateEstProy(String llave, String estado) {
        String sql = "update proyecto set Estado = '" + estado + "' where codigo_proy = " + llave;
        System.out.println("EL UP es " + sql);
        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                if (estado.equals("En Desarrollo")) {
                    sql = "update proyecto set FECHA_FIN_REAL = '' where codigo_proy = " + llave;
                    st.executeUpdate(sql);
                }
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un update a la BD de el estado de la cuenta de la tabla personal.
    public static boolean ejecutarUpdateEstCuenta(String llave) {
        String sql = "update personal set CUENTA_ACTIVA = 'si' where codigo_personal = " + llave;
        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

    //Metodo que lanza un update a la BD de el estado de la tabla rolxent_per.
    public static boolean ejecutarUpdateEstado_Rolx(String codigo_per, String entrega, boolean activo) {
        if (activo) {
            ejecucionBD.sql = "update rolxent_per set estado = 'activo' where rolxent_per.personal = " + codigo_per
                    + " and entrega = " + entrega;
        } else {
            ejecucionBD.sql = "update rolxent_per set estado = 'inactivo' where rolxent_per.personal = " + codigo_per
                    + " and entrega = " + entrega;
        }

        System.out.println(ejecucionBD.sql);

        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdateEstado_Rolx" + e.getMessage());
            return false;
        }

    }

    //Metodo que lanza un update a la BD de el los campos de la tabla rolxentper.
    public static boolean ejecutarUpdateDosLLaves(Object obj, String tabla, String entxMod) {
        String campos[] = null;
        int cont = 0;

        campos = obj.toString().split(",");
        String llave = "";
        String registro = "";

        ejecucionBD.sql = "select personal, estado, entrega, rol from " + tabla;
        ejecutarConsulta();

        funcionesComunes.nombreColumnas();

        ejecucionBD.sql = "update " + tabla + " set ";

        for (String contents : campos) {
            if (cont != 0) {
                ejecucionBD.sql += funcionesComunes.desCol[cont] + " = ";
                if (contents.equals("null")) {
                    sql += contents + ",";
                } else {
                    if (validacionDatos.vrDecimal(contents)) {
                        sql += contents + ",";
                    } else {
                        sql += "'" + contents + "',";
                    }
                }
            } else {
                if (cont == 0) {
                    registro = contents;
                    llave = funcionesComunes.desCol[cont];
                    System.out.println("Registro es " + registro);
                }

            }
            cont++;
        }

        sql = sql.substring(0, sql.length() - 1) + " ";
        sql += " where " + llave + " = '" + registro + "' and ENTREGA = '" + entxMod + "'";

        System.out.println("\n" + sql);

        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

//Metodo que lanza un update a la BD de el los campos de la tabla rolxentper.
    public static boolean ejecutarUpdateDosLLaves(Object obj, String tabla, String entxMod, String ced) {
        String campos[] = null;
        int cont = 0;

        campos = obj.toString().split(",");
        String llave = "";
        String registro = "";

        ejecucionBD.sql = "select personal, estado, entrega, rol from " + tabla;
        ejecutarConsulta();

        funcionesComunes.nombreColumnas();

        ejecucionBD.sql = "update " + tabla + " set ";

        for (String contents : campos) {

            ejecucionBD.sql += funcionesComunes.desCol[cont] + " = ";
            if (contents.equals("null")) {
                sql += contents + ",";
            } else {
                if (validacionDatos.vrDecimal(contents)) {
                    sql += contents + ",";
                } else {
                    sql += "'" + contents + "',";
                }
            }

            if (cont == 0) {
                registro = contents;
                llave = funcionesComunes.desCol[cont];
            }
            cont++;
        }

        sql = sql.substring(0, sql.length() - 1) + " ";
        sql += " where  personal = '" + ced + "' and ENTREGA = '" + entxMod + "'";

        System.out.println("\n" + sql);

        try {
            if (st.executeUpdate(sql) != 1) {
                System.out.println("update = " + false);
                return false;
            } else {
                System.out.println("update = " + true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("update = " + false);
            System.out.println("Error en ejecutarUpdate " + e.getMessage());
            return false;
        }
    }

    //Metodo obtiene la cantidad de registros de una consulta.
    public static int cantidadRegistros() {
        try {
            result.last();
            int cantidad = result.getRow();
            result.first();
            return cantidad;
        } catch (Exception e) {

            System.out.println("Error CatnidadRegistros " + e.getMessage());
            return -1;
        }
    }

    //Metodo Encargado de ubicar el cursor de el result en el registro indicado en la tabla
    public static String ubicarCursor(int iteraciones) {
        if (iteraciones != -1) {
            try {
                for (int cont = 1; cont <= iteraciones; cont++) {
                    if (result.next()) {
                    } else {
                        return null;
                    }
                }
                return result.getString(1);
            } catch (Exception e) {
                System.out.println("Error ubicarCursor " + e.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    //Metodo Encargado de borrar los registros segun la tabla y el campo llave
    public static boolean ejecutarDelete(String tabla, String campo, String llave) {
        try {
            sql = "DELETE FROM " + tabla + " WHERE " + llave + " = '" + campo + "'";
            System.out.println("\n" + sql);

            if (st.executeUpdate(sql) != 1) {
                System.out.println("delete = false");
                return false;
            } else {
                System.out.println("delete = true");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error ejecutarDelete");
            return false;
        }

    }

    //Metodo Encargado de borrar los registros segun la tabla y 2 campos llave
    public static boolean ejecutarDelete(String tabla, String campo, String llave, String campo2, String llave2) {
        try {
            sql = "DELETE FROM " + tabla + " WHERE " + llave + " = '" + campo + "' and " + llave2 + " = '" + campo2 + "'";
            System.out.println("\n" + sql);

            if (st.executeUpdate(sql) != 1) {
                System.out.println("delete = false");
                return false;
            } else {
                System.out.println("delete = true");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error ejecutarDelete");
            return false;
        }

    }

    //Metodo encargado de sacar en un vector los datos de un registro cosultado.
    public static String[] obtenerObjeto() {
        try {
            int cantidadCol = ejecucionBD.result.getMetaData().getColumnCount();
            int cont = 0;
            String[] registro = new String[cantidadCol];
            if (ejecucionBD.result.first()) {
                while (cont < cantidadCol) {
                    registro[cont] = ejecucionBD.result.getString(cont + 1);
                    cont++;
                }
                cont = 0;
            }
            return registro;
        } catch (Exception e) {
            System.out.println("Error en obtenerObjeto");
            return null;
        }
    }
}
