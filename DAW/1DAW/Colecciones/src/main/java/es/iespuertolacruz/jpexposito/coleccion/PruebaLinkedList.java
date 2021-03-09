/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.coleccion;

import java.util.*;
/**
 *
 * @author jpexposito
 */
public class PruebaLinkedList {
    
    LinkedList<String> personas = new LinkedList<>();
    
    public LinkedList<String> getPersonas() {
        return personas;
    }
    
    public void insertar(String persona) {
        personas.add(persona);
    }
    
    public void borrar(String persona) {
        personas.remove(persona);
    }
    
    public boolean buscar(String persona) {
        if (personas.contains(persona)) {
            return true;
        }       
        return false;
    }
    
    public String primerElemento() {
        return personas.getFirst();
    }
    
    public String ultimoElemento() {
        return personas.getLast();
    }
    
    public void eliminarPrimerElemento() {
        personas.removeFirst();
    }
    
    public void eliminarUltimoElemento() {
        personas.removeLast();
    }
    
    
    
    
    
    
    
    


    
    
    
    
    
    
    
}
