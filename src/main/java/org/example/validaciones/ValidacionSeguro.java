package org.example.validaciones;

import org.example.modelos.Seguro;
import org.example.utilities.Messages;
import org.example.utilities.ParseoFechasYRegex;
import org.example.utilities.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidacionSeguro {
    Seguro seguro = new Seguro();

    Regex regex = new Regex();

    ParseoFechasYRegex parseoFechasYRegex = new ParseoFechasYRegex();

    public ValidacionSeguro() {
    }

    public Boolean validacionNombreAsegurado(String nombreAsegurado) throws Exception {
        if (nombreAsegurado.length() > 20) { // Cambio de < a >
            throw new Exception(Messages.NUMERO_DE_CARACTERES_INVALIDO.getMensaje());
        }
        String expresionRegular = "^[a-zA-Z ]+$";
        if (!this.regex.buscarCoincidencia(expresionRegular, nombreAsegurado)) {
            throw new Exception(Messages.FORMATO_INVALIDO.getMensaje());
        }
        return true;
    }




    public Boolean validacionEdadAsegurado(int edadAsegurado) throws Exception{

        if (edadAsegurado < 0){
            throw new Exception(Messages.NUMEROS_NEGATVOS.getMensaje());
        }
        if (edadAsegurado >= 90){
            throw new Exception("Querido usuario, debido a que tiene 90 años o más, comuniquese al 300 3586113");
        }

        return true;
    }

    public Boolean validacionMontoCobertura(Double montoCobertura) throws Exception{

        if (montoCobertura < 0) {
            throw new Exception(Messages.NUMEROS_NEGATVOS.getMensaje());
        }
        if (montoCobertura > 1500000000){
            throw new Exception("Ojo con la DIAN teleparsero");
        }

        return true;
    }

    public Boolean validacionFechaInicioCobertua (String fechaInicioCobertura) throws Exception{
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        if (!fechaInicioCobertura.matches(regex)){
            throw new Exception("Formato de fecha invalido, por favor utilice dd/MM/YYYY");
        }
        return true;
    }

    public Boolean validacionBeneficiario (String beneficiario) throws Exception{

        if (beneficiario.length() > 50){
            throw new Exception(Messages.NUMERO_DE_CARACTERES_INVALIDO.getMensaje());
        }

        String expresionRegular="^[a-zA-Z ]+$";
        if (!this.regex.buscarCoincidencia(expresionRegular, beneficiario)){
            throw new Exception(Messages.FORMATO_INVALIDO.getMensaje());
        }

        return true;
    }

}
