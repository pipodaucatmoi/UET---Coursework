package bai38;

import bai38.skills.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Robot[] list = new Robot[n];
        for (int i = 0; i < n; i++){
            String input = sc.nextLine();
            // input = [keyRobot] [id] [modelName]
            String[] arr = input.split("\\s+");
            String keyRobot = arr[0];
            int id = Integer.parseInt(arr[1]);
            String modelName = arr[2];

            if (keyRobot.equals("DR")){
                list[i] = new DroneRobot(id, modelName);
            } else if (keyRobot.equals("FR")){
                list[i] = new FishRobot(id, modelName);
            } else {
                list[i] = new AmphibiousRobot(id, modelName);
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++){
            Robot acc1 = list[i];
            acc1.performMainTask();

            if (acc1 instanceof Flyable){
                ((Flyable) acc1).fly();
            }
            if (acc1 instanceof Swimmable) {
                ((Swimmable) acc1).swim();
            }
            if (acc1 instanceof GPS){
                ((GPS) acc1).getCoordiantes();
            }
            System.out.println();
        }
        sc.close();
    }
}
