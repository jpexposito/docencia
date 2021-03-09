

import es.iespuertolacruz.jpexposito.empleados.Empleado;
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
public class EmpleadoTest {
    
    Empleado empleado;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if(empleado == null) {
            empleado = new Empleado("Juan");
        }
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void empleadoNoNulo() {
        Assert.assertNotNull("La variable empleado "
                + "no se ha iniciado correctamente", empleado);
    }
    
    @Test
    public void empleadoToString() {
        
       String mensajeEsperado = "Empleado:Juan"; 
       
       Assert.assertTrue("El metodo toString"
               + " no funciona correctamente", 
               mensajeEsperado.equalsIgnoreCase(empleado.toString()));
    }
    
}
