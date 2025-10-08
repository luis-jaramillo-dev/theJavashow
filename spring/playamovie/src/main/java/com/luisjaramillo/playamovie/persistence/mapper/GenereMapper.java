package com.luisjaramillo.playamovie.persistence.mapper;

import com.luisjaramillo.playamovie.domain.dto.Genere;
import org.mapstruct.Named;

public class GenereMapper {
    @Named("stringToGenere")
    public static Genere stringToGenere(String genere) {
        if (genere == null) return null;

        return  switch (genere.toUpperCase()){
            case "ACCION" -> Genere.ACTION;
            case "COMEDY" -> Genere.COMEDY;
            case "DRAMA" -> Genere.DRAMA;
            case "TERROR" -> Genere.HORROR;
            case "ROMANCE" -> Genere.ROMANCE;
            case "CIENCIA_FICCION" -> Genere.SCI_FI;
            case "FANTASY" -> Genere.FANTASY;
            case "THRILLER" -> Genere.THRILLER;
            case "MYSTERY" -> Genere.MYSTERY;
            case "ANIMADA" -> Genere.ANIMATION;
            case "DOCUMENTARY" -> Genere.DOCUMENTARY;
            default -> null;
        };
    }
    @Named("genereToString")
    public static String genereToString(Genere genere) {
        if (genere == null) return null;

        return  switch (genere){
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDY";
            case DRAMA -> "DRAMA";
            case HORROR -> "TERROR";
            case ROMANCE -> "ROMANCE";
            case SCI_FI -> "CIENCIA_FICCION";
            case FANTASY -> "FANTASY";
            case THRILLER -> "THRILLER";
            case MYSTERY -> "MYSTERY";
            case ANIMATION -> "ANIMADA";
            case DOCUMENTARY -> "DOCUMENTARY";
            default -> null;
        };
    }
}
