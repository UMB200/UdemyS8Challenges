package com.UmidJavaUdemy;
import java.util.ArrayList;
import java.util.Scanner;

public class UdemyContact {
    private String contactName;
    private String phoneNumber;
    //Constructor
    public UdemyContact(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static UdemyContact createContact(String name, String phoneNumber){
        return new UdemyContact(name, phoneNumber);
    }
}
class UdemyMobilePhone{
    private static Scanner scanner = new Scanner(System.in);
    private String myNumber;
    private ArrayList<UdemyContact> myContacts;

    public UdemyMobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<UdemyContact>();
    }
    public boolean addContact(UdemyContact contact){
        if(isContact(contact.getContactName()) >=0 ){
            System.out.println(contact.getContactName() + " cannot be added");
            return false;
        }
        else {
            myContacts.add(contact);
            return true;
        }
    }
    private void addContact(){
        System.out.print("Please enter name ");
        String name = scanner.nextLine();
        System.out.print("Please enter phone ");
        String phone = scanner.nextLine();
        UdemyContact newContact = UdemyContact.createContact(name, phone);
        if(addContact(newContact)){
            System.out.println("New contact added " + name + " phone " + phone);
        }
        else {
            System.out.println("Name already exists");
        }
    }
    //return index of contact name
    private int isContact(UdemyContact contact){
        return this.myContacts.indexOf(contact);
    }
    //check all contacts
    private int isContact(String name){
        for(int i = 0; i < myContacts.size(); i++){
            UdemyContact contact = this.myContacts.get(i);
            if(contact.getContactName().equals(name)){
                return i;
            }

        } return -1;
    }
    private boolean isContact(){
        System.out.print("Please enter name ");
        String name = scanner.nextLine();
        UdemyContact currName = queryContact(name);
        if(currName == null){
            System.out.println("Contact not found");
            return false;
        }
        if(currName.equals(currName.getContactName())){
            System.out.println("Such name already exists");
            return false;
        }
        else {
            isContact(name);
            return true;
        }
    }
    public boolean updateContact(UdemyContact oldContact, UdemyContact newContact){
        int pos = isContact(oldContact);
        if(pos < 0){
            System.out.println("This name "+ oldContact.getContactName() +
                    " is not found");
            return false;
        }
        else if(newContact.equals(isContact(oldContact))){
            System.out.println("This name "+ oldContact.getContactName() +
                    " already exists");
            return false;
        }
        else {

            this.myContacts.set(pos, newContact);
            return true;
        }

    }
    private void updateContact(){
        System.out.println("Enter name to update ");
        String name = scanner.nextLine();
        UdemyContact currName = queryContact(name);
        if(currName == null){
            System.out.println("Contact not found");
            return;
        }
        if(currName.equals(isContact(name))){
            isContact();
        }

        System.out.println("Enter new name to update ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone to update ");
        String newPhone = scanner.nextLine();
        UdemyContact newContact = UdemyContact.createContact(newName, newPhone);
        if(updateContact(currName, newContact)) {
            System.out.println(currName.getContactName() +
                    " was updated to " + newContact.getContactName());
        }
        else System.out.println("Error updating contact");
    }

    public String queryContact(UdemyContact contact){
        if(isContact(contact) >=0){
            return contact.getContactName();
        }
        else return null;
    }
    private UdemyContact queryContact(String name){
        int pos = isContact(name);
        if(pos >=0){
            System.out.println(name + "'s phone number is " + myContacts.get(pos).getPhoneNumber());
            return this.myContacts.get(pos);
        }
        return null;
    }
    public boolean removeContact(UdemyContact contact){
        int pos = isContact(contact);
        if(pos < 0){
            System.out.println(contact.getContactName() + " was not found");
            return false;
        }

        this.myContacts.remove(pos);
        //System.out.printf(contact.getContactName() + " was deleted");
        return true;
    }
    private void removeContact(){
        System.out.println("Enter name to delete ");
        String name = scanner.nextLine();
        UdemyContact currName = queryContact(name);
        if(currName == null){
            System.out.println("Contact not found");
            return;
        }
        if(removeContact(currName)) {
            System.out.println(currName.getContactName() + " was deleted");
        }
        else System.out.println(" Error deleting contact");
    }
    private static void printInstructions(){
        System.out.println("\nAvailable actions:\npress ");
        System.out.println("0 - Shut down\n" +
                           "1 - Show contact list\n" +
                           "2 - Add contact\n" +
                           "3 - Modify contact \n" +
                           "4 - Remove contact \n" +
                           "5 - Search for contact name\n" +
                           "6 - Show available actions");
        System.out.printf("Choose your action ");
    }

    private void showContacts(){
        System.out.println("Contact list");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.println((i+1) + "." + this.myContacts.get(i).getContactName() +
                    " phone: " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public void runContacts(){
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit){
            System.out.print("Enter your choice\n ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Press 6 to show all options");
            switch (choice){

                case 0:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    isContact();
                    break;
                case 6:
                    printInstructions();
                    break;
                default:
                    printInstructions();
            }
        }
    }
}
