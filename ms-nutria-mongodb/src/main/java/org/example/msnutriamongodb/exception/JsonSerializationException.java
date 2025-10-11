package org.example.msnutriamongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class JsonSerializationException extends RuntimeException {
  public JsonSerializationException(String message) {
    super(message);
  }
}
