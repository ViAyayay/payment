package ru.sbrf.java.payment.appendix;

import ru.sbrf.java.payment.server.Client;

public class Sbol implements Payable{
    private String serverADDR;
    private int serverPort;
    private int protocol;

    public Sbol(String serverADDR, int serverPort, int protocol) {
        this.serverADDR = serverADDR;
        this.serverPort = serverPort;
        this.protocol = protocol;
    }

    @Override
    public void pay(Client user, long targetNumber, long sum, int currency){

    }
}
