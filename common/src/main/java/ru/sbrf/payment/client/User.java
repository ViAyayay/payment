package ru.sbrf.payment.client;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class User  {
    private long phoneNumber;
    private ArrayList<Counts> clientCountsList ;

    public User(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUserWithoutCounts(){
        return new User(phoneNumber);
    }
}
