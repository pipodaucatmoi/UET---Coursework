public class Solution {
    public static int reverse(int a){
        int b = 0;
        while (a != 0){
            int soDu = a % 10;
            b = b * 10 + soDu;
            a = a / 10;
        }
        if (Integer.MAX_VALUE - b < 0){
            return -1;
        }
        return b;
    }

    static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }
}
