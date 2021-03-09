
import es.iespuertolacruz.jpexposito.Cuenta;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jpexposito
 */
public class CuentaTest {
    
    Cuenta cuenta = null;
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes de la Clase");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Despues de la Clase");

    }
    
    @Before
    public void setUp() {
        System.out.println("Antes del test");
        if (cuenta == null) {
            cuenta = new Cuenta();
        }

    }
    
    @After
    public void tearDown() {
        System.out.println("Despues del test");

    }

    @Test
    public void helloTest() {}
    
    @Test
    public void helloTest2() {}
    
    @Test
    public void cantidadTest() {
        cuenta.setCantidad(5.0);
        cuenta.ingresar(-10.0);
        assertEquals("El valor obtenido no es el esperado",
                cuenta.getCantidad(), 5.0);
    
    }
}
