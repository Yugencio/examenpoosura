package org.example.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public Boolean buscarCoincidencia(String expresionRegular, String cadenaTexto){
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher coincidencia=patron.matcher(cadenaTexto);
        if(coincidencia.matches()){
            return true;
        }else {
            return false;
        }
    }

}
