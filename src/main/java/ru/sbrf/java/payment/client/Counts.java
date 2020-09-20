package ru.sbrf.java.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Counts {
    private BigDecimal countBalance;
    private final Currency currency;
    private final String countNumber;
}