package task;
import task.skills.Wifi;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ThietBi> hub = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++){
            String input = sc.nextLine();
            String[] chia = input.split("\\s+");
            String oneKey = chia[0];
            String id = chia[1];
            String name = chia[2];
            if (oneKey.equals("L")) {
                hub.add(new Light(id, name));
            } else if (oneKey.equals("AC")) {
                hub.add(new Cool(id, name));
            } else if (oneKey.equals("S")) {
                hub.add(new Sound(id, name));
            } else if (oneKey.equals("C")) {
                hub.add(new Rem(id, name));
            }
        }
        System.out.println("\nTurn Off All Devices:");
        for ( ThietBi in : hub){
            in.turnOff();
        }
        System.out.println("\nSetup Wifi:");
        for ( ThietBi in : hub){
            if (in instanceof Wifi){
                Wifi acc = (Wifi) in;
                acc.connectWifi();
            }
        }
        sc.close();
    }
}
