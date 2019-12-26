package com.UmidJavaUdemy;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {
    private static Scanner scanner = new Scanner(System.in);

    private int[] numbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<String>();
    private void addItemsParam(String item){
        groceryList.add(item);
    }
    private void showList(){
        System.out.println("You have " + groceryList.size() +
                " items in your list");
        for(int i =0; i < groceryList.size(); i++){
            System.out.println((i+1)+ " ." + groceryList.get(i));
        }
    }

    private void changeListItemParam(String currItem, String newItem){
        int pos = findItemParam(currItem);
        if(pos >= 0){
            changeListItemParam(pos, newItem);
        }
    }

    private void changeListItemParam(int pos, String newItem){
        groceryList.set(pos, newItem);
        System.out.println("Item " + (pos +1) + " has been modified");
    }

    private void removeListItemParam(String item){
        int pos = findItemParam(item);
        if(pos >= 0){
            removeListItemParam(pos);
        }
    }

    private void removeListItemParam(int pos){
        groceryList.remove(pos);
    }
    private int findItemParam(String searchItem){
            return groceryList.indexOf(searchItem);
    }
    private static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To print modify an item in the list");
        System.out.println("\t 4 - To print remove an item from the list");
        System.out.println("\t 5 - To print search for an item in the list");
        System.out.println("\t 6 - To quit");
    }
    public void runOnMain(){
        boolean quit = false;
        int choice= 0;
        printInstructions();
        while (!quit){
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    showList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                        removeItem();
                    break;
                case 5:
                    findItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;

            }
        }
    }
    private void addItem(){
        System.out.print("Please enter the grocery item ");
        addItemsParam(scanner.nextLine());
    }
    private void modifyItem(){
        System.out.print("Enter item name ");
        String item = scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        changeListItemParam(item, newItem);
    }
    private void removeItem(){
        System.out.print("Enter item name: ");
        String item = scanner.nextLine();
        scanner.nextLine();
        removeListItemParam(item);
    }
    private void findItem(){
        System.out.print("Item to search ");
        String searchItem = scanner.nextLine();
        if(onFile(searchItem)){
            System.out.println("Found " + searchItem +
                    " in grocery list");
        }
        else {
            System.out.println(searchItem + " is not in the shopping list");
        }

    }
    private boolean onFile(String item){
        int pos = findItemParam(item);
        if(pos >=0){
            return true;
        }
        else {
            return false;
        }
    }
    private ArrayList<String> getGroceryList(){
        return groceryList;
    }
    private void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(getGroceryList());

        String[] myArray = new String[getGroceryList().size()];
        myArray = getGroceryList().toArray(myArray);
    }

}
