import java.util.Arrays;

final class Transaction{
    private final String transactionId;
    private final double amount;
    private final String timestamp;

    public Transaction(String transactionId, double amount, String timestamp){
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public double getAmount(){
        return this.amount;
    }
    public String toString(){
        return timestamp + " GIAO DICH " + amount + " ID: " + transactionId;
    }
}
class Account{
    private String accountId;
    private double balance;
    private Transaction[] history;
    int count = 0;

    public Account(String accountId, double balance){
        this.accountId = accountId;
        this.balance = balance;
        this.history = new Transaction[10];
    }
    public void addTransaction(Transaction t){
        if (count < history.length){
            history[count] = t;
            count ++;
        }
    }
    public Transaction[] getHistory(){
        return Arrays.copyOf(history, count);
    }
}
public class ImutableobjDeepcopy {
    static void main(String[] args) {
        Account acc1 = new Account("MB001", 1000);
        acc1.addTransaction(new Transaction("MB002",5000,"3-9-2026"));
        System.out.println(acc1.getHistory()[0]);
        Transaction[] view = acc1.getHistory();
        view[0] = null;
        System.out.println(view[0]);

        Transaction[] check = acc1.getHistory();
        if (check[0] != null && check.length > 0){
            System.out.println("VAN GIU NGUYEN");
        } else {
            System.out.println("DU LIEU THAY DOI, NGUY HIEM");
        }
    }
}