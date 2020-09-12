package ru.sbrf.java.payment.server.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.exceptions.WrongRequestException;
import ru.sbrf.java.payment.server.common.Storage;
import ru.sbrf.java.payment.server.common.Validation;

import java.util.ArrayList;

public class AppConnector<S>  {
    private RequestQueue<S> queue = new RequestQueue<>();

    public ArrayList<Counts> loadCountsList(S identifier, long phoneNumber) {
        try {
            checkRequest(identifier);
            return Storage.getListFromPhone(phoneNumber);
        } catch (WrongRequestException e){
            throw new WrongRequestException(e.getMessage(), (String)identifier);
        }
    }

    public void payToPhone(S identifier, long phoneNumber, long targetNumber, long sum, Currency currency) {
        try {
            checkRequest(identifier);
            Validation validation = new Validation(phoneNumber);
            validation.setCurrency(currency);
            validation.pay(sum, getOtherCountByPhone(targetNumber));
        } catch (WrongRequestException e){
            throw new WrongRequestException(e.getMessage(), (String)identifier);
        }
    }

    private void checkRequest(S identifier) throws WrongRequestException{
        queue.chek(identifier);
    }

    private String getOtherCountByPhone(long targetNumber) {
        return new String();
    }
}