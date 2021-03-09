package es.iespuertodelacruz.profesor.view.utils;

import java.util.Scanner;

public class Operacion {

    public static Double obtenerValor() {

        Scanner reader = new Scanner(System.in);
        Double numero = 0.0;

        System.out.println("Introduce el número. El cero para salir");

        do {
            try {
                numero = Double.valueOf(reader.nextInt());
            } catch (Exception exception){
                System.out.println("¡Cuidado! Solo puedes insertar numeros. ");
                reader.next();
            }
        } while (numero<=0.0);
        System.out.println("Se ha obtenido el numero de forma correcta ");
        return numero;
    }
}
