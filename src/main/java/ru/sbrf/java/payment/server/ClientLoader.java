package ru.sbrf.java.payment.server;

import java.util.ArrayList;

public interface ClientLoader {

    boolean verificationPhoneNumber(long phoneNumber);

    ArrayList getCountsList() throws CountsNotFoundException;

    long setPhoneNumber(long newPhoneNumber) throws IllegalChaneException;

}
