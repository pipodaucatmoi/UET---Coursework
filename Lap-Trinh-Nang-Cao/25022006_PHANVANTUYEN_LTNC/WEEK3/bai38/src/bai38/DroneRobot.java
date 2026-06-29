package bai38;

import bai38.skills.*;

public class DroneRobot extends Robot implements Flyable, GPS{

    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(getModelName() + "performing main task");
    }
    @Override
    public void fly() {
        System.out.println(getModelName() + " flying");
    }
    @Override
    public void getCoordiantes() {
        System.out.println(getModelName() + "getting coordinates");
    }
}
