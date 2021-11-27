package com.springbootmovie.movie.service;

import com.springbootmovie.movie.dto.MovieDto;

import com.springbootmovie.movie.entities.MovieEntity;
import com.springbootmovie.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

}
