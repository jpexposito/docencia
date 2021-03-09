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
public class Elipse extends Forma{
    
    float areaMayor;
    float areaMenor;

    public Elipse() {
    }
    
    

    public Elipse(float areaMayor, float areaMenor) {
        this.areaMayor = areaMayor;
        this.areaMenor = areaMenor;
    }
    

    public Elipse(float areaMayor, float areaMenor, String color, String nombre, int x, int y) {
        super(color, nombre, x, y);
        this.areaMayor = areaMayor;
        this.areaMenor = areaMenor;
    }
    
    
    public Elipse(String color, String nombre, int x, int y) {
        super(color, nombre, x, y);
    }
    
    public float area() {
        return (float) 3.14 * areaMayor*areaMenor;
    }
    
    @Override
    public String toString() {
        return "Elipse-> areaMenor:" + areaMayor
                + ", areaMenor: "+areaMenor;
    }
    
}
