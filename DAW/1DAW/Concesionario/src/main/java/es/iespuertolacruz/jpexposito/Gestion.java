
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.elementos.Cliente;
import es.iespuertolacruz.jpexposito.elementos.Coche;
import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class Gestion {
    ArrayList<Cliente> clientes;
    ArrayList<Coche> coches;

    public Gestion() {
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
        if (coches == null) {
            coches = new ArrayList<>();
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }
    
    
    
    /**
     * Metodo que permite insertar un coche
     * @param coche de la lista
     */
    public void insertar(Coche coche) {
        coches.add(coche);
        
    }
    
    /**
     * Metodo que permite insertar una persona
     * @param cliente de la lista
     */
    public void insertar(Cliente cliente) {
        clientes.add(cliente);
    }
    
    /**
     * Funcion que permite la busqueda de un coche 
     * @param matricula del coche a buscar
     */
    public Coche buscarCoche(String matricula) {
        boolean encontrado = false;
        Coche cocheEncontrado = null;
        int i = 0;
        while (i < coches.size() || !encontrado) {
            if (coches.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                cocheEncontrado = coches.get(i);
                encontrado = true;
            }
            i++;
        }
        return cocheEncontrado;
    }
    
    /**
     * Funcion que permite la busqueda de un cliente
     * @param dni de la persona a buscar
     */
    public Cliente buscarCliente(String dni) {
        boolean encontrado = false;
        Cliente clienteEntronctrado = null;
        
        int i = 0;
        while (i < clientes.size() || !encontrado) {
            if (clientes.get(i).getDni().equalsIgnoreCase(dni)) {
                clienteEntronctrado = clientes.get(i);
                encontrado = true;
            }
            i++;
        }
        
        return clienteEntronctrado;
    }
    
    /**
     * Metodo que permite eliminar un coche de la lista
     * @param matricula del coche a eliminar
     */
    public void eliminarCoche(String matricula) {
        Coche coche = buscarCoche(matricula);
        if (coche != null) {
            coches.remove(coche);
        }
    }
    
    /**
     * Metodo que permite eliminar un cliente de la lista
     * @param dni del cliente a eliminar
     */
    public void eliminarCliente(String dni) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }

}
