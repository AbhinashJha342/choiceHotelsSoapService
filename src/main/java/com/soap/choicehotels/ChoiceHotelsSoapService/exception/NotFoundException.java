package com.soap.choicehotels.ChoiceHotelsSoapService.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends Exception {

    private String errorDetails;

    private int status;

    public NotFoundException(String message, String errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
        this.status = HttpStatus.NOT_FOUND.value();
    }

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
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
