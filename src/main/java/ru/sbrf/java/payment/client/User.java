package ru.sbrf.java.payment.client;

import java.util.ArrayList;

public class User  {
    private long phoneNumber;
    private ArrayList<Counts> clientCountsList ;

    public User(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
