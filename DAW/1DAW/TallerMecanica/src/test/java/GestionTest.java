/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.Gestion;
import es.iespuertolacruz.jpexposito.elementos.Coche;
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
public class GestionTest {
    
    Gestion gestion;
    Coche coche;
    
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
        coche = generarCoche();
        gestion.insertar(coche);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void insertarTest() {
        
        assertTrue(gestion.getCoches().size() == 1, "El tamanio de la lista es "
                + "incorrecto se esperaba 1");
    }
    
    @Test
    public void buscarTest() {
        Coche cocheEncontrado = gestion.buscar("11111A");
        
        assertEquals(coche.getMatricula(), cocheEncontrado.getMatricula(), 
                "El coche encontrado no coincide");
         assertEquals(coche, cocheEncontrado, 
                "El coche encontrado no coincide");
         //assertTrue(cocheEncontrado.getMarca().equalsIgnoreCase("Opel"), 
         //       "El coche encontrado no coincide");
         
    }
    
    @Test
    public void eliminarTest() {
        gestion.eliminar("11111A");
        
        /** Si la lista contiene elementos
        Coche cocheEncontrado = gestion.buscar("11111A");
          assertTrue(cocheEncontrado == null, "Se ha encontrado un elemento"
                  + " con la matricula indicada");
                  */ 
        assertTrue(gestion.getCoches().isEmpty(), 
                "No se ha eliminado correctamente el elemento");
         
    }
    
    
    private Coche generarCoche() {
       Coche coche = null;
       
       coche = new Coche("Opel", "Corsa", "11111A");
       return coche;
    }
}
