package es.iespuertolacruz.jpexposito;

import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class Coches {
    
   ArrayList<String> lista = new ArrayList<String>(); 
   /**
    * Metodo que inserta un coche en la lista
    * @param coche coche a insertar
    */
   public void insertar(String coche) {
       lista.add(coche);
   }
   
   /**
    * Metodo que elimina un coche especifico en la lista
    * @param coche a eliminar de la lista
    */
   public void eliminar(String coche) {
       lista.remove(coche);
   }
    
   /**
    * Metodo que modifica un coche de la lista y sustituye
    * su valor por el nuevo
    * @param coche a sustituir
    * @param nuevo valor a sustituir
    */
   public void modificar(String coche, String nuevo) {
       int posicion = lista.indexOf(coche);
       if (posicion > -1) {
           lista.set(posicion, nuevo);
       }
   }
   /**
    * Funcion que retorno el elemento (coche) especifico de una
    * posicion de la lista
    * @param posicion posicion de la lista
    * @return Elemento de la lista que contiene la posicion
    */
   public String obtenerElementoPosicion(int posicion) {
       String valor = null;
       if (posicion < lista.size()) {
        valor = lista.get(posicion);
       }
       return valor;
   }
   
   /**
    * Funcion que imprime el valor de la lista 
    * @return Un String con la lista de valores
    */
   public String imprimir() {
       return lista.toString();
   }
   
   /**
    * Metodo que limpia el contenido de la lista
    */
   public void eliminarTodo() {
       lista.clear();
   }

    public ArrayList<String> getLista() {
        return lista;
    }
  
}
