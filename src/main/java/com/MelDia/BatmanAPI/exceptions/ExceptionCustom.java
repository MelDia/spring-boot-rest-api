package com.MelDia.BatmanAPI.exceptions;

import org.apache.logging.log4j.LogManager;

public class ExceptionCustom {
    
    private String errorCode;
    private String errorMessage;
    private APIException exception;
    
    public APIException movieNotFoundException() {
        errorMessage = "The movie does not exist in the database";
        errorCode = "NT-1997";
        exception = new APIException(errorMessage, errorCode);
        LogManager.getLogger().info(exception);
        return exception;
    }
    
    public APIException nullAttributteException() {
        errorMessage = "Some attributes  are null";
        errorCode = "NA-1998";
        exception = new APIException(errorMessage, errorCode);
        LogManager.getLogger().info(exception);
        return exception;
    }
    
    public APIException dataBaseIsEmptyException(){
        errorMessage = "The information couldn't process";
        errorCode = "DBE-1999";
        exception = new APIException(errorMessage, errorCode);
        LogManager.getLogger().info(exception);
        return exception;
    }
    
}
