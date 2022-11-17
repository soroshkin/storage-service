package com.epam.microservices.storage.service.storage.infrastructure.rest;

import com.epam.microservices.storage.service.api.exception.StorageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
class StorageExceptionHandler {

  @ExceptionHandler(StorageNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleSongNotFoundException(StorageNotFoundException exception) {
    return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {
    return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
  }
}
