public class Solution {
    public static boolean isPrime(int a){
        if (a < 2){
            return false;
        }
        if (a == 2){
            return true;
        }
        for (int i = 2; i <= (a/2 + 1); i++){
            if (a % i == 0){
                return false;
            }
        }
        return true;
    }
    static void main(String[] args) {
        System.out.println(isPrime(-2));
        System.out.println((isPrime(7)));
    }
}
