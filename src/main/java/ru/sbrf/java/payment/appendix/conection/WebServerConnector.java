package ru.sbrf.java.payment.appendix.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.client.User;
import ru.sbrf.java.payment.exceptions.WrongRequestException;
import ru.sbrf.java.payment.server.conection.AppConnector;

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
        return (ArrayList<Counts>) Server.loadCountsList(getIdentifier(), post).orElse(getNullList());
    }

    @Override
    public void pay(PaymentParameters paymentParameters) {
        try {
            Server.pay(getIdentifier(), paymentParameters);
        }catch (WrongRequestException e){

        }
    }

    private ArrayList<Counts> getNullList() {
        //todo логирование;
        return null;
    }
}
