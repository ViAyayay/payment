package ru.sbrf.java.payment.server.common;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.util.ArrayList;

public class Validation {
    private Long phoneNumber;
    private ArrayList<Counts> countsList;
    private Long balance;
    private String countNumber;

    public Validation(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        countsList = Storage.getListFromPhone(phoneNumber);
    }

    public void setCurrency(Currency currency) {
        for(Counts c: countsList){
            if(c.getCurrency() == currency) {
                balance = c.getCountBalance();
                countNumber = c.getCountNumber();
            }
        }
    }

    public void pay(long sum, String otherCountNumber) {
        if(balance < sum) throw new WrongRequestException("incorrect write-off amount. ");
        Storage.transfer(countNumber, otherCountNumber, sum);
    }
}
