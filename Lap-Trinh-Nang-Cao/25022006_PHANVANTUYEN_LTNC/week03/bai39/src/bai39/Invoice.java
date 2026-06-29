package bai39;

public class Invoice implements IPayable{
    String itemName;
    int quantity;
    double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getName() {
        return itemName;
    }

    public String getTypeClass(){
        return "bai39.Invoice";
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }
}
