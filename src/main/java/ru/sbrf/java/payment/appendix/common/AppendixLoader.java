package ru.sbrf.java.payment.appendix.common;

import ru.sbrf.java.payment.client.User;

public interface AppendixLoader {

    User GetUser();

    void loadCountList(User user);
}
