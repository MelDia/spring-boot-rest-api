package com.MelDia.BatmanAPI.control;

import com.MelDia.BatmanAPI.model.Batman;
import com.MelDia.BatmanAPI.model.BatmanModification;
import com.MelDia.BatmanAPI.model.BatmanRequest;
import com.MelDia.BatmanAPI.response.model.BatmanResponse;
import com.MelDia.BatmanAPI.service.BatmanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batman")
public class BatmanControl {

    @Autowired
    private BatmanService batmanServ;

    //Find all movies
    @RequestMapping(value = "/list/allMovies", produces = "application/json", method = RequestMethod.GET)
    public String allMovies() throws JsonProcessingException {
        return BatmanResponse.respondeFindAll(batmanServ);
    }
    
    //Find movie by id
    @RequestMapping(value = "/search/{id_movie}", produces = "application/json", method = RequestMethod.GET)
    public String findMovieById(@PathVariable ("id_movie") Integer batReq) throws JsonProcessingException{
        Optional<Batman> batman = batmanServ.searchMovieById(batReq);
        return BatmanResponse.responseFindById(batman);	
    }
    
    //Add a new movie 
    @RequestMapping(value = "/add/newMovie", produces = "application/json", method = RequestMethod.POST)
    public String addNewMovie(@RequestBody Batman batman) throws JsonProcessingException{
        return BatmanResponse.responseAddNewMovie(batman, batmanServ);
    }
    
    //Delete a movie
    @RequestMapping(value = "/delete/movie", produces = "application/json", method = RequestMethod.DELETE)
    public String deleteMovie(@RequestBody BatmanRequest batReq) throws JsonProcessingException{
        return BatmanResponse.responseDeleteMovie(batReq.getId_movie(), batmanServ);
        
    }
    
    //Update a movie
    @RequestMapping(value = "/update/movie", produces = "application/json", method = RequestMethod.PUT)
    public String updateMovie(@RequestBody BatmanModification batMod) throws JsonProcessingException{
        Optional<Batman> batman = batmanServ.searchMovieToModify(batMod);
        return BatmanResponse.responseUpdateMovie(batman, batMod, batmanServ);
    }

}
