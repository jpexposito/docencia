package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.agenda.Agenda;
import es.iespuertolacruz.jpexposito.usuarios.Contacto;
import es.iespuertolacruz.jpexposito.usuarios.ContactoPersona;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jpexposito
 */
public class ProgramaAgenda {
    
    
    public static void main (String [ ] args) {
        
        Agenda agenda = new Agenda();

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        
        while (!salir) {
            
            System.out.println("1. Insertar Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
            
            try {
                
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                
                switch (opcion) {
                    case 1:
                        // Pedir datos del contacto
                        ContactoPersona contacto = new ContactoPersona ("dni", "nombre",
                                "telefono", "fechaNacimiento");
                        agenda.addContacto(contacto);
                        
                        System.out.println("Has seleccionado la opcion 1");
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                

            }
        }
    }   
}
