package ru.sbrf.payment.exceptions;

public class WrongRequestException extends RuntimeException{
    private String Number;

    public void setNumber(String number) {
        Number = number;
    }

    public WrongRequestException() {
    }

    public WrongRequestException(String message) {
        super(message);
    }

    public WrongRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongRequestException(Throwable cause) {
        super(cause);
    }

    public WrongRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
