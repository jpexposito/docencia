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
 public class Circulo{                  // Declaración de clase
    private double radio;               // Atributo o Propiedad

    public Circulo() {
        radio = 0;
    }

    public Circulo(double radio) {
        this.radio = radio;
    }   
    
    public double getRadio(){          // Métodos
        return (radio);
    }
    
    public void setRadio(double radio){
        this.radio=radio;
    }
    
    public double perimetro(){
        return(2*Math.PI*radio);
    }
    
    public double area(){
        double area;
        area=Math.PI*radio*radio;
        return(area);
    }
    
    public boolean vacio(){

        if (radio == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean iguales (Circulo c2){
        return (this.radio == c2.radio);
    }
}
