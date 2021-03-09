/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio1;

import es.iespuertolacruz.jpexposito.ejercicio1.exception.AsignaturaExpcetion;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jpexposito
 */
public class PrincipalAsignaturaTest {
    
    ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
    PrincipalAsignatura principal = new PrincipalAsignatura(listaAsignaturas);
    Asignatura matematicas;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        matematicas = new  Asignatura("Matematicas", 6);
        this.listaAsignaturas.add(matematicas);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test que verifica si verificarAsignatura una asignatura en la lista y
 lanza el error esperado
     */
    @Test
    public void asignaturaExpeticonTest() {
        
        try {
            principal.verificarAsignatura(matematicas);
        }catch (AsignaturaExpcetion asignaturaExpcetion) {
            assertTrue(asignaturaExpcetion.getMessage().contains("existe"),
                    "No se ha recibido el mensaje esperado");
        }
    }
    
    /**
     * Verifica que no se muestran asignaturas aprobadas
     */
    @Test
    public void mostrarSuspendidasTest() {
        
        try {
            listaAsignaturas.add(new Asignatura("Fisica", 3));
            String mensaje = principal.mostrar_v2();
             assertFalse(mensaje.contains("5"), "El mensaje de la lista contiene valores iguales a 5");
            
        }catch (Exception expcetion) {
            fail("Se ha producido un error inesperado en mostrarSuspendidasTest");
        }
    
    }
    
    
}
