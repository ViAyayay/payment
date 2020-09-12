package ru.sbrf.java.payment.appendix.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.User;
import ru.sbrf.java.payment.exceptions.WrongRequestException;
import ru.sbrf.java.payment.server.conection.AppConnector;

import java.util.ArrayList;
import java.util.Date;

public class WebServerConnector implements ServerConnector {
    private AppConnector Server = new AppConnector();

    @Override
    public String getIdentifier() {
        return Long.toHexString((new Date()).getTime());
    }

    @Override
    public ArrayList<Counts> loadCountsList(User user) {
        try {
            long phoneNumber = user.getPhoneNumber();
            return Server.loadCountsList(getIdentifier(), phoneNumber);
        }catch (WrongRequestException e){
            return null;
        }
    }

    @Override
    public void payToPhone(User user, long targetNumber, long sum, Currency currency) {
        try {
            long phoneNumber = user.getPhoneNumber();
            Server.payToPhone(getIdentifier(), phoneNumber, targetNumber, sum, currency);
        }catch (WrongRequestException e){

        }
    }
}
