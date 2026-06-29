package bai73;

import java.util.prefs.BackingStoreException;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        Thread luongA = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                acc.deposit(100);
            }
            System.out.println("nap tien thanh cong");
        });

        Thread luongB = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                acc.withdraw(100);
            }
            System.out.println("rut tien thanh cong");
        });

        luongA.start();
        luongB.start();

        try {
            luongA.join();
            luongB.join();
        } catch(InterruptedException e){
            System.out.println("error");
        }

        System.out.println("tien con lai : " + acc.getBalance());
    }
}
