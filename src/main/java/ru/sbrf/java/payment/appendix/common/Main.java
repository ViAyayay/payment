package ru.sbrf.java.payment.appendix.common;

import ru.sbrf.java.payment.appendix.operation.Operations;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Operations op = Operations.ToPhonePayment;
        System.out.println(op.toString());
    }
}
