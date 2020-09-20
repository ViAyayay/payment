package ru.sbrf.java.payment.exceptions;

public class WrongRequestException extends RuntimeException{
    private String Number;

    public WrongRequestException(String message, String number) {
        super(message);
        Number = number;
    }

    public WrongRequestException(String message, Throwable cause, String number) {
        super(message, cause);
        Number = number;
    }

    public WrongRequestException(Throwable cause, String number) {
        super(cause);
        Number = number;
    }

    protected WrongRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String number) {
        super(message, cause, enableSuppression, writableStackTrace);
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
