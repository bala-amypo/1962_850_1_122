// package com.example.demo.exception;

// public class SaleTransactionNotFoundException extends RuntimeException {
//     public SaleTransactionNotFoundException(String message) {
//         super(message);
//     }
// }



package com.example.demo.exception;

public class SaleTransactionNotFoundException extends RuntimeException {

    public SaleTransactionNotFoundException() {
        super();
    }

    public SaleTransactionNotFoundException(String message) {
        super(message);
    }
}
