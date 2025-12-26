package com.example.demo.exception;

public class SaleTransactionNotFoundException extends RuntimeException {
    public SaleTransactionNotFoundException(String message) {
        super(message);
    }
}
