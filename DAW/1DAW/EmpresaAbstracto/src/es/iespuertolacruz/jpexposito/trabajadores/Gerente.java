
package es.iespuertolacruz.jpexposito.trabajadores;

/**
 *
 * @author jpexposito
 */
public class Gerente extends Tecnico{

    @Override
    public String mostrarEspecialidad() {
        return this.getEspecialidad();
    }

    @Override
    public String mostrarNombre() {
       return this.getNombre();
    }
    
}
