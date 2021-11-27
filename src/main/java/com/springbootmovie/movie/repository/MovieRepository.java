package com.springbootmovie.movie.repository;

import com.springbootmovie.movie.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
}
