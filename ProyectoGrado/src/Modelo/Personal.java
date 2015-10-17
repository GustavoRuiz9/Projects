//modelo para la instacia de objetos de la clase Personal con sus respectivos metodos Getter, Setter y toString

package Modelo;

/**
 *
 * @author Tavo
 */
public class Personal {

    String codigo_personal;
    String cedula;
    String nombre;
    String apellido;
    String telefono;
    String celular;
    String correo;
    int edad;
    String direccion;
    int codigoCiudad;
    String cuentaAct;

    public Personal(String codigo_personal, String cedula, String nombre, String apellido, String telefono, String celular, String correo, int edad, String direccion, int codigoCiudad) {
        this.codigo_personal = codigo_personal;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.edad = edad;
        this.direccion = direccion;
        this.codigoCiudad = codigoCiudad;
    }

    public Personal() {
    }

    public String getCod_personal() {
        return codigo_personal;
    }

    public void setCod_personal(String Cod_personal) {
        this.codigo_personal = Cod_personal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getCuentaAct() {
        return cuentaAct;
    }

    public void setCuentaAct(String CuentaAct) {
        this.cuentaAct = CuentaAct;
    }

    @Override
    public String toString() {
        return codigo_personal + "," + cedula + "," + nombre + "," + apellido + "," + telefono + "," + celular + "," + correo + "," + edad + "," + direccion + "," + codigoCiudad + "," + cuentaAct;
    }
}
