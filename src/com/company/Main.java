package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static ArrayList<Contact> contacts;
   public static Scanner scanner;
   public static int id;
    public static void main(String[] args) {
        System.out.println("Hellooo...");
        contacts=new ArrayList<>();
        showInitialOptions();

    }

    private static void showInitialOptions() {
        System.out.println("Select one of the options.. \n" +"1.ManageContacts \n" +"2.ManageMessages\n" +"3.Quit"  );
        scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        switch (choice){
            case 1:manageContacts();
            break;
            case 2:manageMessages();
                break;
            default:
                break;
        }

    }

    private static void manageMessages() {
        System.out.println("Select one : " +"\n1.See the list of all messages" +"\n2.Send a new message" + "\n3.Go back to the previous menu" );
        int choice=scanner.nextInt();
        switch (choice){
            case 1:showAllMessages();
            break;
            case 2:sendMessage();
            break;
            default: showInitialOptions();
            break;
        }
    }

    private static void sendMessage() {
        System.out.println("Enter the name of reciever");
        String name=scanner.next();
        if(name==""){
            System.out.println("No name provided..");
            sendMessage();
        }
        else{
            boolean isContact=false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    isContact=true;
                }
            }
            if(!isContact){
                System.out.println("No such contact exist");
            }
            else {
                System.out.println("Enter message..");
                String text=scanner.next();
                if(text==""){
                    System.out.println("No msg typed..");
                    sendMessage();
                }
                else{
                    id++;
                    Messages newMessages=new Messages(text,name,id);
                    for(Contact c:contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Messages> msg=c.getMessages();
                            msg.add(newMessages);
                            Contact newContact= c;
                            newContact.setMessages(msg);
                            contacts.remove(c);
                            contacts.add(newContact);

                        }
                    }
                }
            }

        }
        showInitialOptions();
    }

    private static void showAllMessages() {
     ArrayList<Messages> messages=new ArrayList<>();
     for (Contact c:contacts){
         messages.addAll(c.getMessages());
     }
     if(messages.size()>0){
         for(Messages msg: messages){
             msg.getDetails();
             System.out.println("**********");
         }
     }
     else{
         System.out.println("No msg");
     }
     showInitialOptions();
    }

    private static void manageContacts() {
        System.out.println("Select one : " +"\n1.Show all contacts" +"\n2.Add new contacts" + "\n3.Search for contacts" +"\n4.Delete Contacts" );

        scanner=new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:showAllContacts();
                break;
            case 2:addNewContacts();
                break;
            case 3:searchForContacts();
                break;
            case 4:deleteContact();
                break;
            default:showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Enter Name : ");
        String name = scanner.next();
        if (name == "") {
            System.out.println("Name Missing");
            deleteContact();
        } else {
            boolean removed = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    contacts.remove(c);
                    removed = true;
                    System.out.println("Deleted successfully..");
                    break;
                }
            }
            if (!removed){
                System.out.println("No such contact exists");
            }
        }
        showInitialOptions();
    }

    private static void searchForContacts() {
        System.out.println("Enter the name of contact");
        String name=scanner.next();
        if(name==""){
            System.out.println("Missing Name ...");
            searchForContacts();
        }
        else{
            boolean isContact=false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    c.getDetails();
                    isContact=true;
                }
            }
            if(!isContact){
                System.out.println("No such contact exists");
            }
        }
        showInitialOptions();

    }

    private static void addNewContacts() {
        System.out.println("Adding Contacts.." +"\n Please Enter contact's name");
        String name=scanner.next();
        System.out.println("\n Please enter user's email");
        String email=scanner.next();
        System.out.println("\n Please enter user's contact no.");
        String number=scanner.next();
        if(name=="" || email=="" || number=="" ){
            System.out.println("Information Missing..");
            addNewContacts();
        }
        else {
            boolean exist=false;
            for (Contact c:contacts){
                if(c.getName().equals(name)){
                    exist=true;
                }
            }
            if(!exist){
                Contact contact=new Contact(name,number,email);
                contacts.add(contact);
                System.out.println("Contact added successfully");
            }
            else {
                System.out.println("A contact with  name " + name +" already exists");
                addNewContacts();
            }
        }
        showInitialOptions();

    }

    private static void showAllContacts() {
        if(contacts.size()>0){
            for(Contact c : contacts){

                c.getDetails();
                System.out.println("***********");
            }
        }
        else{
            System.out.println("No contacts");
        }

        showInitialOptions();
    }

}
