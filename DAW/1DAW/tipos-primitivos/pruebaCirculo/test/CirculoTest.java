/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.Circulo;
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
public class CirculoTest {
    
    Circulo circulo;
    Circulo circulo2;
    
    public CirculoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        if (circulo == null) {
            circulo = new Circulo();
        }
        if (circulo2 == null) {
            circulo2 = new Circulo();
        }
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void circuloNuloTest() {
         Assert.assertNotNull("La variable circulo es nula",circulo);
     }
     
     @Test
     public void vacioTest() {
         Assert.assertTrue("El circulo no esta vacia",
                 circulo.vacio());
     }
     
     
     @Test
     public void igualesTest() {
         Assert.assertTrue("El circulo 2 no es igual al 1",
                 circulo.iguales(circulo2));
     }
     
     @Test
     public void diferentesTest() {
        circulo2.setRadio(1);
        Assert.assertFalse("Circulo 1 y 2 son iguales",
                circulo.iguales(circulo2));

        

     } 
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     @Test
     public void areaNoNulaTest() {
        Assert.assertNotNull("El metodo area no retorna valor", circulo.area());

     }
     
     @Test
     public void areaTest() {
        circulo.setRadio(1);
        Assert.assertTrue("El valor del area es incorrecto", Math.PI == circulo.area());
     }
     
     
     @Test
     public void perimetroTest() {
        circulo.setRadio(1);
        Assert.assertTrue("El valor del area es incorrecto", 2*Math.PI == circulo.perimetro());
     }
     
     
     
     
     
     
     
     
}
