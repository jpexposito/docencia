/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.docente;

/**
 *
 * @author jpexposito
 */
public abstract class Profesor extends Persona {
    
    String tipo;
    float nomina;
    
    public Profesor(String nombre, String apellidos, String tipo) {
        super(nombre, apellidos);
        this.tipo = tipo;
    }
    
     public void mostrarDatos() {
        System.out.println ("Datos Profesor. Nombre: " + this.nombre + ", Apellidos:" +
        this.apellidos + ", Tipo: " + this.tipo );   }

    abstract public float importeNomina ();  
    
    
    
    
}
