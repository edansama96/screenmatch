package com.moviemove.screenmatch.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
// Se define la clase ConvierteDatos que implementa la interfaz IConvierteDatos.
// Esta clase se encargará de convertir (deserializar) datos en formato JSON a objetos Java.
public class ConvierteDatos implements IConvierteDatos {

    // Se crea una instancia de ObjectMapper, que es una clase de la biblioteca Jackson.
    // ObjectMapper permite convertir entre objetos Java y JSON (serialización/deserialización).
    private ObjectMapper objectMapper = new ObjectMapper();

    // Se implementa el método obtenerDatos definido en la interfaz IConvierteDatos.
    // Este método recibe como parámetros:
    // 1. un String llamado 'json', que representa los datos en formato JSON,
    // 2. y una clase 'clase' que representa el tipo al que queremos convertir ese JSON.
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Aquí se usa el método readValue del ObjectMapper para convertir el JSON en una instancia
            // de la clase indicada (clase). Es decir, transforma el texto JSON en un objeto Java.
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            // Si ocurre un error al procesar el JSON (por ejemplo, si está mal formado),
            // se lanza una RuntimeException para indicar que la conversión falló.
            throw new RuntimeException(e);
        }
    }
}
