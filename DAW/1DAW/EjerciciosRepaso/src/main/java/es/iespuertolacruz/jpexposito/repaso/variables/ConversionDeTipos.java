/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.repaso.variables;

/**
 *
 * @author Javi
 */
public class ConversionDeTipos {
    public static void main(String[] args) {
    int x = 2;
    int y = 9;
    double division;

    division = (double) y / (double) x;
    
    // Descomenta la siguiente línea y observa cómo cambia el resultado.
    // division = y / x;
  
    System.out.println("El resultado de la división es " + division);   
  }
}
