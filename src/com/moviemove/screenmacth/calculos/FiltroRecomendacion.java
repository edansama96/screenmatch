package com.moviemove.screenmacth.calculos;

public class FiltroRecomendacion {

    public void filtra(Clasificacion clasificacion){
        if ( clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado en el momento.");
        }else if (clasificacion.getClasificacion() <= 2) {
            System.out.println("Impopular en el momento");

        }else{
            System.out.println("Colocalo en tu lista para verlos después");
        }
    }
}
