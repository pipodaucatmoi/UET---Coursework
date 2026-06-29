public class Solution {
    public static int sumOfDigits(int n){
        int sum = 0;
        n = Math.abs(n);
        while (n != 0){
            int soDu = n % 10;
            sum = sum + soDu;
            n = n / 10;
        }
        return sum;
    }
    static void main(String[] args) {
        System.out.println(sumOfDigits(19));
        System.out.println(sumOfDigits(-2020));
    }
}
