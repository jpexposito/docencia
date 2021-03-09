/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.coleccion;

import es.iespuertolacruz.jpexposito.coleccion.elementos.Empleado;
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
public class PruebaMapTest {
    
    PruebaMapas pruebaMapas;
    Empleado empleado = new Empleado("Juan");
    String clave = "145";
    
    @BeforeAll
    public static void setUpClass() {
     
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        if (pruebaMapas == null) {
            pruebaMapas = new PruebaMapas();
        }
        pruebaMapas.insertar(clave, empleado);
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void listaNoVacia() {
        assertFalse(pruebaMapas.isEmpy(), "El HasMap no contiene elementos");
    }

    @Test
    public void insertarTest() {
        
        boolean condicion = false;
        
        Empleado empleadoBuscar;
        
        empleadoBuscar = pruebaMapas.buscar(clave);
        
        if (empleadoBuscar.equals(empleado)) {
            condicion = true;
        }
    
        assertTrue(condicion, "El elemento no se encuentra en el HasMap");
    
    }
    
    @Test
    public void eliminarTest() {
        pruebaMapas.eliminar(clave);
        assertTrue(pruebaMapas.isEmpy(), "Existen elementos en la lista");
    }
}
