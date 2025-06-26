package com.moviemove.screenmatch.service;
// Se define una interfaz llamada IConvierteDatos.
// Una interfaz en Java declara métodos sin implementarlos, y sirve como contrato
// que deben seguir las clases que la implementen.
public interface IConvierteDatos {

    // Se declara un método genérico llamado 'obtenerDatos'.
    // Este método recibirá:
    // - un String llamado 'json', que representa los datos en formato JSON,
    // - y una clase 'clase' que indica el tipo de objeto al que se desea convertir ese JSON.
    //
    // El método retorna un objeto del tipo indicado por el parámetro genérico <T>.
    // Por ejemplo, si se llama como obtenerDatos(json, Pelicula.class),
    // devolverá un objeto de tipo Pelicula.

    // <T> indica que este método es genérico.
    // Esto significa que 'T' es un tipo que se decidirá en tiempo de compilación,
    // cuando se use este método.

    // El método recibe:
    // - un String llamado 'json' (los datos JSON que se quieren convertir),
    // - y una clase del tipo Class<T>, es decir, la clase a la que se quiere convertir el JSON.

    // El método devolverá un objeto del tipo T.
    //
    // Ejemplo de uso:
    // Si llamas obtenerDatos(json, Pelicula.class), entonces T será Pelicula
    // y el método devolverá un objeto de tipo Pelicula.
    <T> T obtenerDatos(String json, Class<T> clase);

}