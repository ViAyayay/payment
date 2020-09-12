package ru.sbrf.java.payment.appendix.common;

import ru.sbrf.java.payment.client.User;

public class Storage {
    private User user = new User(28706231235L);

    public boolean ifHasUser(){
        return (user != null);
    }

    public User getUser() {
        return user;
    }
}
