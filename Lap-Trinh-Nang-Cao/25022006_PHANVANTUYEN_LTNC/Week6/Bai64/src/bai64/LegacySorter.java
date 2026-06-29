package bai64;

import java.util.Arrays;

public class LegacySorter {
    public int[] quickSort(int[] arr){
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return sorted;
    }
}
