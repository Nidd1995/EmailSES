package com.kuliza.lending.aramex.lmsportal.pojo;

import java.util.List;

public class Recipient {

    private List<String> to;

    private List<String> cc;

    private List<String> bcc;

    public Recipient() {
    }

    public Recipient(List<String> to, List<String> cc, List<String> bcc) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }
}
