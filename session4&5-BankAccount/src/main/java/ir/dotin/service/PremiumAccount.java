package ir.dotin.service;

import ir.dotin.exception.InvalidAmountException;

import java.time.LocalDate;

public class PremiumAccount extends BankAccount implements Loanable , InvestmentCapable{

    public PremiumAccount(String accountNumber, String ownerName, Long balance, LocalDate accountOpeningDate) {
        super(accountNumber, ownerName, balance, accountOpeningDate);
    }

    public void depositInterest() {
        this.setBalance(this.getBalance()+calculateMonthlyInterest(this));
    }
}
