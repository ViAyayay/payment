package ru.sbrf.java.payment.server.common;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Validation {
    private Long phoneNumber;
    private ArrayList<Counts> countsList;
    private BigDecimal balance;
    private String countNumber;

    public Validation(PaymentParameters paymentParameters) {
        this.phoneNumber = paymentParameters.getUser().get().getPhoneNumber();
        countsList = Storage.getListFromPhone(paymentParameters.getUser().get());
        setCurrency(paymentParameters.getCurrency().get());
    }

    public void setCurrency(Currency currency) {
        for(Counts c: countsList){
            if(c.getCurrency() == currency) {
                balance = c.getCountBalance();
                countNumber = c.getCountNumber();
            }
        }
        if (countNumber==null) throw new WrongRequestException("Wrong currency ");
    }

    public void pay(BigDecimal sum, String otherCountNumber) {
        if(balance.compareTo(sum) < 0) throw new WrongRequestException("incorrect write-off amount. ");
        Storage.transfer(countNumber, otherCountNumber, sum);
    }
}
