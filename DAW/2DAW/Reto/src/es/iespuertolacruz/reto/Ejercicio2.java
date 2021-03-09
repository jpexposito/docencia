/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.reto;

import javax.swing.JOptionPane;

/**
 *
 * @author jpexposito
 */
public class Ejercicio2 {
    
    public static void main(String[] args) {
       
        
        String cadena;
        char letras;
        
        cadena=JOptionPane.showInputDialog("Ingrese Texto");
        for(int i=cadena.length()-1;i>=0;i--){
            letras=cadena.charAt(i);
            System.out.print(letras);
        }
    }
    
}
