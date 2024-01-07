package ir.dotin.service;

import java.time.LocalDate;

public interface InvestmentCapable {
    public default Long calculateMonthlyInterest(BankAccount bankAccount){
        LocalDate accountOpeningDate = bankAccount.getAccountOpeningDate();
        int numberOfDays = accountOpeningDate.getMonth().length(accountOpeningDate.isLeapYear());
        return Double.valueOf((numberOfDays * (Bank.getBankInstance().getInterestRate()/100) * bankAccount.getBalance()) / 360).longValue();
    }
}
