package com.luisjaramillo.playamovie.domain.repository;

import com.luisjaramillo.playamovie.domain.dto.MovieDto;
import com.luisjaramillo.playamovie.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAllMovies();
    MovieDto getMovieById(Long id);
    MovieDto saveMovie(MovieDto movieDto);
    MovieDto updateMovie(Long id , UpdateMovieDto movieDto);
    void deleteMovie(Long id);
}
