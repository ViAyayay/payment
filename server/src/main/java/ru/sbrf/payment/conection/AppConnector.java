package ru.sbrf.payment.conection;

import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.exceptions.WrongRequestException;
import ru.sbrf.payment.common.Operator;
import ru.sbrf.payment.common.Storage;

import java.util.ArrayList;
import java.util.Optional;

public class AppConnector <S>  {
    private RequestQueue<S>  queue = new RequestQueue<>();

    public Optional<ArrayList<Counts>> loadCountsList(S identifier, Optional<User> user) {
        try {
            checkRequest(Optional.of(identifier).orElseThrow(WrongRequestException::new));
            return Optional.ofNullable(Storage.getListFromUser(user.get()));
        } catch (WrongRequestException e){
            e.setNumber(identifier.toString());
            throw e;
        }
    }

    public void pay(S identifier, PaymentParameters paymentParameters) { //todo переработать в проверку типа вложенного енума с изменением логики
        try {
            checkRequest(identifier);
            new Operator(paymentParameters, this).pay();
        } catch (WrongRequestException e){
            e.setNumber(identifier.toString());
            throw e;
        }
    }

    private void checkRequest(S identifier) throws WrongRequestException{
        queue.chek(identifier);
    }

    public String getOtherCountByPhone(long targetNumber) {
        return new String();
    }
}
