/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.exceptiones.EdadException;
import es.iespuertolacruz.jpexposito.exceptiones.NombreException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jpexposito
 */
public class PrincipalGato {
    
    
    public static void main(String[] args)  {
        
        ArrayList<Gato> listaGatos = new ArrayList<>();
        
        /* ****************************************************************/
        /* ********************  BUCLE WHILE CON INDICE ***************** */
        /* ****************************************************************/
        int j = 0;
        while (j < 5) {
            pedirDatosGato(listaGatos);
         j++;   
        }
        
        /* ****************************************************************/
        /* ********************  BUCLE WHILE SIN INDICE ***************** */
        /* ****************************************************************/
        
        while (listaGatos.size() < 5) {
            pedirDatosGato(listaGatos); 
        }
        
        /* ****************************************************************/
        /* ********************  BUCLE FOR CON INDICE ***************** */
        /* ****************************************************************/
        for (int i = 0; i < 5; i++) {
            pedirDatosGato(listaGatos);
        }
    }
    
    private static void pedirDatosGato(ArrayList<Gato> listaGatos) {
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce el nombre del gato");
        String nombre = sn.nextLine();
        System.out.println("Introduce la edad del gato");
        int edad = sn.nextInt();
        sn.skip("\n");

        try {
            listaGatos.add(new Gato(nombre, edad));
        } catch (NombreException errorNombre) {
            System.out.println(errorNombre.getMessage());
        } catch (EdadException errorEdad) {
            System.out.println(errorEdad.getMessage());
        }
        
    }
    
}
