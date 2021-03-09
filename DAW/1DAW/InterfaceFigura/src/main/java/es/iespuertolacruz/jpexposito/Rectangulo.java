/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class Rectangulo implements Figura{

    float base;
    float altura;    

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
    @Override
    public float area() {
        return this.base * this.altura;
    }
    
}
