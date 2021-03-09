/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.elementos.Coche;
import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class Gestion {
    ArrayList<Coche> coches;

    public Gestion() {
      if (coches == null) {
          coches = new ArrayList<>();
      }
    }

    public Gestion(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }
    
    
   
    /**
     * Metodo para insertar un coche en la lista
     * @param coche elemento a insertar
     */
    public void insertar(Coche coche) {
        coches.add(coche);
    }
    
    /**
     * Funcion que busca un elemento en la lista
     * @param matricula Clave por la que busca el coche
     * @return retorna el coche/null
     */
    public Coche buscar(String matricula) {
        boolean encontrar = false;
        int i = 0;
        Coche cocheEncontrado = null;
        while(i < coches.size() || !encontrar) {
            Coche coche = coches.get(i);
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                encontrar = true;
                cocheEncontrado = coche;
            }
            i++;
        }
        
        return cocheEncontrado;
    }
    
    /**
     * Metodo que elimina un elemento de la lista si existe
     * @param matricula del elemento a eliminar
     */
    public void eliminar(String matricula) {
        /** Opcion A
        int i = 0;
                
        while(i < coches.size()) {
            Coche coche = coches.get(i);
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                coches.remove(i);
            }
            i++;
        }
        **/
        
        Coche coche = buscar(matricula);
        if (coche != null) {
            coches.remove(coche);
        }
    }
    
    public void eliminar(Coche coche) {
       coches.remove(coche);
    }
    
}
