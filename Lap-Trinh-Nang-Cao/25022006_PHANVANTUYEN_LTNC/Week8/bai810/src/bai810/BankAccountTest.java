package bai810;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456789", "Nguyen Van A", 500.0);
    }

    @Test
    public void testDeposit_EP_ValidAmount() {
        account.deposit(200.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    public void testDeposit_EP_InvalidAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
        assertEquals("Số tiền nạp phải lớn hơn 0.", exception.getMessage());
    }

    @Test
    public void testDeposit_BVA_Boundaries() {
        // min- và min đều ném ngoại lệ
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-0.01));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));

        // min+ nạp thành công
        account.deposit(0.01);
        assertEquals(500.01, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_EP_InvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    @Test
    public void testWithdraw_EP_ValidAmount() {
        assertTrue(account.withdraw(200.0));
        assertEquals(300.0, account.getBalance());
    }

    @Test
    public void testWithdraw_EP_AmountGreaterThanBalance() {
        assertFalse(account.withdraw(600.0));
        assertEquals(500.0, account.getBalance()); // Số dư phải được bảo toàn
    }

    @Test
    public void testWithdraw_BVA_ZeroBoundaries() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-0.01));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));

        assertTrue(account.withdraw(0.01));
        assertEquals(499.99, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_BVA_BalanceBoundaries() {
        // Test với các giá trị xoay quanh mốc 500

        // max- (499.99)
        BankAccount acc1 = new BankAccount("1", "User 1", 500.0);
        assertTrue(acc1.withdraw(499.99));
        assertEquals(0.01, acc1.getBalance(), 0.001);

        // max (500.0)
        BankAccount acc2 = new BankAccount("2", "User 2", 500.0);
        assertTrue(acc2.withdraw(500.0));
        assertEquals(0.0, acc2.getBalance(), 0.001);

        // max+ (500.01)
        BankAccount acc3 = new BankAccount("3", "User 3", 500.0);
        assertFalse(acc3.withdraw(500.01));
        assertEquals(500.0, acc3.getBalance(), 0.001);
    }


    @Test
    public void testConsistencyFlow() {
        // 1. Số dư ban đầu là 0
        BankAccount consistencyAccount = new BankAccount("9999", "Test User", 0.0);
        assertEquals(0.0, consistencyAccount.getBalance());

        // 2. Nạp 500
        consistencyAccount.deposit(500.0);
        assertEquals(500.0, consistencyAccount.getBalance());

        // 3. Rút 200 (thành công)
        assertTrue(consistencyAccount.withdraw(200.0));
        assertEquals(300.0, consistencyAccount.getBalance());

        // 4. Rút 400 (thất bại)
        assertFalse(consistencyAccount.withdraw(400.0));

        // 5. Kiểm tra số dư cuối phải đúng bằng 300
        assertEquals(300.0, consistencyAccount.getBalance());
    }
}
