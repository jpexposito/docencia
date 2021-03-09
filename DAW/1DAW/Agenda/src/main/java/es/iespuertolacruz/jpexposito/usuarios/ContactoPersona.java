/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.usuarios;

/**
 *
 * @author jpexposito
 */
public class ContactoPersona extends Contacto {
    
    String nacimiento;
    
    public ContactoPersona(String dni, String nombre,
            String telefono, String nacimiento ) {
        super(dni, nombre, telefono);
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Contacto{" + "dni=" + identificador + ", nombre=" + nombre + ""
                + ", telefono=" + telefono + " nacimiento = " +nacimiento +'}';
    }
    
    
    
}
