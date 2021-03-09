/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jpexposito
 */
public class UsoEmpleado {
    
    public static void main(String[] args) {
      
        
        
        /* *********************************************************************
         * EJEMPLO DE ARRAY:
         * - TAMANIO ESTATICO (4)
         * - ACCESO A LOS ELEMENTOS EN EL ORDEN QUE SE DESEE [i]
         * - INSERCION EN EL ORDEN QUE SE DESEE
         * - FORMA DE IMPRESION: System.out.println(listaEmpleado[i].dameDatos());
          ******************************************************************** */
        Empleado listaEmpleado[] = new Empleado[4];
        
        listaEmpleado[0] = new Empleado("Pepe", 18, 1200);
        listaEmpleado[3] = new Empleado("Juan", 21, 1500);
        listaEmpleado[1] = new Empleado("Lucia", 19, 1200);
        listaEmpleado[2] = new Empleado("Maria", 20, 1200);
        
        
        
        System.out.println("***************************************************");
        System.out.println("* +********* IMPRESION DEL ARRAY **************** *");
        System.out.println("***************************************************");
        for (int i = 0; i < listaEmpleado.length; i++) {
            System.out.println(listaEmpleado[i].dameDatos());
        }
        
         /* *********************************************************************
         * EJEMPLO DE ARRAYLIST:
         * - TAMANIO DINAMICO
         * - ACCESO A LOS ELEMENTOS EN EL ORDEN QUE SE DESEE get(i)
         * - INSERCION EN ORDEN add(Empleado);
         * - FORMA DE IMPRESION: System.out.println(listaEmpleado[i].dameDatos());
          ******************************************************************** */
        ArrayList<Empleado> arrayListEmpleado = new ArrayList<>();
        
        arrayListEmpleado.add(new Empleado("Pepe en ArrayList" , 18, 1200));
        arrayListEmpleado.add(new Empleado("Lucia en ArrayList", 19, 1200));
        arrayListEmpleado.add(new Empleado("Maria en ArrayList", 20, 1200));
        arrayListEmpleado.add(new Empleado("Pedro en ArrayList", 21, 1500));
        arrayListEmpleado.add(new Empleado("Juan en ArrayList", 21, 1500));
        System.out.println(" Tamanio arraylist despues de insertar:" +arrayListEmpleado.size());
        
        System.out.println("***************************************************");
        System.out.println("* +********* IMPRESION DEL ARRAYLIST (FOR)********* *");
        System.out.println("***************************************************");
        
        for (int i = 0; i < arrayListEmpleado.size(); i++) {
            System.out.println(arrayListEmpleado.get(i).dameDatos());
        }
        
        
        
        System.out.println("***************************************************");
        System.out.println("* +********* IMPRESION DEL ARRAYLIST (WHILE)******* *");
        System.out.println("***************************************************");
        
        int i = 0;
        while  (i < arrayListEmpleado.size()) {
            System.out.println(arrayListEmpleado.get(i).dameDatos());
            i++;
        }
        
        
        System.out.println("***************************************************");
        System.out.println("* +********* USO DEL GET (I)   ******* *");
        System.out.println("* +********* MUESTRO LA POSICION 3  ******* *");
        System.out.println("***************************************************");
        
        System.out.println("POSICION 3=" +arrayListEmpleado.get(3).dameDatos());
        
        
        System.out.println("***************************************************");
        System.out.println("* +********* USO DEL SET (I)   ******* *");
        System.out.println("* +********* INSERTO EN LA POSICION 3  ******* *");
        System.out.println("***************************************************");
        
       arrayListEmpleado.add(3, new Empleado("Juan en posicion 3", 23, 800));
       
       
       i = 0;
        while  (i < arrayListEmpleado.size()) {
            System.out.println(arrayListEmpleado.get(i).dameDatos());
            i++;
        }
       System.out.println(" Tamanio arraylist despues del set:" +arrayListEmpleado.size());
        
        
       
       Empleado arrayEmpleados[] = new Empleado[arrayListEmpleado.size()];
       // add empleado ? que sucede
       arrayListEmpleado.toArray(arrayEmpleados); // Forma 1
       //arrayEmpleados = (Empleado[]) arrayListEmpleado.toArray(); // Forma 2
       
       
        System.out.println("***************************************************");
        System.out.println("* +********* MUESTRO LA NUEVA LISTA  ******* *");
        System.out.println("***************************************************");
       
       for (int j = 0; j < arrayEmpleados.length; j++) {
            System.out.println(arrayEmpleados[j].dameDatos());
        }
       
        System.out.println("***************************************************");
        System.out.println("* +********* ITERADOR   ******* *");
        System.out.println("***************************************************");
        
        Iterator iterador = arrayListEmpleado.iterator();
        while (iterador.hasNext()){
           Empleado empleado = (Empleado) iterador.next();
           System.out.println(empleado.dameDatos());
        }
       
        System.out.println("***************************************************");
        System.out.println("* **** IMPRESION DEL ARRAYLIST SIN INDICE(FOR) **** *");
        System.out.println("***************************************************");
        
        for (Empleado empleado:arrayListEmpleado) {
            System.out.println(empleado.dameDatos());
        }
        
        System.out.println("***************************************************");
        System.out.println("* **** IMPRESION EN UNA SOLA LINEA **** *");
        System.out.println("***************************************************");
        
        System.out.println(arrayListEmpleado);
        
       
       
    }
    
}
