
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.figuras.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class CalculoAreas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        int base = 0;
        int altura = 0;
        int lado = 0;
 
        while (!salir) {
 
            System.out.println("1. Calcular Area Cuadrado");
            System.out.println("2. Calcular Area Circulo");
            System.out.println("3. Calcular Area Triangulo");
            System.out.println("4. Calcular Area Rectangulo");
            System.out.println("5. Calcular Area Rombo");
            System.out.println("6. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el valor del lado");
                        lado = sn.nextInt();
                        Cuadrado cuadrado = new Cuadrado(lado);
                        System.out.println("El valor del area es:"+ cuadrado.area());
                        break;
                    case 2:
                        System.out.println("Introduzca el valor del radio");
                        int radio = sn.nextInt();
                        Circulo circulo = new Circulo(radio);
                        System.out.println("El valor del area es:"+ circulo.area());
                        break;
                    case 3:
                        System.out.println("Introduzca el valor de la base");
                        base = sn.nextInt();
                        System.out.println("Introduzca el valor de la altura");
                        altura = sn.nextInt();
                        Triangulo triangulo = new Triangulo(base, altura);
                        System.out.println("El valor del area es:"
                                + triangulo.area());
                        break;
                    case 5:
                        System.out.println("Introduzca el valor de la diagonal mayo");
                        int diagonalMayor = sn.nextInt();
                        System.out.println("Introduzca el valor de la diagonal menor");
                        int diagonalMenor = sn.nextInt();                        
                        Rombo rombo = new Rombo(diagonalMayor, diagonalMenor);
                        System.out.println("El valor del area es:"
                                + rombo.area());
                        break;
                    case 6:
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
