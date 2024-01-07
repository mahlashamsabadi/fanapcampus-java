package ir.dotin.service;

import ir.dotin.exception.InvalidAmountException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Integer transactionId;
    private String transactionType;
    private Long amount;
    private LocalDate transactionDate;
    private BankAccount fromAccount;
    private BankAccount toAccount;
    private static List<Transaction> allTransactionList = new ArrayList<>();

    public Transaction(Integer transactionId, String transactionType, Long amount, LocalDate transactionDate, BankAccount fromAccount, BankAccount toAccount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Transaction(Integer transactionId, String transactionType, LocalDate transactionDate, BankAccount fromAccount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.fromAccount = fromAccount;
    }

    public Transaction() {
    }

    public BankAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(BankAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    public BankAccount getToAccount() {
        return toAccount;
    }

    public void setToAccount(BankAccount toAccount) {
        this.toAccount = toAccount;
    }

    public static List<Transaction> getAllTransactionList() {
        return allTransactionList;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }


    public String execute() {
        String message = "";
        try {
            switch (this.transactionType) {
                case "withdraw":
                    this.fromAccount.withdraw(this.amount);
                    this.fromAccount.getTransactionList().add(this);
                    message = String.format("The amount %d withdrawn", this.amount);
                    break;
                case "deposit":
                    this.toAccount.deposit(this.amount);
                    this.toAccount.getTransactionList().add(this);
                    message = String.format("The amount %d deposited", this.amount);
                    break;
                case "getBalance":
                    message = String.format("Your balance is %d", this.fromAccount.getBalance());
            }
            allTransactionList.add(this);
            return message;
        } catch (InvalidAmountException e) {
            message = "transaction could not be completed because " + e.getMessage();
            this.rollback();
        }
        return message;
    }

    public void rollback() {
        Transaction transactionToRollback = findTransactionById(this.transactionId);
        if (transactionToRollback != null) {
            BankAccount account = transactionToRollback.fromAccount;
            account.setBalance(account.getBalance() + transactionToRollback.amount);
            account.getTransactionList().remove(transactionToRollback);
            allTransactionList.remove(transactionToRollback);
        }
    }

    public static Transaction findTransactionById(int id) {
        for (Transaction t : allTransactionList) {
            if (t.transactionId == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
