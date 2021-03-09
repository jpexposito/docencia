/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejercicio4;

import java.util.ArrayList;

/**
 *
 * @author jpexposito
 */
public class ListaAlumno {
    
    ArrayList<Alumno> listaAlumnos = new ArrayList<>();
   
   /**
    * Metodo que permite insertar un alumno en la lista
    * @param alumno alumno a insertar
    */
   public void addAlumno(Alumno alumno) {
       this.listaAlumnos.add(alumno);
   }
   
   /**
    * Funcion que permite mostrar la lista de alumnos
    * @return String con los alumnos de la lista
    */
   public String mostrarAlumnos () {
       return listaAlumnos.toString();
   }
   
   /**
    * Funcion que permite obtener la lista de alumnos
    * @return ArrayList con la lista de alumnos
    */
   public ArrayList<Alumno> getListaAlumnos() {
       return this.listaAlumnos;
   }
   
   /**
    * Metodo que permite borrar un alumno de la lista si existe
    * @param alumno a eliminar de la lista
    */
   public void borrarAlumno(Alumno alumno) {
       listaAlumnos.remove(alumno);
   }
   
   /**
    * Metodo que permite limpiar la lista de los elemenos 
    * alumnos
    */
   public void limpiarLista() {
       listaAlumnos.clear();
   }
}
