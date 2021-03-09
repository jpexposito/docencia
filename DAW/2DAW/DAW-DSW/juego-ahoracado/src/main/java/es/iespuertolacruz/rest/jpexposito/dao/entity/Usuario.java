package es.iespuertolacruz.rest.jpexposito.dao.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {

    String email;
    String nombre;
    String dni;
    String password;

    public Usuario() { }

    public Usuario(String nombre, String dni, String password, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
