package bai37;

public class VipRoom extends Room {
    public static double price = 2000000;

    public VipRoom(int soDem) {
        super(soDem);
    }

    @Override
    public double getMoney() {
        return price * soDem;
    }
}
