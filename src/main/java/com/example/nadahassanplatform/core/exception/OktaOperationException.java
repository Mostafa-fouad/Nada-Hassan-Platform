package com.example.nadahassanplatform.core.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OktaOperationException extends RuntimeException {

  public OktaOperationException(String message) {
    super(message);
  }
}
