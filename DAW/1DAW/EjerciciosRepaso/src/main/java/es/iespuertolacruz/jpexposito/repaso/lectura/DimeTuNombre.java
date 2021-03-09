/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.repaso.lectura;

/**
 *
 * @author Javi
 */
public class DimeTuNombre {
  public static void main(String[] args) {
    String nombre;
    System.out.print("Por favor, dime cómo te llamas: ");
    nombre = System.console().readLine();
    System.out.println("Hola " + nombre + ", ¡encantado de conocerte!");
  }
}
