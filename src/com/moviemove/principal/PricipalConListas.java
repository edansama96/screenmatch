package com.moviemove.principal;


import com.moviemove.screenmatch.modelos.Pelicula;
import com.moviemove.screenmatch.modelos.Serie;
import com.moviemove.screenmatch.modelos.Titulo;

import java.util.*;

public class PricipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encato", 2021);
        miPelicula.evaluarPelicua(9);
        Serie casaDragon = new Serie("La casa del dragón", 2022);
        casaDragon.evaluarPelicua(6);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.evaluarPelicua(10);
        Serie lost = new Serie("Lost", 2000);
        lost.evaluarPelicua(9);
        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.evaluarPelicua(7);

        //Creación de ArrayList
        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(casaDragon);
        lista.add(lost);

        /*
         * Ciclo for para recorrer el array
         * y uso del if para castiar elemento
         * de tpitulo a pélicula
         * este proceso no es recomendado
         * */
        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
//                Pelicula pelicula = (Pelicula) item;
                System.out.println("Clasificacion: " + pelicula.getClasificacion());
            }

        }
        //Arraylista para la lista de los nombre de los artistas
        ArrayList<String> listaDeArtitas = new ArrayList();
        listaDeArtitas.add("Penélope Cruz");
        listaDeArtitas.add("Antonio Banderas");
        listaDeArtitas.add("Ricardo Darin");
        System.out.println(listaDeArtitas);


        //interfaz madre de todas las colecciones
        /* se usar el método sort para ordenar la colección
         *                */
        Collections.sort(listaDeArtitas);
        System.out.println("Lista de Artistas  ordenada: " + listaDeArtitas);

        //Proceso para ordenar la lista de titulos
        Collections.sort(lista);
        System.out.println("La lista de péliculas es:  " + lista);

        //Proceso para organizar por fecha
        /*
        * sort uso de parametro Comparator que es interfaz
        * se usa el método estatico comparing y se indica el elemento a comparar
        * que para este caso son las fechas de lanzamiento.
        * */
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista organizada por fecha: " + lista);

    }
}
