
package es.iespuertolacruz.jpexposito;

import java.util.InputMismatchException;
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
       
        boolean salir = false;
        int opcion; 
        Scanner sn = new Scanner(System.in);
        String titular;
        Double cantidad;
        while (!salir) {
 
            System.out.println("1. Crear cuenta CON titular");
            System.out.println("2. Crear cuenta SIN titular");
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones:");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        pedirDatos(opcion);                       
                        break;
                     
                    case 2:
                        pedirDatos(opcion);
                        break;
                        
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
    
    private static void pedirDatos(int opcion) {
        Scanner sn = new Scanner(System.in);
        String titular;
        Double cantidad;
        Cuenta cuenta = null;
    
        if (opcion == 1) {
            System.out.println("Indica el nombre del titular:");
            titular = sn.next();
            cuenta = new Cuenta(titular);
        } else {
            cuenta = new Cuenta();
            //cuenta.setTitular(titular);
        }

        System.out.println("Indica la cantidad de la cuenta:");
        cantidad = Double.valueOf(sn.next());
        cuenta.setCantidad(cantidad);
        System.out.println("Indica la cantidad a retirar:");
        cantidad = Double.valueOf(sn.next());
        cuenta.retirar(cantidad);
        cuenta.toString();
        System.out.println("Indica la cantidad a ingresar:");
        cantidad = Double.valueOf(sn.next());
        cuenta.ingresar(cantidad);
        System.out.println("Datos de la cuenta:"+cuenta.toString());
    }
    
    
}
