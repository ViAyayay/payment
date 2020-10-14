package ru.sbrf.payment.operation;

import ru.sbrf.java.payment.client.Currency;

import java.math.BigDecimal;

public interface ToPhonePayment {

    void payToPhone(long targetNumber, BigDecimal sum, Currency currency);
}
