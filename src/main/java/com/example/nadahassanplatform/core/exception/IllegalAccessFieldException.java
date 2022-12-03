package com.example.nadahassanplatform.core.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IllegalAccessFieldException extends RuntimeException {

  public IllegalAccessFieldException(String message, Throwable t) {
    super(message, t);
  }
}
