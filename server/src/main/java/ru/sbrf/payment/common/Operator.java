package ru.sbrf.payment.common;

import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.exceptions.WrongRequestException;
import ru.sbrf.payment.conection.AppConnector;
import ru.sbrf.payment.client.Operations;

import java.util.Optional;

public class Operator {
    private PaymentParameters paymentParameters;
    private AppConnector connector;
    private Counts count;

    public Operator(PaymentParameters paymentParameters, AppConnector connector) {
        this.paymentParameters = paymentParameters;
        this.connector = connector;
        this.count = Optional.ofNullable(Storage.getCountByCurrency(paymentParameters.getUser(), paymentParameters.getCurrency())).orElseThrow(() -> new WrongRequestException("Wrong currency "));
    }

    public void pay() {

        Validation validation = new Validation(count);
        validation.pay(paymentParameters.getSum());
        switch (paymentParameters.getOperation()){
            case Operations.ToPhonePayment: {
                String targetCounts = connector.getOtherCountByPhone(paymentParameters.getUser().getPhoneNumber());
                Storage.workFromCounts(count, T -> T.setCountBalance(T.getCountBalance().add(paymentParameters.getSum())));
            }
            default:{
                Storage.workFromCounts(count, T -> T.setCountBalance(T.getCountBalance().subtract(paymentParameters.getSum())));
            }

        }
    }
}


