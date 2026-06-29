public class Solution {
    public static int gcd(int a, int b){
        if (a == 0 && b ==0){
            return -1;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int soDu = a % b;
            a = b;
            b = soDu;
        }
        return a;
    }

    static void main(String[] args) {
        System.out.println(gcd(10,2));
        System.out.println(gcd(-2,100));
        System.out.println(gcd(0,100));
    }
}
