

import es.iespuertolacruz.jpexposito.figuras.Cuadrado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jpexposito
 */
public class CuadradoTest {
    Cuadrado cuadrado;
    
    public CuadradoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if (cuadrado == null) {
            cuadrado = new Cuadrado();
        }
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void cuadradoNoNulo() {
        Assert.assertNotNull("El objeto cuadrado es nulo", cuadrado);
    }
}
