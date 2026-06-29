import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumTask implements Callable<Integer> {
    private int[] array;
    private int startIndex;
    private int endIndex;

    public SumTask(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        System.out.println("Luồng " + Thread.currentThread().getName() +
                " đã tính xong đoạn [" + startIndex + " đến " + (endIndex - 1) + "] -> Tổng: " + sum);
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nhap n : ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        System.out.println("nhap " + n + " so nguyen:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int k = 4;
        int length = n / k;

        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> listAns = new ArrayList<>();


        for (int i = 0; i < k; i++) {
            int start = i * length;

            int end = (i == k - 1) ? n : (start + length);

            Callable<Integer> task = new SumTask(arr, start, end);
            Future<Integer> Ans = executor.submit(task);
            listAns.add(Ans);
        }

        int tongCuoiCung = 0;

        try {
            for (Future<Integer> Ans : listAns) {
                int ketQuaMotDoan = Ans.get();
                tongCuoiCung += ketQuaMotDoan;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("\nerror");
            e.printStackTrace();
        }

        System.out.println("\nSUM : " + tongCuoiCung);
        executor.shutdown();
        sc.close();
    }
}