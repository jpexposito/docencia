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
public abstract class Figura extends Forma{
    
    public Figura(String color, String nombre, int x, int y) {
        super(color, nombre, x, y);
    }
    
    abstract public float area() ;
    abstract public String imprimir() ;
    
}
