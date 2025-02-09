package com.contactmanager.helperClass;

import org.springframework.stereotype.Component;

@Component
public class Message {
    // All defined messages
    private String nameSizeError = "Name length must be in 0 - 23 letters";
    private String emailFormatError = "Enter proper email format";
    private String passwordSizeError = "Password must be greater then 8 letters";
    private String successValid = "success";

    String message;
    String type;

    // getting type of message
    public String getMessage(String type) {
        switch (type) {
            case "nameSizeError":
                return nameSizeError;
            case "emailFormatError":
                return emailFormatError;
            case "passwordSizeError":
                return passwordSizeError;
            default:
                return successValid;
        }
    }
}
