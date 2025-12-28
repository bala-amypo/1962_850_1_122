// package com.example.demo.exception;

// public class UserNotFoundException extends RuntimeException {
//     public UserNotFoundException(String message) {
//         super(message);
//     }
// }







package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
