package com.example.nadahassanplatform.core.controller.advice;

import com.example.nadahassanplatform.core.exception.IllegalAccessFieldException;
import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.core.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.data.mapping.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiErrorResponse handleException(MethodArgumentNotValidException ex) {
    String message =
        ex.getBindingResult().getFieldErrors().stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .collect(Collectors.joining(". "));
    return logAndRespond(message, ex);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({NoSuchElementException.class, NotFoundException.class})
  public ApiErrorResponse handleException(RuntimeException ex) {
    return logAndRespond(ex.getMessage() != null ? ex.getMessage() : "Resource not found", ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({HttpMessageNotReadableException.class})
  public ApiErrorResponse handleException(HttpMessageNotReadableException ex) {
    return logAndRespond(String.format("Malformed request %s", ex.getCause().getCause().getMessage()), ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MissingRequestHeaderException.class})
  public ApiErrorResponse handleException(MissingRequestHeaderException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public ApiErrorResponse handleException(MethodArgumentTypeMismatchException ex) {
    final String message = "Method argument type mismatch. " + ex.getMessage();
    return logAndRespond(message, ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public ApiErrorResponse handleException(IllegalArgumentException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
  public ApiErrorResponse handleException(HttpMediaTypeNotSupportedException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  public ApiErrorResponse handleException(HttpRequestMethodNotSupportedException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MissingServletRequestParameterException.class})
  public ApiErrorResponse handleException(MissingServletRequestParameterException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MappingException.class)
  public ApiErrorResponse handleMappingException(MappingException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationException.class)
  public ApiErrorResponse handleValidationException(ValidationException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public ApiErrorResponse handleHibernateConstraintViolationException(ConstraintViolationException ex) {
    String message = ex.getCause().getMessage();
    message =
        message.indexOf("Detail:") > 0 ? message.substring(message.indexOf("Detail:")) : message;
    return logAndRespond(message, ex);
  }
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(FileUploadException.class)
  public ApiErrorResponse handleException(FileUploadException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(NullPointerException.class)
  public ApiErrorResponse handleNullPointerException(NullPointerException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(IllegalAccessFieldException.class)
  public ApiErrorResponse handleIllegalAccessFieldException(IllegalAccessFieldException ex) {
    return logAndRespond(ex.getMessage(), ex);
  }

  private ApiErrorResponse logAndRespond(final String customMessage, final Exception ex) {
    log.error("Caught Error with message = {}", customMessage, ex);
    return new ApiErrorResponse(customMessage);
  }
}
