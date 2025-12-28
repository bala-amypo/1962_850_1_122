// package com.example.demo.exception;

// public class CampaignNotFoundException extends RuntimeException {
//     public CampaignNotFoundException(String message) {
//         super(message);
//     }
// }





package com.example.demo.exception;

public class CampaignNotFoundException extends RuntimeException {

    public CampaignNotFoundException() {
        super();
    }

    public CampaignNotFoundException(String message) {
        super(message);
    }
}
