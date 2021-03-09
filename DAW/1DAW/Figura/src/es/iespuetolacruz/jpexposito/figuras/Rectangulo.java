/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuetolacruz.jpexposito.figuras;

/**
 *
 * @author jpexposito
 */
public class Rectangulo extends Forma{
    
    float ladoMayor, ladoMenor;

    public Rectangulo() {
    }

    
    
    public Rectangulo(float ladoMayor, float ladoMenor) {
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
    }
    
    
    
    
    public Rectangulo(String color, String nombre, int x, int y) {
        super(color, nombre, x, y);
    }
    
    
    @Override
    public String imprimir() {
        return "color:"+this.color;
    }
    
    public float area() {
        return ladoMayor*ladoMenor;
    }

    @Override
    public String toString() {
        return "{" + "ladoMayor=" + ladoMayor +
                ", ladoMenor=" + ladoMenor + '}';
    }
    
    
    
    public float perimetro() {
        return 2*ladoMayor+2*ladoMenor;
    }
    
    public float cambiarTamanio(float escala) {
        ladoMenor*=escala;
        ladoMayor*=escala;
     
        return ladoMayor*ladoMenor;
    }

    public float getLadoMayor() {
        return ladoMayor;
    }

    public void setLadoMayor(float ladoMayor) {
        this.ladoMayor = ladoMayor;
    }

    public float getLadoMenor() {
        return ladoMenor;
    }

    public void setLadoMenor(float ladoMenor) {
        this.ladoMenor = ladoMenor;
    }
    
    
    
    
    
}
