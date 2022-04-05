package com.MelDia.BatmanAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

//To update a movie
public class BatmanModification implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Integer id_movie;

    @JsonProperty("movie_name")
    private String Movie_name;

    @JsonProperty("release_date")
    private String Release_date;

    @JsonProperty("director")
    private String Director;
    
    @JsonProperty("protagonist")
    private String Protagonist;

    public BatmanModification() {
    }

    public BatmanModification(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public BatmanModification(Integer id_movie, String Movie_name, String Release_date, String Director, String Protagonist) {
        this.id_movie = id_movie;
        this.Movie_name = Movie_name;
        this.Release_date = Release_date;
        this.Director = Director;
        this.Protagonist = Protagonist;
    }

    public Integer getId_movie() {
        return id_movie;
    }

    public void setId_movie(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public String getMovie_name() {
        return Movie_name;
    }

    public void setMovie_name(String Movie_name) {
        this.Movie_name = Movie_name;
    }

    public String getRelease_date() {
        return Release_date;
    }

    public void setRelease_date(String Release_date) {
        this.Release_date = Release_date;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }
    
    public String getProtagonist() {
        return Protagonist;
    }

    public void setProtagonist(String Protagonist) {
        this.Protagonist = Protagonist;
    }
    
    
}
