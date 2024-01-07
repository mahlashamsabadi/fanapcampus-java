package ir.dotin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class BusinessAccountTest {
    static BusinessAccount businessAccount1;
    static BusinessAccount businessAccount2;
    static Loan loan;

    @BeforeEach
    void setUp() {
        businessAccount1 = new BusinessAccount("55555000011110000","name3",
                5_000_000_000L , LocalDate.now());
        businessAccount2 = new BusinessAccount("66666000022220000","name4",
                1_000_000_000L , LocalDate.now());
        loan = new Loan("Housing",5_000_000_000L,36,15.0);

    }


    @Test
    void testWithdrawWithBusinessLimitation() {
        Transaction withdrawTransaction = new Transaction(1,"withdraw",1_000_000_000L,LocalDate.now(),businessAccount1,businessAccount2);
        Long balanceBeforeWithdraw = businessAccount1.getBalance();
        withdrawTransaction.execute();
        assertEquals(businessAccount1.getTransactionList().get(0).getTransactionId(),1);
        assertEquals(balanceBeforeWithdraw- withdrawTransaction.getAmount() , businessAccount1.getBalance());
    }

    @Test
    void takeLoan() {
        Long balanceBeforeLoan = businessAccount1.getBalance();
        businessAccount1.takeLoan(loan,businessAccount1);
        assertEquals(balanceBeforeLoan+loan.getAmount(),businessAccount1.getBalance());
    }

    @Test
    void withdrawTheMonthlyInstallmentAmount() {
        businessAccount1.takeLoan(loan,businessAccount1);
        Long balanceBeforePayingInstallment = businessAccount1.getBalance();
        businessAccount1.withdrawTheMonthlyInstallmentAmount(loan,businessAccount1);
        assertEquals(balanceBeforePayingInstallment - businessAccount1.getBalance() , 17_100_694L);
    }

}