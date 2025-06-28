package main;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

       
        Thread depositor = new Thread(() -> {
            while (true) {
                int amount = (int) (Math.random() * 200 + 100);
                account.deposit(amount);
                sleepRandom();
            }
        }, "Depositor");

        
        Thread withdrawer = new Thread(() -> {
            while (true) {
                int amount = (int) (Math.random() * 250 + 50);
                account.withdraw(amount);
                sleepRandom();
            }
        }, "Withdrawer");

        depositor.start();
        withdrawer.start();
    }

    private static void sleepRandom() {
        try {
            Thread.sleep(1000 + (int)(Math.random() * 1000)); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}