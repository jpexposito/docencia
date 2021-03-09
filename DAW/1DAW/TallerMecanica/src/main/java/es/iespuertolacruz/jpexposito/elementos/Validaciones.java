/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertolacruz.jpexposito.elementos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jpexposito
 */
public class Validaciones {
    private String patron = "^[0-9]{4}[A-Z]{3}$";
    
    Pattern pattern;
    Matcher matcher;
    
    /**
     * Funcion que evalua si una matricula cumple el patron 0000XXX o
     * @param valor a evaluar
     * @return true/false en funcion de si es correcto o no
     */
    public void validarMatricula(String valor) throws Exception {
        boolean resultado = false;
        this.pattern = Pattern.compile(patron);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();
        if (!resultado) {
            throw new Exception("La matricula:" +valor+ ", no tiene un formato correcto");
        }
    }
}
