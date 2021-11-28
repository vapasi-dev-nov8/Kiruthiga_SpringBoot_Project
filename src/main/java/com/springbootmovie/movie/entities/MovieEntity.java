package com.springbootmovie.movie.entities;

import com.springbootmovie.movie.dto.MovieDto;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String movieName;
    private String actorName;
    private String directorName;

    public MovieEntity() {
    }

    public MovieEntity(Integer id, String movieName, String actorName, String directorName) {
        Id = id;
        this.movieName = movieName;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    public static MovieEntity entityFrom(MovieDto movieDto){
        return new MovieEntity(null,movieDto.getMovieName(),movieDto.getActorName(),movieDto.getDirectorName());
    }

    public MovieDto movieDto() {
        return new MovieDto(this.Id, this.movieName, this.actorName, this.directorName);
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Integer getId() {
        return Id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Id.equals(that.Id) && movieName.equals(that.movieName) && actorName.equals(that.actorName) && directorName.equals(that.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, movieName, actorName, directorName);
    }
}
