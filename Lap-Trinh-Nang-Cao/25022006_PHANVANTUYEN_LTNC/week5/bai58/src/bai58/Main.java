package bai58;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "numbers.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("n = ");
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                int num = scanner.nextInt();
                dos.writeInt(num);
            }
            System.out.println("Đã ghi xong vào " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }

        System.out.println("\nĐỌC DỮ LIỆU TỪ FILE");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (true) {
                int value = dis.readInt();
                System.out.print(value + " ");
            }
        }
        catch (EOFException e) {
            System.out.println("\n-> Đã đọc hết toàn bộ file.");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
