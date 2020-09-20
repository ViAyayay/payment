package ru.sbrf.java.payment.server.common;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.User;
import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static HashMap<Long, ArrayList<Counts>> countsList = new HashMap<>();

    public static ArrayList<Counts> getListFromPhone(User user) {
        ArrayList list = countsList.get(user.getPhoneNumber());
        if(list == null) throw new WrongRequestException("Client not found. ");
        return list;
    }

    public static void transfer(String countNumber, String otherCountNumber, BigDecimal sum) {
    }
}
