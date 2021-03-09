/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio2;

import es.iespuertolacruz.jpexposito.ejercicio2.exepction.LoteriaException;
import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class Loteria {
    
    ArrayList<Integer> listaNumeros = new ArrayList<>();
    
     /**
     * Metodo mejorado para la ordenacion durante la insercion
     * Esta solucion no es buena miren la cantidad de if y else (codigo espagueti)
     * @param numero 
     */
    public void insertarOrdenado(Integer numero) {
        
        if (listaNumeros.size() > 0) {
          // Si se trata de un numero mayor que el   
          if (numero > listaNumeros.get(listaNumeros.size()-1)) {
              listaNumeros.add(numero);
          } else {
             for(int i= 0; i < listaNumeros.size(); i++) {
                if (numero < listaNumeros.get(i)) {
                    listaNumeros.set(i, numero);
                    break;
                }
            }  
          }
        } else { //O si se trata del primero
            listaNumeros.add(numero);
        }  
    }
    
    /**
     * Metodo mejorado para la ordenacion durante la insercion
     * Esta solucion no es buena miren el for y cuando lo inserta el break
     * que se hace para romper el flujo
     * @param numero 
     */
    public void insertarOrdenadoMejorado(Integer numero) {
        
        if (listaNumeros.size() < 1 || numero > listaNumeros.size() -1) {
           listaNumeros.add(numero); 
        } else {
             for(int i= 0; i < listaNumeros.size(); i++) {
                if (numero < listaNumeros.get(i)) {
                    listaNumeros.set(i, numero);
                    break;
                }
            }  
          }
     }
    
    /**
     * Metodo mejorado para la ordenacion durante la insercion
     * La mejor solucion de las 3
     * @param numero 
     */
    public void insertarOrdenadoMejorado2(Integer numero) {
        boolean insertado = false;
        if (listaNumeros.size() < 1 || numero > listaNumeros.size() -1) {
           listaNumeros.add(numero); 
        } else {
            int i = 0;
            while (i <  listaNumeros.size() || insertado) {
                if (numero < listaNumeros.get(i)) {
                    listaNumeros.set(i, numero);
                    insertado = true;
                } 
            }  
        }
     }
    
    public void verificarElemento(Integer numero) throws LoteriaException {
        if (listaNumeros.contains(numero)) {
            throw new LoteriaException("El numero "+numero+ ", existe en el listado");
        }
    }
    
    
}
