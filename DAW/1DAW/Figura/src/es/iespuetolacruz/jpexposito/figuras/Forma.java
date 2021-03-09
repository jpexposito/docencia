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
public class Forma extends Punto{
    
    String color;
    String nombre;

    public Forma() {
    }
    
        
    public Forma(int x, int y) {
        super(x, y);
    }
    

    public Forma(String color, String nombre, int x, int y) {
        super(x, y);
        this.color = color;
        this.nombre = nombre;
    }
    
    
    /**
     * 
     * @param color 
     */
    public void cambiar(String color) {
        this.color = color; //
        
    }
    
    /**
     * 
     */
    public void obtener() {
        
    }
    
    
   
    

    
}
