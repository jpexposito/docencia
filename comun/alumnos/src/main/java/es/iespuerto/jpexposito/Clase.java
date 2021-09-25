package es.iespuerto.jpexposito;

import java.util.ArrayList;

public class Clase {
    int numero;
    String curso;
    ArrayList<Alumno> alumnos;

    /**
     * Constructor por defecto
     */
    public Clase() {}

    /**
     * Constructor de la clase
     * @param numero de la clase
     * @param curso de la clase
     * @param alumnos de la clase
     */
    public Clase (int numero, String curso, ArrayList<Alumno> alumnos) {
        this.numero = numero;
        this.curso = curso;
        this.alumnos = alumnos;
    }

    /**
     * Funcion que determina el numero de alumnos
     * @return numero alumnos en la clase
     */
    public int numeroAlumnos() {
        if (alumnos != null) {
            return alumnos.size();
        }
        return 0;
    }

    /**
     * Funcion encargda de obtener el numero de alumnos de una edad determinada
     * @param edad sobre la que se aplica el filtro
     * @return numero de alumnos de edad igual o mayor a una dada
     */
    public int numeroAlumnos(int edad) {
        int total = 0;
        if (alumnos != null) {
            int i = 0;
            for (Alumno alumno:alumnos){
                if (alumno.getEdad() >=edad) {
                    total++;
                }
            }
            return total;
        }
        return 0;
    }

    /**
     * Funcion encargada de obtener los alumnos que comienzan por una determinada letra
     * @param letra por la que comienza el nombre del alumno
     * @return numero total de alumnos
     */
    public int numeroAlumnos(String letra) {
        int total = 0;
        if (alumnos != null) {
            int i = 0;
            for (Alumno alumno:alumnos){
                if (alumno.getNombre().toString().startsWith(letra.toUpperCase())) {
                    total++;
                }
            }
            return total;
        }
        return 0;
    }
}
