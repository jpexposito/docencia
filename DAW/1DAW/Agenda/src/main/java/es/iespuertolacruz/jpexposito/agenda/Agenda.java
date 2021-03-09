
package es.iespuertolacruz.jpexposito.agenda;

import es.iespuertolacruz.jpexposito.usuarios.Contacto;
import java.util.ArrayList;
/**
 *
 * @author jpexposito
 */
public class Agenda {
    
    ArrayList<Contacto> contactos = new ArrayList<>();
    
    public boolean addContacto(Contacto contacto) {
        boolean insertado = false;
        
        insertado = contactos.add(contacto);
        
        return insertado;
    }
    
    public boolean deleteContacto(Contacto contacto) {
        boolean borrado = false;
        
        borrado = contactos.remove(contacto);
        
        
        return borrado;
    }
    
    public boolean deleteContacto(String dni) {
        boolean borrado = false;
        
        //Opcion 2
        // Siempre inicializar
        int j = 0;
        // && !borrado
        while (j < contactos.size() && (borrado == false)) {
            
            Contacto contactoEvaluar = contactos.get(j);
            if (contactoEvaluar != null 
                    && contactoEvaluar.getIdentificador().equals(dni)   ) {
                
                contactos.remove(contactoEvaluar);
                borrado = true;
            }
            
            j++;
        }
        
        //Opcion 2
        /**
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contactoEvaluar = contactos.get(i);
            if (contactoEvaluar != null 
                    && contactoEvaluar.getDni().equals(dni)   ) {
                
                contactos.remove(contactoEvaluar);
                borrado = true;
            }
        }
        */
        
        
        return borrado;
    }
    
    public boolean existContacto(Contacto contacto) {
        boolean existe = false;
        
        existe =  contactos.contains(contacto);
        
        return existe;
    }
    
    public boolean existContacto(String dni) {
        boolean existe = false;
        
       int j = 0;
        // && !borrado
        while (j < contactos.size() && (existe == false)) {
            
            Contacto contactoEvaluar = contactos.get(j);
            if (contactoEvaluar != null 
                    && contactoEvaluar.getIdentificador().equals(dni)   ) {
                existe = true;
            }
            
            j++;
        }
        
        return existe;
    }
    
    
    public int buscaContacto(String dni) {
       int posicion = -1;
        
        
       int indice = 0;
        // && !borrado
        while (indice < contactos.size() && (posicion == -1)) {

            Contacto contactoEvaluar = contactos.get(indice);
            if (contactoEvaluar != null 
                    && contactoEvaluar.getIdentificador().equals(dni)   ) {
                posicion = indice;
            }

            indice++;
        }
        
        return posicion;
    }
    
    public void listarContacto() {
        
        // Sólo utilizar uno de ellos
        //Opcion 1
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println(contactos.get(i));
        }
        
        //Opcion 2
        int j = 0;
        while (j < contactos.size()) {
            System.out.println(contactos.get(j));
            j++;
        }
        
        //Opcion 3 Iterator
        
        //Opcion 4
        System.out.println(contactos.toString());
        
    }
    
    public int existeContacto() {
        int posicion = -1;
        
        return posicion;
    }
    
}
