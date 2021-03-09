package es.iespuertodelacruz.profesor.view;

import es.iespuertodelacruz.profesor.controlador.*;

import java.util.Scanner;

import static es.iespuertodelacruz.profesor.view.utils.Operacion.obtenerValor;

public class Calculadora {

    public static void generarVista() {

        Double n1,n2 = 0.0;

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir){

            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");

            System.out.println("Escribe una de las opciones\n");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("Has seleccionado la opcion Sumar");
                    n1 = obtenerValor();
                    n2 = obtenerValor();
                    Suma suma = new Suma(n1,n2);
                    suma.mostrarResultado();
                    //suma.almacenarBDD();
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion Restar");
                    n1 = obtenerValor();
                    n2 = obtenerValor();
                    Resta resta = new Resta(n1,n2);
                    resta.mostrarResultado();
                    //resta.almacenarBDD();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion Multiplicar");
                    n1 = obtenerValor();
                    n2 = obtenerValor();
                    Multilplicacion multilplicacion = new Multilplicacion(n1,n2);
                    multilplicacion.mostrarResultado();
                    //multilplicacion.almacenarBDD();
                    break;
                case 4:
                    System.out.println("Has seleccionado la opcion Dividir");
                    n1 = obtenerValor();
                    n2 = obtenerValor();
                    Division division = new Division(n1,n2);
                    division.mostrarResultado();
                    //division.almacenarBDD();
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
