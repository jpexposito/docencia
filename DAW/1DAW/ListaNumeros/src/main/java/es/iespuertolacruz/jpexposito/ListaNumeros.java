/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jpexposito
 */
public class ListaNumeros {
    
    static int semilla = 1000000;
    
    
    /**
     * Funcion que retorna un numero aleatorio
     * @return 
     */
    public int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(semilla) +1;
        
    }
    
    /**
     * Funcion que crea una lista de numeros aleatorios
     * @param tamanio, tamanio de la lista de elementos
     */
    public ArrayList<Integer> crearLista(int tamanio ) {
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        for (int i = 0; i< tamanio; i++ ) {
            listaNumeros.add(generarNumeroAleatorio());
        }
        return listaNumeros;
    }
    
    /**
     * Funcion que crea la lista de numeros pares
     * @param listaNumeros
     * @return Retorna una lista nueva de numeros pares
     */
    public ArrayList<Integer> crearListaPar(ArrayList<Integer> listaNumeros) {
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (Integer numero:listaNumeros) {
            if (numero % 2 == 0) {
                listaPar.add(numero);
            }
        }
        return listaPar;
    }
    
    /**
     * Funcion que crea la lista de numeros impares
     * @param listaNumeros
     * @return Retorna una lista nueva de numeros impares
     */
    public ArrayList<Integer> crearListaImpar(ArrayList<Integer> listaNumeros) {
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (Integer numero:listaNumeros) {
            if (numero % 2 != 0) {
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }
    
    
    
     /**
     * Metodo que muesta los numeros pares de una lista
     * @param listaNumeros, lista de numeros a recorrer 
     * @return retorna una lista ordenada
     */
    public ArrayList<Integer> crearListaPosicionPar(ArrayList<Integer> listaNumeros) {
        ArrayList<Integer> listaPoscionPar = new ArrayList<>();

        for (int i= 0; i < listaNumeros.size(); i++) {
            if (i % 2 == 0) {
                listaPoscionPar.add(listaNumeros.get(i));
            }
        }
        return listaPoscionPar;
    }
    
    public ArrayList<Integer> crearListaPosicionImPar(ArrayList<Integer> listaNumeros) {
        ArrayList<Integer> listaPoscionImPar = new ArrayList<>();

        for (int i= 0; i < listaNumeros.size(); i++) {
            if (i % 2 == 0) {
                listaPoscionImPar.add(listaNumeros.get(i));
            }
        }
        return listaPoscionImPar;
    }
    
}
