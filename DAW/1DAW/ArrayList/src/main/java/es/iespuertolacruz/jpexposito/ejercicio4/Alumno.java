/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio4;

/**
 *
 * @author jpexposito
 */
public class Alumno {
    String nombre;
    Integer edad;

    public Alumno(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ""
                + ", edad=" + edad + '}';
    }
    
    
    
}
