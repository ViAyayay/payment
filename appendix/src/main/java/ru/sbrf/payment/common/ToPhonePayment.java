package ru.sbrf.payment.common;

import ru.sbrf.payment.client.Currency;

import java.math.BigDecimal;

public interface ToPhonePayment {

    void payToPhone(long targetNumber, BigDecimal sum, Currency currency);
}
