
package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Circulo extends Figura {
     float radio;

    @Override
    public String toString() {
        return "Circulo, radio:" +this.radio;
    }

    @Override
    public float area() {
        return (float) (Math.PI*radio*radio);
    }
    
}
