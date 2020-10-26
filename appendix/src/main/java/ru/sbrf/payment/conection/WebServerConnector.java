package ru.sbrf.payment.conection;

import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.exceptions.WrongRequestException;
import ru.sbrf.payment.conection.AppConnector;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class WebServerConnector implements ServerConnector {
    private AppConnector Server = new AppConnector();

    @Override
    public String getIdentifier() {

        return Long.toHexString((new Date()).getTime());
    }

    @Override
    public ArrayList<Counts> loadCountsList(User user) {
        Optional<User> post = Optional.of(user.GetUserWithoutCounts());
        return (ArrayList<Counts>) Server.loadCountsList(getIdentifier(), post).orElseGet(this::logNullList);
    }

    @Override
    public void pay(PaymentParameters paymentParameters) {
        try {
            Server.pay(getIdentifier(), paymentParameters);
        }catch (WrongRequestException e){

        }
    }

    private ArrayList<Counts> logNullList() {
        //todo логирование;
        return null;
    }
}
