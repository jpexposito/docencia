
import es.iespuertolacruz.jpexposito.ListaNumeros;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpexposito
 */
public class ListaNumerosTest {
    ListaNumeros listaNumeros = new ListaNumeros();
    int tamanio = 10;
    ArrayList<Integer> lista;
    
    @Test
    public void crearListaTest() {
      lista = this.listaNumeros.crearLista(tamanio);
      Assertions.assertTrue(lista.size() == tamanio,"El tamanio de la lista"
              + " es incorrecto, esperado = " +tamanio);
    }
    
}
