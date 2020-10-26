package ru.sbrf.payment.client;

import lombok.AllArgsConstructor;
import ru.sbrf.payment.exceptions.WrongRequestException;

import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
public class PaymentParameters {
    private User user;
    private String targetCountNumber;
    private Currency currency;
    private BigDecimal sum;
    private Operations operation;
    private String[] ExtraOption; //todo переделать

    public PaymentParameters() {
    }

    public PaymentParameters setUser(User user) {
        this.user = user;
        return this;
    }

    public PaymentParameters setTargetCountNumber(String targetCountNumber) {
        this.targetCountNumber = targetCountNumber;
        return this;
    }

    public PaymentParameters setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public PaymentParameters setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    public PaymentParameters setOperation(Operations operation) {
        this.operation = operation;
        return this;
    }

    public PaymentParameters setExtraOption(String... extraOption) {
        this.ExtraOption = extraOption;
        return this;
    }

    public User getUser() {
        return Optional.of(user).orElseThrow(() ->new WrongRequestException());
    }

    public String getTargetCountNumber() {
        return Optional.of(targetCountNumber).orElseThrow(() ->new WrongRequestException());
    }

    public Currency getCurrency() {
        return Optional.of(currency).orElseThrow(() ->new WrongRequestException());
    }

    public BigDecimal getSum() {
        return Optional.of(sum).orElseThrow(() ->new WrongRequestException());
    }

    public Operations getOperation() {
        return Optional.of(operation).orElseThrow(() ->new WrongRequestException());
    }

    public String[] getExtraOption() {
        return Optional.of(ExtraOption).orElseThrow(() ->new WrongRequestException());
    }
}
