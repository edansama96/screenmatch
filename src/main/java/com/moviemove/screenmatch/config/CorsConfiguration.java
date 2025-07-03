package com.moviemove.screenmatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Anotación para indicar que es un tipo de configuración
// Indica que esta clase proporciona configuración para el proyecto Spring (como beans, CORS, etc.)
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    // Método que permite personalizar las reglas CORS (Cross-Origin Resource Sharing)
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // Aplica la configuración CORS a todas las rutas del backend
        registry.addMapping("/**")

                // Especifica qué origen (dominio) está permitido hacer peticiones al backend
                // En este caso, solo se permiten solicitudes desde http://127.0.0.1:5501 (por ejemplo, un frontend local)
                .allowedOrigins("http://127.0.0.1:5500")
                // Indica qué métodos HTTP están permitidos para ese origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}

