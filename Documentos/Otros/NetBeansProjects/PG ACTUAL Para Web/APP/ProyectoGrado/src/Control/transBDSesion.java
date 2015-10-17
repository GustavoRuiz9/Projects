package Control;

//Clase encargada de encriptar las contraseñas.
import static Control.ejecucionBD.result;
import Modelo.Personal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author tavo
 */
public class transBDSesion {

    public static Personal personalSesion;
    //algoritmos
    public static String MD2 = "MD2";
    public static String MD5 = "MD5";
    public static String SHA1 = "SHA-1";
    public static String SHA256 = "SHA-256";
    public static String SHA384 = "SHA-384";
    public static String SHA512 = "SHA-512";

    /**
     * *
     *
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     *
     * @param digest arreglo de bytes a convertir
     *
     * @return String creado a partir de <code>digest</code>
     *
     */
    private static String toHexadecimal(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    /**
     * *
     *
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
     *
     * @param message texto a encriptar
     *
     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1,
     * SHA-256, SHA-384, SHA-512
     *
     * @return mensaje encriptado
     *
     */
    public static String getStringMessageDigest(String message, String algorithm) {
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    }

    /**
     * Metodo que lleva el Resutl al primer registro
     */
    public static boolean existeUser() {
        try {
            if (result.getRow() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error en existeUser = " + e.getMessage());
            return false;
        }
    }

    /**
     * Metodo que Determina si el usuario logeado es de Rol Director
     */
    public static String validarRolDirector() {
        try {
            ejecucionBD.sql = "Select * from personal where codigo_personal = '" + result.getString(1) + "'";
            ejecucionBD.ejecutarConsulta();
            personalSesion = new Personal();

            personalSesion.setCod_personal(result.getString(1));
            personalSesion.setCedula(result.getString(2));
            personalSesion.setNombre(result.getString(3));
            personalSesion.setApellido(result.getString(4));
            return result.getString(1);

        } catch (Exception e) {
            System.out.println("Error en validarRolDirector = " + e.getMessage());
            return "-1";
        }
    }
}