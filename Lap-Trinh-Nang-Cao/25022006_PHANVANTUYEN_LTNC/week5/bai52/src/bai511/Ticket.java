package bai511;

public class Ticket {
    String id;
    String content;
    String timestamp;
    Customer customer;

    public Ticket(String id, String content, String timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}