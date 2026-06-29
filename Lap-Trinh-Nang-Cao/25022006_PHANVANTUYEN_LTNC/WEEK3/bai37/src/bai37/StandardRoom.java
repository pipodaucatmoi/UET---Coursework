package bai37;

public class StandardRoom extends Room{
    public static double price = 500000;

    public StandardRoom(int soDem) {
        super(soDem);
    }

    @Override
    public double getMoney() {
        if (soDem > 3){
            return price * soDem * 0.95;
        } else {
            return price * soDem;
        }
    }
}
