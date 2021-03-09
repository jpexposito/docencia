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
public class Punto {
    int x;
    int y;

    public Punto() {
    }

    
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String imprimir() {
     return "";   
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
