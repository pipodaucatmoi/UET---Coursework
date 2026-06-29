public class BankAccount {
    private String accountNumber;
    private String ownerNumber;
    private double balance;

    public BankAccount(String accountNumber, String ownerNumber){
    this.accountNumber = accountNumber;
    this.ownerNumber = ownerNumber;
    this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerNumber, double balance){
        this.accountNumber = accountNumber;
        this.ownerNumber = ownerNumber;
        if (balance < 0){
            System.out.println("So tien be hon 0");
            this.balance = 0.0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("So tien khong hop le");
        } else {
            this.balance = this.balance + amount;
            System.out.println("Nap thanh cong " + amount + " vao tai khoan. So du hien tai " + this.balance + " VND");
        }
    }

    public boolean withdraw(double amount){
        if (amount <= 0){
            System.out.println("So tien khong kha dung");
            return false;
        } else if (amount > this.balance){
            System.out.println("So du khong du");
            return false;
        } else {
            this.balance = this.balance - amount;
            System.out.println("Rut thanh cong " + amount + " VND. So du hien tai " + this.balance + " VND");
            return true;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    static void main(String[] args) {
        BankAccount acc1 = new BankAccount("123", "ronaldo");
        BankAccount acc2 = new BankAccount("234", "messsi", 10000);
        acc1.deposit(-100);
        acc1.deposit(10000);
        acc1.withdraw(5000);
        acc2.deposit(10000);
        acc2.withdraw(20000);
    }
}