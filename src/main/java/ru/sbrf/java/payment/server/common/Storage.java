package ru.sbrf.java.payment.server.common;

import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Storage {
    private static HashMap<Long, ArrayList<Counts>> countsList = new HashMap<>();

    public static ArrayList<Counts> getListFromPhone(long phoneNumber) {
        ArrayList list = countsList.get(phoneNumber);
        if(list == null) throw new WrongRequestException("Client not found. ");
        return list;
    }

    public static void transfer(String countNumber, String otherCountNumber, long sum) {
    }
}
