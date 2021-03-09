/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import es.iespuertolacruz.jpexposito.Gato;
import es.iespuertolacruz.jpexposito.exceptiones.EdadException;
import es.iespuertolacruz.jpexposito.exceptiones.NombreException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author jpexposito
 */
public class GatoTest {

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void gatoNombreErrorTest() {
        try {
            Gato gato = new Gato("Is", 1);
        } catch(NombreException exception) {
            Assertions.assertTrue(exception.getMessage().
                    contains("no puede ser nulo o de tamanio menor"),
                    "No devuelve el mensaje correcto");
        } catch (EdadException ex) {
            Assertions.fail("No se puede producir esta exception EdadException");
        } 
    }
    
    
        @Test
    public void gatoEdadErrorTest() {
        try {
            Gato gato = new Gato("Isi", 0);
        } catch(EdadException exception) {
            Assertions.assertTrue(exception.getMessage().
                    contains("mayor que 0"),
                    "No devuelve el mensaje correcto");
        } catch (NombreException ex) {
            Assertions.fail("No se puede producir esta exception NombreException");
        } 
    }
}
