package com.soap.choicehotels.ChoiceHotelsSoapService.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorData error = new ErrorData(HttpStatus.BAD_REQUEST);
        error.setMessage(Collections.singletonMap("errors", ex.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.toList())).toString());
        return new ResponseEntity<>(error, error.getStatus());
    }
}
