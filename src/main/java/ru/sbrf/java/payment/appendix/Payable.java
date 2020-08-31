package ru.sbrf.java.payment.appendix;

import ru.sbrf.java.payment.server.Client;

public interface Payable {

    void pay(Client user, long targetNumber, long sum, int currency);
}
