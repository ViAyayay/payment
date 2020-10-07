package ru.sbrf.java.payment.server.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.client.User;
import ru.sbrf.java.payment.exceptions.WrongRequestException;
import ru.sbrf.java.payment.server.common.Storage;
import ru.sbrf.java.payment.server.common.Validation;

import java.util.ArrayList;
import java.util.Optional;

public class AppConnector <S>  {
    private RequestQueue<S>  queue = new RequestQueue<>();

    public Optional<ArrayList<Counts>> loadCountsList(S identifier, Optional<User> user) {
        try {
            checkRequest(identifier);
            return Optional.ofNullable(Storage.getListFromPhone(user.get()));
        } catch (WrongRequestException e){
            e.setNumber((String)identifier);
            throw e;
        }
    }

    public void pay(S identifier, PaymentParameters paymentParameters) { //todo переработать в проверку типа вложенного енума с изменением логики
        try {
            checkRequest(identifier);
            Validation validation = new Validation(paymentParameters);
            validation.pay(paymentParameters.getSum().get(), getOtherCountByPhone((Long)paymentParameters.getOperation().get().getExtraOption()));
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
