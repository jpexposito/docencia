/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.coleccion;


import java.util.*;
import es.iespuertolacruz.jpexposito.coleccion.elementos.*;
/**
 *
 * @author jpexposito
 */
public class PruebaHastSet {
    
    private Set <Cliente> clientesBanco = new  HashSet<Cliente>();

    public PruebaHastSet() {
        this.clientesBanco = new HashSet<>();
    }
    
    public PruebaHastSet(Set <Cliente> clientesBanco ) {
        this.clientesBanco = clientesBanco;
    }

    public Set<Cliente> getClientesBanco() {
        return clientesBanco;
    }    
    
    /**
     * Metodo que permite insertar un cliente en el Set
     * @param cliente Objeto de tipo cliente
     */
    public void insertar(Cliente cliente) {
        clientesBanco.add(cliente);
    }
    
    public void eliminar(Cliente cliente) {
        clientesBanco.remove(cliente);
    }
    
    @Override
    public String toString() {
        return clientesBanco.toString();
    }

    void modificar(String cuenta, String nombre) {
        for(Cliente cliente:clientesBanco) {
            if (cliente.getNumCuenta().equalsIgnoreCase(cuenta)) {
                cliente.setNombre(nombre);
                break;
            }
        }
        
    }
    
    
    
    
}
