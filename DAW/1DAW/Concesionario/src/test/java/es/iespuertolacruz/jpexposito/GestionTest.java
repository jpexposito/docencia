package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.elementos.Cliente;
import es.iespuertolacruz.jpexposito.elementos.Coche;
import es.iespuertolacruz.jpexposito.elementos.Direccion;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class GestionTest {
    
    Gestion gestion;
    Cliente cliente;
    Coche coche;
    
    @BeforeEach
    public void before() {
        if (gestion == null) {
            gestion = new Gestion();
        }
        
        if (coche == null) {
            coche = new Coche("Opel", "Corsa", "11111A");
        }
        if (cliente == null) {
            Direccion direccion = new Direccion(1, "Q", "cp38300", "S/C de Tenerife");
            cliente = new Cliente("A", "B", "1111111H", 17, coche, direccion);
        }
        
        gestion.insertar(coche);
        gestion.insertar(cliente);
    }
    
    @Test
    public void insertarCocheTest() {
        assertTrue(gestion.getCoches().size() == 1, "La lista de coches no contiene el numero correcto");
    }
    
    @Test
    public void insertarClienteTest() {
        assertTrue(gestion.getClientes().size() == 1, "La lista de clientes no contiene el numero correcto");
    }
    
    @Test
    public void eliminarCocheTest() {
        gestion.eliminarCoche("11111A");
        assertTrue(gestion.getCoches().isEmpty(), "La lista de coches no contiene el numero correcto");
    }
    
    @Test
    public void eliminarClienteTest() {
        gestion.eliminarCliente("1111111H");
        assertTrue(gestion.getClientes().isEmpty(), "La lista de clientes no contiene el numero correcto");
    }
}
