package com.timbuchalka;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dev on 1/09/17.
 */
public class Bank {
    private Scanner scanner = new Scanner(System.in);

    private String bankNames ;
    private ArrayList<Branch> branches ;

    public Bank(String bankName) {
        this.bankNames = bankName;
        this.branches = new ArrayList<Branch>();
    }

//    public void addBranch() {
//        System.out.print("Enter new branch name : ");
//        String name = scanner.nextLine().toUpperCase().trim();
// *       Branch branch = findBranch(name);
// *       if(branch == null) {
//            this.branches.add(new Branch(name));
//            System.out.println("Added " + name + " successfully.");
//        } else System.out.println(name + " is already on file.  Try again.\n");
//    }

    public void addBranch() {
        System.out.print("Enter new branch name : ");
        String name = scanner.nextLine().toUpperCase().trim();
        int position = findBranchPosition(name);
        if(position < 0) {
            this.branches.add(new Branch(name));
            System.out.println("Added " + name + " successfully.");
        } else System.out.println(name + " is already on file.  Try again.\n");
    }

    public void modifyBranch(){
        System.out.print("Enter branch's current name : ");
        String currentName = scanner.nextLine().toUpperCase().trim();
        int position = findBranchPosition(currentName);
        if(position < 0) {
            System.out.println(currentName + "does not exist.  Try again.\n");
        } else {
            for(int i=2; i>0; i--) {
                System.out.print("Enter branch's new name : ");
                String newName = scanner.nextLine().toUpperCase().trim();
                if (findBranchPosition(newName) >= 0) {
                    System.out.println(newName + " exist already.  Try again.\n");
                } else {
                    this.branches.get(position).setBranchName(newName);
                    System.out.println("Name changed : " + currentName + " -> " + newName);
                    i = 0;
                }
            }
        }
    }

    public void searchBranch(){
        System.out.print("Enter branch name to find : ");
        String name = scanner.nextLine().toUpperCase().trim();
        int position = findBranchPosition(name);
        if(position < 0) {
            System.out.println(name + "does not exist.  Try again.\n");
        } else {
            branchLinePrint(position);
        }
    }

    public void deleteBranch(){
        System.out.print("Enter branch name to delete : ");
        String name = scanner.nextLine().toUpperCase().trim();
        int position = findBranchPosition(name);
        if(position < 0) {
            System.out.println(name + "does not exist.  Try again.\n");
        } else {
            System.out.println("Are you sure to delete? (yes or no) ...");
            String yesOrNo = scanner.nextLine().toLowerCase().trim();
            if (yesOrNo.equals("yes")) {
                this.branches.remove(position);
                System.out.println("\n  --> " + name + " has been deleted .\n");
            } else System.out.println("Processing canceled by user.\n");
        }
    }

    public void showAllBranch(){
        System.out.println("\n Total " + this.branches.size() + " Branches.\n");
        for(int i=0; i<this.branches.size(); i++) branchLinePrint(i);
        System.out.println();
    }

    public void branchLinePrint(int x){
        System.out.println("  " + (x+1) + " --> " + this.branches.get(x).getBranchName() +
                " (" + this.branches.get(x).getCount() + " customers)");
    }

    public int findBranchPosition(String name){
        for(int i=0; i<this.branches.size(); i++) {
            if(this.branches.get(i).getBranchName().equals(name)){
                return i;
            }
        }
        return -1;
    }

//    public Branch findBranch(String name){
//        for(int i=0; i<this.branches.size(); i++) {
//            Branch checkBranch = this.branches.get(i);
//            if(checkBranch.getBranchName().equals(name)){
//                return checkBranch;
//            }
//        }
//        return null;
//    }

// - - - - - - - - - - - - - - - -

    public void addCustomer(){
        showAllBranch();
        if(this.branches.size()==0) { return; }
        for(int count=2; count>0; count--) {
            System.out.print("Enter # to select branch : ");
            int select = scanner.nextInt();
            scanner.nextLine();
            if(select > 0 && select <= this.branches.size()){
                int i = select - 1;      //  real positoin in the array list of branches.
                Branch branch = this.branches.get(i);
                String name = branch.getBranchName();
                int acctNumber = branch.getAcctNumber();
                System.out.println("\n  You can add a customer to " + name + "  (" +
                        branch.getCount() + " customers)\n");
                if(branch.newCustomer(acctNumber)) {
                    branch.setCount(1);
                    branch.setAcctNumber(1);
                    branchLinePrint(i);
                }
                break;
            } else {
                System.out.println("Wrong # you entered.  Try again.\n");
            }
        }
    }

    public void modifyCustomer() {
        showAllBranch();
        if(this.branches.size()==0) { return; }
        for (int count = 2; count > 0; count--) {
            System.out.print("Enter a name of branch to modifhy customer : ");
            String name = scanner.nextLine().toUpperCase().trim();
            int position = findBranchPosition(name);
            if(position < 0) {
                System.out.println(name + "does not exist.  Try again.\n");
            } else if(this.branches.get(position).getCount() > 0) {
                Branch branch = this.branches.get(position);
                branchLinePrint(position);
                branch.editCustomer();
                break;
            } else System.out.println("\n" + name + " has no customer yet.");
        }
    }

    public void searchCustomer(boolean printAll){
        showAllBranch();
        if(this.branches.size()==0) { return; }
        for(int count=2; count>0; count--) {
            System.out.print("Enter # to select branch : ");
            int select = scanner.nextInt();
            scanner.nextLine();
            if(select > 0 && select <= this.branches.size()){
                int i = select - 1;      //  real positoin in the array list of branches.
                Branch branch = this.branches.get(i);
                System.out.println("\n  " + branch.getBranchName() + "  (" +
                        branch.getCount() + " customers)\n");
                if(printAll) {
                    branch.printAllCustomer();
                } else {
                    branch.printOneCustomer();
                }
                break;
            } else {
                System.out.println("Wrong # you entered.  Try again.\n");
            }
        }
    }

    public void deleteCustomer(){
        System.out.println("   - - - Didn't finish yet. - - -\n");
    }

// - - - - - -
    public void doBanking(String bankingMode){
        showAllBranch();
        if(this.branches.size()==0) { return; }
        for(int count=2; count>0; count--) {
            System.out.println("   - - - " + bankingMode + " - - -\n");
            System.out.print("Enter # to select branch : ");
            int select = scanner.nextInt();
            scanner.nextLine();
            if(select > 0 && select <= this.branches.size()){
                int i = select - 1;      //  real positoin in the array list of branches.
                Branch branch = this.branches.get(i);
                String name = branch.getBranchName();
                branch.chooseCustomer(bankingMode);    //
                break;
            } else {
                System.out.println("Wrong # you entered.  Try again.\n");
            }
        }
    }
}
