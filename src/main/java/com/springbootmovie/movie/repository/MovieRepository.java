package com.springbootmovie.movie.repository;

import com.springbootmovie.movie.dto.Movies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {

    List<Movies> moviesAll = new ArrayList<Movies>(Arrays.asList(
            new Movies(1,"Gajini","Suriya","Murugadoss"),
            new Movies(2,"Jai Bheem","Suriya","Ganavel"),
            new Movies(3,"Arambam","Ajith","Vishnuvardhan"),
            new Movies(4,"Pithamagan","Vikram","Bala")));


    public List<Movies> getAllMovies()
    {
        return moviesAll;
    }

    public Movies saveMovie(Movies movies) {
        int newId= moviesAll.get(moviesAll.size()-1).getMovieId()+1;
        Movies addMovieID= new Movies(newId,movies.getMovieName(),movies.getActorName(),movies.getDirectorName());
        moviesAll.add(addMovieID);
        return addMovieID;

    }


}
