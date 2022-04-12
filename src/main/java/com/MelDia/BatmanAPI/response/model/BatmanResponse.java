package com.MelDia.BatmanAPI.response.model;

import com.MelDia.BatmanAPI.exceptions.ExceptionCustom;
import com.MelDia.BatmanAPI.model.BatmanRequest;
import com.MelDia.BatmanAPI.model.Batman;
import com.MelDia.BatmanAPI.model.BatmanModification;
import com.MelDia.BatmanAPI.service.BatmanService;
import com.MelDia.BatmanAPI.util.ModificationOfValues;
import com.MelDia.BatmanAPI.util.ToJSON;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class BatmanResponse {

    //FIND ALL MOVIES
    public static String respondeFindAll(BatmanService batmanServ) throws JsonProcessingException {
        List<Batman> listMovies = batmanServ.listMovies();
        JSONObject jsonObj = new JSONObject();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (listMovies.isEmpty()) {
            return BatmanBadResponse.ExceptionResponse(jsonObj, HttpStatus.NOT_FOUND, new ExceptionCustom().dataBaseIsEmptyException());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        jsonObj.put("movies", listMovies);
        jsonObj.put("status", HttpStatus.OK.value());
        jsonObj.put("message", "The Batman filmography list was successfully found!");
        LogManager.getLogger().info("Response = list all movies -> " + jsonObj);
                
        return jsonObj.toString();
    }
    
    //FIND MOVIE BY ID
    public static String responseFindById(Optional<Batman> batman) throws JsonProcessingException {
        JSONObject jsonObj = new JSONObject();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (!(batman.isPresent())) {
            return BatmanBadResponse.ExceptionResponse(jsonObj, HttpStatus.NOT_FOUND, new ExceptionCustom().movieNotFoundException());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        jsonObj.put("movie", ToJSON.toJsonBatman(batman));
        jsonObj.put("status", HttpStatus.OK.value());
        jsonObj.put("message", "The Batman movie was successfully found!");
        LogManager.getLogger().info("Response = find by id -> " + jsonObj);
        return jsonObj.toString();
    }
    
    //ADD A NEW MOVIE
    public static String responseAddNewMovie(Batman batman, BatmanService batmanServ) throws JsonProcessingException {
        JSONObject jsonObj = new JSONObject();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (batman.getMovie_name() == null 
                || batman.getRelease_date() == null 
                || batman.getDirector() == null
                || batman.getProtagonist() == null) {
            return BatmanBadResponse.ExceptionResponse(jsonObj, HttpStatus.BAD_REQUEST, new ExceptionCustom().nullAttributteException());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        batmanServ.addNewMovie(batman);
        jsonObj.put("movie", ToJSON.toJsonObject(batman));
        jsonObj.put("status", HttpStatus.OK.value());
        jsonObj.put("message", "A new Batman movie has been added to the database");
        LogManager.getLogger().info("Response = added a new movie -> " + jsonObj);
        return jsonObj.toString();
    }
    
    //DELETE A MOVIE
    public static String responseDeleteMovie(Integer id, BatmanService batmanServ) {
        BatmanRequest batReq = new BatmanRequest();
        batReq.setId_movie(id);
        Optional<Batman> deleteMovie = batmanServ.searchMovieById(id);
        JSONObject jsonObj = new JSONObject();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (!(deleteMovie.isPresent())) {
            return BatmanBadResponse.ExceptionResponse(jsonObj, HttpStatus.NOT_FOUND, new ExceptionCustom().dataBaseIsEmptyException());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        batmanServ.deleteMovie(deleteMovie.get());
        jsonObj.put("movie", ToJSON.toJsonBatman(deleteMovie));
        jsonObj.put("status", HttpStatus.OK.value());
        jsonObj.put("message", "A Batman movie was deleted from database");
        LogManager.getLogger().info("Response = deleted a movie -> " + jsonObj);
        return jsonObj.toString();
    }
    
    //UPDATE A MOVIE
    public static String responseUpdateMovie(Optional<Batman> batman, BatmanModification batMod, BatmanService batmanServ){
        JSONObject jsonObj = new JSONObject();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (!(batman.isPresent())) {
            return BatmanBadResponse.ExceptionResponse(jsonObj, HttpStatus.NOT_FOUND, new ExceptionCustom().movieNotFoundException());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        Batman updateMovie = batman.get();
        ModificationOfValues.setValuesMovie(updateMovie, batMod);
        batmanServ.updateMovie(updateMovie);
        jsonObj.put("movie", ToJSON.toJsonObject(updateMovie));
        jsonObj.put("status", HttpStatus.OK.value());
        jsonObj.put("message", "A Batman movie was updated");
        LogManager.getLogger().info("Response = updated a movie -> " + jsonObj);
        return jsonObj.toString();
    }
}
