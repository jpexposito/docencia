
package es.iespuertodelacruz.jpexposito.modelo;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpexposito
 */

@XmlRootElement
public class Usuario {
    
    private String dni;
    private String nombre;
    private String apellido;

    public Usuario(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Override
    public String toString() {
        return "Dni:" +this.dni + ", Nombre:" + this.nombre + ", Apellidos:" + apellido;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }
    

    
    
    
    
}
