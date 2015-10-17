//modelo para la instacia de objetos de la clase Observacion con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author CarlosMito
 */
public class Observaciones {

    public String codigo_proy;
    public String descripcion;
    public double vr_definitivo;

    public Observaciones( String proy, String descrip, double verdef) {

        
        codigo_proy = proy;
        descripcion = descrip;
        vr_definitivo = verdef;

    }

    public Observaciones() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodigo_proy() {
        return codigo_proy;
    }

    public void setCodigo_proy(String codigo_proy) {
        this.codigo_proy = codigo_proy;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getVr_definitivo() {
        return vr_definitivo;
    }

    public void setVr_definitivo(double vr_definitivo) {
        this.vr_definitivo = vr_definitivo;
    }

    

    @Override
    public String toString() {
        return codigo_proy + " , " + descripcion + " , "  + vr_definitivo;
    }
}