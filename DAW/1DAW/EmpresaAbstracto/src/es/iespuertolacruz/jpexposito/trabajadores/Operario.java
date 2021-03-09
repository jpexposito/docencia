
package es.iespuertolacruz.jpexposito.trabajadores;

/**
 *
 * @author jpexposito
 */
public class Operario extends Empleado {

    @Override
    public String mostrarNombre() {
        return this.getClass().getSimpleName()+this.getNombre();
        //return "Operario:" +this.getNombre();
    }
    
}
