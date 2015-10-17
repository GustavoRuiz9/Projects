package Control;

//Clase encargada de validar los datos de los formularios.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tavo
 */
public class validacionDatos {

    //verifica si el valor de campo esta nulo si asi es retorna true de lo contrario false
    public static boolean campoVacio(String campo) {
        return campo.trim().isEmpty();
    }

    //valida que el valor campo sea un valor entero, si es int retorna true de lo cont. false
    public static boolean vrEntero(String campo) {

        if (campoVacio(campo)) {
            return false;
        } else {

            try {
                Long.parseLong(campo);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    //valida que el valor campo sea un valor numerico, si es numerico retorna true de lo cont. false
    public static boolean vrDecimal(String campo) {

        if (campoVacio(campo)) {
            return false;
        } else {

            try {
                Double.parseDouble(campo);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    //valida si un obj de tipo String contiene algun dato dif de a-z y A-Z, si es asi retorna false de lo cont. true
    public static boolean caracteres(String campo) {
        try {
            if (!campoVacio(campo)) {
                int cont = 0;
                while (cont != campo.length()) {
                    cont++;
                    String letra = campo.substring(cont - 1, cont);
                    int val = (int) letra.charAt(0);
                    if (val >= 97 && val <= 122 || val >= 65 && val <= 90 || val == 32 || val == 209 || val == 241) {
                        continue;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean caracteresNumeros(String campo) {
        try {
            if (!campoVacio(campo)) {
                int cont = 0;
                while (cont != campo.length()) {
                    cont++;
                    String letra = campo.substring(cont - 1, cont);
                    int val = (int) letra.charAt(0);
                    if (val >= 97 && val <= 122 || val >= 65 && val <= 90 || val == 32 || val >= 48 && val <= 57 || val == 209 || val == 241) {
                        continue;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //metodo que valida la cantidad de un campo sea logico, usado para el num entregas, actividades
    //desarrolladores. 1 - 20. true es log.
    public static boolean validarCantidad(String campo, int cual) {
        int b = 10;
        int a = 1;
        if (cual == 1) {
            b = 8;
        } else {
            if (cual == 3) {
                a = 16;
                b = 60;
            } else {
                if (cual != 0) {
                    b = 16;
                }
            }
        }

        if (vrEntero(campo)) {
            int campoEnt = Integer.parseInt(campo);
            if (campoEnt < a || campoEnt > b) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    //Metodo encargado de validar el porcentaje ingresado en porcentaje de el formulario de entrega.
    public static boolean validarPorcentaje(String campo, int may) {

        if (vrEntero(campo)) {
            int campoEnt = Integer.parseInt(campo);
            if (campoEnt < 10 || campoEnt > may) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    //metodo que valida si el dato de el campo es mayor de 3 caracteres. si es asi es true.
    public static int validarCantidad(String campo) {
        if (caracteres(campo)) {
            if (campo.length() >= 5) {
                return 1;
            }
            return 2;
        } else {
            return 3;
        }
    }

    //Metodo encargado validar la cantidad de caracteres que sean mayor a 7.
    public static boolean validarCantidadCyN(String campo) {
        if (caracteresNumeros(campo)) {
            if (campo.length() >= 8) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //Metodo encargado de validar el numero de los telefonos 
    public static boolean validarDatosTelefonicos(String campo, int cant) {
        if (vrEntero(campo)) {
            if (campo.length() == cant) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //Metodo encargado de validar el email
    public static boolean esEmail(String correo) {
        if (!correo.isEmpty()) {
            Pattern pat = null;
            Matcher mat = null;
            pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
            mat = pat.matcher(correo);
            if (mat.find()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
