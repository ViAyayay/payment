package ru.sbrf.java.payment.phonenumbers;

import ru.sbrf.java.payment.exceptions.WrongRequestException;

public class PhoneVerification{
    private String number;
    private int cursor = 0;
    private int startNewCursor;

    public <T> PhoneVerification(T verifiableNumber, PhoneNumber phoneNumber) {
        number = verifiableNumber.toString().trim();

        chekStart();
        chekBracket();
        phoneNumber.setCode(chekSymbols(3));
        cursor = startNewCursor;
        startNewCursor += 7;
        phoneNumber.setNumber(chekSymbols(7));
        checkEnd();
    }

    private void chekStart() {
        if (number.startsWith("+")){
            cursor += 2;
        } else if (number.startsWith("8")) {
            cursor++;
        }
    }

    private void chekBracket() {
        if (number.charAt(cursor)=='('){
            cursor++;
            startNewCursor = cursor + 4;
            if (number.indexOf(')') == -1) throw new WrongRequestException();
        } else {
            startNewCursor = cursor + 3;}
    }

    private int chekSymbols(int amt) {
        String numeral = "";
        for (int i = 0; i < amt; i++) {
            numeral = numeral + chekCursorSymbol(cursor + i);
        }
        return Integer.valueOf(numeral);
    }


    private char chekCursorSymbol(int c){
        char value;
        try{
            value = number.charAt(c);
        } catch (IndexOutOfBoundsException e) {
            throw new WrongNumberException();
        }
        if(value >= '0' && value <= '9') {
            return value;
        } else if(value == ')') throw new WrongNumberException();
        else {
            cursor++;
            startNewCursor++;
            return chekCursorSymbol(++c);
        }
    }

    private void checkEnd() {
        try {
            char c = number.charAt(startNewCursor);
            throw new WrongNumberException();
        } catch (IndexOutOfBoundsException e){

        }
    }
}
