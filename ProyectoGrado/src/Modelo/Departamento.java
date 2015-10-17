//modelo para la instacia de objetos de la clase Departamento con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author Tavo
 */
public class Departamento {
    
    String codigoDepa="";
    String nombreDepa="";

    public Departamento() {
    }

    public String getCodigoDepa() {
        return codigoDepa;
    }

    public void setCodigoDepa(String codigoDepa) {
        this.codigoDepa = codigoDepa;
    }

    public String getNombreDepa() {
        return nombreDepa;
    }

    public void setNombreDepa(String nombreDepa) {
        this.nombreDepa = nombreDepa;
    }
}
