
package es.iespuertolacruz.jpexposito.docente;

/**
 *
 * @author jpexposito
 */
public class Persona {
    
    String nombre;
    String apellidos;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    
}
