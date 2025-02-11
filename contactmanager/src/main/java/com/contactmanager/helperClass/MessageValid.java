package com.contactmanager.helperClass;

import org.springframework.stereotype.Component;

//Used to store message and isValid()
@Component
public class MessageValid {
    private String message;
    private boolean valid;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
