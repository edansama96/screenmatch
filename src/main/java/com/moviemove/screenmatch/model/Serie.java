package com.moviemove.screenmatch.model;

/*
*Mapeo de la información
* Se crea la clase series
* para podeber manejar más información
* de la api de omdb
* Clase que representa los datos optenidos de la api
* se usa para la forma de mostrar y almacenar
* la información en la base de datos.
* */

import com.moviemove.screenmatch.service.ConsultaGemini;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
//Anotación para indicar que esta clase es una entidad en la base de datos
@Entity
//Anotación para cambiar el nombre de la table en la base de datos
@Table(name = "series")
public class Serie  {
    //Variable creada para almacenar el id de cada serie adicionada
  //Anotacion para representar que es un ID
   @Id
   //Anotacion para que se identifique y autogenere el id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   //Anotación utilizado para que cada serie no se repita y sea unica
   @Column(unique = true)
    private String titulo;
    private Integer totalTemporadas;
    //Se cambia de tipo string a souble por el uso que se le esta dando
    // en la aplicación en la parte de filtros
    private Double evaluacion;
    private String poster;
    //Anotación para indicar el uso del enum con el que se establece parametros predefinidos
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String actores;
    private String sinopsis;
//Secrea un atributo o vatiable para almacenar la lista de episodios de cada series
    //Anotación para indicar que existe la lista pero de momento no se utilizara @Transient
    //Anotación para indicar la relacion a manejar y el dato de intersección o conexión
    //Al usar el cascade es para sinconizar la inteeracción entre las tablas
    //se usara fetch para indicar si usar lazy o eager para obtener la información
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios;

    //Se establece un constructor vacio indicando que no se necesitan inicializar los atributos
    // y con esto no se cree un problema a la hora de ejecución del programa
    public Serie() {}
   // Se usa el método constructor para poder inicializar los atributos manejados
    public Serie(DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalTemporadas = datosSerie.totalTemporadas();
        // original         this.evaluacion = String.valueOf(OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0));
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
        this.poster = datosSerie.poster();
        //Se creo un método en la clase enum para usar las categeorias establecidas
        // se usa split para indicar que de los diferentes categeorias dadas por la api se usaria la posición 0
        this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        this.actores = datosSerie.actores();
        //Caso opcional para poder realizar la traduccion de la sinopsis por medio del
        //api de geminis
        //this.sinopsis = ConsultaGemini.obtenerTraduccion(datosSerie.sinopsis()) ;
        this.sinopsis = datosSerie.sinopsis() ;

    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        //se modifica el método se obtención para poder relacionar la información
        // de cada episodio con su serie conrrespondiente
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return
                " genero=" + genero + '\'' +
                ",titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", evaluacion='" + evaluacion + '\'' +
                ", poster='" + poster + '\'' +
                ", actores='" + actores + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", episodios='" + episodios +'\'';
    }
}
