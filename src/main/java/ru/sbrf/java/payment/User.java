package ru.sbrf.java.payment;

import ru.sbrf.java.payment.appendix.Payable;

public class User  {
    private long phoneNumber;
    private float countBalance;
    private int currency;

    public User(long phoneNumber, float countBalance, short currency) {
        this.phoneNumber = phoneNumber;
        this.countBalance = countBalance;
        this.currency = currency;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountBalance(float countBalance) {
        this.countBalance = countBalance;
    }

    public void setCurrency(short currency) {
        this.currency = currency;
    }


}
