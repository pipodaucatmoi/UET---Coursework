package bai310;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Employee[] list = new Employee[n];

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            //            E [name] [baseSalary]
            //            D [name] [baseSalary] [overtimeHours]
            //            T [name] [baseSalary] [bugsFound])
            String[] chia = input.split("\\s+");
            String oneKey = chia[0];
            String name = chia[1];
            double baseSalary = Double.parseDouble(chia[2]);
            if (oneKey.equals("D")) {
                int overtimeHours = Integer.parseInt(chia[3]);
                list[i] = new Developer(name, baseSalary, overtimeHours);
            } else if (oneKey.equals("T")) {
                int bugsFound = Integer.parseInt(chia[3]);
                list[i] = new Tester(name, baseSalary, bugsFound);
            } else {
                list[i] = new Employee(name, baseSalary);
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (list[i] instanceof Developer) {
                System.out.println(list[i].toString() + list[i].calculateBonus());
                System.out.println("Tang khoa hoc AWS");
            } else if (list[i] instanceof Tester) {
                System.out.println(list[i].toString() + list[i].calculateBonus());
                System.out.println("Tang tool Test");
            } else {
                System.out.println(list[i].toString() + list[i].calculateBonus());
            }
            System.out.println();
        }
        sc.close();
    }
}
