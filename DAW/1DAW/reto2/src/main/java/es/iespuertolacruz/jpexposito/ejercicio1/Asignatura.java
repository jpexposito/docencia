/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio1;

/**
 *
 * @author jpexposito
 */
public class Asignatura {
    
    String nombre;
    int nota;

    public Asignatura(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Asignatura:" + "nombre=" + nombre + ", nota=" + nota +";\n";
    }
    
    
    
    
    
}
