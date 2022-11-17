package com.epam.microservices.storage.service.storage.infrastructure.rest;

import com.fasterxml.jackson.annotation.JsonCreator;

class ErrorResponse {

  private final String message;

  @JsonCreator
  ErrorResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "ErrorResponse{" +
      "message='" + message + '\'' +
      '}';
  }
}
