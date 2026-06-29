package bai34;
import bai32.Animal;
import bai32.Cat;
import bai32.Dog;

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        if (a instanceof Cat){
            a.makeSound();
        } else {
            System.out.println("Day khong phai meo");
        }
    }
}
