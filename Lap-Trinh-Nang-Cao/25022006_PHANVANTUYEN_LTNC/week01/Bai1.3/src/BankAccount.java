//Hãy chỉ ra đâu là trạng thái, hành vi, định danh của đối tượng trong đoạn mã dưới đây

public class BankAccount {
    // 3 trang thai
    private String accountNumber;
    private String ownerName;
    private double balance = 0.0;

    public void openAccount(String accNum, String owner) {
        this.accountNumber = accNum;
        this.ownerName = owner;
    }
//hanhvi
    public void deposit(double amount) {
        this.balance += amount;
    }
//hanhvi
    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //dinh danh myAccount
        BankAccount myAccount = new BankAccount();
        myAccount.openAccount("101202303", "Nguyen Van A");
        myAccount.deposit(500.0);
        myAccount.withdraw(150.0);
    }
}
