package es.iespuerto.jpexposito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InstitutoTest extends UtilsTest{
    Instituto instituto;
    ArrayList<Clase> clases;

    @BeforeEach
    public void beforeClass() {
        this.before();
        clases = new ArrayList<>();
        clases.add(this.getClase());
        instituto = new Instituto(clases);
    }

    @Test
    public void ceroAlumnosTest(){
        Instituto instituto = new Instituto(new ArrayList<>());
        obtenido = instituto.alumnosTotal();
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }

    @Test
    public void unAlumnosTest(){
        esperado = 1;
        obtenido = instituto.alumnosTotal();
        Assertions.assertEquals(esperado, obtenido, "El numero de alumnos no es el esperado");
    }

}
