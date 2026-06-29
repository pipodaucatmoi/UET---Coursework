package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp chính điều hành hệ thống ngân hàng - Bài tập 2.
 */
public class Main_bai2 {
    private static final Logger logger = LoggerFactory.getLogger(Main_bai2.class);

    private double balance = 1000.0;

    /**
     * Phương thức rút tiền có ghi log đầy đủ.
     *
     * @param amount Số tiền khách hàng muốn rút.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            logger.warn("Cảnh báo: Số tiền rút không hợp lệ: {}", amount);
            return;
        }

        if (amount > balance) {
            logger.error("Lỗi giao dịch: Số dư không đủ (Hiện có: {}, Yêu cầu: {})", balance, amount);
        } else {
            balance -= amount;
            logger.info("Giao dịch thành công: Đã rút {}. Số dư mới: {}", amount, balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Hàm chạy chương trình chính.
     */
    public static void main(String[] args) {
        logger.info("--- Khởi động hệ thống BankSystem (Bài 2) ---");
        Main_bai2 bank = new Main_bai2();

        bank.withdraw(200.0);  // INFO
        bank.withdraw(1500.0); // ERROR
        bank.withdraw(-50.0);  // WARN

        logger.info("--- Kết thúc phiên giao dịch ---");
    }
}