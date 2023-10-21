package org.example.utilities;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseoFechas {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean validarFormatoFecha(String fechaString) {
        // Expresión regular para validar el formato "dd/MM/yyyy"
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fechaString);

        // Comprueba si la cadena coincide con el formato de fecha
        return matcher.matches();
    }
}
