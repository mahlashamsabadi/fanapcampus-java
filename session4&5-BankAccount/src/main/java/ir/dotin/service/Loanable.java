package ir.dotin.service;

import ir.dotin.exception.InvalidAmountException;

public interface Loanable {
    public default void takeLoan(Loan loan , BankAccount bankAccount){
        bankAccount.setBalance(bankAccount.getBalance()+loan.getAmount());
    }
    public default void withdrawTheMonthlyInstallmentAmount(Loan loan, BankAccount bankAccount){
        bankAccount.setBalance(bankAccount.getBalance() - loan.calculateMonthlyInstallmentAmount());
    }
}
