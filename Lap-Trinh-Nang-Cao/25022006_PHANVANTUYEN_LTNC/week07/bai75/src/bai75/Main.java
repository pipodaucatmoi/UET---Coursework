package bai75;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class OrderTask implements Callable<Boolean> {
    private String id;
    private long processMs;
    private List<String> logs;
    private AtomicInteger successCount;

    public OrderTask(String id, long processMs, List<String> logs, AtomicInteger successCount) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
        this.successCount = successCount;
    }

    @Override
    public Boolean call() {

        System.out.println("Start " + id);
        try {
            Thread.sleep(processMs);
        } catch (InterruptedException e) {
            System.out.println("Đơn hàng " + id + " bị gián đoạn!");
        }

        boolean isSuccess = processMs <= 1500;
        String logMessage = (isSuccess ? "DONE " : "FAIL ") + id;

        if (isSuccess) {
            successCount.incrementAndGet();
        }

        synchronized (logs) {
            logs.add(logMessage);
        }
        return isSuccess;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng đơn hàng cần xử lý : ");
        int m = Integer.parseInt(sc.nextLine());

        List<String> sharedLogs = new ArrayList<>();
        AtomicInteger successCounter = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Boolean>> listAns = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            System.out.println("\nĐơn hàng " + (i + 1) );
            System.out.print("Nhập ID: ");
            String id = sc.nextLine();
            System.out.print("Thời gian xử lý (ms): ");
            long processMs = Long.parseLong(sc.nextLine());

            Callable<Boolean> task = new OrderTask(id, processMs, sharedLogs, successCounter);
            listAns.add(executor.submit(task));
        }

        for (Future<Boolean> don : listAns) {
            try {
                don.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        System.out.println("\nEND");
        System.out.println("Success = " + successCounter.get());

        System.out.println("\nDanh sách :");
        for (String log : sharedLogs) {
            System.out.println(log);
        }

        executor.shutdown();
        sc.close();
    }
}
