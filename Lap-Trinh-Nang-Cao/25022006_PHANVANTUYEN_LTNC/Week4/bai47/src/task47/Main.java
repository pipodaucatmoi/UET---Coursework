package task47;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String chia[] = input.split("\\s+");
            String id = chia[0];
            String name = chia[1];
            Double gpa = Double.parseDouble(chia[2]);
            students.add(new Student(id, name, gpa));
        }
        System.out.println();
        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0: ");
        students.forEach(student -> System.out.println(student));
        System.out.println();
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("After sorting by name: ");
        students.forEach(student -> System.out.println(student));
        System.out.println();

        Operation<Double> cong = (a, b) -> a + b;
        Operation<Double> tru = (a, b) -> a - b;
        Operation<Double> nhan = (a, b) -> a * b;
        Operation<Double> chia = (a, b) -> {
            if (b == 0) {
                System.out.println("Error");
                return 0.0;
            }
            return a / b;
        };
        double x = 10.5, y = 5.0;
        System.out.println("Cộng: " + cong.execute(x, y));
        System.out.println("Trừ: " + tru.execute(x, y));
        System.out.println("Nhân: " + nhan.execute(x, y));
        System.out.println("Chia: " + chia.execute(x, y));
        sc.close();
    }
}