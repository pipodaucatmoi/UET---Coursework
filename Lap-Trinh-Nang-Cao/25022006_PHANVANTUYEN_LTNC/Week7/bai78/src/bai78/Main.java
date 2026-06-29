package bai78;

import java.util.Scanner;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        int[][] allArrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            allArrays[i] = new int[m];
            for (int j = 0; j < m; j++) {
                allArrays[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nOutput:\n");

        ExecutorService pool1 = Executors.newFixedThreadPool(5);
        ExecutorService pool2 = Executors.newFixedThreadPool(5);

        CompletionService<Stage1Result> cs1 = new ExecutorCompletionService<>(pool1);
        CompletionService<Long> cs2 = new ExecutorCompletionService<>(pool2);

        for (int i = 0; i < n; i++) {
            cs1.submit(new Stage1Task(i, allArrays[i]));
        }

        // 2. Chờ nhận hàng từ Xưởng 1 để ném sang Xưởng 2
        for (int i = 0; i < n; i++) {
            try {
                Future<Stage1Result> completedFuture = cs1.take();
                Stage1Result resultStage1 = completedFuture.get();

                cs2.submit(new Stage2Task(resultStage1.index, resultStage1.primes));

            } catch (InterruptedException | ExecutionException e) { e.printStackTrace(); }
        }

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            try {
                Future<Long> finalCompleted = cs2.take();
                totalSum += finalCompleted.get();
            } catch (InterruptedException | ExecutionException e) {}
        }

        System.out.println("\nTotal = " + totalSum);

        pool1.shutdown();
        pool2.shutdown();
        scanner.close();
    }
}
