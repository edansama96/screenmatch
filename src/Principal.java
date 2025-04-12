import com.moviemove.screenmacth.calculos.CalculadoraDeTiempo;
import com.moviemove.screenmacth.calculos.FiltroRecomendacion;
import com.moviemove.screenmatch.modelos.Episodio;
import com.moviemove.screenmatch.modelos.Pelicula;
import com.moviemove.screenmatch.modelos.Serie;


public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula= new Pelicula();
        miPelicula.setNombre("Encato");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);


        miPelicula.mostrarFichaTecnica();
        miPelicula.evaluarPelicua(10);
        miPelicula.evaluarPelicua(10);
        miPelicula.evaluarPelicua(7.80);
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calcularMedia());

        Serie casaDragon = new Serie();
        casaDragon.setNombre("La casa del dragón");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.mostrarFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setNombre("Matrix") ;
        otraPelicula.setFechaDeLanzamiento(1998);
        otraPelicula.setDuracionEnMinutos(180);
        otraPelicula.mostrarFichaTecnica();


        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: " + calculadora.getTiempoTotal() + " minutos");


        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);
        System.out.println("_________________________________________");
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(200);

        filtroRecomendacion.filtra(episodio);


    }
}
