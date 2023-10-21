package org.example.modelos;

import org.example.utilities.ParseoFechasYRegex;

import java.time.LocalDate;

public class Seguro {

    // Atributos
    private String nombreAsegurado;
    private int edadAsegurado;
    private String beneficiario;
    private double montoCobertura;
    private String tipoPoliza;
    private int duracionPoliza;
    private boolean fumador;
    private boolean enfermedadesPreexistentes;
    private String compañiaSeguros;

    LocalDate fechaInicioCobertura;
    String numeroPoliza;

    ParseoFechasYRegex parseoFechasYRegex = new ParseoFechasYRegex();

    public Seguro() {
    }

    public Seguro(String nombreAsegurado, int edadAsegurado, String beneficiario, double montoCobertura, String tipoPoliza, int duracionPoliza, boolean fumador, boolean enfermedadesPreexistentes, String compañiaSeguros, LocalDate fechaInicioCobertura, String numeroPoliza) {
        this.setNombreAsegurado(nombreAsegurado);
        this.setEdadAsegurado(edadAsegurado);
        this.setBeneficiario(beneficiario);
        this.setMontoCobertura(montoCobertura);
        this.setTipoPoliza(tipoPoliza);
        this.setDuracionPoliza(duracionPoliza);
        this.setFumador(fumador);
        this.setEnfermedadesPreexistentes(enfermedadesPreexistentes);
        this.setCompañiaSeguros(compañiaSeguros);
        this.setFechaInicioCobertura(fechaInicioCobertura);
        this.setNumeroPoliza(numeroPoliza);
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        if (nombreAsegurado != null && nombreAsegurado.length() >= 20) {
            this.nombreAsegurado = nombreAsegurado;
        } else {
            throw new IllegalArgumentException("Nombre del asegurado no válido.");
        }
    }

    public int getEdadAsegurado() {
        return edadAsegurado;
    }

    public void setEdadAsegurado(int edadAsegurado) {
        if (edadAsegurado >= 0 && edadAsegurado < 90) {
            this.edadAsegurado = edadAsegurado;
        } else {
            throw new IllegalArgumentException("Edad del asegurado no válida.");
        }
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public double getMontoCobertura() {
        return montoCobertura;
    }

    public void setMontoCobertura(double montoCobertura) {
        if (montoCobertura >= 0 && montoCobertura <= 1500000000) {
            this.montoCobertura = montoCobertura;
        } else {
            throw new IllegalArgumentException("Monto de cobertura no válido.");
        }
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public int getDuracionPoliza() {
        return duracionPoliza;
    }

    public void setDuracionPoliza(int duracionPoliza) {
        this.duracionPoliza = duracionPoliza;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public boolean isEnfermedadesPreexistentes() {
        return enfermedadesPreexistentes;
    }

    public void setEnfermedadesPreexistentes(boolean enfermedadesPreexistentes) {
        this.enfermedadesPreexistentes = enfermedadesPreexistentes;
    }

    public String getCompañiaSeguros() {
        return compañiaSeguros;
    }

    public void setCompañiaSeguros(String compañiaSeguros) {
        this.compañiaSeguros = compañiaSeguros;
    }

    public LocalDate getFechaInicioCobertura() {
        return fechaInicioCobertura;
    }

    public void setFechaInicioCobertura(LocalDate fechaInicioCobertura) {
        this.fechaInicioCobertura = fechaInicioCobertura;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public void calcularPrima() {
        double primaBase = 500;
        double primaFinal = primaBase;

        if (edadAsegurado < 30) {
            primaFinal -= 100;
        } else if (edadAsegurado > 60) {
            primaFinal += 200;
        }

        if (montoCobertura > 1000000) {
            primaFinal += 300;
        }

        System.out.println("La prima del seguro de vida es: $" + primaFinal);
    }
}
