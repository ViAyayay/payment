package ru.sbrf.payment.common;

import ru.sbrf.java.payment.appendix.conection.*;
import ru.sbrf.payment.conection.ServerConnector;
import ru.sbrf.payment.conection.WebServerConnector;
import ru.sbrf.payment.operation.Operations;
import ru.sbrf.payment.operation.ToPhonePayment;
import ru.sbrf.java.payment.client.Currency;
import ru.sbrf.java.payment.client.PaymentParameters;
import ru.sbrf.java.payment.client.User;

import java.math.BigDecimal;

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


    @Override
    public void payToPhone(long targetNumber, BigDecimal sum, Currency currency){
        connector.pay(new PaymentParameters()
                                            .setUser(user.GetUserWithoutCounts())
                                            .setCurrency(currency)
                                            .setSum(sum)
                                            .setOperation(Operations.ToPhonePayment)
                                            .setExtraOption(targetNumber)
        );
    }

    public void loadClientCountsList() {
        appLoader.loadCountList(user);
    }
}
