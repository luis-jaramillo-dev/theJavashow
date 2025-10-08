package com.luisjaramillo.playamovie.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MovieAIService {
    @UserMessage(value = "\"Genera un saludos de bienvenida al portafolio {{appName}}\"")
    String generateGreeting(@V("appName") String appName);

    @SystemMessage("\"Eres un asistente que recomienda peliculas basandote en las preferencias del usuario, maximo tres peliculas," +
            "busca las peliculas disponibles en la plataforma\"")
   String generateMovieRecommendation(@UserMessage("userPreferences") String userPreferences);
}
