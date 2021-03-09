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
public class ContactoEmpresa extends Contacto {
    String web;

    public ContactoEmpresa(String identificador, String nombre,
            String telefono, String web) {
        super(identificador, nombre, telefono);
        this.web = web;
    }
    
    @Override
    public String toString() {
        return "Contacto{" + "cif=" + identificador + ", nombre=" + nombre + ""
                + ", telefono=" + telefono + " web = " + web +'}';
    }
    
    
}
