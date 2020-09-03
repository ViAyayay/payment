package ru.sbrf.java.payment.appendix;

import java.util.ArrayList;

public class AppendixLoader {
    private static Sbol appendix;


    public static void setAppendix(Sbol sbol) {
        appendix = sbol;
    }

    public static User GetUser() {
        User user = null;
            //загрузка/создание пользователья
        return user;
    }

    public static void GetCountList(User user) {
        ArrayList<Counts> countsList;
        ArrayList loaderList;
        countsList = user.getClientCountsList();
            //загрузка листа
        countsList = null;
    }
}
