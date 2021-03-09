
package es.iespuertolacruz.jpexposito.empleados;

/**
 *
 * @author jpexposito
 */
public class Directivo extends Empleado {

    public Directivo() {
    }

    public Directivo(String nombre) {
        super(nombre);
    }
    
    public String toString(){
        return this.getClass().getSimpleName() + ":" + this.nombre;
    }
    
    
}
