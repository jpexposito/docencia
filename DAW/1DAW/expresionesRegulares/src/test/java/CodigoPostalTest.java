/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ejemplos.CodigoPostal;
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
public class CodigoPostalTest {
    
    CodigoPostal codigoPostal;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (codigoPostal == null) {
            codigoPostal = new CodigoPostal();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void validarTest() {
        String valor = "cp38400";
        boolean resultado = codigoPostal.validar(valor);
        assertTrue(resultado,"La cadena no cumple con el patron especificado");
    }
    
    @Test
    public void errorTest(){
        String valor = "CP555";
        boolean resultado = codigoPostal.validar(valor);
        assertFalse(resultado,"La cadena no cumple con el patron especificado");
    }
    
    @Test
    public void errorTamanioIncorrectoTest(){
        String valor = "cp38400CP555";
        boolean resultado = codigoPostal.validar(valor);
        assertFalse(resultado,"La cadena no cumple con el patron especificado");
    }
    
    @Test
    public void errorTamanioIncorrectoCadenaTest(){
        String valor = "cp38400CP555";
        assertTrue(valor.length() == 7, "El tamanio no es correcto");
        boolean resultado = codigoPostal.validar(valor);
        assertFalse(resultado,"La cadena no cumple con el patron especificado");
    }
    
    
}
