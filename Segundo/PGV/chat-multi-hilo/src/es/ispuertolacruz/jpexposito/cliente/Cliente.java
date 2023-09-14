package es.ispuertolacruz.jpexposito.cliente;


import es.ispuertolacruz.jpexposito.cliente.PersonaThread;

import java.util.ArrayList;

public class Cliente {
    
    /**
     * Funcion Main que lanza la ejecucion de los hilos para simular el comportamiento
     * de los clientes del chat
     * @param args 
     */
    public static void main(String[] args) {
        ArrayList<Thread> clientes = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            clientes.add(new PersonaThread(i));
        }
        for (Thread cliente : clientes) {
            cliente.start();
        }
    }
}
