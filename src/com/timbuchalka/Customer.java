package com.timbuchalka;

import java.util.ArrayList;

/**
 * Created by dev on 1/09/17.
 */
public class Customer {
    private String custName;
    private int acctNumber;
    private double balance ;
    private ArrayList<Double> transactions ;

    public Customer(String custName, int acctNumber, double initialAmount) {
        this.custName = custName;
        this.acctNumber = acctNumber;
        this.balance = 0.0d;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount) {
        this.balance = this.balance + amount;
        this.transactions.add(amount);
    }

    public String getCustName() {
        return custName;
    }

    public int getAcctNumber(){
        return acctNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setBalance(double amount) {
        this.balance += amount;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void printHistory(){
        double subTotal = 0.0;
        for(int i=0; i<transactions.size(); i++) {
            subTotal += transactions.get(i);
            System.out.println("    " + (i+1) + " -> $" + transactions.get(i) +
                            "   sub Total $" + subTotal);
        }
    }
}