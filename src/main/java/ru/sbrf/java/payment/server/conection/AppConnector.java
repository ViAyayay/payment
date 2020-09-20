package ru.sbrf.java.payment.server.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.client.User;
import ru.sbrf.java.payment.exceptions.WrongRequestException;
import ru.sbrf.java.payment.server.common.Storage;
import ru.sbrf.java.payment.server.common.Validation;

import java.util.ArrayList;

public class AppConnector<S>  {
    private RequestQueue<S> queue = new RequestQueue<>();

    public ArrayList<Counts> loadCountsList(S identifier, User user) {
        try {
            checkRequest(identifier);
            return Storage.getListFromPhone(user);
        } catch (WrongRequestException e){
            e.setNumber((String)identifier);
            throw e;
        }
    }

    public void payToPhone(S identifier, PaymentParameters paymentParameters, long targetNumber) {
        try {
            checkRequest(identifier);
            Validation validation = new Validation(paymentParameters);
            validation.pay(paymentParameters.getSum().get(), getOtherCountByPhone(targetNumber));
        } catch (WrongRequestException e){
            e.setNumber((String)identifier);
            throw e;
        }
    }

    private void checkRequest(S identifier) throws WrongRequestException{
        queue.chek(identifier);
    }

    private String getOtherCountByPhone(long targetNumber) {
        return new String();
    }
}
