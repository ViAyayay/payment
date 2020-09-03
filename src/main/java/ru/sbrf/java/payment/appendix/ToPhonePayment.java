package ru.sbrf.java.payment.appendix;

public interface ToPhonePayment {

    void pay(long targetNumber, long sum, int currency);
}
