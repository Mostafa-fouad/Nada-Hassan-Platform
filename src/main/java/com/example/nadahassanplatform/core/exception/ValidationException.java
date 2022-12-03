package com.example.nadahassanplatform.core.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

  public ValidationException(String message) {
    super(message);
  }

  public ValidationException(String message, Throwable cause) {
    super(message, cause);
  }
}
