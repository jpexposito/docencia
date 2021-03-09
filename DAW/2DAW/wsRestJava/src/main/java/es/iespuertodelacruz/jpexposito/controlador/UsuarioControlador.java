
package es.iespuertodelacruz.jpexposito.controlador;


import es.iespuertodelacruz.jpexposito.modelo.Usuario;
import es.iespuertodelacruz.jpexposito.exception.DatosIncorrectosException;
import es.iespuertodelacruz.jpexposito.exception.UsuarioExisteException;
import es.iespuertodelacruz.jpexposito.modelo.jdbc.dao.UsuarioDao;

/**
 *
 * @author jpexposito
 */
public class UsuarioControlador {
    
    UsuarioDao usarioDao;
    
    public void insertar(String dni, String nombre, String apellidos) throws DatosIncorrectosException, UsuarioExisteException {
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
        
        usarioDao.insertar(usuario);
        
    }
    
    
}
