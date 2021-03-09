package es.iespuertodelacruz.nefta;
import es.iespuertodelacruz.nefta.Cuenta;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
 * @author Nefta
 */
public class Cuentas {

    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion=0;
        String titular="";
        double cantidad=0;
        
        /**
         * Menu
         */
        
        
        while (!salir) {

            System.out.println("1. Crear una cuenta vacia");
            System.out.println("2. Crear una cuenta con ingreso");
            System.out.println("3. Retirar dinero de una cuenta");
            System.out.println("4. Salir");
            
            
        
        try{
            
            System.out.println("Introduce una de las opciones");
            opcion = sc.nextInt();
            
            switch (opcion){
                
                case 1:
                    System.out.println("Crear una cuenta vacia");
                    System.out.println("Introduzca el titular");
                    titular = sc.next();
                    Cuenta cuentavacia = new Cuenta(titular);
                    cuentavacia.setTitular(titular);
                    System.out.println("Ha habierto una cuenta a nombre de "+cuentavacia.toString());
                    break;
                    
                case 2:
                    System.out.println("Crear una cuenta con ingreso");
                    System.out.println("Introduzca el titular");
                    titular = sc.next();
                    System.out.println("Introduzca la cantidad a ingresar");
                    cantidad = sc.nextDouble();
                    Cuenta cuentaingreso = new Cuenta(titular, cantidad);
                    cuentaingreso.Ingresar(cantidad);
                    System.out.println("Se ha abierto la cuenta "+cuentaingreso.toString());
                    break;
                case 3:
                    
                    System.out.println("Retirar dinero");
                    System.out.println("Introduzca el titular");
                    titular = sc.next();
                    System.out.println("Introduzca la cantidad a retirar");
                    cantidad = sc.nextDouble();
                    Cuenta retirar = new Cuenta(titular, cantidad);
                    retirar.Retirar(cantidad);
                    System.out.println("Se ha retirado "+retirar.toString());
                    break;
                case 4:
                    
                    salir=true;
                    System.out.println("Que tenga un buen dia");
                    break;
                    
                default:
                    System.out.println("Solo numeros entre el 1 y el 4");
                    break;
            }
                   
            
        }catch (InputMismatchException e){
            System.out.println("Debe introducir un numero");
            sc.next();
        }
        }
            
    }
    
}