package bai38;

import bai38.skills.Flyable;
import bai38.skills.GPS;
import bai38.skills.Swimmable;

public class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {

    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }
    @Override
    public void performMainTask() {
        System.out.println(getModelName() + " performing main task ");
    }
    @Override
    public void fly() {
        System.out.println(getModelName() + " flying ");
    }
    @Override
    public void swim() {
        System.out.println(getModelName() + " swimming ");
    }
    @Override
    public void getCoordiantes() {
        System.out.println(getModelName() + " getting coordinates ");
    }
}
