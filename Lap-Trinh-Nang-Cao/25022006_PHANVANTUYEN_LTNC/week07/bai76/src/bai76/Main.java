package bai76;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ExecutorService executor = Executors.newFixedThreadPool(Math.min(n, 10));
        List<Future<Integer>> listAns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] currentArray = new int[m];

            for (int j = 0; j < m; j++) {
                currentArray[j] = sc.nextInt();
            }

            Callable<Integer> task = new SecondLargestTask(currentArray);
            listAns.add(executor.submit(task));
        }

        int finalSum = 0;

        System.out.println("\nOutput:");

        for (int i = 0; i < n; i++) {
            try {
                Integer secondLargest = listAns.get(i).get();

                if (secondLargest != null) {
                    System.out.println("Array " + i + ": second largest = " + secondLargest);
                    finalSum += secondLargest;
                } else {
                    System.out.println("Array " + i + ": Not found");
                }

            } catch (InterruptedException | ExecutionException e) {}
        }

        System.out.println("\nSum = " + finalSum);

        executor.shutdown();
        sc.close();
    }
}