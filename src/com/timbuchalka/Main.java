package com.timbuchalka;

import java.util.Scanner;

/**
 * Created by dev on 1/09/17.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank ;

    public static void main(String[] args) {

        bank = new Bank("Bank of America");
        int choice ;
        boolean doWhile = true;
        while (doWhile){
            PrintMainMenu();
            System.out.println("\nEnter number to choose : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    doWhile = false;
                    break;
                case 1:
                    CustomerMode();
                    break;
                case 2:
                    BankingMode();
                    break;
                case 3:
                    BranchMode();
                    break;
            }
        }
    }

    public static void PrintMainMenu(){
        System.out.println( "\n - - - -  Main Menu  - - - -\n\n" +
                "\t0 -> Quit the program.\n" +
                "\t1 -> Go to Customer Mode.\n" +
                "\t2 -> Go to Banking Mode.\n" +
                "\t3 -> Go to Branch Control.");
    }

    public static void CustomerMode() {
        int choice;
        boolean doWhile = true;
        CustomerMenu();
        while(doWhile){
            System.out.println("\nEnter your choice : (6-> display this menu again)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    doWhile = false;
                    break;
                case 1:
                    bank.addCustomer();
                    break;
                case 2:
                    bank.modifyCustomer();
                    break;
                case 3:
                    bank.searchCustomer(false);
                    break;
                case 4:
                    bank.deleteCustomer();
                    break;
                case 5:
                    bank.searchCustomer(true);
                    break;
                case 6:
                    CustomerMenu();
                    break;
            }
        }
    }

    public static void CustomerMenu(){
        System.out.println("\n* * * *  Customer Mode  * * * * * \n \n" +
                "\t0 -> Return to the Main Menu.\n" +
                "\t1 -> To add Customer.\n" +
                "\t2 -> To change Customer's infomation.\n" +
                "\t3 -> To search Customer's infomation.\n" +
                "\t4 -> To delete Customer.\n" +
                "\t5 -> To print Customer's list.\n" +
                "\t6 -> To diplay the 'Customer Menu'.");
    }

    public static void BankingMode() {
        int choice;
        boolean doWhile = true;
        BankingMenu();
        while (doWhile){
            System.out.println("\nEnter your choice : (4-> display Menu again)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    doWhile = false ;
                    break;
                case 1:
                    bank.doBanking("make Deposit");
                    break;
                case 2:
                    bank.doBanking("make Withdraw");
                    break;
                case 3:
                    bank.doBanking("show Transaction");
                    break;
                case 4:
                    BankingMenu();
                    break;
            }
        }
    }

    public static void BankingMenu() {
        System.out.println("\n * * * *  Banking Mode  * * * * *  \n" +
                "\t0 -> Return to Main Menu.\n" +
                "\t1 -> To make a Deposit.\n" +
                "\t2 -> To make a Withdraw.\n" +
                "\t3 -> To print transaction.\n" +
                "\t4 -> To display the 'Banking Menu'.");
    }

    public static void BranchMode() {
        int choice;
        boolean doWhile = true;
        BranchMenu();
        while (doWhile){
            System.out.println("\nEnter your choice : (6-> display Menu again)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    doWhile = false ;
                    break;
                case 1:
                    bank.addBranch();
                    break;
                case 2:
                    bank.modifyBranch();
                    break;
                case 3:
                    bank.searchBranch();
                    break;
                case 4:
                    bank.deleteBranch();
                    break;
                case 5:
                    bank.showAllBranch();
                    break;
                case 6:
                    BranchMenu();
                    break;
            }
        }
    }

    public static void BranchMenu(){
        System.out.println("\n * * * *  Branch Mode  * * * * *  \n" +
                "\t0 -> Return to the Main Menu.\n" +
                "\t1 -> To add a Branch.\n" +
                "\t2 -> To change a Branch infomation.\n" +
                "\t3 -> To search a Branch infomation.\n" +
                "\t4 -> To delete a Branch.\n" +
                "\t5 -> To print all Branch list.\n" +
                "\t6 -> To display the 'Branch Menu'.");
    }
}

