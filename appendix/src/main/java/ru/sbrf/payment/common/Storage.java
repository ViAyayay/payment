package ru.sbrf.payment.common;

import lombok.Getter;
import lombok.Setter;
import ru.sbrf.java.payment.client.User;

@Getter
@Setter
public class Storage {
    private User user = new User(8706231235L);

    public boolean ifHasUser(){
        return (user != null);
    }
}
