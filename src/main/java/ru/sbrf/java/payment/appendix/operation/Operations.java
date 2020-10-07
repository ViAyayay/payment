package ru.sbrf.java.payment.appendix.operation;

import lombok.Getter;

@Getter
public enum Operations {
    ToPhonePayment;

    private Object extraOption = null;

    public Operations setExtraOption(Object extraOptions) {
        this.extraOption = extraOptions;
        return this;
    }
}
