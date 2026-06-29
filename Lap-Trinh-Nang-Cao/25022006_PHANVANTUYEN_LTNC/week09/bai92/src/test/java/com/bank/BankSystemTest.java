package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BankSystemTest {
    @Test
    void testWithdrawSuccess() {
        Main_bai2 bank = new Main_bai2();
        bank.withdraw(100.0);
        assertEquals(900.0, bank.getBalance(), "So du phai con lai 900 sau khi rut 100");
    }
}