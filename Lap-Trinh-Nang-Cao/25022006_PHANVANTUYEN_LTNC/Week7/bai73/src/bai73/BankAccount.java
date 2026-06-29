package bai73;

public class BankAccount {
    public int balance;

    public BankAccount(){this.balance = 0;}

    public synchronized void deposit(int amount){
        this.balance += amount;
    }
    public synchronized void withdraw(int amount){
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
