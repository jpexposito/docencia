
package es.iespuertolacruz.jpexposito.empleados;

/**
 *
 * @author jpexposito
 */
public class Oficial extends Operario {

    public Oficial() {
    }

    public Oficial(String nombre) {
        super(nombre);
    }
    
    @Override
    public String toString() {
        return "Oficial:" +this.nombre;
    }
}
