package main;

public class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited $" + amount + " | New balance: $" + balance);
        notify(); 
    }

    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            System.out.println(Thread.currentThread().getName() + " waiting to withdraw $" + amount + " | Current balance: $" + balance);
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + " | New balance: $" + balance);
    }
}