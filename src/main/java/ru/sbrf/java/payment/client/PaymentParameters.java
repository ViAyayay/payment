package ru.sbrf.java.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class PaymentParameters {
    private Optional<User> user;
    private Optional<String> targetCountNumber;
    private Optional<Currency> currency;
    private Optional<BigDecimal> sum;



}
