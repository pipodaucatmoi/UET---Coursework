package bai57;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn (VD: input.txt): ");
        String sourcePath = sc.nextLine();

        System.out.print("Nhập đường dẫn tệp đích (VD: output.txt): ");
        String destPath = sc.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }
            System.out.println("Sao chép thành công: " + lineCount + " dòng.");
        }
        catch (FileNotFoundException e) {
            System.out.println("Source file not found. hoặc Cannot create destination file.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Lỗi khi đóng tệp.");
            }
        }
        sc.close();
    }
}

