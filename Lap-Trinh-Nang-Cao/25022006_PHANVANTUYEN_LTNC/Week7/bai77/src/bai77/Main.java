package bai77;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Integer>> listAns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] currentArray = new int[m];

            for (int j = 0; j < m; j++) {
                currentArray[j] = sc.nextInt();
            }

            Callable<Integer> task = new PrimeCounterTask(currentArray);
            listAns.add(executor.submit(task));;
        }

        System.out.println("\nOutput : ");
        int maxPrimeCount = -1;
        List<Integer> bestArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            try {
                int primeCount = listAns.get(i).get();
                System.out.println("Array " + i + " : " + primeCount);

                if (primeCount > maxPrimeCount) {
                    maxPrimeCount = primeCount;
                    bestArray.clear();
                    bestArray.add(i);
                } else if (primeCount == maxPrimeCount) {
                    bestArray.add(i);
                }
            } catch (InterruptedException | ExecutionException e) { e.printStackTrace(); }
        }

        if (maxPrimeCount >= 0) {
            for (int idx : bestArray) {
                System.out.println("Most primes : Array " + idx + " with " + maxPrimeCount + " primes");
            }
        }

        executor.shutdown();
        sc.close();
    }
}
