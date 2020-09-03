package ru.sbrf.java.payment.appendix;


import java.util.ArrayList;

class User  {
    private long phoneNumber;
    private ArrayList<Counts> clientCountsList;

    public User(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Counts> getClientCountsList() {
        return clientCountsList;
    }

}
