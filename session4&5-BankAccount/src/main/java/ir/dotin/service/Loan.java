package ir.dotin.service;

public class Loan {
    private final String name;
    private final Long amount;
    private final Integer numberOfMonthlyInstallment;
    private final Double annualInterestRate;


    public Loan(String name, Long amount, Integer numberOfMonthlyInstallment, Double annualInterestRate) {
        this.name = name;
        this.amount = amount;
        this.numberOfMonthlyInstallment = numberOfMonthlyInstallment;
        this.annualInterestRate = annualInterestRate;
    }

    public Long calculateMonthlyInstallmentAmount(){
        Double a =(this.amount*this.annualInterestRate*(1+this.numberOfMonthlyInstallment))/ 2400 ;
        Double b = (this.amount+a)/this.numberOfMonthlyInstallment ;
        return b.longValue();
    }
    public String getName() {
        return name;
    }
    
    public Long getAmount() {
        return amount;
    }

    public Integer getNumberOfMonthlyInstallment() {
        return numberOfMonthlyInstallment;
    }


    public Double getAnnualInterestRate() {
        return annualInterestRate;
    }

}
