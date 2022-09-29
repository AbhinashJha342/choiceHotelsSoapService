package com.soap.choicehotels.ChoiceHotelsSoapService.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
