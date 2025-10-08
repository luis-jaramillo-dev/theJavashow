package com.luisjaramillo.playamovie.web.controller;

import com.luisjaramillo.playamovie.domain.service.MovieAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String appName;
    private final MovieAIService movieAIService;


    public HelloController(@Value("${spring.application.name}") String appName, MovieAIService movieAIService) {
        this.appName = appName;
        this.movieAIService = movieAIService;
    }

    @GetMapping("/hello")
    public String hello() {
        return movieAIService.generateGreeting(appName);
    }
}
