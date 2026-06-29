package bai37;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String room1 = sc.nextLine();
        String[] arr = room1.split("\\s+");
        int soDem = Integer.parseInt(arr[1]);

        if (arr[0].equals("S")){
            StandardRoom acc1 = new StandardRoom(soDem);
            System.out.println(acc1.getMoney());
        } else {
            VipRoom acc1 = new VipRoom(soDem);
            System.out.println(acc1.getMoney());
        }
    }
}
