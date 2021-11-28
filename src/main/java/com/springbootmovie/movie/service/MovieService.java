package com.springbootmovie.movie.service;

import com.springbootmovie.movie.dto.MovieDto;

import com.springbootmovie.movie.entities.MovieEntity;
import com.springbootmovie.movie.repository.MovieRepository;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movieDtoList = new ArrayList<>();

        for (MovieEntity movieEntity : movieRepository.findAll()) {
            movieDtoList.add(MovieDto.dtoFrom(movieEntity));
        }
        return movieDtoList;
    }

    public MovieDto saveMovie(MovieDto movieDto) {
        MovieEntity movieEntity = MovieEntity.entityFrom(movieDto);
        MovieEntity savedMovieEntity = movieRepository.save(movieEntity);
        return MovieDto.dtoFrom(savedMovieEntity);
    }

    public Optional<MovieDto> getMovie(Integer id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        return movieEntity.map(MovieDto::dtoFrom);
    }
    public Optional<MovieDto> getByActorName(String actorName) {
        Optional<MovieEntity> movieEntity = movieRepository.findByActorName(actorName);
        return movieEntity.map(MovieDto::dtoFrom);
    }

    public List<MovieDto> getMovieByActorsName(List<String> actorsName) {
        List<MovieDto> moviesOfActors = new ArrayList<>();
        Iterable<MovieEntity> movieEntities = movieRepository.findAllByActorNameIn(actorsName);
        for(MovieEntity movieEntity : movieEntities)
            moviesOfActors.add(MovieDto.dtoFrom(movieEntity));
        return moviesOfActors;
    }

    public MovieDto updateMovieDataByID(Integer id,MovieDto movie) {
        MovieEntity movieInUpdateRequest = MovieEntity.entityFrom(movie);
        Optional<MovieEntity> updateMovieEntity = movieRepository.findById(id);
        if(updateMovieEntity.isPresent()){
            MovieEntity movieEntity = updateMovieEntity.get();
            movieEntity.setMovieName(movieInUpdateRequest.getMovieName());
            movieEntity.setActorName(movieInUpdateRequest.getActorName());
            movieEntity.setDirectorName(movieInUpdateRequest.getDirectorName());
            movieRepository.save(movieEntity);
            MovieDto updatedMovieID = MovieDto.dtoFrom(movieEntity);
            return updatedMovieID;
        }
        return null;

    }

}
