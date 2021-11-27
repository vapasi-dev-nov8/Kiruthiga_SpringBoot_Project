package com.springbootmovie.movie.controller;

import com.springbootmovie.movie.dto.Movies;
import com.springbootmovie.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/v1/movies")
    public class Moviecontroller {

        MovieService movieService;

        @Autowired
        public Moviecontroller(MovieService movieService) {
            this.movieService = movieService;
        }


        @GetMapping("/")
        public ResponseEntity<List<Movies>> getAllMovies() {
            //return new ResponseEntity<List<Movies>>(movieService.getAllMovies(), HttpStatus.OK);
            List<Movies> allMovies = movieService.getAllMovies();
            return ResponseEntity.ok().body(allMovies);
        }
        @PostMapping("/")
        public ResponseEntity <Movies> saveMovies(@RequestBody Movies movies){
            Movies movieID= (Movies)movieService.saveMovie(movies);
            return new ResponseEntity <Movies>(movieID, HttpStatus.CREATED);

        }
    }


