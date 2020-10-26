package ru.sbrf.payment.common;

import ru.sbrf.payment.client.Operations;

public class Main {
    public static void main(String[] args) {
        Operations op = Operations.ToPhonePayment;
        System.out.println(op.toString());
    }
}
