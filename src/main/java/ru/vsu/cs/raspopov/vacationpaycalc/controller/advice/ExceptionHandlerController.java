package ru.vsu.cs.raspopov.vacationpaycalc.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = BAD_REQUEST)
    public String handleValidationException(ValidationException e) {
        log.error("EXCEPTION OCCURRED", e);
        return e.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("EXCEPTION OCCURRED", e);
        return e.getMessage();
    }
}
