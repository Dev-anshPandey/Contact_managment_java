package com.company;

public class Messages {
    private String text;
    private String recipient;
    private  int id;

    public void getDetails(){
        System.out.println("Contact Name : " + recipient + "\nMessage : " + text +"" + "\nID : " + id );
    }
    public String getText() {
        return text;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Messages(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

}
