package ru.sbrf.payment.common;

import ru.sbrf.payment.client.User;

public interface AppendixLoader {

    User GetUser();

    void loadCountList(User user);
}
