package com.moviemove.screenmatch.repository;

import com.moviemove.screenmatch.model.Categoria;
import com.moviemove.screenmatch.model.Episodio;
import com.moviemove.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository <Serie,Long> {
    //Se usara esta clase para poder manejar un texto qu JPA interprete en la busqueda de la serie
    Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);
    //Lista utilizada paa ordenar y buscar el top 5 de las series
    List<Serie> findTop5ByOrderByEvaluacionDesc();
    //Buscar series por categoria
    List<Serie> findByGenero(Categoria categoria);
    //Consulta derivada para buscar con dos tipos de filtros
    List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);
    //Lista para manejar un metodo con una querry y observar el mismo comportamiento de arriba
    //     @Query(value = "SELECT * FROM series WHERE series.total_temporadas <= 6 AND series.evaluacion >= 7.5;", nativeQuery = true) native query consultas fijas
  //Uso de JPQL el lenguaje usado para manejar las entidades y realizar consultas con estas
  // Se cambia el * por un s la cual representa la entidad a manejar
  // además ya no se utilizara el nombre de la tabla si no de la clase a manejar además de usar un alias
    //uso de : para diferenciar entre los atributos de entrada y las vatiables de la clase
    @Query( "SELECT s FROM Serie  s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
    List <Serie> seriesPorTemporadaYEvaluacion (int totalTemporadas, Double evaluacion);
 //Método para buscar episodios por nombre
    //Se usa jpql para realizar una consulta relacional entre las tablas
    // además de esto se usa ILIKE para no diferenciar entre máyuscuas o mínusculas
    @Query ("SELECT e FROM Serie s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
    List<Episodio> episodiosPorNombre(String nombreEpisodio);
    //Función o método para realizar un top de episodios por serie
    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5 ")
    List<Episodio> top5Episodios(Serie serie);

}
