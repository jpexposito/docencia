/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.coleccion.elementos;

/**
 *
 * @author jpexposito
 */
public class Empleado {
    String nombre;
    double sueldo;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.sueldo = 2000;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}'+"\n";
    }
    
    
    
    
}
