/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.reto;

import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class Ejercicio3 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String fraseInvertida = "";
        String palabras[];
        
        palabras = teclado.nextLine().split(" ");
        
        for (int i=palabras.length-1;i>=0;i--) {
            fraseInvertida = fraseInvertida + " " + palabras[i];
        }
        
        System.out.println(fraseInvertida.substring(1));
    }
    
}
