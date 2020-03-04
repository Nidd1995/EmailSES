package com.kuliza.lending.aramex.lmsportal.utils.dto;

import com.kuliza.lending.aramex.lmsportal.pojo.Recipient;

import java.util.List;

public class EmailDTO {

    private String subject;

    private String body;

    private String sender;

    private Recipient receiver;

    public EmailDTO() {

    }
    public EmailDTO(String subject, String body, String sender, Recipient receiver) {
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Recipient getReceiver() {
        return receiver;
    }

    public void setReceiver(Recipient receiver) {
        this.receiver = receiver;
    }




}
