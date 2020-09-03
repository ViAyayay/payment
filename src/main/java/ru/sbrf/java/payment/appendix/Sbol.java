package ru.sbrf.java.payment.appendix;

class Sbol implements ToPhonePayment {
    private String serverADDR;
    private int serverPort;
    private int protocol;

    private User user;

    public Sbol(String serverADDR, int serverPort, int protocol) {
        this.serverADDR = serverADDR;
        this.serverPort = serverPort;
        this.protocol = protocol;
        AppendixLoader.setAppendix(this);
        user = AppendixLoader.GetUser();
    }


    public void loadClientCountsList() {
        AppendixLoader.GetCountList(user);
    }


    @Override
    public void pay(long targetNumber, long sum, int currency){

    }
}
