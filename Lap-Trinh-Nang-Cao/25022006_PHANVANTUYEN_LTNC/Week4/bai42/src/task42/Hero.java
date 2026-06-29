package task42;
import task42.skills.CanFly;
import task42.skills.CanSwim;

public class Hero extends ActionCharacter implements CanSwim, CanFly {
    public String getNameClass(){
        return "Hero";
    }
    @Override
    public void fly() {
        System.out.println(getNameClass() + " is flying");
    }
    @Override
    public void swim() {
        System.out.println(getNameClass() + " is swimming");
    }
//    public void fight(){
//        System.out.println(getNameClass() + " is fighting");
//    }
}
