package com.timbuchalka;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dev on 1/09/17.
 */
public class Branch {

    private Scanner scanner = new Scanner(System.in);

    private String branchName;
    private int acctNumber;
    private int count;
    private ArrayList<Customer> customers ;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.acctNumber = 1001;
        this.count = 0;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public int getCount() {
        return count;
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setCount(int count){
        this.count += count;
    }

    public void setAcctNumber(int count){
        this.acctNumber += count;
    }
// - - - - - -
    public boolean newCustomer(int acctNumber) {
        System.out.print("Enter a new customer's name : ");
        String name = scanner.nextLine().toUpperCase().trim();
        System.out.println("Account number will be " + acctNumber);
        for (int i = 2; i > 0; i--) {
            System.out.print("Enter amount to deposit : $");
            double deposit = scanner.nextDouble();
            scanner.nextLine();
            if (deposit <= 0) {
                System.out.println("Wrong amount.  Try more than 0. ");
            } else {
                System.out.println("Added " + name + " successfully.\n");
                this.customers.add(new Customer(name,acctNumber,deposit));
                return true;
            }
        }
        return false;
    }

    public Customer findCustomer(String name){
        for(int i=0; i<this.customers.size(); i++) {
            Customer checkList = this.customers.get(i);
            if(checkList.getCustName().equals(name)){
                return checkList;
            }
        }
        return null;
    }

    public int findCustomer(String name, int number){
        for(int i=0; i<this.customers.size(); i++) {
            Customer checkList = this.customers.get(i);
            if(checkList.getCustName().equals(name) && checkList.getAcctNumber()==number){
                return i;
            }
        }
        return -1;
    }

    public void editCustomer(){
        for (int count = 2; count > 0; count--) {
            System.out.print("Enter a customer's name to edit : ");
            String name = scanner.nextLine().toUpperCase().trim();
            System.out.print("Enter customer's account number : ");
            int number = scanner.nextInt();
            scanner.nextLine();
            int i = findCustomer(name,number);
            if(i >= 0){
                System.out.println("Enter new name for customer : ");
                String newName = scanner.nextLine().toUpperCase().trim();
                if(newName != null) {
                    this.customers.get(i).setCustName(newName);
                    System.out.println("Changed " + name + " -> " + newName + " successfully.\n");
                    count = 0;
                } else System.out.println("New name did not provide. Try again.\n");
            } else System.out.println(name + " does not exist on file.\n");
        }
    }

    public void printOneCustomer() {
        System.out.print("Enter a customer's name to look at : ");
        String name = scanner.nextLine().toUpperCase().trim();
        int count = 0;
        for(int i=0; i<this.customers.size(); i++) {
            if (this.customers.get(i).getCustName().equals(name)) {
                count++;
                linePrint(i, count);
           }
        }
        if(count==0) System.out.println(name + " does not exit on the file.");
    }

    public void printAllCustomer() {
        for(int i=0; i<this.customers.size(); i++){
            linePrint(i, i+1);
        }
    }

    public void linePrint(int i, int count){
        String name = this.customers.get(i).getCustName();
        int number = this.customers.get(i).getAcctNumber();
        double balance = this.customers.get(i).getBalance();
        System.out.println("  " + count + " -> " + name + "(# " + number + ") $ " +
                            balance + " available now." );
    }

    public void chooseCustomer(String bankingMode){
        for(int count=2; count>0; count--){
            System.out.print("Enter a customer's name : ");
            String name = scanner.nextLine().toUpperCase().trim();
            System.out.print("Enter customer's account number : ");
            int number = scanner.nextInt();
            scanner.nextLine();
            int i = findCustomer(name,number);
            if(i >= 0){
                Customer customer = this.customers.get(i);
                System.out.println(name + "(#" + number + ") has balance $" + customer.getBalance());
                if(bankingMode.equals("make Deposit")) {
                    System.out.print("Enter amount to deposit ... $");
                    Double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if(amount > 0){
                        customer.addTransaction(amount);
                        System.out.println("Made a deposit $" + amount + " successfully...");
                    } else System.out.println("Wrong amount...");
                } else if(bankingMode.equals("make Withdraw")) {
                    System.out.print("Enter amount to withdraw ... $");
                    Double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if(amount > 0 && amount<= customer.getBalance()){
                        customer.addTransaction(-amount);
                        System.out.println("Made a withdraw $" + amount + " successfully...");
                    } else System.out.println("Wrong amount...");
                } else customer.printHistory() ;
                return ;
            } else System.out.println("Customer's information does not match.");
        }
    }
}
