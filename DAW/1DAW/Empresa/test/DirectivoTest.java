

import es.iespuertolacruz.jpexposito.empleados.Directivo;
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
public class DirectivoTest {
    
    Directivo directivo;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if (directivo == null){
            directivo = new Directivo("Pedro");
        } 
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void directivoToString() {
    String mensajeEsperado = Directivo.class.getSimpleName()+":Pedro"; 
       
       Assert.assertTrue("El metodo toString"
               + " no funciona correctamente", 
               mensajeEsperado.equalsIgnoreCase(directivo.toString()));
    }
}
