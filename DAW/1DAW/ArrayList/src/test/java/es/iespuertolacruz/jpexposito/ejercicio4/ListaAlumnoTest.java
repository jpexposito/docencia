package es.iespuertolacruz.jpexposito.ejercicio4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertolacruz.jpexposito.ejercicio4.Alumno;
import es.iespuertolacruz.jpexposito.ejercicio4.ListaAlumno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jpexposito
 */
public class ListaAlumnoTest {
    
    ListaAlumno lista;
    Alumno alumno;
    
    
    @BeforeEach
    public void before() {
        if (this.lista == null) {
           this.lista = new ListaAlumno(); 
        }
        if (alumno == null) {
            alumno = new Alumno("Pepe", 18);
        }
        lista.addAlumno(alumno);
    }

    @Test
    public void addAlumnoTest() {
      
        Assertions.assertNotNull(lista, "La lista de Alumno es nula");
        Assertions.assertTrue(lista.getListaAlumnos().size() == 1, 
                "La lista contiene un numero diferente a 1");
    }
    
    
    @Test
    public void mostrarAlumnoTest() {
        Assertions.assertTrue(lista.mostrarAlumnos().contains("Pepe"), 
                "La lista no contiene el elemento Pepe");
    }
    
    @Test
    public void eliminarAlumnoTest() {
        lista.borrarAlumno(alumno);
        Assertions.assertTrue(lista.getListaAlumnos().size() == 0, 
                "La lista contiene un numero diferente a 0");
    }
    
    @Test
    public void limpiarAlumnoTest() {
        lista.limpiarLista();
        Assertions.assertTrue(lista.getListaAlumnos().size() == 0, 
                "La lista contiene un numero diferente a 0");
    }
    
}
