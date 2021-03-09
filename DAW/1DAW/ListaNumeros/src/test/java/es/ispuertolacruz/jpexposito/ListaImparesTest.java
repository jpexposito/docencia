/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ispuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.ListaNumeros;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jpexposito
 */
public class ListaImparesTest {
    ListaNumeros listaNumeros = new ListaNumeros();
    int tamanio = 10;
    ArrayList<Integer> lista;
    
    
    @Test
    public void listaParestOkTest() {
      lista = this.listaNumeros.crearLista(tamanio); 
      
      ArrayList<Integer> listaImpares = this.listaNumeros.crearListaImpar(lista);
      for (Integer numero:listaImpares) {
          if (numero%2 == 0) {
               Assertions.fail("La lista contiene numeros impares:" +numero);
          }
      }
      
      
     
    }
}
