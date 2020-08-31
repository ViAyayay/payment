package ru.sbrf.java.payment.server;

import java.util.ArrayList;

public class Client {
    private long phoneNumber;
    private ArrayList<Counts> clientCountsList;

    public Client(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        CountsLoader loader = new CountsLoader(this);
        clientCountsList = loader.getCountList();
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(long phoneNumber) { //ради Exception
        CountsLoader loader = new CountsLoader(this);
        try {
            loader.setNewPhoneNumber(phoneNumber);
            this.phoneNumber = phoneNumber;
            return true;
        } catch (IllegalChaneException e){
            return false;
        }
    }

    public ArrayList<Counts> getClientCountsList() {
        return clientCountsList;
    }


}

