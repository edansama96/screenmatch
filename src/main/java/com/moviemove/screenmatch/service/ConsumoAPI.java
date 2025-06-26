package com.moviemove.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    // Método que realiza una solicitud HTTP GET a la URL indicada y devuelve la respuesta como texto (JSON, por ejemplo)
    public String obtenerDatos(String url) {

        // Se crea un cliente HTTP con configuración por defecto (Java 11+)
        HttpClient client = HttpClient.newHttpClient();

        // Se construye una solicitud HTTP tipo GET a partir de la URL dada
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Convierte el String 'url' en un objeto URI
                .build(); // Finaliza la construcción de la solicitud

        // Se declara la variable que almacenará la respuesta del servidor
        HttpResponse<String> response = null;

        // Bloque try-catch para manejar posibles errores al enviar la solicitud
        try {
            // Se envía la solicitud y se espera la respuesta de forma sincrónica
            // La respuesta se interpretará como texto plano (String)
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            // Si ocurre un error de entrada/salida (por ejemplo, problema de red), se lanza una excepción no verificada
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            // Si el hilo es interrumpido mientras espera la respuesta, también se lanza como RuntimeException
            throw new RuntimeException(e);
        }

        // Se extrae el cuerpo (body) de la respuesta HTTP, usualmente un JSON
        String json = response.body();

        // Se devuelve el cuerpo de la respuesta como String
        return json;
    }



}
