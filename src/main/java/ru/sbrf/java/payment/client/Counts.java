package ru.sbrf.java.payment.client;

import java.math.BigDecimal;

public class Counts {
    private BigDecimal countBalance;
    private final Currency currency;
    private final String countNumber;

    public Counts(BigDecimal countBalance, Currency currency, String countNumber) {
        this.countBalance = countBalance;
        this.currency = currency;
        this.countNumber = countNumber;
    }

    public BigDecimal getCountBalance() {
        return countBalance;
    }

    public String getCountNumber() {
        return countNumber;
    }

    public Currency getCurrency() {
        return currency;
    }
}