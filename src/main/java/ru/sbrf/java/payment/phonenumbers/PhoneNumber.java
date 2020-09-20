package ru.sbrf.java.payment.phonenumbers;

public class PhoneNumber{
    private int code;
    private int number;

    public  <T> PhoneNumber(T verifiableNumber) {
        new PhoneVerification(verifiableNumber, this);
    }
}
