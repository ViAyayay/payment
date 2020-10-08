package ru.sbrf.java.payment.client;

import lombok.AllArgsConstructor;
import ru.sbrf.java.payment.appendix.operation.Operations;
import ru.sbrf.java.payment.exceptions.WrongRequestException;

import java.math.BigDecimal;
import java.util.Optional;

@AllArgsConstructor
public class PaymentParameters {
    private Optional<User> user = Optional.empty();
    private Optional<String> targetCountNumber = Optional.empty();
    private Optional<Currency> currency = Optional.empty();
    private Optional<BigDecimal> sum = Optional.empty();
    private Optional<Operations> operation = Optional.empty();
    private Optional<?> ExtraOption = Optional.empty();

    public PaymentParameters() {
    }

    public PaymentParameters setUser(User user) {
        this.user = Optional.of(user);
        return this;
    }

    public PaymentParameters setTargetCountNumber(String targetCountNumber) {
        this.targetCountNumber = Optional.of(targetCountNumber);
        return this;
    }

    public PaymentParameters setCurrency(Currency currency) {
        this.currency = Optional.of(currency);
        return this;
    }

    public PaymentParameters setSum(BigDecimal sum) {
        this.sum = Optional.of(sum);
        return this;
    }

    public PaymentParameters setOperation(Operations operation) {
        this.operation = Optional.of(operation);
        return this;
    }

    public <T> PaymentParameters setExtraOption(T extraOption) {
        this.ExtraOption = Optional.of(extraOption);
        return this;
    }

    public User getUser() {
        return user.orElseThrow(() ->new WrongRequestException());
    }

    public String getTargetCountNumber() {
        return targetCountNumber.orElseThrow(() ->new WrongRequestException());
    }

    public Currency getCurrency() {
        return currency.orElseThrow(() ->new WrongRequestException());
    }

    public BigDecimal getSum() {
        return sum.orElseThrow(() ->new WrongRequestException());
    }

    public Operations getOperation() {
        return operation.orElseThrow(() ->new WrongRequestException());
    }

    public <T> T getExtraOption() {
        return (T) ExtraOption.orElseThrow(() ->new WrongRequestException());
    }
}
