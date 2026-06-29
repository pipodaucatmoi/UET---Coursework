package bai37;

public abstract class Room {
    int soDem;

    public Room(int soDem) {
        this.soDem = soDem;
    }
    public abstract double getMoney();

}
