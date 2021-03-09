/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ejemplos.CodigoPostal;
import es.iespuertolacruz.jpexposito.ejemplos.Ip;
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
public class IpTest {
    
    Ip ip;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (ip == null) {
            ip = new Ip();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void verificarTest() {
        String valor = "192.0.0.1";
        boolean resultado = ip.validar(valor);
        assertTrue(resultado, "La cadena no cumple con el patron especificado 0000XXX");
    }
     @Test
    public void errorTest() {
        String valor = "256.0.0.1";
        boolean resultado = ip.validar(valor);
        assertFalse(resultado, "La cadena no cumple con el patron especificado 0000XXX");
    }
    
    
}
