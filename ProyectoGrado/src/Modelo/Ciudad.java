//modelo para la instacia de objetos de la clase Ciudad con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author tavo
 */
public class Ciudad {

    String codigoCiudad = "";
    String nombreCiudad = "";
    int departamento;

    public Ciudad(String ciudad, String nombre, int departamento) {
        codigoCiudad = ciudad;
        nombreCiudad = nombre;
        this.departamento = departamento;
    }
    public Ciudad() {
 
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return codigoCiudad + "," + nombreCiudad + "," + departamento;
    }
}
