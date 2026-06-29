package bai39;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        IPayable[] payableList = new IPayable[n];

//        Nếu là bai39.PartTimeStaff:
//        S [id] [name] [workingHours] [hourlyRate]
//        Nếu là bai39.Invoice:
//        I [itemName] [quantity] [pricePerItem])
        for (int i = 0; i < n; i++){
            String input = sc.nextLine();
            String[] chia = input.split("\\s+");
            String oneKey = chia[0];

            if (oneKey.equals("S")){
                String id = chia[1];
                String name = chia[2];
                int workingHours = Integer.parseInt(chia[3]);
                double hourRate = Double.parseDouble(chia[4]);
                payableList[i] = new PartTimeStaff(id, name, workingHours, hourRate);
            } else {
                String itemName = chia[1];
                int quantity = Integer.parseInt(chia[2]);
                double pricePerItem = Double.parseDouble(chia[3]);
                payableList[i] = new Invoice(itemName, quantity, pricePerItem);
            }
        }
        System.out.println();
        double toTal = 0;
        for (int i = 0; i < n; i++){
            if (payableList[i] instanceof PartTimeStaff){
                Staff acc = (PartTimeStaff) payableList[i];
                toTal = toTal + acc.getPaymentAmount();
                System.out.println(acc.getTypeClass()+" "+acc.getName()+" - Payment: "+acc.getPaymentAmount());
            } else {
                Invoice acc = (Invoice) payableList[i];
                toTal = toTal + acc.getPaymentAmount();
                System.out.println(acc.getTypeClass()+" "+acc.getName()+" - Paymetn: "+acc.getPaymentAmount());
            }
        }
        System.out.println("Total Payment = "+toTal);
    }
}
