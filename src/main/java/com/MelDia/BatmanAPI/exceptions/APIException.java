package com.MelDia.BatmanAPI.exceptions;

public class APIException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;

    public APIException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "APIException{" 
                + "ErrorCode: " + errorCode 
                + ", ErrorMessage: " + errorMessage + '}';
    }

    
    
}
