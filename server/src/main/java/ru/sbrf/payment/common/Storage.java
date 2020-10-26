package ru.sbrf.payment.common;

import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.Currency;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.exceptions.WrongRequestException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

public class Storage {
    private static HashMap<Long, ArrayList<Counts>> countsList = new HashMap<>();

    public static void setCountsList(HashMap<Long, ArrayList<Counts>> countsList) {
        Storage.countsList = countsList;
    }

    public static HashMap<Long, ArrayList<Counts>> getCountsList() {
        return countsList;
    }

    public static ArrayList<Counts> getListFromUser(User user) {
        return Optional.ofNullable(countsList.get(user.getPhoneNumber())).orElseThrow(() -> new WrongRequestException("Client not found. "));
    }

    public static Counts getCountByCurrency(User user, Currency currency){
        for(Counts count: getListFromUser(user)){
            if(count.getCurrency() == currency) {
                return count;
            }
        }
        return null;
    }

    public static void workFromCounts(Counts count, Consumer<Counts> consumer){
        consumer.accept(count);
    }


}
