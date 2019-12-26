package com.UmidJavaUdemy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Create a program that implements a simple mobile phone with the following
capabilities.
Able to store, modify, remove and query contact names.
You will want to create a separate class for Contacts (name and phone number).
Create a master class (MobilePhone) that holds the ArrayList of Contacts
The MobilePhone class has the functionality listed above.
Add a menu of options that are available.
Options:  Quit, print list of contacts, add new contact, update existing contact,
remove contact and search/find contact.
When adding or updating be sure to check if the contact already exists (use name)
Be sure not to expose the inner workings of the Arraylist to MobilePhone e.g. no ints, no .get(i) etc
MobilePhone should do everything with Contact objects only.*/
public class MobilePhone {
    Contacts contacts = new Contacts();

    public void startContacts(){
        contacts.runContacts();
    }

    public Contacts getContacts() {
        return contacts;
    }

}
class Contacts{
    private static Scanner scanner = new Scanner(System.in);
    private String contactName;
    private String phoneNumber;
    private int[] numbers = new int[100];

    public ArrayList<String> getContacts() {
        return contacts;
    }

    private ArrayList<String> contacts = new ArrayList<String>();

    private void showContacts(){
        System.out.println("You have " + contacts.size() +
                " contacts om your list");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println((i+1) +". " + contacts.get(i));
        }
    }
    private boolean isContact(String name){
        int pos = findContact(name);
        if(pos>=0 && contacts.contains(name)){
            System.out.printf("This entry exists");
            return true;
        }
        else return false;
    }

    private void addContact(String name, String phone){
        if(isContact(name)){
            System.out.println("Please enter another name");
            if(isContact(phone)){
                System.out.println("Phone " + phone  + " is associated with " + name);
                String newName = scanner.nextLine();
                System.out.println("Changing " +name + " to " + newName);
                modifyContact(name, newName);
            }
        }
        else {
            contacts.add(name);
            contacts.add(phone);
        }
    }
    private void modifyContact(String currentContact, String newContact){
        int pos = findContact(currentContact);
        if(isContact(newContact)) {
            System.out.printf("This name " + newContact + " already exists");
        }
        else {
            modifyContact(pos, newContact);
            System.out.println("Contact " + currentContact + " was updated to "  +
                    newContact);
        }
    }
    private void modifyContact(int pos, String newName){
        contacts.set(pos, newName);

    }
    private int findContact(String searchName){
        return contacts.indexOf(searchName);
    }
    private void removeContact(String name){
        int pos = findContact(name);
        if(pos >=0){
            removeContact(pos);
            System.out.println("Contact " + name + " was removed");
        }
    }
    private void removeContact(int pos){
        contacts.remove(pos);
    }
    private static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - Show choice options");
        System.out.println("\t 1 - Show contact list");
        System.out.println("\t 2 - Add contact to the list");
        System.out.println("\t 3 - Modify contact in the list");
        System.out.println("\t 4 - Remove contact from the list");
        System.out.println("\t 5 - Search for an item in the list");
        System.out.println("\t 6 - To quit");
    }
    public void runContacts(){
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit){
            System.out.print("Enter your choice ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    returnArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }
    }
    private void addContact(){
        System.out.print("Please enter name and phone ");
        addContact(scanner.nextLine(), scanner.nextLine());
    }
    private void modifyContact(){
        System.out.print("Enter name to change ");
        String name = scanner.nextLine();
        System.out.print("Enter new name ");
        String newName = scanner.nextLine();
        modifyContact(name, newName);
    }
    private void removeContact(){
        System.out.print("Enter name to remove ");
        String name = scanner.nextLine();
        scanner.nextLine();
        removeContact(name);
    }
    private void findContact(){
        System.out.print("Name to find ");
        String searchName = scanner.nextLine();
        if(isContact(searchName)){
            System.out.print("Found "+ searchName + " in contact list");
        }
        else {
            System.out.print(searchName + " is not in the list");
        }
    }
    private void returnArrayList(){
        ArrayList<String> newList = new ArrayList<String>();
        newList.addAll(getContacts());
        ArrayList<String> nextList = new ArrayList<String>(getContacts());
        String[] myArray = new String[getContacts().size()];
        myArray = getContacts().toArray(myArray);
    }

}
