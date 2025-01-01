package com.santt4naweb.workshop01.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.santt4naweb.workshop01.services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Intercepta as exceptions para esse obj executar um possivel tratamento
public class ResourceExceptionHandler {
   @ExceptionHandler(ResourceNotFoundException.class) // esse methodo vai interceptar qualquer exception deste tipo
                                                      // passado
   public ResponseEntity<StandardError> resourceNotFoud(ResourceNotFoundException e, HttpServletRequest request) {
      // Criando os Atributos
      String error = "Resource not foud";
      HttpStatus status = HttpStatus.NOT_FOUND;
      // Instanciando o Constructor
      StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
            request.getRequestURI());
      // returnando a response
      return ResponseEntity.status(status).body(err);
   }
}
