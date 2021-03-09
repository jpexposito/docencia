
package es.iespuertolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Cuadrado extends Figura {  
    
    public Cuadrado() {
        super();
    }
    
    public Cuadrado(float lado) {
        super(lado, lado);
    }
    
    public Cuadrado(float altura, float base) {
        super(altura, base);
    }
    
    @Override
    public String toString(){
        return "Lado:" + this.altura;
    }
  
}
