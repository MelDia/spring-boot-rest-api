package com.MelDia.BatmanAPI.response.model;

import com.MelDia.BatmanAPI.exceptions.APIException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class BatmanBadResponse {

    public static String ExceptionResponse(JSONObject jsonObj, HttpStatus httpSt, APIException apiExc) {
        jsonObj.put("Status", httpSt.value());
        jsonObj.put("Error Code", apiExc.getErrorCode());
        jsonObj.put("Error Message", apiExc.getErrorMessage());
        return jsonObj.toString();
    }

}
