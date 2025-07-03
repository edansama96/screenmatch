package com.moviemove.screenmatch.dto;

import com.moviemove.screenmatch.model.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
/*
* Clase record TIPO DTO o Objeto de tranferencia de datos
* Se encargara de obtener la información de la base de datos para
* moostrarle dicha información al usuario
* */
public record SerieDTO(
        Long id,
        String titulo,
        Integer totalTemporadas,
        Double evaluacion,
        String poster,
        Categoria genero,
        String actores,
        String sinopsis) {
}
