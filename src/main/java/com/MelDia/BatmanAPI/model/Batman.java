package com.MelDia.BatmanAPI.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "batman")
public class Batman implements Serializable {
    
    @Id
    @Column (name = "id_movie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id_movie;
    
    @Column (name = "movie_name", nullable = false)
    @JsonProperty("movie_name")
    private String Movie_name;
    
    @Column (name = "release_date", nullable = false)
    @JsonProperty("release_date")
    private String Release_date;
    
    @Column (name = "director", nullable = false)
    @JsonProperty("director")
    private String Director;
    
    @Column (name = "protagonist", nullable = false)
    @JsonProperty("protagonist")
    private String Protagonist;

    public Batman() {
    }

    public Batman(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public Batman(Integer id_movie, String Movie_name, String Release_date, String Director, String Protagonist) {
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

    @Override
    public String toString() {
        return "Batman{" 
                + "Id: " + id_movie 
                + ", Movie name: " + Movie_name 
                + ", Release date: " + Release_date 
                + ", Director: " + Director 
                + ", Protagonist: " + Protagonist + '}';
    }
    
    
    
}
