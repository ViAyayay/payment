package ru.sbrf.java.payment.appendix;

class Counts {
    private long countBalance;
    private final int currency;
    private final long countNumber;

    public Counts(long countBalance, short currency, long countNumber) {
        this.countBalance = countBalance;
        this.currency = currency;
        this.countNumber = countNumber;
    }

    public long getCountNumber() {
        return countNumber;
    }

    public long getCountBalance() {
        return countBalance;
    }

    public void setCountBalance(long countBalance) {
        this.countBalance = countBalance;
    }

    public int getCurrency() {
        return currency;
    }
}