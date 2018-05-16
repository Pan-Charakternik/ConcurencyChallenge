package com.jjozwik;

import java.util.concurrent.locks.ReentrantLock;

import static com.jjozwik.ThreadColor.ANSI_BLUE;
import static com.jjozwik.ThreadColor.ANSI_RED;

public class Main {

    public static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000.00);


        Thread customer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(ANSI_RED + "Customer 1 ");
                    account.deposit(300.00);
                    System.out.println(ANSI_RED + "Customer 1 ");
                    account.withdraw(50.00);
                    account.printAccountBalance();
                }
;            }
        });

        Thread customer2 = new Thread(new Runnable() {
            @Override

            public void run() {
                synchronized (lock){
                    System.out.println(ANSI_BLUE + "Customer 2 ");
                    account.deposit(203.75);
//                account.printAccountBalance();
                    System.out.println(ANSI_BLUE + "Customer 2 ");
                    account.withdraw(100.00);
                    account.printAccountBalance();
                }
            }
        });


        customer1.start();
        customer2.start();
//        account.printAccountBalance();

    }


}
