

import es.iespuertolacruz.jpexposito.empleados.Oficial;
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
public class OficialTest {
    
    Oficial oficial;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if (oficial == null) {
            oficial = new Oficial();
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void operararioTest() {
        Assert.assertTrue("El campo nombre no es vacio",
                oficial.getNombre() == null);
    }
}
