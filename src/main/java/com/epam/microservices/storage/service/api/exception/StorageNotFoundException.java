package com.epam.microservices.storage.service.api.exception;

public class StorageNotFoundException extends RuntimeException{

  public StorageNotFoundException(String message) {
    super(message);
  }
}
