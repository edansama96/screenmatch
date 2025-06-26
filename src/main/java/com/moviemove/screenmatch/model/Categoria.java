package com.moviemove.screenmatch.model;

public enum Categoria {
    /*
    * Clase enumun para manejar constantes
    * establecidas como en el caso de las categorías
    * */
    /*
    * Hasta este punto no se reconoce el elemento
    * debido a que screenmatch no está reconociendo los elementos
    * */
    ACCION("Action","Acción" ),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comedia"),
    DRAMA("Drama", "Drama"),
    CRIMEN("Crime", "Crimen");
    /*
    * Se procede a crear un atributo de tipo privado este sera
    * String y se usara para el reconocimiento de las categorias con
    * OMDB
    * */
    private String categoriaOmdb;
    /*
    * Se procede a crear un nuevo tipo de categoria en español para
    * manejar dichos elementos para el caso de busqueda cuando el usaurio ingresa la información
    * */
    private  String categoriaOmdbEspanol;


    // Se crear un costructor de la clase Categoria para indicar como
    // se deben iniciar dichas constantes
    Categoria(String categoriaOmdb, String categoriaOmdbEspanol) {
        this.categoriaOmdb = categoriaOmdb;
        //Se declara la inicialización del nuevo parametro para busqueda
        this.categoriaOmdbEspanol = categoriaOmdbEspanol;
    }
    /*
    * En el siguiente video, necesitaremos crear un Enum y
    * utilizar un método específico para realizar
    *  la conversión entre la información de OMDB y
    * la de nuestra aplicación. Puedes copiar el código
    * a continuación para poder continuar:
    *
    * */
    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    /*
    * Se adaptara el método de arriba para poder usarlo
    * con respecto a la busqueda que quiera realizar el usuario
    *
    * */
    public static Categoria fromEspanol(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdbEspanol.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

}

