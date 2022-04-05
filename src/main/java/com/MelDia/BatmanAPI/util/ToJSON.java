package com.MelDia.BatmanAPI.util;

import com.MelDia.BatmanAPI.model.Batman;
import java.util.Optional;
import org.json.JSONObject;

public class ToJSON {

    public static JSONObject toJsonBatman(Optional<Batman> batman) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", batman.get().getId_movie());
        jsonObj.put("movie_name", batman.get().getMovie_name());
        jsonObj.put("release_date", batman.get().getRelease_date());
        jsonObj.put("director", batman.get().getDirector());
        jsonObj.put("protagonist", batman.get().getProtagonist());
        return jsonObj;
    }

    public static JSONObject toJsonObject(Batman batman) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", batman.getId_movie());
        jsonObj.put("movie_name", batman.getMovie_name());
        jsonObj.put("release_date", batman.getRelease_date());
        jsonObj.put("director", batman.getDirector());
        jsonObj.put("protagonist", batman.getProtagonist());
        return jsonObj;
    }
}
