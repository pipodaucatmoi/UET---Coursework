public class Solution{
    public static int secondLargest(int[] arr){
        int l = arr.length;
        if (l < 2){
            return -1;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < l; i++) {
            int soHienTai = arr[i];
            if (soHienTai > max1) {
                max2 = max1;
                max1 = soHienTai;
            } else if ((soHienTai > max2) && (soHienTai != max1)) {
                max2 = soHienTai;
            }
        }
        if (max2 == Integer.MIN_VALUE){
            return -1;
        }
        return max2;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {2,2,2,2};
        int[] arr3 = {2,2};
        System.out.println(secondLargest(arr1));
        System.out.println(secondLargest(arr2));
        System.out.println(secondLargest(arr3));

    }