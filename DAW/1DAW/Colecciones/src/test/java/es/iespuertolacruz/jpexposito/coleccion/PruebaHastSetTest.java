/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.coleccion;

import es.iespuertolacruz.jpexposito.coleccion.elementos.Cliente;
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
public class PruebaHastSetTest {
    
    PruebaHastSet pruebaHastSet;
    Cliente cliente;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (pruebaHastSet == null) {
            pruebaHastSet = new PruebaHastSet();
        }
        if (cliente == null) {
            cliente = generarCliente("Juan", "00001", 2000);
        }
        pruebaHastSet.insertar(cliente);
        
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void insertarTest() {
        assertTrue(pruebaHastSet.getClientesBanco().size() == 1, "El tamanio del Set no es el correcto, se esperaba 1");
    }
    
    @Test
    public void eliminarTest() {
        pruebaHastSet.eliminar(cliente);
        assertTrue(pruebaHastSet.getClientesBanco().size() == 0, "El tamanio del Set no es el correcto, se esperaba 0");
    }
    
    @Test
    public void imprimirTest() {
        assertTrue(pruebaHastSet.toString().contains("Juan"), "La cadena no contiene el texto esperado");
        assertTrue(pruebaHastSet.toString().contains("00001"), "La cadena no contiene el texto esperado");
        assertTrue(pruebaHastSet.toString().contains("2000"), "La cadena no contiene el texto esperado");
    }
    
    @Test
    public void modificarTest() {
        pruebaHastSet.modificar("00001", "Pedro");
        assertTrue(pruebaHastSet.toString().contains("00001"), "La cadena no contiene el texto esperado");
        assertTrue(pruebaHastSet.toString().contains("Pedro"), "La cadena no contiene el texto esperado");
        
        
    }
    
    
    
    private Cliente generarCliente(String nombre, String cuenta, int saldo) {
        return new Cliente(nombre, cuenta, saldo);
    }
}
