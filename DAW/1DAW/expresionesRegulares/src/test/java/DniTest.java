/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ejemplos.Dni;
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
public class DniTest {
    
    Dni dni;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (dni == null) {
            dni = new Dni();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void dniOkTest() {
        String valor = "11111111A";
        boolean resultado = dni.validar(valor);
        
        assertTrue(resultado, "La cadena no cumple el patron correspondiente");
    
    }
    
    @Test
    public void dniErrorTest() {
        String valor = "11111111";
        boolean resultado = dni.validar(valor);
        
        assertFalse(resultado, "No se puede validar porque dni es incorrecto:"+valor);
    
    }
    
    @Test
    public void dniErrorTamanioTest() {
        String valor = "111111111A";
        boolean resultado = dni.validar(valor);
        
        assertFalse(resultado, "No se puede validar porque dni es incorrecto:"+valor);
   
    }
    
    
}
