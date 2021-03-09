/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.exception;

/**
 *
 * @author jpexposito
 */
public class UsuarioExisteException extends Exception {
    
    public UsuarioExisteException() {
      super();
    }
    
    public UsuarioExisteException(String mensaje) {
            super(mensaje); 
    }
    
}
