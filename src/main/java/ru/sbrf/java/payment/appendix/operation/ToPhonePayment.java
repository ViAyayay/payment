package ru.sbrf.java.payment.appendix.operation;

import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.User;

public interface ToPhonePayment {

    void payToPhone(long targetNumber, long sum, Currency currency);
}
