/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio1;

import es.iespuertolacruz.jpexposito.Coches;
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
public class CochesTest {
    
    Coches coches;
    String ford = "Ford";
    @BeforeEach
    public void setUp() {
        if (coches == null) {
            coches = new Coches();
        }
        coches.insertar(ford);
    }
    
    @Test
    public void insertarTest() {
        assertTrue(coches.getLista().size() == 1, 
                "El tamanio de la lista es incorrecto");
    }
    
    @Test
    public void eliminarTest() {
        coches.eliminar(ford);
        assertTrue(coches.getLista().size() == 0, 
                "El tamanio de la lista es incorrecto");
    }
    
    
    @Test
    public void limpiarListaTest() {
        coches.eliminarTodo();
        assertTrue(coches.getLista().size() == 0, 
                "El tamanio de la lista es incorrecto");
    }
    
    @Test
    public void modificarTest() {
        String seat = "Seat";
        coches.modificar(ford, seat);
        assertTrue(coches.getLista().size() == 1, 
                "El tamanio de la lista es incorrecto");
        
        assertTrue(coches.getLista().contains(seat), 
                "La lista no contiene la marca "+seat);
    }
    
}
