package task42;

import task42.skills.CanSwim;

public class Main {
    public static void main(String[] args) {
        Hero acc = new Hero();
        //acc.fight();
        CanSwim accsw = (CanSwim) acc;
        accsw.swim();
        //CanFight accf = (CanFight) acc;
        acc.fight();
    }
}
