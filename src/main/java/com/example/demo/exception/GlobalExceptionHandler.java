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


// // Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import java.util.HashMap;
// import java.util.Map;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
//         Map<String, String> body = new HashMap<>();
//         body.put("error", ex.getMessage());
//         return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
//         Map<String, String> body = new HashMap<>();
//         body.put("error", ex.getMessage());
//         return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
//         Map<String, String> body = new HashMap<>();
//         body.put("error", "An unexpected error occurred: " + ex.getMessage());
//         return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
