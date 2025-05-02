package com.moviemove.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moviemove.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.moviemove.screenmatch.modelos.Titulo;
import com.moviemove.screenmatch.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PricipalConBusqeda {
    //clase principal en la cual se interactua con la api de omdbapi, que tiene información de series
// y películas además de usar throws, para manejar ciertos errores que puede suceder en el proceso
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        //lista de titulos que guardara la información
        List<Titulo> titulos =  new ArrayList<>();
        //Se instancia la clase Gson, para realizar la conversión
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
               //Permite que el gson guardado se puede obervar mejor al
                // guardar cada elemento de forma horizontal
                .setPrettyPrinting()
                .create();
        /*
         * Se realiza el proceso que permitira obtener varias consultas y que
         * estas seguarden en un archivo json
         * */

        while (true) {
            System.out.println("Escriba el nombre de una pelicula: ");
//        var busqueda = teclado.nextLine();
            //Se procede a usar la clase URLEncoder para manejar espacio o caracteres espaciles
            var busqueda = URLEncoder.encode(teclado.nextLine(), StandardCharsets.UTF_8);

            //Condición para romper el ciclo infinito while
            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            String clave = "4b61bf4e";
            //Opción aplica para el reemplazo del espacio en blanco busqueda.replace(" ","+")
            String url = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=" + clave;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                //Para convetir de json a la clase
                /*
                 * Se crear una instnacia de la calse a trasnformar
                 * en donde por medio de json se le indica el json que se convertirar
                 * así como el tipo de clase a la cual se convertira
                 * */
                //Titulo miTitulo = gson.fromJson(json, Titulo.class);
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);
//        Titulo miTitulo = new Titulo(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Título ya convertido: " + miTitulo);

                //Se procede a adicionar el titulo ingresado por el usuario
                titulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, vrtifique la dirección. ");
//            System.out.println(e.getMessage());
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado");
            }
        }

        System.out.println("Lisa de : " + titulos);
        /*
        * Depués de la validación de los títulos guardados,
        * se procede a realizar un archivo que guardara la infromacón
        * en un archivo tipo gson o json
        * */
        FileWriter escritura = new FileWriter("titulos.json");
        //En el objeto se usa el objeto gson, para poder guardar la información
        // tipo gson de titulos
        escritura.write(gson.toJson(titulos));
        // después de realizar el proceso de escritura siempre
        // es necesario cerrar el proceso
        escritura.close();

        System.out.println("Finalizo la ejecución del programa: ");


    }
}

/*
 * Se maneja la clase FileWriter, para poder usar entradas y salidas
 * y con esto se quiere generar un archivo el cual guarde la información
 * que se esta obteniendo de las api
 * Al abrir la conexión, al  finalizar por temas de memoria
 * y otros requisitos se debe cerrar la conexión
 * */
//FileWriter escritura = new FileWriter("peliculas.txt");
//escritura.write(miTitulo.toString());
//        escritura.close();
