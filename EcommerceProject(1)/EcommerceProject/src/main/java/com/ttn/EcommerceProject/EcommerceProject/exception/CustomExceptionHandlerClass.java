package com.ttn.EcommerceProject.EcommerceProject.exception;//package com.Ttn.EcommerceProject.exception;

import com.ttn.EcommerceProject.EcommerceProject.Error.ErrorPage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandlerClass extends ResponseEntityExceptionHandler {

    @Override
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorPage error1 = new ErrorPage(LocalDateTime.now(),
                 ex.getBindingResult().getFieldErrors()
                .stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList()),
                request.getDescription(false));
        return new ResponseEntity<>(error1, HttpStatus.BAD_REQUEST);
    }
}
