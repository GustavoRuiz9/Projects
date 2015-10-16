//modelo para la instacia de objetos de la clase Cuenta con sus respectivos metodos Getter, Setter y toString
package Modelo;

/**
 *
 * @author tavo
 */
public class Cuenta {

    private String personal = "";
    private String nombre_usua = "";
    private String contrasena = "";

    public Cuenta(String persona, String nombre_usua, String contrasena) {
        this.personal = persona;
        this.nombre_usua = nombre_usua;
        this.contrasena = contrasena;
    }

    public Cuenta() {
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String persona) {
        this.personal = persona;
    }

    public String getNombre_usua() {
        return nombre_usua;
    }

    public void setNombre_usua(String nombre_usua) {
        this.nombre_usua = nombre_usua;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return personal + "," + nombre_usua + "," + contrasena;
    }
}
