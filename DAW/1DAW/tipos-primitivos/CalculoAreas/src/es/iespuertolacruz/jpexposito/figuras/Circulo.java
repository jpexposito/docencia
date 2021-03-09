
package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Circulo extends Figura {
    
    float radio;

   
    
    public Circulo(float radio) {
        this.radio = radio;
    }
    
    
    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    
    /**
     * Funcion que calcula el area de un circulo.
     * @return area calculada
     */
    @Override
    public float area() {
        return (float) (Math.PI*radio*radio);
    }
    
    @Override
    public String toString(){
        return "";
    }
    
}
