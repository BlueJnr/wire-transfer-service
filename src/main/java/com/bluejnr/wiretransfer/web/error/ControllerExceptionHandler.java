package com.bluejnr.wiretransfer.web.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.bluejnr.wiretransfer.exception.ErrorMessage;
import com.bluejnr.wiretransfer.exception.FinalStateException;
import com.bluejnr.wiretransfer.exception.StateNotMatchException;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(FinalStateException.class)
  @ResponseStatus(value = HttpStatus.FORBIDDEN)
  public ErrorMessage finalStateException(FinalStateException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.FORBIDDEN.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return message;
  }
  
  @ExceptionHandler(StateNotMatchException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage stateNotMatchException(StateNotMatchException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.BAD_REQUEST.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return message;
  }
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));
    
    return message;
  }
}
