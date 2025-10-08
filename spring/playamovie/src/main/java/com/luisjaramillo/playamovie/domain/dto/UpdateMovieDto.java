package com.luisjaramillo.playamovie.domain.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(

        @NotNull
        @NotBlank(message = "Title is required")
        String title,
        @PastOrPresent(message = "Release date must be in the past or present")
        LocalDate releaseDate,
        @Min(value = 0, message = "Classification must be at least 0")
        @Max(value = 5 , message = "Classification must be at most 5")
        BigDecimal classification
) {
}
