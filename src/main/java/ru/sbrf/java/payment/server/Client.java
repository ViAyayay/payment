package ru.sbrf.java.payment.server;

import java.util.LinkedList;

public class Client {
    private long phoneNumber;
    private LinkedList<Counts> clientCountsList;

    public Client(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LinkedList<Counts> getClientCountsList() {
        return clientCountsList;
    }
}

class Counts{
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
