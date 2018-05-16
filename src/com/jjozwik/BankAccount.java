package com.jjozwik;

import static com.jjozwik.ThreadColor.ANSI_RED;
import static com.jjozwik.ThreadColor.ANSI_RESET;
import static com.jjozwik.ThreadColor.ANSI_WHITE;

public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println(amount + " has been deposited to the bank account: " + this.accountNumber );
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println(amount + " has been taken from the bank account: " + this.accountNumber );
    }

    public void printAccountBalance(){
        System.out.println(ANSI_RESET + "Current account state = " + this.balance );
    }
}
