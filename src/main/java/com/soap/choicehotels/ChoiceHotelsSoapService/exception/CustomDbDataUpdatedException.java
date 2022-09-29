package com.soap.choicehotels.ChoiceHotelsSoapService.exception;

import org.springframework.http.HttpStatus;

public class CustomDbDataUpdatedException extends Exception{

    private String errorDetails;

    private int status;

    public CustomDbDataUpdatedException(String message, String errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
        this.status = HttpStatus.BAD_REQUEST.value();
    }

    public CustomDbDataUpdatedException() {
    }

    public CustomDbDataUpdatedException(String message) {
        super(message);
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFaultInfo() {
        return this.errorDetails;
    }
}
