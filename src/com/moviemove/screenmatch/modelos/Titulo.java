package com.moviemove.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;
import com.moviemove.screenmatch.excepcion.ErrorEnConversionDeDuracionException;

public class Titulo  implements  Comparable <Titulo>{
    //Clase padre que contiene atributos que comparten elementos
    // como series o péliculas
    // en su momento se uso la anotación serializedName, para obtener el nombre del elemento
    // como estaba guardado en el json
//    @SerializedName("Title")
    private String nombre;
//    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean icluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;


    /*
    * Método constructor en donde se esta realizando una obtención y conversion de los
    *  valores obtenidos por medio de la API
    * */
    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        //Se esta creando una propia exception para el caso de la pélicula de bichos
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duración," +
                    "porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }

//    public Titulo() {
//    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean incluidoEnElPlan() {
        return icluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean icluidoEnElPlan) {
        this.icluidoEnElPlan = icluidoEnElPlan;
    }

    public int getTotalDeLasEvaluaciones() {
        return totalDeLasEvaluaciones;
    }


    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.nombre = nombre;
    }

    public void mostrarFichaTecnica() {
        System.out.println("\nEl nombre de la pélicula es: " + nombre);
        System.out.println("La fecha  de lazamiento de la pélicula es: " + fechaDeLanzamiento);
        System.out.println("La duración en minutos de la pélicula es: " + getDuracionEnMinutos());

    }

    public void evaluarPelicua(double nota) {
        sumaDeLasEvaluaciones += nota; // igual a  sumaDeLasEvaluaciones = sumaDeLasEvaluaciones +nota
        totalDeLasEvaluaciones++;

    }





    public double calcularMedia() {

        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    // método para orgnizar por titulo
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return
                "(nombre='" + nombre  +
                ", fechaDeLanzamiento= " + fechaDeLanzamiento+
                ", duración= "+duracionEnMinutos +")\n";
    }
}
