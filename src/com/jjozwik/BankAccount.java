package com.jjozwik;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.jjozwik.ThreadColor.ANSI_RED;
import static com.jjozwik.ThreadColor.ANSI_RESET;
import static com.jjozwik.ThreadColor.ANSI_WHITE;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

//    public synchronized void deposit(double amount){
//        balance += amount;
//        System.out.println(amount + " has been deposited to the bank account: " + this.accountNumber );
//    }
//
//    public synchronized void withdraw(double amount){
//        balance -= amount;
//        System.out.println(amount + " has been taken from the bank account: " + this.accountNumber );
//    }
//
//    public synchronized void printAccountBalance(){
//        System.out.println(ANSI_RESET + "Current account state = " + this.balance );
//    }


//    public void deposit(double amount){
//        synchronized (this){
//            balance += amount;
//            System.out.println(amount + " has been deposited to the bank account: " + this.accountNumber );
//        }
//
//    }
//
//    public void withdraw(double amount){
//        synchronized (this){
//            balance -= amount;
//            System.out.println(amount + " has been taken from the bank account: " + this.accountNumber );
//        }
//
//    }
//
//    public void printAccountBalance(){
//        System.out.println(ANSI_RESET + "Current account state = " + this.balance );
//    }

    public void deposit(double amount){
        lock.lock();
        try {
            balance += amount;
            System.out.println(amount + " has been deposited to the bank account: " + this.accountNumber );
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount){
        lock.lock();
        try{
            balance -= amount;
            System.out.println(amount + " has been taken from the bank account: " + this.accountNumber );
        } finally {
            lock.unlock();
        }
    }

    public void printAccountBalance(){
        System.out.println(ANSI_RESET + "Current account state = " + this.balance );
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = "+accountNumber);
    }
}
