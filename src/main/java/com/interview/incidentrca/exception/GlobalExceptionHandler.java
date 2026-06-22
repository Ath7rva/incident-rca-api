package com.interview.incidentrca.exception;
import org.springframework.beans.TypeMismatchException;import org.springframework.core.convert.ConversionFailedException;import org.springframework.http.*;import org.springframework.security.core.AuthenticationException;import org.springframework.web.bind.MethodArgumentNotValidException;import org.springframework.web.bind.annotation.*;import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;import java.time.Instant;import java.util.*;
@RestControllerAdvice public class GlobalExceptionHandler{
 @ExceptionHandler(ResourceNotFoundException.class) ResponseEntity<Map<String,Object>> notFound(RuntimeException ex){return body(HttpStatus.NOT_FOUND,ex.getMessage());}
 @ExceptionHandler(BadRequestException.class) ResponseEntity<Map<String,Object>> bad(RuntimeException ex){return body(HttpStatus.BAD_REQUEST,ex.getMessage());}
 @ExceptionHandler(AuthenticationException.class) ResponseEntity<Map<String,Object>> auth(AuthenticationException ex){return body(HttpStatus.UNAUTHORIZED,"Invalid email or password");}
 @ExceptionHandler({MethodArgumentTypeMismatchException.class,TypeMismatchException.class,ConversionFailedException.class}) ResponseEntity<Map<String,Object>> typeMismatch(Exception ex){return body(HttpStatus.BAD_REQUEST,"Invalid query value. Use correct formats, for dates use 2026-06-22T00:00:00Z");}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){return body(HttpStatus.BAD_REQUEST,ex.getBindingResult().getFieldErrors().stream().map(e->e.getField()+": "+e.getDefaultMessage()).toList().toString());}
 @ExceptionHandler(Exception.class) ResponseEntity<Map<String,Object>> other(Exception ex){return body(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());}
 private ResponseEntity<Map<String,Object>> body(HttpStatus s,String m){return ResponseEntity.status(s).body(Map.of("timestamp",Instant.now(),"status",s.value(),"error",s.getReasonPhrase(),"message",m));}
}
