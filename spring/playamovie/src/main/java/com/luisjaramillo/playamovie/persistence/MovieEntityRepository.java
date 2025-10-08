package com.luisjaramillo.playamovie.persistence;

import com.luisjaramillo.playamovie.domain.exception.MovieAlreadyExist;
import com.luisjaramillo.playamovie.domain.dto.MovieDto;
import com.luisjaramillo.playamovie.domain.dto.UpdateMovieDto;
import com.luisjaramillo.playamovie.domain.repository.MovieRepository;
import com.luisjaramillo.playamovie.persistence.crud.CrudMovie;
import com.luisjaramillo.playamovie.persistence.entity.MovieEntity;
import com.luisjaramillo.playamovie.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovie crudMovie;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovie crudMovie, MovieMapper movieMapper) {
        this.crudMovie = crudMovie;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieMapper.toMovieDto(this.crudMovie.findAll());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        return movieMapper.toMovieDto(this.crudMovie.findById(id).orElse(null));
    }

    @Override
    public MovieDto saveMovie(MovieDto movieDto) {
        if(this.crudMovie.findFirstByTitle(movieDto.title()) != null) {
            throw new MovieAlreadyExist(movieDto.title());
        }

        return movieMapper.toMovieDto(
                this.crudMovie.save(movieMapper.toMovieEntity(movieDto))
        );
    }

    @Override
    public MovieDto updateMovie(Long id, UpdateMovieDto movieDto) {
        MovieEntity movieEntity = this.crudMovie.findById(id).orElse(null);
        if (movieEntity == null) return null;
        this.movieMapper.updateMovieFromDto(movieDto, movieEntity);
        return movieMapper.toMovieDto(this.crudMovie.save(movieEntity));
    }

    @Override
    public void deleteMovie(Long id) {
        this.crudMovie.deleteById(id);
    }
}
