package com.moviemove.screenmatch.service;

import com.moviemove.screenmatch.dto.EpisodioDTO;
import com.moviemove.screenmatch.dto.SerieDTO;
import com.moviemove.screenmatch.model.Categoria;
import com.moviemove.screenmatch.model.Serie;
import com.moviemove.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* Reglas de negocio y transformaciones
*
* */
@Service
public class SerieService {
    //Inyección para el uso de los datos
    @Autowired
    private SerieRepository repository;


// Método que obtiene todas las series desde la base de datos,
// las convierte a objetos SerieDTO y retorna una lista con esas series transformadas.
   // @GetMapping("/series")
    public List<SerieDTO> obtenerTodasLasSeries() {
      //  primer proceso de conversión
//        return repository.findAll().stream()
//                .map(s -> new SerieDTO(s.getTitulo(),s.getTotalTemporadas(),s.getEvaluacion(),s.getPoster(),
//                        s.getGenero(), s.getActores(),s.getSinopsis()))
//                .collect(Collectors.toList());
        //Segunda forma al observar que la conversion en un paso general para diferentes procesos
        return convierteDatos( repository.findAll());


    }
    //Metodo para manejar on top5
    public List<SerieDTO> obtenerTop5() {
        return  convierteDatos(repository.findTop5ByOrderByEvaluacionDesc());
    }

    //Método para obtener el lanzamientod e episodios más recientes
    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return  convierteDatos(repository.lanzamientosMasRecientes());
    }


//Método para abtraer o convertir la información
    public List<SerieDTO> convierteDatos(List<Serie> serie){
      return   serie.stream()
                .map(s -> new SerieDTO(s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getEvaluacion(),s.getPoster(),
                        s.getGenero(), s.getActores(),s.getSinopsis()))
                .collect(Collectors.toList());
    }

    // Método que busca una serie por su ID y devuelve un objeto SerieDTO con la información
    public SerieDTO obtenerPorId(Long id) {

        // Se usa Optional para manejar el caso en que no exista una serie con el ID dado
        Optional<Serie> serie = repository.findById(id);

        // Verifica si se encontró una serie con ese ID
        if (serie.isPresent()) {
            // Si está presente, se obtiene el objeto Serie
            Serie s = serie.get();

            // Se construye un objeto SerieDTO con los datos necesarios de la serie
            return new SerieDTO(
                    s.getId(),
                    s.getTitulo(),           // Título de la serie
                    s.getTotalTemporadas(), // Número total de temporadas
                    s.getEvaluacion(),      // Evaluación o calificación
                    s.getPoster(),          // URL del póster o imagen
                    s.getGenero(),          // Género de la serie
                    s.getActores(),         // Actores principales
                    s.getSinopsis()         // Sinopsis o descripción
            );

        } else {
            // Si no se encontró la serie, se retorna null
            return null;
        }
    }

    public List<EpisodioDTO> obtenerTodasLasTemporadas(Long id) {
        // Se usa Optional para manejar el caso en que no exista una serie con el ID dado
        Optional<Serie> serie = repository.findById(id);
        //validación para manejar la info de temporadas
        if (serie.isPresent()) {
            Serie s = serie.get();


            return s.getEpisodios().stream()
                    // USADO PARA VALIDAR que se estuviera manejando la información de temporadas
//                    .peek(e -> {
//                        if (e.getNumeroTemporada() == null) {
//                            System.out.println("⚠️ Episodio sin número de temporada: " + e.getTitulo());
//                        } else {
//                            System.out.println("✅ Episodio " + e.getTitulo() + " tiene temporada: " + e.getNumeroTemporada());
//                        }
//                    })
                    .filter(e -> e.getNumeroTemporada() != null && e.getNumeroTemporada() > 0)
                    .map(e -> new EpisodioDTO(
                            e.getNumeroTemporada(),
                            e.getTitulo(),
                            e.getNumeroEpisodio()
                    )).collect(Collectors.toList());

        }else{

        return null;
        }

    }

    //Método para obtener los episodios apartir del número de temporadas
    public List<EpisodioDTO> obtenerTemporadasPorNumero(Long id, Long numeroTemporada) {
        return repository.obtenerTemporadasPorNumero(id, numeroTemporada).stream()
                .map(e -> new EpisodioDTO(e.getNumeroTemporada(),e.getTitulo(),e.getNumeroEpisodio())).collect(Collectors.toList());
    }

    //Método para obtener las series por categoria
    public List<SerieDTO> obtenerSeriesPorCategoria(String nombreGenero) {
        //De la clase categoria se usa el método fromEspañol para realizar la conversión de enum a string
        // En el manejo de las categorias
        Categoria categoria = Categoria.fromEspanol(nombreGenero);
        // Se usa el método ConvierteDatos encargado de convertir la información de Serie a SerieDTO, y después se usa
        //el parametro de método declarado en se usa para buscar las series por genero
        return  convierteDatos( repository.findByGenero(categoria));

    }

    //Método para obtener el top por episodios
//    public List<EpisodioDTO> obtenerTopEpisodios(Long id) {
//        var serie = repository.findById(id).get();
//        return repository.top5Episodios(serie)
//                .stream()
//                .map(e -> new EpisodioDTO(e.getNumeroTemporada(),e.getTitulo(),
//                        e.getNumeroEpisodio()))
//                .collect(Collectors.toList());
//    }
}
