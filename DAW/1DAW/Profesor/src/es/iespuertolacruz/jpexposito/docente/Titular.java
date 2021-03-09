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
public class Titular extends Profesor{
    
    public Titular(String nombre, String apellidos, String tipo) {
        super(nombre, apellidos, "TITULAR");
    }

    @Override
    public float importeNomina() {
        return 1.1F*nomina;
    }
    
}
