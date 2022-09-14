package com.company;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
    private String email;
    private ArrayList<Messages> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return number;
    }

    public void setContact(String contact) {
        this.number = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Messages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Messages> messages) {
        this.messages = messages;
    }

    public Contact(String name, String contact, String email, ArrayList<Messages> messages) {
        this.name = name;
        this.number = contact;
        this.email = email;
        this.messages = messages;
    }
    public void getDetails(){
        System.out.println("Name : " + name+""+"\nNumber: " + number + "" +"\nEmail : " + email );
    }
    public Contact(String name, String contact, String email) {
        this.name = name;
        this.number = contact;
        this.email = email;
        this.messages= new ArrayList<>();
    }
}


