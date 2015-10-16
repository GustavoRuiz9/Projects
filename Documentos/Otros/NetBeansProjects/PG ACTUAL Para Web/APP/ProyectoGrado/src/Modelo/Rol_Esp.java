//modelo para la instacia de objetos de la clase Rol_Esp con sus respectivos metodos Getter, Setter y toString.
package Modelo;

/**
 *
 * @author Tavo
 */
public class Rol_Esp {

    String rol = "";
    String nombreRol = "";
    String sueldo = "";

    public Rol_Esp() {
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
}
