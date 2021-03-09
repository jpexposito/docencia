
package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class Ejemplo {
    
    public static void main(String[] args) {
        Animal miAnimal = new Animal("Falco");
        miAnimal.setEdad(3);
        System.out.println("El nombre es: " + miAnimal.getNombre());
        System.out.println(" y tiene " + miAnimal.getEdad() + " años");
    }
    
}
