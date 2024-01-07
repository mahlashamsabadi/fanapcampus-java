package ir.dotin.controller;

import ir.dotin.service.BankAccount;

public class Validation {

    public static boolean depositValidation(Long amount) {
        return amount > 0;
    }

    public static boolean withdrawValidation(Long amount, BankAccount bankAccount) {
        return amount > 0 && amount <= bankAccount.getTransferLimit() && amount < bankAccount.getBalance();
    }
}
