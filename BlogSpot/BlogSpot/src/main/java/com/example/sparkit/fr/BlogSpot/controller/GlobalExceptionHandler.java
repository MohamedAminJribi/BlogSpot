package com.example.sparkit.fr.BlogSpot.controller;

import com.example.sparkit.fr.BlogSpot.Exeption.ErrorResponse;
import com.example.sparkit.fr.BlogSpot.Exeption.HttpCustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({HttpCustomException.class})
    public ErrorResponse handleNotFoundException(HttpCustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(ex.getErrorCode());
        errorResponse.setMessage(ex.getErrorMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return errorResponse;
    }
}
