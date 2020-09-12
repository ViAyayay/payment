package ru.sbrf.java.payment.client;

public enum Currency {
    RUB(643),
    USD(840),
    EUR(978);

    private int code;

    Currency(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}

