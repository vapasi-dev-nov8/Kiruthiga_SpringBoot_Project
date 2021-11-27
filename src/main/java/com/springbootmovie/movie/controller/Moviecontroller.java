package com.springbootmovie.movie.controller;

import com.springbootmovie.movie.dto.MovieDto;
//import com.springbootmovie.movie.dto.Moviedto;
import com.springbootmovie.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/api/v1/movies")
    public class Moviecontroller {

        MovieService movieService;

        @Autowired
        public Moviecontroller(MovieService movieService) {
            this.movieService = movieService;
        }


        @GetMapping("/")
        public ResponseEntity<List<MovieDto>> getAllMovies() {
            //return new ResponseEntity<List<MovieDto>>(movieService.getAllMovies(), HttpStatus.OK);
            List<MovieDto> allMovies = movieService.getAllMovies();
            return ResponseEntity.ok().body(allMovies);
        }
        @PostMapping("/")
        public ResponseEntity <MovieDto> saveMovies(@RequestBody MovieDto moviedto){
            MovieDto movieID= (MovieDto)movieService.saveMovie(moviedto);
            return new ResponseEntity <MovieDto>(movieID, HttpStatus.CREATED);
        }
    @GetMapping("/{id}")

    public ResponseEntity<MovieDto> getMovieForId(@PathVariable Integer id) {
        Optional<MovieDto> movie = movieService.getMovie(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        }
        return ResponseEntity.notFound().build();
    }
    }


