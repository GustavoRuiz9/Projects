//modelo para la instacia de objetos de la clase Actividad con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author tavo
 */
public class Actividad {

    String codigo_actividad;
    String titulo;
    String entrega;
    String responsable;
    String fecha_ini;
    String fecha_fin;
    String fecha_fin_real;
    String estado;

    public Actividad(String codigo_actividad, String titulo, String entrega, String fecha_ini, String fecha_fin, String fecha_fin_real, String estado, Double valor, String responsable, int nivel_complejidad) {
        this.codigo_actividad = codigo_actividad;
        this.titulo = titulo;
        this.entrega = entrega;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.fecha_fin_real = fecha_fin_real;
        this.estado = estado;
        this.responsable = responsable;
    }

    public Actividad() {
    }

    public String getCodigo_actividad() {
        return codigo_actividad;
    }

    public void setCodigo_actividad(String codigo_actividad) {
        this.codigo_actividad = codigo_actividad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_fin_real() {
        return fecha_fin_real;
    }

    public void setFecha_fin_real(String fecha_fin_real) {
        this.fecha_fin_real = fecha_fin_real;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return codigo_actividad + "," + titulo + "," + entrega + "," + fecha_ini + "," + fecha_fin + "," + fecha_fin_real + "," + estado + "," + responsable;
    }
}