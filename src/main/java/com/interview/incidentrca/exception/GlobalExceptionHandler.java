package com.interview.incidentrca.exception;
import org.springframework.http.*;import org.springframework.web.bind.MethodArgumentNotValidException;import org.springframework.web.bind.annotation.*;import java.time.Instant;import java.util.*;
@RestControllerAdvice public class GlobalExceptionHandler{
 @ExceptionHandler(ResourceNotFoundException.class) ResponseEntity<Map<String,Object>> notFound(RuntimeException ex){return body(HttpStatus.NOT_FOUND,ex.getMessage());}
 @ExceptionHandler(BadRequestException.class) ResponseEntity<Map<String,Object>> bad(RuntimeException ex){return body(HttpStatus.BAD_REQUEST,ex.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){return body(HttpStatus.BAD_REQUEST,ex.getBindingResult().getFieldErrors().stream().map(e->e.getField()+": "+e.getDefaultMessage()).toList().toString());}
 @ExceptionHandler(Exception.class) ResponseEntity<Map<String,Object>> other(Exception ex){return body(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());}
 private ResponseEntity<Map<String,Object>> body(HttpStatus s,String m){return ResponseEntity.status(s).body(Map.of("timestamp",Instant.now(),"status",s.value(),"error",s.getReasonPhrase(),"message",m));}
}
