package ru.sbrf.payment.conection;

import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;

import java.util.ArrayList;

public interface ServerConnector {
    String getIdentifier();

    ArrayList<Counts> loadCountsList(User user);

    String pay(PaymentParameters paymentParameters);
}
