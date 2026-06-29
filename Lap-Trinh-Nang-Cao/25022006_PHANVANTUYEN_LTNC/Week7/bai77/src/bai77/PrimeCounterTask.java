package bai77;

import java.util.concurrent.Callable;

public class PrimeCounterTask implements Callable<Integer> {
    private int[] arr;

    public PrimeCounterTask(int[] arr) {
        this.arr = arr;
    }

    private boolean isPrime(int n){
        if (n < 2) { return false; }
        if (n == 2) { return true; }
        for (int i = 2; i * i <= n; i ++){
            if (n % i == 0) { return false; }
        }
        return true;
    }

    @Override
    public Integer call() throws Exception {
        int primeCount = 0;
        for (int idx : arr) {
            if (isPrime(idx)){
                primeCount += 1;
            }
        }
        return primeCount;
    }
}
