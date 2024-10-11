package com.alura.conversorDeMoneda.archivosDeTexto;

import com.alura.conversorDeMoneda.moneda.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class AlmacenarConversion {

    public void almacenarConversion(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        Moneda conversion = new Moneda (monedaOrigen, monedaDestino, cantidad, resultado);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter escritor = new FileWriter("conversiones.json", true)) {
            gson.toJson(conversion, escritor);
            escritor.write(System.lineSeparator()); // Añadir nueva línea después de cada entrada
            System.out.println("Conversión almacenada en conversiones.json");
        } catch (IOException e) {
            System.out.println("Error al guardar la conversión: " + e.getMessage());
        }
    }

}
