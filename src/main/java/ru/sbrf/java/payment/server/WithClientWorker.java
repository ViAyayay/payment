package ru.sbrf.java.payment.server;


import java.util.ArrayList;

public class WithClientWorker implements ClientLoader{
    private long phoneNumber;

    public WithClientWorker(long phoneNumber) {
        if(verificationPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public boolean verificationPhoneNumber(long phoneNumber) {
        try{
            //проверка номера
            return true;
        }catch (Exception ex) {
            //обработка исключения
            return false;
        }
    }

    @Override
    public ArrayList getCountsList() throws CountsNotFoundException {
        ArrayList list = null;
        try{
            //проверка счетов
        }catch (Exception ex) {
            throw new CountsNotFoundException("Loading counts problem: " + ex.getStackTrace());
        }
        return list;
    }

    @Override
    public long setPhoneNumber(long newPhoneNumber) throws IllegalChaneException {

        try {
            //попытка изменить номер телефона
            this.phoneNumber = phoneNumber;
        } catch (Exception ex){
            throw new IllegalChaneException("Loading counts problem: " + ex.getStackTrace());
        }
        return phoneNumber;
    }
}

