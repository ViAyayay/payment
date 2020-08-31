package ru.sbrf.java.payment.server;

import java.util.ArrayList;

class CountsLoader {
    private Client client;

    public CountsLoader(Client client) {
        this.client = client;
    }

    public static ArrayList getCountList(){
        //обработка информации о клиенте
        return null;
    }

    public void setNewPhoneNumber(long newPhoneNumber) throws IllegalChaneException{
        try {
            //обработка замены номера
        }catch (Exception e){
            throw new IllegalChaneException();
        }
    }
}


