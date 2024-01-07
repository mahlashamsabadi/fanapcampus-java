package ir.dotin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PremiumAccountTest{
    static PremiumAccount premiumAccount1;

    @BeforeEach
    void setUp() {
        premiumAccount1 = new PremiumAccount("7777000011110000","name5",
                5_000_000_000L , LocalDate.now());
    }


    @Test
    void depositInterest() {
        Long balanceBeforeDepositInterest = premiumAccount1.getBalance();
        premiumAccount1.depositInterest();
        assertEquals(premiumAccount1.getBalance() - balanceBeforeDepositInterest , 64_583_333);
    }

}