package bai56;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập số nguyên a: ");
            int a = sc.nextInt();

            System.out.print("Nhập số nguyên b: ");
            int b = sc.nextInt();

            int result = a / b;

            System.out.println("Kết quả a / b = " + result);

        }
        catch (InputMismatchException e) {
            System.out.println("[LỖI] Bạn vừa nhập chữ! Vui lòng chỉ nhập số nguyên.");
        }
        catch (ArithmeticException e) {
            System.out.println("[LỖI] Phép toán sai: Không thể chia một số cho 0!");
        }
        finally {
            System.out.println("Program finished.");
        }
        sc.close();
    }
}
