package com.alejandro.info.model;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailModel {

    private String destination;
    private String subject;
    private String body;

    public MailModel(String destination, String subject, String body) {
        this.destination = destination;
        this.subject = subject;
        this.body = body;
    }

    public void setDestination(String destinations) {
        this.destination = destination;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
