package es.iespuetolacruz.jpexposito;

import es.iespuetolacruz.jpexposito.figuras.*;
import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class Figura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Realizamos el menu

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Circulo.-  Construir y mostrar los datos");
            System.out.println("2. Elipse.-  Construir y mostrar los datos");
            System.out.println("3. Cuadrado.-  Construir y mostrar los datos");
            System.out.println("4. Rectangulo.-  Construir y mostrar los datos");
            System.out.println("5. Salir ");

            System.out.println("Escribe una de las opciones\n");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca los datos del circulo");
                    System.out.println("Circulo.- Introduzca el radio:");
                    String radio = sn.next();
                    Circulo circulo = new Circulo(Float.parseFloat(radio));
                    System.out.println("Valor del circulo:"
                            + circulo.toString());
                     System.out.println("Area del circulo:"
                            + circulo.area());
                    

                    break;
                case 2:
                    System.out.println("Introduzca los datos de la elipse");
                    System.out.println("Elipse.- Introduzca el radio Mayor:");
                    String radioMayor = sn.next();
                    System.out.println("Elipse.- Introduzca el radio Mayor:");
                    String radioMenor = sn.next();
                    Elipse elipse = new Elipse(Float.parseFloat(radioMayor),
                            Float.parseFloat(radioMenor));
                    System.out.println("Valor de la elipse:"
                            + elipse.toString());
                    System.out.println("Area de la elipse:"
                            + elipse.area());

                    break;
                case 3:
                    System.out.println("Introduzca los datos del cuadrado");
                    System.out.println("Cuadrado.- Introduzca el lado:");
                    String lado = sn.next();
                    Cuadrado cuadrado = new Cuadrado(Float.parseFloat(lado));
                    System.out.println("Valor del cuadrado:"
                            + cuadrado.toString());
                     System.out.println("Area del cuadrado:"
                            + cuadrado.area());

                    break;

                case 4:
                    System.out.println("Introduzca los datos del rectungulo");
                    System.out.println("Rectangulo.- Introduzca el lado Mayor:");
                    String ladoMayor = sn.next();
                    System.out.println("Rectangulo.- Introduzca el lado Menor:");
                    String ladoMenor = sn.next();
                    Rectangulo rectangulo = new Rectangulo(Float.parseFloat(ladoMayor),
                            Float.parseFloat(ladoMenor));
                    System.out.println("Valor del rectangulo:"
                            + rectangulo.toString());
                    System.out.println("Area del rectangulo:"
                            + rectangulo.area());

                    break;

                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }

        }

    }

}
