package com.UmidJavaUdemy;
import java.util.ArrayList;
import java.util.Scanner;

// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions
public class Bank {
    private static Scanner scanner = new Scanner(System.in);

// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
    private static ArrayList<BankBranch> branchArrayList;
    private static ArrayList<BankBranch.Customer> customerArrayList;


    public void printOption(){
        boolean exit = false;
        while(!exit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int choice =scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Closing bank");
                    break;
                case 1:
                    createBranch();
                    break;
                case 2:
                    showBranch();
                    break;
                case 3:
                    addCustomerByBank();
                    break;
                case 4:
                    addTransactiontoCustomer();
                case 5:
                    showTransactions();
                    break;
            }
        }
    }
    private static void createBranch(){
        System.out.println("Enter branch name ");
        String branchName = scanner.nextLine();
        BankBranch bankBranch = BankBranch.createBranch(branchName);
        branchArrayList.add(bankBranch);
    }
    private static void showBranch(){
        System.out.println("List of bank branches");
        for(int i = 0; i < branchArrayList.size(); i++){
            System.out.println((i+1) + ". " +
                    branchArrayList.get(i).getBranchName());
        }
    }
    private static void addCustomerByBank(){
        System.out.println("Please enter branch to add customer to ");
        String bankWhereAddCustomer = scanner.nextLine();
        int branchPosition = branchArrayList.indexOf(bankWhereAddCustomer);
        System.out.println("Please enter customer's name ");
        String customerName = scanner.nextLine();
        BankBranch.Customer customer = BankBranch.Customer.createCustomer(customerName);
        customerArrayList.add(customer);
        customer.addTransaction(10.0);
    }
    private static void addTransactiontoCustomer(){
        System.out.println("Please enter customer ");
        String customerName = scanner.nextLine();
        System.out.println("Please enter transaction amount");
        double amount = scanner.nextDouble();
        int customer = findCustomer(customerName);
        BankBranch.addNewTransaction(amount, customerArrayList.get(customer));
    }
    private static int findCustomer(String name){
        for(int i =0; i < customerArrayList.size(); i++){
            BankBranch.Customer customer = customerArrayList.get(i);
            if(customer.getName().equals(name)){
                return i;
            }
        }return -1;
    }


    private static void showTransactions(){
        System.out.println("Please enter customer ");
        String customerName = scanner.nextLine();
        customerArrayList.get(findCustomer(customerName));


    }

    private int findBranch(BankBranch bankBranch){
        return branchArrayList.indexOf(bankBranch);
    }

    static class BankBranch{
    /* Need to be able to add a new customer and initial transaction amount.
    Also needs to add additional transactions for that customer/branch*/
        private ArrayList<Customer> customerArrayList;

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getBranchName() {
            return branchName;
        }


        private String branchName;

        public BankBranch(ArrayList<Customer> customerArrayList, String branchName) {
            this.customerArrayList = customerArrayList;
            this.branchName = branchName;
        }
        public BankBranch(String branchName) {
            this.branchName = branchName;
        }
        public static BankBranch createBranch(String branchName){
            return new BankBranch(branchName);
        }

        public boolean addNewCustomer(Customer newCustomer){
            if(customerArrayList.indexOf(newCustomer) >=0){
                System.out.println("Customer " + newCustomer.getName() + " already exists");
                return false;
            }
            else {
                customerArrayList.add(newCustomer);
                return true;
            }
        }

        public static void  addNewTransaction(double amount, Customer customer){
            customer.addTransaction(amount);
        }

        private int findCustomer(Customer customer){
            return this.customerArrayList.indexOf(customer);
        }

        static class Customer{
            private ArrayList<Double> transactions;
            private String name;

            public void setTransactions(ArrayList<Double> transactions) {
                this.transactions = transactions;
            }
            public static void showTransactions(Customer customer){
                for(int i =0; i < customer.transactions.size(); i++){
                    System.out.println((i+1) + ": " +
                            customer.transactions.get(i));
                }
            }

            public void setName(String name) {
                this.name = name;
            }

            public Customer(ArrayList<Double> transactions) {
                this.transactions = transactions;

            }
            public Customer(String name) {
                this.name = name;
            }
            public Customer(ArrayList<Double> transactions, String name) {
                this.transactions = transactions;
                this.name = name;
            }

            public ArrayList<Double> getTransactions() {
                return transactions;
            }
            public String getName() {
                return name;
            }
            public static Customer createCustomer(String name){
                return new Customer(name);
            }
            public static Customer createTransaction(ArrayList<Double> transactions){
                return new Customer(transactions);
            }
            public void addTransaction(double amount){
                transactions.add(amount);
            }
        }
    }
}

