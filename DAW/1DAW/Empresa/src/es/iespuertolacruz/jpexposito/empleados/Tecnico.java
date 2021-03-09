
package es.iespuertolacruz.jpexposito.empleados;

/**
 *
 * @author jpexposito
 */
public class Tecnico extends Operario{

    public Tecnico() {
    }

    public Tecnico(String nombre) {
        super(nombre);
    }
    
    @Override
    public String toString() {
        return "Tecnico:" +this.nombre;
    }
}
