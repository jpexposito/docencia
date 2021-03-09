/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.elementos;

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
public class ListaTest {
    
    Gestion gestion;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (gestion == null) {
            gestion = new Gestion();
        }
        gestion.insertar(generarPersona());
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void insertarTest() { 
        assertTrue(gestion.getPersonas().size() == 1, "El numero de elementos es"
                + " incorrectos, se esperaba 1");
    }
    
    @Test
    public void eliminarTest() { 
        gestion.eliminar(generarPersona());
        assertTrue(gestion.getPersonas().isEmpty(), "El numero de elementos es"
                + " incorrectos, se esperaba 0");
    }
    
    @Test
    public void contarTest() { 
        assertTrue(gestion.contar() == 1, "El numero de elementos es"
                + " incorrectos, se esperaba 1");
    }
    
    
    private Persona generarPersona() {
        Direccion direccion = new Direccion("la calle", 1, "S/C de Tenerife");
        Persona persona = new Persona("Juan", "Hdez", 111111, 20, direccion);
        return persona;
    }
}
