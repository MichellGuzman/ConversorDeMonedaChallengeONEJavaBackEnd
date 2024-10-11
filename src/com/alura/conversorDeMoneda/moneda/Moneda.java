package com.alura.conversorDeMoneda.moneda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moneda{

    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double resultado;
    private String fechaHora;

    public Moneda(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.resultado = resultado;
        this.fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // Getters y Setters
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getResultado() {
        return resultado;
    }

    public String getFechaHora() {
        return fechaHora; // Getter para la fecha y hora
    }
}