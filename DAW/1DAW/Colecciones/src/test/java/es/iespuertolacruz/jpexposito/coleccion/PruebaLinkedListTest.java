package es.iespuertolacruz.jpexposito.coleccion;

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
public class PruebaLinkedListTest {

    PruebaLinkedList pruebaLinkedList;

    @BeforeEach
    public void before() {
        if (pruebaLinkedList == null) {
            pruebaLinkedList = new PruebaLinkedList();
        }
        pruebaLinkedList.insertar("Juan");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void insertarTest() {

        assertTrue(pruebaLinkedList.getPersonas().contains("Juan"),
                "La lista no contiene a la persona especificada");
        assertTrue(pruebaLinkedList.getPersonas().size() == 1,
                "La lista no contiene el tamanio correcto");
    }

    @Test
    public void borrarTest() {

        pruebaLinkedList.borrar("Juan");
        assertFalse(pruebaLinkedList.getPersonas().contains("Juan"),
                "La lista contiene a la persona especificada");

    }

    @Test
    public void buscarTest() {
        assertTrue(pruebaLinkedList.buscar("Juan"),
                "La persona debe de existir en la lista");
    }
    
    @Test
    public void eliminarPrimeroTest() {
        pruebaLinkedList.eliminarPrimerElemento();
        assertFalse(pruebaLinkedList.buscar("Juan"),
                "La persona debe de existir en la lista");
    }
    
    @Test
    public void eliminarUltimoTest() {
        pruebaLinkedList.eliminarUltimoElemento();
        assertFalse(pruebaLinkedList.buscar("Juan"),
                "La persona debe de existir en la lista");
    }
}
