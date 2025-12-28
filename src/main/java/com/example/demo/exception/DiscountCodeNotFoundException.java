// package com.example.demo.exception;

// public class DiscountCodeNotFoundException extends RuntimeException {
//     public DiscountCodeNotFoundException(String message) {
//         super(message);
//     }
// }





package com.example.demo.exception;

public class DiscountCodeNotFoundException extends RuntimeException {

    public DiscountCodeNotFoundException() {
        super();
    }

    public DiscountCodeNotFoundException(String message) {
        super(message);
    }
}
