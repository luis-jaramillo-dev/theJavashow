package com.luisjaramillo.playamovie.web.controller;

import com.luisjaramillo.playamovie.domain.dto.MovieDto;
import com.luisjaramillo.playamovie.domain.dto.SuggestRequestDto;
import com.luisjaramillo.playamovie.domain.dto.UpdateMovieDto;
import com.luisjaramillo.playamovie.domain.service.MovieAIService;
import com.luisjaramillo.playamovie.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Movies crud operations")
public class MovieController {

    private final MovieService movieService;
    private final MovieAIService movieAIService;


    public MovieController(MovieService movieService, MovieAIService movieAIService) {
        this.movieAIService = movieAIService;
        this.movieService = movieService;
    }

    @GetMapping()

    public List<MovieDto> getAllMovies() {
        return (List<MovieDto>) this.movieService.getAll();
    }

    @PostMapping("/suggestions")
    public ResponseEntity<String> getMoviesSuggestions(
            @RequestBody SuggestRequestDto prompt
    ) {
        return ResponseEntity.ok(this.movieAIService.generateMovieRecommendation(prompt.userPreference()));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find a movie by ID",
            description = "Return all information about the movie.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Movie found"),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getMovieById(@Parameter(description = "Movie ID to search", example = "9") @PathVariable Long id) {
        MovieDto movieDto = this.movieService.getMovieById(id);
        if (movieDto != null) {
            return ResponseEntity.ok(movieDto);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto movieDto) {
        if (movieDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.saveMovie(movieDto));
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto movieDto) {
        if (movieDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.updateMovie(id, movieDto));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        this.movieService.getMovieById(id);
        return ResponseEntity.noContent().build();
    }
}
