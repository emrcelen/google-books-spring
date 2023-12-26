package com.googleapi.test.exception.handler;

import com.googleapi.test.exception.BookNotFoundException;
import com.googleapi.test.exception.GeneralException;
import com.googleapi.test.exception.response.BookExceptionResponse;
import com.googleapi.test.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(BookNotFoundException.class)
    public final ResponseEntity<?> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
        BookExceptionResponse bookExceptionResponse = new BookExceptionResponse(
                bookNotFoundException.getMessage(),
                formatter.format(LocalDateTime.now()),
                bookNotFoundException.getPage(),
                bookNotFoundException.getSize());
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(bookExceptionResponse);
    }
    @ExceptionHandler(GeneralException.class)
    public final ResponseEntity<?> handleClientResponseException(GeneralException clientResponseException){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                clientResponseException.getMessage(),
                formatter.format(LocalDateTime.now()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
