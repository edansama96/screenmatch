package com.moviemove.principal;

import com.moviemove.screenmacth.calculos.CalculadoraDeTiempo;
import com.moviemove.screenmacth.calculos.FiltroRecomendacion;
import com.moviemove.screenmatch.modelos.Episodio;
import com.moviemove.screenmatch.modelos.Pelicula;
import com.moviemove.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Pelicula miPelicula= new Pelicula("Encato" , 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);


        miPelicula.mostrarFichaTecnica();
        miPelicula.evaluarPelicua(10);
        miPelicula.evaluarPelicua(10);
        miPelicula.evaluarPelicua(7.80);
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calcularMedia());


        Serie casaDragon = new Serie("La casa del dragón", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.mostrarFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Matrix",1998);
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

        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);

        //Creación de ArrayList
        ArrayList <Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("El tamaño de la lista es:" + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        System.out.println("-------------------------------------------------------------");

        System.out.println(listaDePeliculas);

        System.out.println("toString de la pélicula: " + listaDePeliculas.get(0).toString());



    }
}
