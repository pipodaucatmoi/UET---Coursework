package bai83;

public class Main {
    public static void main(String[] args) {
        Vehicle myBike = new MotorBike("29A1-123.45", "Honda Wave");
        Vehicle myCar = new Car("30G-999.99", "Toyota Camry");
        Vehicle myEV = new ElectricCar("51H-888.88", "VinFast VF8");

        System.out.println(myBike.getInfo());
        System.out.println(myCar.getInfo());
        System.out.println(myEV.getInfo());
    }
}
