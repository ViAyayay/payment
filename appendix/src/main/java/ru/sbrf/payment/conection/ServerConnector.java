package ru.sbrf.payment.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.client.User;

import java.util.ArrayList;

public interface ServerConnector {
    String getIdentifier();

    ArrayList<Counts> loadCountsList(User user);

    void pay(PaymentParameters paymentParameters);
}
