package ir.dotin.service;

import java.math.BigInteger;
import java.time.LocalDate;

public class BusinessAccount extends BankAccount implements Loanable{
    private final Long transferLimit = 5_000_000_000L;

    public BusinessAccount(String accountNumber, String ownerName, Long balance, LocalDate accountOpeningDate) {
        super(accountNumber, ownerName, balance, accountOpeningDate);
    }

    @Override
    public Long getTransferLimit() {
        return transferLimit;
    }

}
