package com.moviemove.screenmatch;

import com.moviemove.screenmatch.model.DatosEpisodio;
import com.moviemove.screenmatch.model.DatosSerie;
import com.moviemove.screenmatch.model.DatosTemporadas;
import com.moviemove.screenmatch.principal.EjemploStream;
import com.moviemove.screenmatch.principal.Principal;
import com.moviemove.screenmatch.repository.SerieRepository;
import com.moviemove.screenmatch.service.ConsumoAPI;
import com.moviemove.screenmatch.service.ConvierteDatos;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ScreenmatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);

	}




}
