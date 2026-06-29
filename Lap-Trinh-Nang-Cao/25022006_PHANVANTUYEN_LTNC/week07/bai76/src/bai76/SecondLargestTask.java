package bai76;

import java.util.concurrent.Callable;

public class SecondLargestTask implements Callable<Integer> {
    private int[] arr;

    public SecondLargestTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() {

        if (arr == null || arr.length < 2) { return null; }
        Integer first = null;
        Integer second = null;

        for (int num : arr){
            if (first == null || num > first){
                second = first;
                first = num;
            } else if (num < first || second == null || second < num) {
                second = num;
            }
        }
        return second;
    }
}
