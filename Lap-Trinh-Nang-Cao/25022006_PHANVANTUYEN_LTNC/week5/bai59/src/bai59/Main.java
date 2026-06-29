package bai59;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();
        String file = "students.dat";

        System.out.println("=== NHẬP SINH VIÊN (Gõ 'END' ở ID để dừng) ===");
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("END")) break;

            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            list.add(new Student(id, name, gpa));
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Student s : list) {
                oos.writeObject(s);
            }
            System.out.println("-> Đã lưu dữ liệu ra tệp " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== ĐỌC LẠI TỪ TỆP VÀ IN DANH SÁCH ===");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
            }
        }

        catch (EOFException e) {
            System.out.println("-> [Đã đọc hết dữ liệu trong tệp]");
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy lớp Student.");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy tệp.");
        } catch (IOException e) {
            System.out.println("Lỗi I/O: " + e.getMessage());
        }
        sc.close();
    }

}
