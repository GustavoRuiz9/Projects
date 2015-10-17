//modelo para la instacia de objetos de la clase Cliente con sus respectivos metodos Getter, Setter y toString
package Modelo;

public class Cliente {

    public String codigo_cliente;
    public String cedula;
    public String nombreCli;
    public String apellidoCli;
    public String sexoCli;
    public int ciudadCli;
    public String telefonoCli;
    public String correoCli;
    public String nom_empresa;
    public String nit_empresa;

    public Cliente(String codigo_cliente, String cedula, String nom, String ape, String sex, int ciu, String tel, String corre, String nomemp, String nit) {

        this.codigo_cliente = codigo_cliente;
        this.cedula = cedula;
        this.nombreCli = nom;
        this.apellidoCli = ape;
        this.sexoCli = sex;
        this.ciudadCli = ciu;
        this.telefonoCli = tel;
        this.correoCli = corre;
        this.nom_empresa = nomemp;
        this.nit_empresa = nit;

    }

    public Cliente() {
    }

    public String getCodCliente() {
        return codigo_cliente;
    }

    public void setCodCliente(String codigoCli) {
        this.codigo_cliente = codigoCli;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApellidoCli() {
        return apellidoCli;
    }

    public void setApellidoCli(String apellidoCli) {
        this.apellidoCli = apellidoCli;
    }

    public String getSexoCli() {
        return sexoCli;
    }

    public void setSexoCli(String sexoCli) {
        this.sexoCli = sexoCli;
    }

    public int getCiudadCli() {
        return ciudadCli;
    }

    public void setCiudadCli(int ciudadCli) {
        this.ciudadCli = ciudadCli;
    }

    public String getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(String telefonoCli) {
        this.telefonoCli = telefonoCli;
    }

    public String getCorreoCli() {
        return correoCli;
    }

    public void setCorreoCli(String correoCli) {
        this.correoCli = correoCli;
    }

    public String getNom_empresa() {
        return nom_empresa;
    }

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    public String getNit_empresa() {
        return nit_empresa;
    }

    public void setNit_empresa(String nit_empresa) {
        this.nit_empresa = nit_empresa;
    }

    @Override
    public String toString() {
        return codigo_cliente + "," + cedula + "," + nombreCli + "," + apellidoCli + "," + sexoCli + "," + ciudadCli + "," + telefonoCli + "," + correoCli + "," + nom_empresa + "," + nit_empresa;
    }
}
