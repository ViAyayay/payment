package ru.sbrf.payment.conection;

import org.springframework.stereotype.Service;
import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;
//import ru.sbrf.payment.conection.AppConnector;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class WebServerConnector implements ServerConnector {
//    private AppConnector Server = new AppConnector();

    @Override
    public String getIdentifier() {

        return Long.toHexString((new Date()).getTime());
    }

    @Override
    public ArrayList<Counts> loadCountsList(User user) {

        return (ArrayList<Counts>) user.getClientCountsList();
    }

    @Override
    public String pay(PaymentParameters paymentParameters) {

        return new String("");
    }

    private ArrayList<Counts> logNullList() {
        //todo логирование;
        return null;
    }
}
