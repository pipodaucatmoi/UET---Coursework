package task43;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Employee[] list = new Employee[n];
        for (int i = 0; i < n; i++){
            String nv = sc.nextLine();
            String[] chia = nv.split("\\s+");
            String oneKey = chia[0];
            String id = chia[1];
            String name = chia[2];
            double baseSalary = Double.parseDouble(chia[3]);
            if (oneKey.equals("T")){
                double overtimeHours = Double.parseDouble(chia[4]);
                list[i] = new Technician(id, name, baseSalary, overtimeHours);
            } else {
                list[i] = new OfficeWorker(id, name, baseSalary);
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.println(list[i].toString() + list[i].calculatePay());
            list[i].work();
            System.out.println();
        }
    }
}