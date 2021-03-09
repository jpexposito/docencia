/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.elementos;

/**
 *
 * @author jpexposito
 */
public class Cliente extends Persona{
    
    public Cliente(String nombre, String apellidos, String dni, int edad, Coche coche, Direccion direccion) {
        super(nombre, apellidos, dni, edad, coche, direccion);
    }
    
}
