package ru.sbrf.java.payment.client;

public class Counts {
    private long countBalance;
    private final Currency currency;
    private final String countNumber;

    public Counts(long countBalance, Currency currency, String countNumber) {
        this.countBalance = countBalance;
        this.currency = currency;
        this.countNumber = countNumber;
    }

    public long getCountBalance() {
        return countBalance;
    }

    public String getCountNumber() {
        return countNumber;
    }

    public Currency getCurrency() {
        return currency;
    }
}