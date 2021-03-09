/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio3;

import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class Lista {
    
    ArrayList<String> listaElementos = new ArrayList<>();
    
    public void ordenar() {
        ArrayList<String> listaInversa = new ArrayList<>();
        
        int i = 0;
        int tamanio = listaElementos.size();
        while (i < listaElementos.size()) {
            listaInversa.add(listaElementos.get(tamanio-1-i));
            i++;
        }   
    }
    
    
    
}
