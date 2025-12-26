// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import java.util.HashMap;
// import java.util.Map;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", ex.getMessage());
//         errorResponse.put("status", HttpStatus.NOT_FOUND.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", ex.getMessage());
//         errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(UsernameNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", ex.getMessage());
//         errorResponse.put("status", HttpStatus.NOT_FOUND.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", "An internal error occurred");
//         errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }




package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneral(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Internal server error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}