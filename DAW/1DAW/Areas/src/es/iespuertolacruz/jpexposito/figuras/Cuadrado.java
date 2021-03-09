
package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Cuadrado extends Figura{
    float lado;
    
    @Override
    public String toString() {
        return "Cuadrado: lado" +this.lado;
    }

    @Override
    public float area() {
        return this.lado*this.lado;
    }
    
}
