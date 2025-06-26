package com.moviemove.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
* Se crea la clase record para obtener y manejar una información
* determinada de los capitulos de la serie
* en donde se trabajo con la fecha de lazamiento, el título, episiodio, y puntuacuíon
* se usan anotaciones de la libreria jackson para usar los elementos mencionados con el nombre
* que tienen en el json, además de usar el ignore para no tener presente el resto de información
* dada por la api
* */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode") Integer numeroEpisodio,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Released") String fechaDeLanzamiento
) {
}
