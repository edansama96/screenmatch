package com.moviemove.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
* Se usa la clase Record, para obtener la información de la api
* Ademas de esto por el manejo diferentes de los elementos
* se utilizara una anotación del jackson para su intepretación
* */
/*
* Tener presente la anotación @JsonAlias se utiliza para leer la información
* Tener presente la anotación @JsonProperty permite leer y enviar información
* como por ejemplo para este caso poder adicionar una serie.
* */
//anotación para indicar que solo se utilizaran unas propiedades del json y no todas
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Actors") String actores,
        @JsonAlias("Plot") String sinopsis){
}