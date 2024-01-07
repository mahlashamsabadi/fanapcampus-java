package ir.dotin.service;

import ir.dotin.controller.Validation;

import java.time.LocalDate;

public class BasicAccount extends BankAccount{

    public BasicAccount(String accountNumber, String ownerName, Long balance, LocalDate accountOpeningDate) {
        super(accountNumber, ownerName, balance, accountOpeningDate);
    }
}
