
package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Figura {
    
    float altura;
    float base;

    public Figura() {
        altura = 0;
        base = 0;
    }

    
    public Figura(float altura, float base) {
        this.altura = altura;
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }
    
    public String toString() {
        return "Base:" + this.base + ", Altura:" + this.altura;
    }
    
    public float area(){
        return this.base*this.altura;
    }
    
    
    
    
}
