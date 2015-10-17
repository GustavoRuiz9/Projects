//modelo para la instacia de objetos de la clase Entrega con sus respectivos metodos Getter, Setter y toString
package Modelo;

/**
 *
 * @author Tavo
 */
public class Entrega {

    String codigoEnt;
    String titulo;
    int porcentaje;
    String proyecto;
    String fecha_inicio;
    String fecha_fin;
    String fecha_finReal;
    String estado;
    Double valor;

    public Entrega(String codigoEnt, String titulo, int porcentaje, String proyecto, String fecha_inicio, String fecha_fin, String fecha_finReal, String estado, Double valor) {
        this.codigoEnt = codigoEnt;
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.proyecto = proyecto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_finReal = fecha_finReal;
        this.estado = estado;
        this.valor = valor;
    }

    public Entrega() {
    }

    public String getCodigoEnt() {
        return codigoEnt;
    }

    public void setCodigoEnt(String codigoEnt) {
        this.codigoEnt = codigoEnt;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String tiulo) {
        this.titulo = tiulo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_finReal() {
        return fecha_finReal;
    }

    public void setFecha_finReal(String fecha_finReal) {
        this.fecha_finReal = fecha_finReal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String toString() {
        return codigoEnt + "," + titulo + "," + porcentaje + "," + proyecto + "," + fecha_inicio + "," + fecha_fin + "," + fecha_finReal + "," + estado + "," + valor;
    }
}
