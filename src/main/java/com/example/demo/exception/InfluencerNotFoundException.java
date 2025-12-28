// package com.example.demo.exception;

// public class InfluencerNotFoundException extends RuntimeException {
//     public InfluencerNotFoundException(String message) {
//         super(message);
//     }
// }





package com.example.demo.exception;

public class InfluencerNotFoundException extends RuntimeException {

    public InfluencerNotFoundException() {
        super();
    }

    public InfluencerNotFoundException(String message) {
        super(message);
    }
}
