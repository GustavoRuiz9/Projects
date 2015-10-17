//modelo para la instacia de objetos de la clase Categoria_proyecto con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author tavo
 */
public class Categoria_Proyecto {
    
    String codigoCat="";
    String nivelCat="";
    String descripcionCat="";

    public Categoria_Proyecto() {
    }

    public String getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(String codigoCat) {
        this.codigoCat = codigoCat;
    }

    public String getNivelCat() {
        return nivelCat;
    }

    public void setNivelCat(String nivelCat) {
        this.nivelCat = nivelCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }   
}





