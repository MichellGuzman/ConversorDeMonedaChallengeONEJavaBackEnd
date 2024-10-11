package com.alura.conversorDeMoneda.principal;

import com.alura.conversorDeMoneda.archivosDeTexto.AlmacenarConversion;
import com.alura.conversorDeMoneda.moneda.Moneda;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConvercionMonedas {

    public void convercionMonedas(){
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/562fa40ac92cf8b446a204ee/latest/COP"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Scanner lectura = new Scanner(System.in);
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

                //Se indica usar el codigo de la moneda para las converciones
                System.out.println("Utiliza el codigo base de las monedas en el siguiente paso");
                System.out.println("(Se recomienda ver el archivo 'Monedas Apoyadas del menu principal')");
                System.out.println("******************************************************************");

                // Solicitar la moneda de origen, la moneda de destino y la cantidad
                System.out.println("Ingresa la moneda de origen:");
                String monedaOrigen = lectura.nextLine().toUpperCase();

                System.out.println("Ingresa la moneda de destino:");
                String monedaDestino = lectura.nextLine().toUpperCase();

                System.out.println("Ingresa la cantidad a convertir:");
                double cantidad = lectura.nextDouble();

                // Obtener las tasas correspondientes
                double tasaOrigen = conversionRates.getAsJsonPrimitive(monedaOrigen).getAsDouble();
                double tasaDestino = conversionRates.getAsJsonPrimitive(monedaDestino).getAsDouble();

                // Realizar la conversión
                double resultado = (cantidad / tasaOrigen) * tasaDestino;
                System.out.printf("%.2f %s equivale a %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);

                AlmacenarConversion moneda = new AlmacenarConversion();
                moneda.almacenarConversion(monedaOrigen,monedaDestino,cantidad,resultado);

            } else {
                System.out.println("Error: " + response.statusCode() + " - " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Una de las monedas ingresadas no es válida.");

        }

    }
}
