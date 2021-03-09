package es.iespuertolacruz.jpexposito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpexposito
 */
public class CalculadoraTest {
    
    Calculadora calculadora = null;
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("Esto es BeforeClass ");
        if (calculadora == null) {
            calculadora = new Calculadora();
        } 
    }
    
    @AfterClass
    public void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Esto es Before ");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void primerTest() {
        
       
        
        calculadora.suma(0, 0);
    }
    
    @Test
    public void segundoTest() {}
}
