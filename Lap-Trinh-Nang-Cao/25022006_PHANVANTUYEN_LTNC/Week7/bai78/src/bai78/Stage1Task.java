package bai78;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Stage1Task implements Callable<Stage1Result> {
    private final int index;
    private final int[] arr;

    public Stage1Task(int index, int[] arr) {
        this.index = index;
        this.arr = arr;
    }

    private boolean isPrime(int n) {
        if (n < 2) { return false; }
        if (n == 2) { return true ;}
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) { return false; };
        }
        return true;
    }

    @Override
    public Stage1Result call() {
        List<Integer> primes = new ArrayList<>();
        for (int num : arr) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        System.out.println("Stage 1 - Array " + index + ": " + primes);

        // Đóng gói cả index và list vào Thùng để trả về cho Main
        return new Stage1Result(index, primes);
    }
}

