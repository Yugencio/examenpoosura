package org.example.utilities;

public enum Messages {


    NUMEROS_NEGATVOS("No puedes utilizar numeros negativos"),

    FORMATO_INVALIDO("El formato de caracteres es invalido"),

    NUMERO_DE_CARACTERES_INVALIDO("Cantidad de caracteres invalida"),
;


    private String mensaje;

    Messages(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
