/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.elementos;

import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class Gestion {
    
    
    private ArrayList<Persona> personas = new ArrayList<>();

   
    public ArrayList<Persona> getPersonas() {
        return personas;
    }
    
    public void insertar (Persona persona) {
        personas.add(persona);
    }

    public void eliminar(Persona persona) {  
        personas.remove(persona);
    }
    
    public int contar() {
        return personas.size();
    }
    
    /**
     * Funcion que realiza la busqueda por el parametro dni
     * @param dni clave por la que se busca un elemento
     * @return Persona encontrada/null si no lo encuentra
     */
    public Persona buscar(int dni) {
        boolean encontrado = false;
        int i = 0;
        Persona personaEncontrada = null;

        while(i < personas.size() || !encontrado) {
            Persona persona = personas.get(i);
            if (persona.getDni() == dni) {
                encontrado = true;
                personaEncontrada = persona;
            }
            i++;
        }
        
        return personaEncontrada;
    }
    
    /**
     * Funcio....
     * @param nombre
     * @return 
     
    public Persona buscar(String nombre) {
        Persona personaEncontrada = null;
        
        return personaEncontrada;
    }
    */
    /**
     * Funcion que retorna las personas con  un nombre
     * @param nombre con el que filtrar 
     * @return lista personas
     */
    public ArrayList<Persona> buscar(String nombre) {
        ArrayList<Persona> personasEncontradas = new ArrayList<>();
 
       for(Persona persona:personas) {
         if (persona.getNombre().equalsIgnoreCase(nombre)) {
                personasEncontradas.add(persona);
            }  
       }        
       
       return personasEncontradas;       
    }
    
    
    
}
