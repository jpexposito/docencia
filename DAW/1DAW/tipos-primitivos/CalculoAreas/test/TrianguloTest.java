

import es.iespuertolacruz.jpexposito.figuras.Triangulo;
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
public class TrianguloTest {
    
    Triangulo triangulo;
    
    public TrianguloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if(triangulo == null) {
            triangulo = new Triangulo();
        }
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void areaTest() {
       triangulo.setAltura(1);
       triangulo.setBase(1);
        Assert.assertTrue("El resultado del area no es el esperado",
                0.5f == triangulo.area());
    }
}
