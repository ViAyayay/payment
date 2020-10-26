package ru.sbrf.payment.conection.service;


import org.springframework.stereotype.Service;
import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.conection.RequestQueue;
import ru.sbrf.payment.exceptions.WrongRequestException;
import ru.sbrf.payment.common.Operator;
import ru.sbrf.payment.common.Storage;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServerHandler<S>  {
    private RequestQueue<S> queue;

    public ArrayList<Counts> loadCountsList(S identifier, User user) {
        try {
            checkRequest(Optional.of(identifier).orElseThrow(WrongRequestException::new));
            return Storage.getListFromUser(Optional.of(user).orElseThrow(() ->new WrongRequestException("user field empty")));
        } catch (WrongRequestException e){
            e.setNumber(identifier.toString());
            throw e;
        }
    }

    public void pay(S identifier, PaymentParameters paymentParameters, String response) {
        try {
            checkRequest(identifier);
            response = "запрос в обработке.";
            new Operator(paymentParameters, this).pay();
            response = String.format("запрос по операции %S выполнен", paymentParameters.getOperation());
        } catch (WrongRequestException e){
            response = "запрос не выполнен. причина: " + e.getMessage();
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
