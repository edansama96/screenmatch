package com.moviemove.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

/*
* Con el proyecto Spring ya creado, comenzamos creando una clase llamada ConsultaGemini,
* donde agruparemos todo el código relacionado con la API de Google:
* */
public class ConsultaGemini {
    /*
    * Luego podemos construir un método estático llamado obtenerTraduccion,
    *  que realizará la traducción vía API desde cualquier paquete de
    *  nuestro proyecto:
    * */
    public static String obtenerTraduccion(String texto) {
        /*
        * Ahora definimos qué modelo de la API utilizaremos y cuál será el prompt.
        *  Como necesitamos traducir un texto del inglés al español, el
        * código sería:
        * */
        String modelo = "gemini-2.0-flash-lite"; // Puedes cambiar la versión si lo deseas
        String prompt = "Traduce el siguiente texto al español: " + texto;

        /*
        * Finalmente, realizamos la solicitud de traducción con el modelo y prompt definidos. Hay un tercer parámetro para configuraciones
        * adicionales, pero en esta actividad lo dejaremos como null. Además, usamos un bloque try-catch para
        * gestionar posibles errores mediante excepciones en Java:
        * */

        Client cliente = new Client.Builder().apiKey("AIzaSyC68bmiuCf4qbgmD0YpCj0aRyFpRCRJY8k").build();

        try {
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null // Parámetro para configuraciones adicionales
            );

            if (!respuesta.text().isEmpty()) {
                return respuesta.text();
            }
        } catch (Exception e) {
            System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
        }

        return null;

    }
}
