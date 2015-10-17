//modelo para la instacia de objetos de la clase Rol_Ent_Per con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author Tavo
 */
public class Rol_Ent_Per {

    String personal;
    String estado;
    String entrega;
    int rol;

    public Rol_Ent_Per(String personal, String estado, String entrega, int rol) {
        this.personal = personal;
        this.estado = estado;
        this.entrega = entrega;
        this.rol = rol;
    }

    public Rol_Ent_Per() {
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return personal + "," + estado + "," + entrega + "," + rol;
    }
}
