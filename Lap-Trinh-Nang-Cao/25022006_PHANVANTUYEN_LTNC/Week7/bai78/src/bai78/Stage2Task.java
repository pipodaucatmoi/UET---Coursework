package bai78;

import java.util.List;
import java.util.concurrent.Callable;

public class Stage2Task implements Callable<Long> {
    private final int index;
    private final List<Integer> primes;

    public Stage2Task(int index, List<Integer> primes) {
        this.index = index;
        this.primes = primes;
    }

    @Override
    public Long call() {
        long sum = 0;
        int count = primes.size();
        boolean isEven = (count % 2 == 0);

        for (int p : primes) {
            long val = p;
            sum += isEven ? (val * val) : (val * val * val);
        }

        String type = isEven ? "squares" : "cubes";
        System.out.println("Stage 2 - Array " + index + ": sum of " + type + " = " + sum);

        return sum;
    }
}