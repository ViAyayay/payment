package ru.sbrf.java.payment.appendix.common;

import ru.sbrf.java.payment.appendix.conection.ServerConnector;
import ru.sbrf.java.payment.client.Counts;
import ru.sbrf.java.payment.client.User;

import java.util.ArrayList;

public class WebAppendixLoader implements AppendixLoader {
    private ServerConnector connector;

    public WebAppendixLoader(ServerConnector connector) {
        this.connector = connector;
    }

    @Override
    public User GetUser() {
        User user;
        Storage storage = new Storage();
        user = storage.ifHasUser()? storage.getUser(): createUser();
        return user;
    }

    @Override
    public void loadCountList(User user) {
        ArrayList<Counts> list;
        list = connector.loadCountsList(user);
    }

    private User createUser() {
        return null;
    }
}
