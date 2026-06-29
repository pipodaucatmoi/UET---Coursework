import java.util.Arrays;
import java.util.Scanner;

public class Main {
    Employee[] ds;

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Employee[] arr = new Employee[n];

        for (int i = 0; i < n; i ++) {
            String nv = sc.nextLine();
            String[] chia = nv.split("\"");
            String loaiNv = chia[0].trim();
            String name = chia[1];
            double[] so = Arrays.stream(chia[2].trim().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            if (loaiNv.equals("P")){
                double workHours = so[0];
                double hourlyRate = so[1];
                arr[i] = new PartTimeEmployee(name, workHours, hourlyRate);
            } else {
                double baseSalary = so[0];
                double bonus = so[1];
                double penalty = so[2];
                arr[i] = new FullTimeEmployee(name, baseSalary, bonus, penalty);
            }
        }
        System.out.println("Out put: ");
        for (int i = 0; i < n; i++){
            System.out.println(arr[i].getName() + " - " + arr[i].getNv() + " - " + arr[i].getSalary());
        }
        sc.close();
    }

}
