package ru.sbrf.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Counts {
    private BigDecimal countBalance;
    private final Currency currency;
    private final String countNumber;
}