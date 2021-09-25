package es.iespuerto.jpexposito;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class UtilsTest {
    public static final String NOMBRE = "Juan";
    public static final String APELLIDOS = "Perez";
    public static final int EDAD = 26;
    Clase clase;
    Alumno alumno;
    int esperado= 0;

    int obtenido = 0;

    @BeforeEach
    public void before() {
        alumno = new Alumno(NOMBRE, APELLIDOS, EDAD);
        if (clase == null) {
            ArrayList<Alumno> alumnos = new ArrayList<>();
            alumnos.add(alumno);
            clase = new Clase(2, "DAM", alumnos);
        }
    }

    /**
     * Getters and Setters de la clase
     */

    public Clase getClase() {
        return clase;
    }

    public void setEsperado(int esperado) {
        this.esperado = esperado;
    }

    public void setObtenido(int obtenido) {
        this.obtenido = obtenido;
    }
}
