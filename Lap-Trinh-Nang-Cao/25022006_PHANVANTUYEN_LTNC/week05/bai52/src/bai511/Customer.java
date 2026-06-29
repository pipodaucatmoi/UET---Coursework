package bai511;

public class Customer {
    String id;
    String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }

    public String getName(){
        return name;
    }
}
