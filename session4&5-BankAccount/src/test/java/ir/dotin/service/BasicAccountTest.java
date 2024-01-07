package ir.dotin.service;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BasicAccountTest{

    static BasicAccount basicAccount1;
    static BasicAccount basicAccount2;

    @BeforeEach
    void setUp() {
        basicAccount1 = new BasicAccount("1111000011110000","name1",
                500_000_000L , LocalDate.now());
        basicAccount2 = new BasicAccount("2222000022220000","name2",
                1_000_000L , LocalDate.now());
    }

    @Test
    void testWithdraw() {
        Transaction withdrawTransaction = new Transaction(1,"withdraw",10_000L,LocalDate.now(),basicAccount1,basicAccount2);
        Long balanceBeforeWithdraw = basicAccount1.getBalance();
        withdrawTransaction.execute();
        assertEquals(basicAccount1.getTransactionList().get(0).getTransactionId(),1);
        assertEquals(balanceBeforeWithdraw-withdrawTransaction.getAmount() , basicAccount1.getBalance());
    }

    @Test
    void testDeposit() {
        Transaction depositTransaction = new Transaction(1,"deposit",10_000L,LocalDate.now(),basicAccount1,basicAccount2);
        Long balanceBeforeDeposit = basicAccount2.getBalance();
        depositTransaction.execute();
        assertEquals(basicAccount2.getTransactionList().get(0).getTransactionId(),1);
        assertEquals(balanceBeforeDeposit+depositTransaction.getAmount() , basicAccount2.getBalance());
    }

    @Test
    void testGetBalance() {
        Transaction getBalanceTransaction = new Transaction(2, "getBalance",LocalDate.now(),basicAccount1);
        String message = getBalanceTransaction.execute();
        assertEquals(String.format("Your balance is %d",basicAccount1.getBalance()), message);
        System.out.println(Transaction.getAllTransactionList());
    }

    @Test
    void testWithdrawInvalidAmount(){
        Transaction withdrawTransaction = new Transaction(3,"withdraw",110_000_000L,LocalDate.now(),basicAccount1,basicAccount2);
        withdrawTransaction.setAmount(110_000_000L);
        String message = withdrawTransaction.execute();
        assertEquals(basicAccount1.getTransactionList().size() , 0);
        assertEquals(String.format("transaction could not be completed because The amount %d is invalid",
                withdrawTransaction.getAmount()) , message);
    }

    @Test
    void testUnCompletedTransaction(){
        Long balanceBeforeWithdraw = basicAccount1.getBalance();
        Transaction withdrawTransaction = new Transaction(4,"withdraw",110_000L,LocalDate.now(),basicAccount1,basicAccount2);
        withdrawTransaction.execute();
        Transaction depositTransaction = new Transaction(4,"deposit",-110_000L,LocalDate.now(),basicAccount1,basicAccount2);
        depositTransaction.execute();
        assertEquals(basicAccount1.getTransactionList().size(),0);
        assertEquals(basicAccount1.getBalance(),balanceBeforeWithdraw);
        System.out.println(Transaction.getAllTransactionList().size());
    }
}