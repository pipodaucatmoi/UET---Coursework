public class Solution {
    public static boolean isPalindrome(int a){
        if ((a % 10 == 0 && a != 0) || a < 0){
            return false;
        }
        int nuaSau = 0;
        while (a > nuaSau){
            int soDu = a % 10;
            nuaSau = nuaSau * 10 + soDu;
            a = a / 10;
        }
        return (a == nuaSau) || (a == nuaSau/10);
    }

    static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(2233));
    }
}
