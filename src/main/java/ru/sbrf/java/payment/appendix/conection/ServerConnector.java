package ru.sbrf.java.payment.appendix.conection;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.User;

import java.util.ArrayList;

public interface ServerConnector {
    String getIdentifier();

    ArrayList<Counts> loadCountsList(User user);

    void payToPhone(User user, long targetNumber, long sum, Currency currency);
}
