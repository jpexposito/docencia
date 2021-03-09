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
public class Circulo extends Elipse{
    
    float radio;

    public Circulo() {
    }

    
    
    public Circulo(float radio) {
        this.radio = radio;
    }
    
    public Circulo(float radio, String color, String nombre, int x, int y) {
        super(color, nombre, x, y);
        this.radio = radio;
    }
    
    public Circulo(String color, String nombre, int x, int y) {
        super(color, nombre, x, y);
    }
    
    @Override
    public float area() {
        return (float) 3.14 *radio*radio;
    }

    @Override
    public String toString() {
        return "Circulo{" + "radio=" + radio + '}';
    }
    
    
    
    
}
