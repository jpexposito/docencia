/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.elementos;

/**
 *
 * @author jpexposito
 */
public class Persona extends Validaciones {
    
    
    String nombre;
    String apellidos;
    String dni;
    int edad;
    Coche coche;
    Direccion direccion;

    public Persona(String nombre, String apellidos, String dni, int edad, Coche coche, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        validarDni(dni);
        this.edad = edad;
        this.coche = coche;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
    
    
    
}
