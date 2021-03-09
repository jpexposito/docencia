
package es.iespuertolacruz.jpexposito.empleados;

/**
 *
 * @author jpexposito
 */
public class Operario extends Empleado {
    
    public Operario() {
    }

    public Operario(String nombre) {
        super(nombre);
    }
    
    @Override
    public String toString() {
        return "Operario:" +this.nombre;
    }
    
    
    
}
