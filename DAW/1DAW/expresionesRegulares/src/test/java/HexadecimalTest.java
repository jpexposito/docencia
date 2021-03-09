/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ejemplos.CodigoPostal;
import es.iespuertolacruz.jpexposito.ejemplos.Hexadecimal;
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
public class HexadecimalTest {
    
    Hexadecimal hexadecimal;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (hexadecimal == null) {
            hexadecimal = new Hexadecimal();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

   @Test
    public void hexadecimalOkTest() {
        String valor = "0F";
        boolean resultado = hexadecimal.validar(valor);
        assertTrue(resultado, "La cadena no cumple el patron correspondiente");
    }
    
    @Test
    public void hexadecimalErrorTest() {
        String valor = "1AA";
        boolean resultado = hexadecimal.validar(valor);
        assertFalse(resultado, "No se puede validar porque el numero"
                + " es incorrecto: "+valor);
    }
    
    @Test
    public void hexadecimalOk2Test() {
        String valor = "FF78ab";
        boolean resultado = hexadecimal.validar(valor);
        
        assertTrue(resultado, "La cadena no cumple el patron correspondiente");
    
    }
    @Test
    public void hexadecimalError2Test() {
        String valor = "78FG0";
        boolean resultado = hexadecimal.validar(valor);
        
        assertFalse(resultado, "No se puede validar porque dni es incorrecto:"+valor);
    
    }
    
    @Test
    public void hexadecimalCorrecto2Test() {
        String valor = "20";
        boolean resultado = hexadecimal.validar(valor);
        
        assertTrue(resultado, "No se puede validar porque dni es incorrecto:"+valor);
    
    }
    
    
}
