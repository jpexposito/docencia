/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.ejemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jpexposito
 */
public class Hexadecimal {
    
    private String patron = "^([0-9A-Fa-f]{2})+$";
    //private String patron = "^[0-9A-Fa-f]{6}$";
    
    Pattern pattern;
    Matcher matcher;

    /**
     * Funcion que evalua si un hexadecimal es valido
     *
     * @param valor a evaluar
     * @return true/false en funcion de si es correcto o no
     */
    public boolean validar(String valor) {
        boolean resultado = false;
        this.pattern = Pattern.compile(patron);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();
        return resultado;
    }
    
}
