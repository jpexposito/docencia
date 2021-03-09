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
public class Fecha {
    //private String patron = "^[0-30][/][01-12][/][2021]$";
    //private String patron = "^([0-2][0-9]|3[0-1])(/|-)(0[1-9]|1[0-2])2(\\d{4})$";
    //private String patron = "^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/[0-9]{4}$";
    private String patron = "^[0-3]{1}[0-9]{1}/[0-1]{1}[0-9]{1}/[0-9]{4}";
    Pattern pattern;
    Matcher matcher;

    /**
     * Funcion que evalua si un dni es valido
     *
     * @param valor a evaluar
     * @return true/false en funcion si es correcto o no
     */
    public boolean validar(String valor) {
        boolean resultado = false;

        this.pattern = Pattern.compile(patron);
        this.matcher = pattern.matcher(valor);
        resultado = matcher.find();

        return resultado;
    }
}
