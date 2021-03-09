package es.iespuertolacruz.jpexposito.empleados;

/**
 *
 * @author jpexposito
 */
public class Empleado {
    
    String nombre;
    
    public Empleado() {   
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public String toString() {
        return "Empleado:" +this.nombre;
    }
    
    public String mostrarNombre() {
        return this.nombre;
    }
    
    
}
