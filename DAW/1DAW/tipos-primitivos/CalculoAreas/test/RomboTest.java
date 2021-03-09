

import es.iespuertolacruz.jpexposito.figuras.Rombo;
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
public class RomboTest {
    
    Rombo rombo;
    
    public RomboTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if(rombo == null) {
            rombo = new Rombo();
        }
        
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void romboNotNull() {
        Assert.assertNotNull("El valor de la variables rombo es nulo", rombo);
    }
    
    @Test
    public void area() {
        rombo.setDiagonalMayor(1);
        rombo.setDiagonalMenor(1);
        Assert.assertEquals("El valor del area no es el esperado",
                0.5f, rombo.area(), 0);
    }
    
    @Test
    public void areaValoresNegativos() {
        try {
            rombo = new Rombo(1, -1);
        } catch (ArithmeticException arithmeticException) {
            Assert.assertTrue("No se ha obtenido el mensaje esperado",
                    arithmeticException.getMessage().contains("cero"));
        } catch (Exception exception) {
            Assert.fail("Se ha producido un error no controlado:"
            +exception.getMessage());
        }
    }
    
}
