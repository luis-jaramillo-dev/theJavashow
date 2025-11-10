package com.luisjaramillo.playamovie.domain.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        Integer id,
        @NotBlank
        String title,
        Genere genre,
        @PastOrPresent(message = "Release date must be in the past or present")
        LocalDate releaseDate,
        @Positive
        Integer duration,
        Boolean isAvailable,
        @Min(value = 0, message = "El valor minimo de calificacion debe ser cero")
        @Max(value = 5, message = "El valor maximo de la calificacion debe ser cinco")
        float classification
) {
}
