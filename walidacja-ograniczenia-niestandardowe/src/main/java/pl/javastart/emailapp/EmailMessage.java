package pl.javastart.emailapp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class EmailMessage {
    @NotNull
    @Email
    private String sender;
    @NotNull
    @Email
    private String recipient;
    @NotBadWord(lang = {Lang.PL, Lang.EN})
    private String message;

    public EmailMessage(String sender, String recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
