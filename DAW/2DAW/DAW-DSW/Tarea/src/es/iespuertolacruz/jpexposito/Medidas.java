
package es.iespuertolacruz.jpexposito;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class Medidas {
    
    /**
     * Funcion principal del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        float velocidadKm;
 
        while (!salir) {
 
            System.out.println("1. Transformar km/h en m/s");
            System.out.println("2. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce la velocidad");
                        velocidadKm = sn.nextFloat();
                        System.out.println("La velocidad insertada es:"+velocidadKm+ " km/h");
                         System.out.println("La velocidad en m/s:"+ (velocidadKm*1000)/3600);
                        
                        break;
                    case 2:
                        System.out.println("Has seleccionad salir");
                        salir = true;
                        break;
               
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
    
}
