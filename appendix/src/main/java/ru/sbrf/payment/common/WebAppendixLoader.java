package ru.sbrf.payment.common;

import ru.sbrf.payment.conection.ServerConnector;
import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.User;

import java.util.Optional;

public class WebAppendixLoader implements AppendixLoader {
    private ServerConnector connector;

    public WebAppendixLoader(ServerConnector connector) {
        this.connector = connector;
    }

    @Override
    public User GetUser() {
        Storage storage = new Storage();
        return Optional.of(storage.getUser())
                                    .orElseGet(() -> createUser(storage));
    }

    @Override
    public void loadCountList(User user) {
        user.setClientCountsList(connector.loadCountsList(user));
    }

    private User createUser(Storage storage) {
        return null; //todo
    }
}
