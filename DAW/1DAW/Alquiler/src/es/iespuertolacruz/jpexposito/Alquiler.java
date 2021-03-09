
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.usuarios.Cliente;
import java.util.Scanner;

/**
 * Clase princial que contiene el menu
 * @author jpexposito
 */
public class Alquiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Realizamos el menu

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){

            System.out.println("1. Introducir Cliente");
            System.out.println("2. -----");
            System.out.println("3. -----");
            System.out.println("4. -----");
            System.out.println("5. Salir ");

            System.out.println("Escribe una de las opciones\n");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Introduzca los datos del cliente");
                    System.out.println("Indique el código del cliente:");
                    String codigo = sn.next();
                    System.out.println("Indique el nombre del cliente:");
                    String nombre = sn.next();
                    System.out.println("Indique el dni del cliente:");
                    String dni = sn.next();
                    System.out.println("Indique la dirección del cliente:");
                    String direccion = sn.next();
                    System.out.println("Indique el teléfono del cliente:");
                    String telefono = sn.next();
                    Cliente cliente = new Cliente(codigo, nombre, dni, direccion, telefono);
                    System.out.println("El cliente almacenado contine-> Cliente: " +cliente.toString());
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
