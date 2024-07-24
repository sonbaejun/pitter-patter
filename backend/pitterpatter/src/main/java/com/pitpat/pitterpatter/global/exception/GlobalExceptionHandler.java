package com.pitpat.pitterpatter.global.exception;

import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import com.pitpat.pitterpatter.global.exception.exceptions.TokenExpiredException;
import com.pitpat.pitterpatter.global.exception.exceptions.UserProblemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDataNotFoundException(DataNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Map<String, String>> handleTokenExpiredException(TokenExpiredException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserProblemException.class)
    public ResponseEntity<Map<String, String>> handleUserProblemException(UserProblemException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 다른 예외 핸들러도 추가할 수 있습니다.
}
