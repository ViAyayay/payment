package ru.sbrf.java.payment.appendix.common;

import ru.sbrf.java.payment.appendix.conection.*;
import ru.sbrf.java.payment.appendix.operation.ToPhonePayment;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.client.User;

import java.math.BigDecimal;
import java.util.Optional;

class Sbol implements ToPhonePayment {
    private String serverADDR;
    private int serverPort;
    private int protocol;

    private AppendixLoader appLoader;
    private User user;
    private ServerConnector connector = new WebServerConnector();



    public Sbol(String serverADDR, int serverPort, int protocol) {
        this.serverADDR = serverADDR;
        this.serverPort = serverPort;
        this.protocol = protocol;
        this.appLoader = new WebAppendixLoader(connector);
        user = appLoader.GetUser();
        loadClientCountsList();
    }


    public void loadClientCountsList() {
        appLoader.loadCountList(user);
    }

    @Override
    public void payToPhone(long targetNumber, BigDecimal sum, Currency currency){
        connector.payToPhone(new PaymentParameters(Optional.of(user.GetUserWithoutCounts()), Optional.empty(), Optional.of(currency), Optional.of(sum)), targetNumber);
    }
}
