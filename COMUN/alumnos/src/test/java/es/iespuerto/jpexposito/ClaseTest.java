package es.iespuerto.jpexposito;

import org.junit.jupiter.api.*;

public class ClaseTest extends UtilsTest {

    String letra;

    @Test
    public void ceroAlumnosTest() {
        Clase clase = new Clase();
        obtenido = clase.numeroAlumnos();
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }

    @Test
    public void unoAlumnosTest() {
        esperado = 1;
        obtenido = clase.numeroAlumnos();
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }

    /**
     * Test que tiene como objetivo filtrar los alumnos con una edad igual o mayor a una dada
     */
    @Test
    public void unAlumno25Test() {
        int edad = 25;
        esperado = 1;
        obtenido = clase.numeroAlumnos(edad);
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }

    @Test
    public void alumnosComienzanATest() {
        letra = "a";
        obtenido = clase.numeroAlumnos(letra);
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }
    @Test
    public void alumnosComienzanJTest() {
        letra = "J";
        esperado = 1;
        obtenido = clase.numeroAlumnos(letra);
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }

}
