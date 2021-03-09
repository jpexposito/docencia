
package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Triangulo extends Figura{

    public Triangulo() {
        
    }
    
    public Triangulo(float altura, float base) {
        super(altura, base);
    }


    @Override
    public float area() {
        return (float)(base*altura)/2;
    }
    
    
}
