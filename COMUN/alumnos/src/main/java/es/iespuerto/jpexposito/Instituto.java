package es.iespuerto.jpexposito;

import java.util.ArrayList;

public class Instituto {
    ArrayList<Clase> clases;

    public Instituto(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    /**
     * Funcion que determina el numero de alumnos en el instituto
     * @return numero total
     */
    public int alumnosTotal() {
        int total = 0;
        int i = 0;
        if (clases !=null) {
            while (i < clases.size()) {
                total += clases.get(i).numeroAlumnos();
                i++;
            }
        }
        return total;
    }
}
