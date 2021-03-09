/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito;

/**
 *
 * @author jpexposito
 */
public class MiClase {

    
    //Atributos de la clase
    private String atributo1;
    private int atributo2;
    private float atributo3;

    
    /**
     * Constructor por defecto de la clase
     */
    public MiClase() {
    }

    /**
     * Constructor con atributos de la clase
     * @param atributo1 Atributo 1 de la clase de tipo String
     * @param atributo2  Atributo 2 de la clase de tipo int
     */
    public MiClase(String atributo1, int atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }
    
    
    /**
     * Metodo que realiza una accion
     */
    public void metodo1(){
        this.atributo1 = "hola";
        
    }
    
    public String funcion1(){
        String resultado = "adios";
        
        return resultado;
    }
    
    
    
}
