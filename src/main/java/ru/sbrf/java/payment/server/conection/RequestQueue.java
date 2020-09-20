package ru.sbrf.java.payment.server.conection;

import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.util.LinkedList;

public class RequestQueue<S>{
    LinkedList<S> queue = new LinkedList();

    public void chek(S identifier) throws WrongRequestException {
        if(queue.contains(identifier)){
            throw new WrongRequestException("double " + identifier, identifier.toString());
        }else {
            while(queue.size()>5) queue.remove();
            queue.addLast(identifier);
        }
    }
}
