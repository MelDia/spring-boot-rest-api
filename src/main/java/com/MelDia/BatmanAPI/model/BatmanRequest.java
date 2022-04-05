package com.MelDia.BatmanAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//To find movies by id
public class BatmanRequest {
    
    @JsonProperty("id")
    private Integer id_movie;
    
    public BatmanRequest() {
    }

    public BatmanRequest(Integer id_movie) {
        this.id_movie = id_movie;
    }

    public Integer getId_movie() {
        return id_movie;
    }

    public void setId_movie(Integer id_movie) {
        this.id_movie = id_movie;
    }    
}
