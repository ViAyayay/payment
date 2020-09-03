package ru.sbrf.java.payment.server;

public class CountsNotFoundException extends Exception{
    public CountsNotFoundException(String message) {
        super(message);
    }
}
