/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ejemplos.Dni;
import es.iespuertolacruz.jpexposito.ejemplos.Fecha;
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
public class FechaTest {
    
    Fecha fecha;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        if (fecha == null) {
            fecha = new Fecha();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void validarFecha() {
        
        String valor = "11/01/2021";
        boolean resultado = fecha.validar(valor);
        
        assertTrue(resultado, "La fecha no es correcta");
        
    }
    
    @Test
    public void validarErrorFecha() {
        
        String valor = "31/13/1010";
        boolean resultado = fecha.validar(valor);
        
        assertFalse(resultado, "La fecha no es correcta");
        
    }
    
    @Test
    public void dniErrorTest() {
        String valor = "39/52/2541";
        boolean resultado = fecha.validar(valor);
        
        assertFalse(resultado, "No se puede validar porque dni es incorrecto: "
                + valor);
    }
}
