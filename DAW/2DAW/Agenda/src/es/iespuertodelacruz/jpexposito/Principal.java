/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jpexposito;


import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){

            System.out.println("1. Introducir Usuario");
            System.out.println("2. Modificar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Buscar Usuario");
            System.out.println("5. Salir ");

            System.out.println("Escribe una de las opciones\n");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Introduzca los datos Usuario");
                    System.out.println("Indique el dni del usuario:");
                    String dni = sn.next();
                    System.out.println("Indique el nombre del usuario:");
                    String nombre = sn.next();
                    System.out.println("Indique el apellidos del usuario:");
                    String apellido = sn.next();
                    //Usuario usuario = new Principal(dni, nombre, apellido);
                    
                   
                    break;
                case 2:
                    System.out.println("---------");

                    
                    break;
               
                case 5:
                    salir=true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }

        }
    }

    
    
}
