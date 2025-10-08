package com.luisjaramillo.playamovie.persistence.crud;

import com.luisjaramillo.playamovie.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovie extends CrudRepository<MovieEntity, Long> {

    MovieEntity findFirstByTitle(String title);
}
