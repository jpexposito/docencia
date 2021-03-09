

import es.iespuertolacruz.jpexposito.figuras.Rectangulo;
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
public class RectanguloTest {
    Rectangulo rectangulo;
    
    public RectanguloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if (rectangulo == null) {
            rectangulo = new Rectangulo();
        }
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void rectanguloNuloTest() {
        Assert.assertNotNull("El rectangulo es nulo", rectangulo); 
    }
    
    @Test
    public void areaTest() {
        Assert.assertEquals("La area obtenida no es la esperada",
                0, rectangulo.area()); 
    }
    
    @Test
    public void areaValorInicializadoTest() {
        rectangulo.setAltura(2);
        rectangulo.setBase(3);
        Assert.assertEquals("La area obtenida no es la esperada",
                6, rectangulo.area()); 
    }
}
