package es.iespuertolacruz.jpexposito.poo.i.a2;


import java.util.Scanner;

public class ProgramaPersona {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        System.out.println("Introduce los datos de la primera persona");
        System.out.println("DNI: ");
        persona1.dni = sc.nextLine();
        System.out.println("Nombre: ");
        persona1.nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        persona1.apellidos = sc.nextLine();
        System.out.println("Edad: ");
        persona1.edad = sc.nextInt();

        sc.nextLine();

        System.out.println("Introduce los datos de la segunda persona");
        System.out.println("DNI: ");
        persona2.dni = sc.nextLine();
        System.out.println("Nombre: ");
        persona2.nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        persona2.apellidos = sc.nextLine();
        System.out.println("Edad: ");
        persona2.edad = sc.nextInt();

        String cadena1 = persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni;
        String cadena2 = persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.dni;

        if (persona1.edad >= 18) {
            cadena1 += " es mayor de edad";
        } else {
            cadena1 += " no es mayor de edad";
        }

        if (persona2.edad >= 18) {
            cadena2 += " es mayor de edad";
        } else {
            cadena2 += " no es mayor de edad";
        }

        System.out.println(cadena1);
        System.out.println(cadena2);

    }
}
