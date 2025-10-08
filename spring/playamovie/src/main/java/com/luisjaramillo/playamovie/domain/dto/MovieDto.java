package com.luisjaramillo.playamovie.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        Integer id,
        String title,
        Genere genre,
        LocalDate releaseDate,
        Integer duration,
        Boolean isAvailable,
        BigDecimal classification
) {
}
