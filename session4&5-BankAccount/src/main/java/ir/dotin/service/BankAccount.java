package ir.dotin.service;

import ir.dotin.controller.Validation;
import ir.dotin.exception.InvalidAmountException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public abstract class BankAccount {
    private String accountNumber;
    private String ownerName;
    private Long balance;
    private final Long transferLimit = 100_000_000L;
    private LocalDate accountOpeningDate;

    private List<Transaction> transactionList;

    public BankAccount(String accountNumber, String ownerName, Long balance, LocalDate accountOpeningDate) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.accountOpeningDate = accountOpeningDate;
        this.transactionList = new ArrayList<>();
    }

    public void deposit(Long amount) throws InvalidAmountException {
        if(Validation.depositValidation(amount)) {
            this.setBalance(this.getBalance() + amount);
        }
        else {
            throw new InvalidAmountException(String.format("The amount %d is invalid",amount));
        }

    }
    public void withdraw(Long amount) throws InvalidAmountException {
        if(Validation.withdrawValidation(amount , this)) {
            this.setBalance(this.getBalance() - amount);
        }
        else {
            throw new InvalidAmountException(String.format("The amount %d is invalid",amount));
        }

    }

    public LocalDate getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public void setAccountOpeningDate(LocalDate accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getBalance() {
        return balance;
    }
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getTransferLimit() {
        return transferLimit;
    }

}
