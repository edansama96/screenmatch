package com.moviemove.screenmatch.principal;


import java.util.Arrays;
import java.util.List;

public class EjemploStream {
    //Ejemplo del uso de Streams
    public void muestraEjemplo(){
        //Se crea una lista de nombres con la cual se trabajara
        List <String> nombres = Arrays.asList("Brenda","Luis","Maria Fernanda","Eric","Genesys");
        //uso de stream
        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);


    }
}
