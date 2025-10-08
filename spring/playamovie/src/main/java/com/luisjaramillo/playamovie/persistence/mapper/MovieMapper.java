package com.luisjaramillo.playamovie.persistence.mapper;

import com.luisjaramillo.playamovie.domain.dto.MovieDto;
import com.luisjaramillo.playamovie.domain.dto.UpdateMovieDto;
import com.luisjaramillo.playamovie.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {GenereMapper.class}
)
public interface MovieMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "genre", target = "genre", qualifiedByName = "stringToGenere")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "isAvailable", target = "isAvailable")
    @Mapping(source = "classification", target = "classification")
    MovieDto toMovieDto(MovieEntity movieEntity);

    List<MovieDto> toMovieDto(Iterable<MovieEntity> movieEntity);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genre", qualifiedByName = "genereToString")
    MovieEntity toMovieEntity(MovieDto movieDto);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "classification", target = "classification")
    void updateMovieFromDto(
            UpdateMovieDto movieDto,
            @MappingTarget MovieEntity movieEntity
    );


}
