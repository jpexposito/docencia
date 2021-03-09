/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import java.util.*;

/**
 *
 * @author FP
 */
public class PruebaCirculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer=new Scanner(System.in);
        
        Circulo c1 = new Circulo (7.5);     // Creación de objeto c1
        Circulo c2;                         // Declaración de objeto c2
        double radio;
        c2 = new Circulo ();             // Creación de objeto c2
        
        if (c2.vacio()){
            System.out.println("Introduce el radio del segundo círculo: ");
            radio=leer.nextDouble();
            c2.setRadio(radio);
        }
        
        System.out.println("El perímetro del círculo 1 es: "+c1.perimetro());
        System.out.println("El área del círculo 1 es: "+c1.area());
        System.out.println("El perímetro del círculo 2 es: "+c2.perimetro());
        System.out.println("El área del círculo 2 es: "+c2.area());
        
        if (c1.iguales(c2))
            System.out.println("Los círculos son iguales");
        else
            System.out.println("Los círculos NO son iguales");
        
        
    }
}
