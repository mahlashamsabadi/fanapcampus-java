package ir.dotin.service;

public class Bank {
    private String name;
    private Double interestRateInPercent;
    private static Bank bankInstance = null;
    private Bank(String name, Double interestRateInPercent) {
        this.name = name;
        this.interestRateInPercent = interestRateInPercent;
    }

    public static Bank getBankInstance(){
        if (bankInstance == null){
            bankInstance = new Bank("Fanap-Campus" , 15.0);
        }
        return bankInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInterestRate() {
        return interestRateInPercent;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRateInPercent = interestRate;
    }
}
