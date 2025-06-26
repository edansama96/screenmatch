package com.moviemove.screenmatch.principal;

//import com.moviemove.screenmatch.model.DatosEpisodio;
import com.moviemove.screenmatch.model.*;
//import com.moviemove.screenmatch.model.Episodio;
import com.moviemove.screenmatch.repository.SerieRepository;
import com.moviemove.screenmatch.service.ConsumoAPI;
import com.moviemove.screenmatch.service.ConvierteDatos;

import java.io.FileInputStream;
import java.io.IOException;
//import java.sql.SQLOutput;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

public class Principal {
    //Instancia  de la clase Scanner para poder recibir información por consola
    private Scanner tecalado = new Scanner(System.in);
    // Se crear una instnacia de la clase Consumo API, la cual realiza el proceso de
    // consulta en este caso que es el método get
    private ConsumoAPI consumoApi = new ConsumoAPI();
    //Crear un objeto Properties para poder manejar y cargar la key del api
    private Properties properties = new Properties();
    //Variables para la información constante de la uri
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    // VARIABLE que se usara para guardar el valor del apikey
    private String API_KEY = "";
    //Variable de pruepa del api_key al usar variables de entorno
    // al usar el System.getenv("variable de entorno "); para obtener la información
    private String API_KEY0 = System.getenv("API_SCREEN");
    // Instancia de la clase que realiza la conversión de los datos
    private ConvierteDatos conversor = new ConvierteDatos();
    //coleccion tipo lista de DatosSerie
    private List<DatosSerie> datosSeries = new ArrayList<>();
  //Se crea un atributo del elemento que se inyectara
    private SerieRepository repositorio;
    //Se pasa a declara de forma global la lista de Series para su uso en otras partes
   private List <Serie> series;
   //Se delara de forma global para el uso de la información con respecto al top 5 de los episodios por serie
   private Optional<Serie> serieBuscada;
    //uso del constructor para inicializar el parametro
    public Principal(SerieRepository repository) {
    this.repositorio = repository;
    }

    //Clase para crear el menu con la cual interactuara el usaurio
        //Méotodo encargado de mostrar el menu e interactuar con el usuario
    public void muestraElMenu(){
        //Se le solicita al usuario  el nombre del elemento a buscar
//        System.out.println("Por favor escribe el nombre de la serie que deseas buscar: ");
//        //Se establece una variable la cual guardara la información indicada por el usuario
//        // para este caso es de tipo String
//        var nombreSerie = tecalado.nextLine();
        //Se cargara el archivo config.properties
        // se usa un try en caso de encontrar un problema al cargar el archivo
//        try {
//            //abre el archivo que se utilizara
//            FileInputStream inputStream = new FileInputStream("target/classes/config.properties");
//           //Se lee e interpreta la información del archivo
//            properties.load(inputStream);
//            // se obtendra la clave apikey
//             API_KEY = properties.getProperty("api.key");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //se crear una variable de tipo String, la cual guarda el valor retornado por el
        // método ObtenerDatos
//        var json = consumoApi.obtenerDatos(URL_BASE+nombreSerie.replace(" ", "+")+"&apikey="+API_KEY);
        // se uso para validar que la petición get estuviera funcionando
        //System.out.println(json);
        // se realizara la conversión usando la variable de la clase conversorDatos instanciada
//        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        //Sout que permite obtener el título, totalTemporadas y evaluación
//        System.out.println(datos);
//        Integer total = datos.totalTemporadas();;
        // validando que la conversión funcionara bien
        //System.out.println("Los datos son: "+datos.totalTemporadas());
        //Creación de la lista para guardar los episodios de cada capitulos
        //Busca los datos de todas las temporadas
//        List<DatosTemporadas> temporadas = new ArrayList<>();
//        for (int i = 1; i <= total; i++) {
//            //nueva uri utilizada para poder buscar y guardar todos los episodios en cada uno de las temporadas al usar el iterador i
//            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + "&apikey=" + API_KEY);
//            //Variable que se encarga de obtener y convertir al información de tipo Json a tipo DatosTemporada
//            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
//           // System.out.println(datosTemporadas);
//            // Se adicciona la infromación de cada temporada en la lista
//            temporadas.add(datosTemporadas);
//        }
        //en la list de temporadas se realiza un foreach que permite después observar toda la información de cada temporada con respecto a su
        //número y episodios
       // temporadas.forEach(System.out::println);

         // Se trabaja con los arrays obtenidos, por lo tanto ahora se mostrará solo el título de los episodios por temporada
        // Se utilizarán ciclos for para poder recorrer cada lista
        //for (int i = 0; i < datos.totalTemporadas(); i++) {
            // Se crea una lista que guardará los episodios de la temporada actual
          //  List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();

            // Este segundo ciclo recorre los episodios de la temporada actual
            //for (int j = 0; j < episodiosTemporada.size(); j++) {
                // Se imprime el título de cada episodio
              //  System.out.println(episodiosTemporada.get(j).titulo());
            //}
        //}
        //Ahora se optimizara el código para esto se usara las funciones lambda
       // en este caso se realizara lo mismo que arriba pero con funciones lambda
        // ahora se pueden mostrar la lista de todos los episodios de todas las temporadas
       //Mejorar usando una función lambda
       // temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())) );

        //Convertir todas las informaciones a uns lista de tipo DatosEpisodio
        //Conversión de la lista tipo temporada a lista tipo episodio
//        List <DatosEpisodio> datosEpisodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream())
//                .collect(Collectors.toList());

        // Se utiliza la lista creada para manejar un TOP 5 de episodios
        //se utilizo stram para manejar la lista en donde se utilizaron funciones
        // para poder filtrar, comprar  y limitar además de terminar mostrando la información
//        System.out.println("Top 5 mejores episodios: ");
        //Uso de la función peek - ojeadita para entender como est duncionando el uso del stream que es programación funcional
//        datosEpisodios.stream()
                //Al utilizar filter en este caso permite obtener los episodios que la evaluación sea diferente a N/A
//                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primer filtro (N/A)" + e))
                //Realiza la comparación de las diferentes notas para organizarlos de mayor a menor
                // además de esto aplica la limitación de los 5 mejores episodios así como
                // hacer que las letras se cambien de mínusculas a máyusculas para el limite establecido
                // de los episodios
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .peek(e -> System.out.println("Segundo filtro oredenación (De mayor a menor)" + e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Tercer filtro (m > M)" + e))
//                .limit(5)
//                .forEach(System.out::println);

        // Conviertiendo los datos a una lista de tipo episodio
//        List <Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numeroTemporada(),d)))
//                .collect(Collectors.toList());

        // Se imprime los datos convertidos
        //episodios.forEach(System.out::println);

        //Búsqueda de episodios apartir de un año determinado
        //System.out.println("Por favor indica el año a partir del cual deseas ver los episodios: ");
       // se crea la variable que guardara el dato
       // var fecha = tecalado.nextInt();
        //limpieza del buffer
       // tecalado.nextLine();

        // crear una viarble propia de fecha de busqueda
//        LocalDate fechaBusqueda = LocalDate.of(fecha,1,1);
//        //DataTimeFormatter se utilizara para dar una personalización a la fecha
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        //Se establece los parametros en los cuales se trabajara con la
//        // lista de episodios
//        episodios.stream()
//                .filter(e -> e.getFechaDeLanzamiento() != null &&  e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
//                .forEach(e -> System.out.println("Temporada: " + e.getNumeroTemporada() +
//                        ", Episodio: " + e.getTitulo() +
//                         ", Fecha de Lanzamiento: " + e.getFechaDeLanzamiento().format(dtf)
//                ));

        //Busqueda episodios por pesdazo del título
//        System.out.println("Por favor escriba el titulo del episodio que desea ver ");
//        //varaiable para captar la información de busqueda
//        var pedazoTitulo = tecalado.nextLine();
//        // Uso de los episodios para realizar la compración o busqueda
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
//                .findFirst();
//        if(episodioBuscado.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Los datos son: " + episodioBuscado.get());
//        }else{
//            System.out.println("El episodio no existe o no fue encontrado");
//        }

        //Tener presente las colecciones parae este caso que se quiere tene una
        // suma de la temporada se usara la colección map
        // En esta varible map se usa el integer como el valor llave y double como el valor que se trabajara que son
        // las sumas de la evaluación de temporada
        // Aquí se usa un stream y collect para manejar los datos necesarios.
//        Map<Integer , Double> evaluacionesPorTemporada = episodios.stream()
//                .filter(e -> e.getEvaluacion() >0.0)
//                .collect(Collectors.groupingBy(Episodio::getNumeroTemporada,Collectors.averagingDouble(Episodio::getEvaluacion) ));
//        System.out.println(evaluacionesPorTemporada);

        //Uso de un nuevo recurso el cual permitira obtener un resumen de estadisticas

//        DoubleSummaryStatistics est = episodios.stream()
//                .filter(e-> e.getEvaluacion() > 0.0)
//                .collect(Collectors.summarizingDouble(Episodio :: getEvaluacion));
//
//        System.out.println("Media de las evaluaciones: " + est.getAverage());
//        System.out.println("El episodio mejor evaluado: " + est.getMax());
//        System.out.println("El episodio peor evaluado: " + est.getMin());
    var opcion = -1;
    while(opcion != 0){
        var menu = """
                1 - Buscar Series
                2 - Buscar Episodios
                3 - Mostrar Series buscadas
                4 - Buscar Series por título
                5 - Top 5 Mejores Series
                6 - Buscar Series por categoria
                7 - Filtrar series por una cantidad de temporadas y evaluación
                8 - Buscar episodios por nombre o título
                9 - Top 5 episodios por serie
                0-salir
                """;
        System.out.println(menu);
        opcion = tecalado.nextInt();
        tecalado.nextLine();

        switch (opcion){
            case 1:
                buscarSerieWeb();
                break;
            case 2:
                buscarEpisodioPorSerie();
                break;
            case 3:
               mostrarSeriesBuscadas();
                break;
            case 4:
                buscarSeriePorTitulo();
                break;
            case 5 :
                buscarTop5Series();
                break;
            case 6 :
                buscarSeriePorCategoria();
                break;
            case 7:
                filtrarSeriesPorTemporadaYEvaluacion();
                break;
            case 8:
                buscarEpisodiosPorTitulo();
                break;
            case 9 :
                buscarTop5Episodios();
            case 0:
                System.out.println("Cerrando la aplicación...");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    }


    private DatosSerie getDatosSerie(){
//        //Se le solicita al usuario  el nombre del elemento a buscar
//        System.out.println("Escribe el nombre de la serie que deseas buscar ");
//        //Se establece una variable la cual guardara la información indicada por el usuario
//        // para este caso es de tipo String
//        var nombreSerie = tecalado.nextLine();
//        //Se cargara el archivo config.properties
//        // se usa un try en caso de encontrar un problema al cargar el archivo
//        try {
//            //abre el archivo que se utilizara
//            FileInputStream inputStream = new FileInputStream("target/classes/config.properties");
//            //Se lee e interpreta la información del archivo
//            properties.load(inputStream);
//            // se obtendra la clave apikey
//            API_KEY = properties.getProperty("api.key");
//            //después de obtener el api al usar properties
//            var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&apikey=" + API_KEY0);
//            System.out.println(json);
//            DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
//            return  datos;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        // Se cambiara el uso del comportamiento manejado del  método o función debido
        // a que se dejara de usar el archivo config.properties para el manejo de información importante
        //Se le solicita al usuario  el nombre del elemento a buscar
        System.out.println("Escribe el nombre de la serie que deseas buscar ");
        //Se establece una variable la cual guardara la información indicada por el usuario
        // para este caso es de tipo String
        var nombreSerie = tecalado.nextLine();
        //Se validara si la variable de entorno es null o esta vacia con lo cual se muestra un throw
        // para indicar que no se obtiene la información del api
        if( API_KEY0 == null || API_KEY0.isEmpty()){
            throw new RuntimeException("No se encontro la variable de entorno del 'Api Screen' A" );

        }

            //después de validar si se obtuvo la información se procede a realizar el url que permitira obtener la información
            var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&apikey=" + API_KEY0);
            System.out.println(json);
            DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
            return  datos;

    }

    private void buscarEpisodioPorSerie(){
        //Se dejara de trabajar con la api de ombd para obtener la información
        // se manejaran las series guardadas en la base de datos
       // DatosSerie datosSerie = getDatosSerie();
        mostrarSeriesBuscadas();
        System.out.println("Escribe el nombre de la serie de la cual quiero ver los episodios: ");
       //variable para guardar la información indicada por el usuario
        var nombreSerie = tecalado.nextLine();
        // uso del optional teniendo presente que se realizara una busqueda
        // que puede o no contener un resultado
        Optional<Serie> serie = series.stream()
                .filter( s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();

        //Después de realizar la busqueda por medio del stream se procede a tratar la información obtenida
        if(serie.isPresent()){
            var serieEncontrada = serie.get();

            List<DatosTemporadas> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoApi.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + "&apikey="+API_KEY0);
                System.out.println("Json del paso 2: " + json);
                DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);

            //Después de el procesamiento y obtenicón de las temporadas
            // Ahora se procede a realizar una conversión de temporadas a episodios
            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numeroTemporada(), e)))
                    .collect(Collectors.toList());
            // Proceso de guardar la información en episodios
            serieEncontrada.setEpisodios(episodios);
            //Una vez encontrada la información a trabajar se procede
            // a guardar la información por medio de la clase repositorio
            repositorio.save(serieEncontrada);
        }else{
            System.out.println("La series "+nombreSerie +" buscada no se encuentra en la base de datos");
        }

    }

    private void buscarSerieWeb(){
        DatosSerie datos = getDatosSerie();
        //Se cambia el manejo de la información debido a que ya no se guardara en
        // una lista si no en la base de datos
        //datosSeries.add(datos);
        //Se declara uns instancia de series en donde se podra como parametro de entrada
        // datos
        Serie serie = new Serie(datos);
        System.out.println("la información manejada : " + datos);
        //ahora se usara repositorio que se esta implementado para gusrdar la información
        repositorio.save(serie);
        System.out.println(datos);
    }
//método para mostrar las series web buscadas
    private void mostrarSeriesBuscadas() {
       //datosSeries.forEach(System.out::println);
        //Se realizara un cambio por que ahora se manejara la clase Series creada
       // Se crear una lista series que guarda la información de datosSerie
//        List <Serie> series =  new ArrayList<>();
        // ahora en la lista de la serie se usara la información del repo encargada
        //de gusrdar la información en la base de datos
         series = repositorio.findAll();
        //Se indica a la lista el manejo de los datos series
        // con map se convierte a elementos tipo Serie
        //convierte la información a una nueva lista
//        series = datosSeries.stream()
//                .map(d ->  new Serie(d))
//                .collect(Collectors.toList());
        //Se procede a deshabilitar la lista que guardaba la información y el uso
        // de stream con datosSeries-


        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);


    }
    //Método utilizad para mostrar las Series
    private void  buscarSeriePorTitulo() {
        //Se le solicita al usuario  el nombre del elemento a buscar
        System.out.println("Escribe el nombre de la serie que deseas buscar ");
        //Se establece una variable la cual guardara la información indicada por el usuario
        // para este caso es de tipo String
        var nombreSerie = tecalado.nextLine();
        //Se crea una lista donde se almacenara la serie para esto se usa el optinal que
        // representa que el elemento aun no debe estar creado, así como se le envia el parametro
        // establecido por el usuario, además de evocar el método creado en la clase repositorio Serie
         serieBuscada = repositorio.findByTituloContainsIgnoreCase(nombreSerie);

        //Se procede a manejar la información con un condicional
        if (serieBuscada.isPresent()){
            System.out.println("La series buscada es: " + serieBuscada.get());
        }else {
            System.out.println("Serie no encontrada");
        }

    }
    //Método para realizar la busqueda del top 5 series
    private void buscarTop5Series(){
        //Lista que guardara la información de las series
        List <Serie> topSeries = repositorio.findTop5ByOrderByEvaluacionDesc();
        //Se muestra la lista guardada
        topSeries.forEach(s ->
                System.out.println("Serie:" + s.getTitulo() +  " Evaluación:" +s.getEvaluacion()));
    }
    /*
    * Método para buscar seria por categoria
    * Se debe realizar una conversion o casteo, al estar
    * relacionado elementos de la clase enum que se utiliza
    * para establecer las categorias
    *
    * */
    private void buscarSeriePorCategoria(){
        //Se le solicita la información al usuario
        System.out.println("Escriba el genero/categoria de la seria que desea buscar");
        var generoC = tecalado.nextLine();
        //Se tranforma el genero en un elemnto de categoria tipo
        //enum
        var categoria = Categoria.fromEspanol(generoC);
        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
        //Se muestra un mensaje al usaurio
        System.out.println("Las series de la categoria: " + generoC);
        seriesPorCategoria.forEach(System.out::println);

    }
        //Clase utilizara para filtrar las series con una cantidad de temporadas y una cantidad de nota de evaluación
    // por usar la region de latinoamerica se usa la , y no el .
/*
* Primera forma utilizad para filtrar la información por numero de temporadas y evaluación
* en donde se utilizan queries derivadas
*
* */
    public void filtrarSeriesPorTemporadaYEvaluacion(){
        //Se solicita la información de la cantidad de temporadas al usuario
        System.out.println("¿Filtrar séries con cuántas temporadas? ");
        var totalTemporadas = tecalado.nextInt();
        tecalado.nextLine();
        //Se solicita la información de la cantidad de evaluación de la serie que desea buscar o filtrar
        System.out.println("¿Com evaluación apartir de cuál valor? ");
        var evaluacion = tecalado.nextDouble();
        //Se limpia el buffer manejado para la lectura de información por consola
        tecalado.nextLine();
       // List<Serie> filtroSeries = repositorio.findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(totalTemporadas, evaluacion);
        //alternativa que usa query native
        List<Serie> filtroSeries = repositorio.seriesPorTemporadaYEvaluacion(totalTemporadas,evaluacion);
        //Se procede a mostrar la información de las series filtradas
        System.out.println("*** Series filtradas ***");
        filtroSeries.forEach(s ->
                System.out.println(s.getTitulo() + "  - evaluacion: " + s.getEvaluacion()));
    }
//Método para buscar episodios por nombre
    private void buscarEpisodiosPorTitulo(){
        System.out.println("Escribe el nombre del episodio que deseas buscar: ");
        var nombreEpisodio = tecalado.nextLine();
        //Se guarda la seria que se utilizara para buscar
        List<Episodio> episodiosEncontrados = repositorio.episodiosPorNombre(nombreEpisodio);
    //se procesa si se encontro o no el episodios
    //Se mostrara la salida del episodio
       episodiosEncontrados.forEach(e->
               System.out.printf("Serie: %s Temporada: %s Episodio: %s Evaluación: %s \n",
                       e.getSerie(), e.getNumeroTemporada(), e.getTitulo(), e.getEvaluacion()));
    }
    //Método para buscar el top 5 de episodios por serie
    private void buscarTop5Episodios() {
    //Para saber cual seria es la que el usuario quiere buscar los episodios se evoca o llama al método
        buscarSeriePorTitulo();
        //Se procede a validar si la serie esta para poder trabajr con
        // ella y así obtener el top de los episodios por serie
        if(serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            //Se crea uns lista para manejar el top 5 de episodios
            List<Episodio>  topEpisodios = repositorio.top5Episodios(serie);
            System.out.println("*** Episodios top5 ***");
            topEpisodios.forEach(e ->
                    System.out.printf("Serie: %s - Temporada: %s - Episodio: %s y Numero: %s - Evaluación %s\n",
                            e.getSerie().getTitulo(), e.getNumeroTemporada(), e.getTitulo(), e.getNumeroEpisodio(), e.getEvaluacion()));
        }

    }




}
