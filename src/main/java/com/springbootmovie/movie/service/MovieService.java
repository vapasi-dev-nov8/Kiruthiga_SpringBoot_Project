package com.springbootmovie.movie.service;

import com.springbootmovie.movie.dto.Movies;
import com.springbootmovie.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movies> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public Movies saveMovie(Movies movies) {
        return movieRepository.saveMovie(movies);
    }

}
