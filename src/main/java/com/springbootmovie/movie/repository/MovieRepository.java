package com.springbootmovie.movie.repository;

import com.springbootmovie.movie.dto.MovieDto;
import com.springbootmovie.movie.entities.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {

//Optional<MovieEntity> findByActorName(String actorName);

    Optional<MovieEntity> findByActorName(String actorName);

    Iterable<MovieEntity> findAllByActorNameIn(List<String> actorsName);
}
