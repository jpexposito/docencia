/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ProgramaPalabra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jpexposito
 */
public class ProgramaPalabraTest {
    
    ProgramaPalabra programa = new ProgramaPalabra();
    
    String elementos = "hola,adios,hola,adios";
    
    ArrayList<String> arrayListaPrueba = new ArrayList<String>(Arrays.asList(elementos.split(",")));
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void addPalabraLista() {
        ArrayList<String> lista = new ArrayList<>();
        
        programa.insertarPalabra(lista, "uno");
        assertTrue(lista.size() == 1, "La lista contiene mas de un elemento:"+lista.size());
    
    }
    
    @Test
    public void contarPalabraLista() {
        int numero = programa.contarPalabras(arrayListaPrueba);
        assertTrue(numero == 3, "La lista no contiene el numero correcto:"+numero);
    }
}
