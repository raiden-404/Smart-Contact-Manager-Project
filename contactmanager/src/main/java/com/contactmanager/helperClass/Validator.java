package com.contactmanager.helperClass;

import org.springframework.stereotype.Component;
import com.contactmanager.entities.User;

//Used for server side validation for username password and email
@Component
public class Validator {
    Message message = new Message();
    // use MessageValid defined class object to store the message and isValid()
    MessageValid messageValid = new MessageValid();

    // Take user object any validate it for further process
    public MessageValid checkValidation(User user) {
        // check for user name size
        if (user.getName().length() < 3 || user.getName().length() > 23) {
            this.messageValid.setMessage(message.getMessage("nameSizeError"));
            this.messageValid.setValid(false);
            return messageValid;
        }
        // check for email pattern
        else if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            this.messageValid.setMessage(message.getMessage("emailFormatError"));
            this.messageValid.setValid(false);
            return messageValid;
        }
        // check for password length
        else if (user.getPassword().length() < 8) {
            this.messageValid.setMessage(message.getMessage("passwordSizeError"));
            this.messageValid.setValid(false);
            return messageValid;
        }
        // when everthing is fine then validate the message
        else {
            this.messageValid.setMessage(message.getMessage("successValid"));
            this.messageValid.setValid(true);
            return messageValid;
        }
    }
}