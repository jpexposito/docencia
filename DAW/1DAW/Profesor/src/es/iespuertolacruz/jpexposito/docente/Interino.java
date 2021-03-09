
package es.iespuertolacruz.jpexposito.docente;

/**
 *
 * @author jpexposito
 */
public class Interino extends Profesor {

    public Interino(String nombre, String apellidos, String tipo) {
        super(nombre, apellidos, "INTERINO");
    }

    @Override
    public float importeNomina() {
        return 0.9F*nomina;
    }
    
}
