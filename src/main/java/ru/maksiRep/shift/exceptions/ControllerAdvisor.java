package ru.maksiRep.shift.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(EmptyIntervalException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionResponse emptyIntervalException(EmptyIntervalException emptyIntervalException) {
        return new ExceptionResponse(emptyIntervalException.getMessage());
    }

    @ExceptionHandler(IncorrectIntervalValue.class)
    @ResponseStatus(BAD_REQUEST)
    public ExceptionResponse incorrectIntervalValue(IncorrectIntervalValue incorrectIntervalValue) {
        return new ExceptionResponse(incorrectIntervalValue.getMessage());
    }
}