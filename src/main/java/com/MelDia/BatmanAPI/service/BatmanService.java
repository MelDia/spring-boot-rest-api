package com.MelDia.BatmanAPI.service;

import com.MelDia.BatmanAPI.dao.BatmanDAO;
import com.MelDia.BatmanAPI.model.Batman;
import com.MelDia.BatmanAPI.model.BatmanModification;
import com.MelDia.BatmanAPI.model.BatmanRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatmanService {

    @Autowired
    public BatmanDAO batmanDao;

    public List<Batman> listMovies() {
        return batmanDao.findAll();
    }

    public Optional<Batman> searchMovieById(BatmanRequest batReq) {
        return batmanDao.findById(batReq.getId_movie());
    }

    public Optional<Batman> searchMovieToModify(BatmanModification batMod) {
        return batmanDao.findById(batMod.getId_movie());
    }

    public void addNewMovie(Batman batman) {
        batmanDao.save(batman);
    }

    public void deleteMovie(Batman batman) {
        batmanDao.delete(batman);
    }

    public void updateMovie(Batman batman) {
        batmanDao.save(batman);
    }

}
