
package es.iespuertolacruz.reto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Descomponer un numero en factores primosr");
            System.out.println("2. Salir ");

            System.out.println("Escribe una de las opciones\n");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el número a descomponer:");
                    int numero = sn.nextInt();
                    ArrayList<Integer> factoriales = descomponEnFactoresPrimos(numero);
                    System.out.println("Resultado" +factoriales.toString());
                    
                    break;
                
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 2");
            }

        }

    }
    
    
    
    public static ArrayList<Integer> descomponEnFactoresPrimos(int valor){
		assert valor>1;
		
		// Se empieza probando como posible factor primo el 2.
		int factor = 2;
		ArrayList<Integer> factores=new ArrayList<Integer>();
		
		while (factor <= valor){
			// Mientras es divisible, se añade el factor a la lista de factores primos
			// y se realiza la división.
			while (valor % factor == 0 ){
				factores.add(new Integer(factor));
				valor = valor/factor;
			}
			
			// Si no es divisible, se pasa al posible siguiente factor.
			factor++;
		}
		return factores;
	}

    
}
