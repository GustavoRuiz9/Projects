//modelo para la instacia de objetos de la clase Proyecto con sus respectivos metodos Getter, Setter y toString
package Modelo;

/**
 *
 * @author tavo
 */
public class Proyecto {

    String codigo;
    int cant_Desarrolladores;
    double est_cantidad_pers;
    int num_entregas;
    String titulo;
    int categoria;
    String cliente;
    String fecha_inicio;
    String fecha_fin;
    String fecha_finreal;
    Double costo_estimado;
    Double costo_final;
    String estado;
    String rangopf;

    public Proyecto(String codigo, int cantidad_pers, double est_cantidad_pers, int num_entregas, String titulo, int categoria, String cliente, String fecha_inicio, String fecha_fin, String fecha_finreal, Double valor_estimado, Double valor_final, String estado, String rangopf) {
        this.codigo = codigo;
        this.cant_Desarrolladores = cantidad_pers;
        this.est_cantidad_pers = est_cantidad_pers;
        this.num_entregas = num_entregas;
        this.titulo = titulo;
        this.categoria = categoria;
        this.cliente = cliente;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_finreal = fecha_finreal;
        this.costo_estimado = valor_estimado;
        this.costo_final = valor_final;
        this.estado = estado;
        this.rangopf = rangopf;
    }

    public Proyecto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCant_Desarrolladores() {
        return cant_Desarrolladores;
    }

    public void setCant_Desarrolladores(int cant_Desarrolladores) {
        this.cant_Desarrolladores = cant_Desarrolladores;
    }

    public double getEst_cantidad_pers() {
        return est_cantidad_pers;
    }

    public void setEst_cantidad_pers(double est_cantidad_pers) {
        this.est_cantidad_pers = est_cantidad_pers;
    }

    public int getNum_entregas() {
        return num_entregas;
    }

    public void setNum_entregas(int num_entregas) {
        this.num_entregas = num_entregas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public String getFecha_finreal() {
        return fecha_finreal;
    }

    public void setFecha_finreal(String fecha_finreal) {
        this.fecha_finreal = fecha_finreal;
    }

    public Double getCosto_estimado() {
        return costo_estimado;
    }

    public void setCosto_estimado(Double costo_estimado) {
        this.costo_estimado = costo_estimado;
    }

    public Double getCosto_final() {
        return costo_final;
    }

    public void setCosto_final(Double costo_final) {
        this.costo_final = costo_final;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRangopf() {
        return estado;
    }

    public void setRangopf(String rangopf) {
        this.rangopf = rangopf;
    }

    @Override
    public String toString() {
        return codigo + "," + cant_Desarrolladores + "," + est_cantidad_pers + "," + num_entregas + "," + titulo + "," + categoria + "," + cliente + "," + fecha_inicio + "," + fecha_fin + "," + fecha_finreal + "," + costo_estimado + "," + costo_final + "," + estado + "," + rangopf;
    }
}
