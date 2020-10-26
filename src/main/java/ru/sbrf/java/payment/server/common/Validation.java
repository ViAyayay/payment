package ru.sbrf.java.payment.server.common;

import lombok.AllArgsConstructor;
import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.math.BigDecimal;

@AllArgsConstructor
public class Validation {
    private Counts count;

    public void pay(BigDecimal sum) {
        if(count.getCountBalance().compareTo(sum) < 0) throw new WrongRequestException("incorrect write-off amount. ");
    }
}
