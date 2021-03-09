/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito.controlador;

import es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException;
import es.iespuertodelacruz.jpexposito.exception.FicheroNoExisteException;
import es.iespuertodelacruz.jpexposito.exception.GestionFicheroException;
import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import es.iespuertodelacruz.jpexposito.modelo.file.UsuarioFile;

/**
 *
 * @author jpexposito
 */
public class UsuarioFileControlador {
    
    String rutaFichero = "usarioFileRest.xml";
    UsuarioFile usuarioFile = new UsuarioFile();
    
    
    public void insertar (String dni, String nombre, String apellidos) throws DatosIncorrectosException, GestionFicheroException, FicheroNoExisteException {
        String camposIncorrectos = null;
        
        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        } 
        
        if (nombre == null || nombre.isEmpty()) {
            camposIncorrectos += " El nombre no puede ser nulo o vacio,";
        }
        
        if (apellidos == null || apellidos.isEmpty()) {
            camposIncorrectos += " Los apellidos no puede ser nulo o vacio";
        }
        
        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }
        
        
        Usuario usuario = new Usuario(dni, nombre, apellidos);  
        usuarioFile.insertar(rutaFichero, usuario);
    }
    
    
     public void buscar (String dni) throws DatosIncorrectosException, GestionFicheroException, FicheroNoExisteException {
        String camposIncorrectos = null;
        
        if (dni == null || dni.isEmpty()) {
            camposIncorrectos = "El dni no puede ser nulo o vacio,";
        } 
        
        if (camposIncorrectos != null) {
            throw new DatosIncorrectosException(camposIncorrectos);
        }
        
         
        usuarioFile.buscar(rutaFichero, dni);
    }
}
