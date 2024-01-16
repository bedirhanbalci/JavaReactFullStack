package com.tobeto.rent.a.car.demo.core.utilities.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice   // Class içerisinde global exception handler metotlar bulunduğunu söyler.
public class GlobalExceptionHandler {

    // TODO : Exception'ın içeriğini inceleyerek tüm validasyon hatalarını alan ve hata mesajı olarak yazdırma

    @ExceptionHandler(MethodArgumentNotValidException.class)          // metodun içerisinde verilen türün exception handler metodu olduğunu belirler.
    @ResponseStatus(HttpStatus.BAD_REQUEST)                           // return işlevinin cevabı hangi http statüsünde döndüreceğini belirler.
    public List<String> handleArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<String> methodArgumentException = new ArrayList<String>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            methodArgumentException.add(fieldError.getDefaultMessage());
        }

        return methodArgumentException;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException exception) {
        return exception.getMessage();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception) {
        return "Bilinmedik hata";
    }
}
