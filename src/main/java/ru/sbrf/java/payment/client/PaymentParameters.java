package ru.sbrf.java.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.sbrf.java.payment.appendix.operation.Operations;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
public class PaymentParameters {
    private Optional<User> user = Optional.empty();
    private Optional<String> targetCountNumber = Optional.empty();
    private Optional<Currency> currency = Optional.empty();
    private Optional<BigDecimal> sum = Optional.empty();
    private Optional<Operations> operation = Optional.empty();

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

    //TODO переработать, чтобы get теры возвращали параметры, вложенные в поля optional
}
