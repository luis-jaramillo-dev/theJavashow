package com.luisjaramillo.playamovie.domain.service;

import com.luisjaramillo.playamovie.domain.dto.MovieDto;
import com.luisjaramillo.playamovie.domain.dto.UpdateMovieDto;
import com.luisjaramillo.playamovie.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Tool("peliculas disponibles en la plataforma")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAllMovies();
    }
    public MovieDto getMovieById(Long id) {
        return this.movieRepository.getMovieById(id);
    }

    public MovieDto saveMovie(MovieDto movieDto) {
        return this.movieRepository.saveMovie(movieDto);
    }

    public MovieDto updateMovie(Long id, UpdateMovieDto movieDto) {
        return this.movieRepository.updateMovie(id,movieDto);
    }

    public void deleteMovie(Long id) {
        this.movieRepository.deleteMovie(id);
    }


}
