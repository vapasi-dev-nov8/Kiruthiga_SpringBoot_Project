package com.springbootmovie.movie.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.springbootmovie.movie.entities.MovieEntity;
import com.sun.org.apache.bcel.internal.generic.INEG;

public class MovieDto {

    private Integer movieId;
    private String movieName;
    private String actorName;
    private String directorName;

    @JsonCreator
    public MovieDto(String movieName,String actorName,String directorName){
        this(null,movieName,actorName,directorName);
    }

    public MovieDto(){}

    public MovieDto(Integer movieId, String movieName, String actorName, String directorName) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.actorName = actorName;
        this.directorName = directorName;
    }
    public static MovieDto dtoFrom(MovieEntity movieEntity){
        return new MovieDto(
                movieEntity.getId(),
                movieEntity.getMovieName(),
                movieEntity.getActorName(),
                movieEntity.getDirectorName());
    }


    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", actorName='" + actorName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }

}
