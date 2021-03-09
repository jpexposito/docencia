
package es.iespuertolacruz.jpexposito.coleccion;

import es.iespuertolacruz.jpexposito.coleccion.elementos.Empleado;
import java.util.*;

/**
 *
 * @author jpexposito
 */
public class PruebaMapas {
    
    HashMap<String, Empleado> personal = new HashMap<>();
    
    /**
     * 
     * @param key
     * @param empleado 
     */
    public void insertar(String key, Empleado empleado) {
       personal.put(key, empleado);
    }
    
    @Override
    public String toString() {
        return personal.toString();
    }
    
    public void eliminar (String key) {
        personal.remove(key);
    }
    
    public int tamanio() {
        return personal.size();
    }
    
    public void modificar(String key, Empleado empleado) {
        personal.put(key, empleado);
    }
    
    public Empleado buscar (String key) {
        return personal.get(key);
    }
    
    public boolean isEmpy() {
        return personal.isEmpty();
    }
}
