package ru.sbrf.java.payment.appendix.common;

import ru.sbrf.java.payment.client.User;

public class Storage {
    private User user = new User(28706231235L);
//    private ArrayList<Counts> clientCountsList = new ArrayList<>(Arrays.asList(
//            new Counts(123500, Currency.EUR, "564455556645666468871000"),
//            new Counts(3523500, Currency.RUB, "564455550005666468871000")
//    ));

    public boolean ifHasUser(){
        return (user != null);
    }

    public User getUser() {
        return user;
    }
}
