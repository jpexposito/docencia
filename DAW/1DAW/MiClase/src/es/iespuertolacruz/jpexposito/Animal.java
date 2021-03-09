package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class Animal {
    
    private String raza;
    private String nombre;
    private int edad;

    /**
     * Constructor al que se le pasa el nombre del animal
     * @param nombre 
     */
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    /**
    public Animal(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    **/
    
    
    
    
}
