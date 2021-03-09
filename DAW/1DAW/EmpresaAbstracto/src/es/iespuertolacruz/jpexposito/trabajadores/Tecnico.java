
package es.iespuertolacruz.jpexposito.trabajadores;

/**
 *
 * @author jpexposito
 */
public abstract class Tecnico extends Empleado {
    
    public String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    public abstract String mostrarEspecialidad();
    
    
    
}
