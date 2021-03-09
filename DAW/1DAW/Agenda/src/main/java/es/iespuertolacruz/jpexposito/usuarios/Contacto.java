/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.usuarios;

/**
 *
 * @author jpexposito
 */
public abstract class Contacto {
    
    String identificador;
    String nombre;
    String telefono;

    public Contacto(String identificador, String nombre, String telefono) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "dni=" + identificador + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    
}
