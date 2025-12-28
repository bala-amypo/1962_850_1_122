// package com.example.demo.exception;

// public class RoiReportNotFoundException extends RuntimeException {
//     public RoiReportNotFoundException(String message) {
//         super(message);
//     }
// }




package com.example.demo.exception;

public class RoiReportNotFoundException extends RuntimeException {

    public RoiReportNotFoundException() {
        super();
    }

    public RoiReportNotFoundException(String message) {
        super(message);
    }
}
