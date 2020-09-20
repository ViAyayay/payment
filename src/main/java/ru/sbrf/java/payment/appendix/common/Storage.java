package ru.sbrf.java.payment.appendix.common;

import lombok.Getter;
import lombok.Setter;
import ru.sbrf.java.payment.client.User;

@Getter
@Setter
public class Storage {
    private User user = new User(28706231235L);

    public boolean ifHasUser(){
        return (user != null);
    }
}
