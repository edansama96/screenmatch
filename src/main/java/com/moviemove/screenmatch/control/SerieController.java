package com.moviemove.screenmatch.control;

import com.moviemove.screenmatch.dto.EpisodioDTO;
import com.moviemove.screenmatch.dto.SerieDTO;
import com.moviemove.screenmatch.repository.SerieRepository;
import com.moviemove.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//Anotación para el modelo api rest
@RestController
@RequestMapping("/series")
public class SerieController {
    //Autowired para llamar y traer la dependencia de SerieService
    @Autowired
    private SerieService servicio;
    //Uso de la anotación GetMapping requisisiones
    //Manejo de endpoint
    //@GetMapping("/series")
    //Método para retornar una lista de series
//    public List<Serie> obtenerTodasLasSeries(){
//        return  repository.findAll();
//    }

    // Método que obtiene todas las series desde la base de datos,
// las convierte a objetos SerieDTO y retorna una lista con esas series transformadas.
//Método que llamar el método establecido en la clase SerieService para mostrar las series
// en donde se realiza el cambio a un elmento DTO
    @GetMapping("")
    public List<SerieDTO> obtenerTodasLasSeries() {
        return servicio.obtenerTodasLasSeries();

    }

    //Mapeo  para manejar el top 5
    @GetMapping("/top5")
    public List<SerieDTO> obtenerTop5() {
        return servicio.obtenerTop5();
    }


    //Mapero para  obtener los lanzamientos más reciente de episodios
    @GetMapping("/lanzamientos")
    public List<SerieDTO> obtenerLazamientosMasRecientes() {
        return servicio.obtenerLanzamientosMasRecientes();
    }

    //Mapeo para poder obtener la información de cada serie
    @GetMapping("/{id}")
    public SerieDTO obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    //Mapero paa manejar la cantidad de temporadas de cada serie
    @GetMapping("/{id}/temporadas/todas")
    // se usa el pathvariable para que se reconoca del id que se esta manejando
    public List<EpisodioDTO> obtenerTodasLasTemporadas(@PathVariable Long id) {
        return servicio.obtenerTodasLasTemporadas(id);
    }

    //Mapero para obtener la información de los capitulos por temporada
    @GetMapping("/{id}/temporadas/{numeroTemporada}")
    public List<EpisodioDTO> obtenerTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numeroTemporada){

    return  servicio.obtenerTemporadasPorNumero(id,numeroTemporada);

    }

    //Mapeo para poder buscar las series por categoria
    @GetMapping("/categoria/{nombreGenero}")
    public List<SerieDTO> obtenerSeriesPorCategoria(@PathVariable String nombreGenero){

        return  servicio.obtenerSeriesPorCategoria(nombreGenero);

    }

    //Mapeo para poder obtener el top de las series
//    @GetMapping("/{id}/temporadas/top")
//    public List<EpisodioDTO> obterTopEpisodios(@PathVariable Long id){
//        return servicio.obtenerTopEpisodios(id);
//    }




}
