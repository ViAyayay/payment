package ru.sbrf.java.payment.appendix.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.PaymentParameters;
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
    public void payToPhone(PaymentParameters paymentParameters, long targetNumber) {
        try {
            Server.payToPhone(getIdentifier(), paymentParameters, targetNumber);
        }catch (WrongRequestException e){

        }
    }
}
