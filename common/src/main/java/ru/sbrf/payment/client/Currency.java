package ru.sbrf.payment.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    RUB(643),
    USD(840),
    EUR(978);

    private int code;
}

