//package com.moviemove.screenmatch;
//
//import com.moviemove.screenmatch.principal.Principal;
//import com.moviemove.screenmatch.repository.SerieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//
//@SpringBootApplication
//public class ScreenmatchApplicationConsola implements CommandLineRunner {
//	//Indica a spring que realice una inyección de dependencia
//	@Autowired
//	//Ahora se indica el emeneot que se intectara
//	private SerieRepository repository;
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenmatchApplicationConsola.class, args);
//
//	}
//
//
//		@Override
//		public void run (String...args) throws Exception {
//			// System.out.println("Hola mundo desde Spring Boot");
//			/*
//			 * Se creará una instancia para traer la información
//			 * de la API OMDb (Open Movie Database), que contiene información
//			 * sobre series y películas. Esta información se cargará
//			 * automáticamente una vez se construya el proyecto en Spring Boot.
//			 */
//
////		var consumoApi = new ConsumoAPI();
//			// url para consultar la información general de la series
//			//var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=4b61bf4e");
//			//Ejercicio para consumir otro tipo de api
//			//var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
//			//System.out.println(json);
//			//Se crea una nueva instancia de Convierte Datos
//			//ConvierteDatos conversor = new ConvierteDatos();
//			//variables para llamar el méotodo y recibe el json de la api para convertir dicha información
//			//en una clase de DatosSeries.class
//			//var datos = conversor.obtenerDatos(json, DatosSerie.class);
//			//System.out.println(datos);
//			//url para recolectar información de las temporadas y capitulos en específico
//			//json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=4b61bf4e");
//			// se creara una variable de tipo  datosepisodio que guarda la nueva información obtenida información obtenida
////		DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
////		System.out.println(episodios);
//
//			// por el cambio realizado en Principal, se comenta el proceso de solicitudes manejado hasta el momento.
//			// por lo cual ahora en este método sobre escrito ahora se manejara una instnacia de principal
//		//Principal principal = new Principal();
//		//Ahora para manejar el atributo que se inyectara se addiciona en el constructor de la clase
//		//Principal
//			Principal principal = new Principal(repository);
//			principal.muestraElMenu();
////			EjemploStream practica = new EjemploStream();
////			practica.muestraEjemplo();
//
//
//		}
//
//}
