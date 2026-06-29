package bai39;

public abstract class Staff implements IPayable{
    String id, name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String id() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public abstract String getTypeClass();
    public abstract double getPaymentAmount();
}
