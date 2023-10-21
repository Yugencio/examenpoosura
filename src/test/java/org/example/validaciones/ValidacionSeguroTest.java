package org.example.validaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.validaciones.ValidacionSeguro;
import org.example.validaciones.ValidacionSeguro;
import org.example.modelos.Seguro;
import org.example.utilities.Messages;
import org.example.utilities.ParseoFechasYRegex;
import org.example.utilities.Regex;


import static org.junit.jupiter.api.Assertions.*;

public class ValidacionSeguroTest {

    private ValidacionSeguro validacionSeguro;

    @BeforeEach
    public void setUp() {
        validacionSeguro = new ValidacionSeguro();
    }

    @Test
    public void testValidacionNombreAsegurado() {
        // Caso válido
        try {
            assertTrue(validacionSeguro.validacionNombreAsegurado("John Doe"));
        } catch (Exception e) {
            fail("No se esperaba una excepción en caso válido: " + e.getMessage());
        }

        // Caso con nombre demasiado largo
        try {
            validacionSeguro.validacionNombreAsegurado("JohnDoeJohnDoeJohnDoeJohnDoeJohnDoe"); // Nombre de más de 20 caracteres
            fail("Se esperaba una excepción con mensaje: " + Messages.NUMERO_DE_CARACTERES_INVALIDO.getMensaje());
        } catch (Exception e) {
            assertEquals(Messages.NUMERO_DE_CARACTERES_INVALIDO.getMensaje(), e.getMessage());
        }

        // Caso con caracteres no permitidos
        try {
            validacionSeguro.validacionNombreAsegurado("John-Doe");
            fail("Se esperaba una excepción con mensaje: " + Messages.FORMATO_INVALIDO.getMensaje());
        } catch (Exception e) {
            assertEquals(Messages.FORMATO_INVALIDO.getMensaje(), e.getMessage());
        }
    }




    @Test
    public void testValidacionEdadAsegurado() throws Exception {
        // Caso válido
        assertTrue(validacionSeguro.validacionEdadAsegurado(30));

        // Caso con edad negativa
        assertThrows(Exception.class, () -> validacionSeguro.validacionEdadAsegurado(-5));

        // Caso con edad igual o mayor a 90
        assertThrows(Exception.class, () -> validacionSeguro.validacionEdadAsegurado(90));
    }

    @Test
    public void testValidacionMontoCobertura() throws Exception {
        // Caso válido
        assertTrue(validacionSeguro.validacionMontoCobertura(1000000.0));

        // Caso con monto negativo
        assertThrows(Exception.class, () -> validacionSeguro.validacionMontoCobertura(-5000.0));

        // Caso con monto mayor a 1500000000
        assertThrows(Exception.class, () -> validacionSeguro.validacionMontoCobertura(2000000000.0));
    }

    @Test
    public void testValidacionFechaInicioCobertura() throws Exception {
        // Caso válido
        assertTrue(validacionSeguro.validacionFechaInicioCobertua("01/01/2023"));

        // Caso con formato de fecha inválido
        assertThrows(Exception.class, () -> validacionSeguro.validacionFechaInicioCobertua("2023-01-01"));
    }

    @Test
    public void testValidacionBeneficiario() throws Exception {
        // Caso válido
        assertTrue(validacionSeguro.validacionBeneficiario("Jane Smith"));

        // Caso con nombre de beneficiario demasiado largo
        assertThrows(Exception.class, () -> validacionSeguro.validacionBeneficiario("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
    }
}




