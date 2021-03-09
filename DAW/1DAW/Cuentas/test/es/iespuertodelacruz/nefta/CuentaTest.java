/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.nefta;

import es.iespuertodelacruz.nefta.Cuenta;
import java.util.function.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nefta
 */
public class CuentaTest {
    Cuenta cuenta;
    String titular ="";
    double cantidad = 0;
    public CuentaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if(cuenta == null){
           cuenta = new Cuenta(titular);
        }
    }
    
    @AfterEach
    public void tearDown() {
    }
    /**
     * Test of getCantidad method, of class Cuenta.
     */
    /**
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Cuenta instance = null;
        double expResult = 0.0;
        double result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    **/
    
    @Test
    public void CuentaNullTest(){
        assertNotNull(cuenta, "El objeto esta vacio");
    }
    
    @Test
    public void CantidadNull(){
        assertNotNull(cantidad, "El objeto es nulo");
    }
    
}
