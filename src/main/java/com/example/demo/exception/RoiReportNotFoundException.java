package com.example.demo.exception;

public class RoiReportNotFoundException extends RuntimeException {
    public RoiReportNotFoundException(String message) {
        super(message);
    }
}
