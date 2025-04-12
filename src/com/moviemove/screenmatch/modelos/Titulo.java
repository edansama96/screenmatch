package com.moviemove.screenmatch.modelos;

public class Titulo {
    //Clase padre que contiene atributos que comparten elementos
    // como series o péliculas
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean icluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;


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

}
