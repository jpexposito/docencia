/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

import es.iespuertolacruz.jpexposito.exceptiones.EdadException;
import es.iespuertolacruz.jpexposito.exceptiones.NombreException;

/**
 *
 * @author jpexposito
 */
public class Gato {
    String nombre;
    int edad;

    public Gato(String nombre, int edad) throws NombreException, EdadException {
        comprobarNombre(nombre);       
        comprobarEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        comprobarNombre(nombre);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        comprobarEdad(edad);
    }
    
    public void imprimir() {
        System.out.println("El gato se lllama:" + this.nombre + ", y su edad:" +this.edad);
    }
    
    private void comprobarEdad(int edad) throws EdadException {
        if (edad > 0 ) {
            this.edad = edad;
        } else {
            throw new EdadException("La edad " + edad + ", no es valida, debe ser"
                    + " mayor que 0");
        }
    }
    
    private void comprobarNombre(String nombre) throws NombreException  {
        if (nombre !=null && nombre.length() > 2) {
            this.nombre = nombre;
        } else {
            throw new NombreException("El nombre " + nombre + ", no es valido,"
                    + " no puede ser nulo o de tamanio menor < 3");
        }
    }
}
