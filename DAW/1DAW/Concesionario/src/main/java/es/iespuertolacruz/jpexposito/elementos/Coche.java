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
public class Coche extends Vehiculo{
    
    /**
     * Constructor del coche
     * @param marca del coche
     * @param modelo del coche
     * @param matricula del coche
     */
    public Coche(String marca, String modelo, String matricula) {
        super(marca, modelo, matricula);
    }
    
}
