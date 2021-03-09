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
public class Cuadrado implements Figura {

    float lado;

    public Cuadrado(float lado) {
        this.lado = lado;
    }
    
    @Override
    public float area() {
        return this.lado * this.lado;
    }
    
}
