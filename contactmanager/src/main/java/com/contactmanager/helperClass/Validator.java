package com.contactmanager.helperClass;

import org.springframework.stereotype.Component;
import com.contactmanager.entities.User;

@Component
public class Validator {
    Message message = new Message();    
    MessageValid messageValid = new MessageValid();
    public MessageValid checkValidation(User user) {
        if (user.getName().length() < 3 || user.getName().length() > 23) {
            this.messageValid.setMessage(message.getMessage("nameSizeError"));
            this.messageValid.setValid(false);
            return messageValid;
        } else if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            this.messageValid.setMessage(message.getMessage("emailFormatError"));
            this.messageValid.setValid(false);
            return messageValid;
        } else if (user.getPassword().length() < 8) {
            this.messageValid.setMessage(message.getMessage("passwordSizeError"));
            this.messageValid.setValid(false);
            return messageValid;
        } else {
            this.messageValid.setMessage(message.getMessage("successValid"));
            this.messageValid.setValid(true);
            return messageValid;
        }
    }
}