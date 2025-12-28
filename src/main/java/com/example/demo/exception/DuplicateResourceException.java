// package com.example.demo.exception;

// public class DuplicateResourceException extends RuntimeException {
//     public DuplicateResourceException(String message) {
//         super(message);
//     }
// }





package com.example.demo.exception;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException() {
        super();
    }

    public DuplicateResourceException(String message) {
        super(message);
    }
}
