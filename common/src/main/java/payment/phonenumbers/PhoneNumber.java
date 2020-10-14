package payment.phonenumbers;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhoneNumber{
    private int code;
    private int number;

    public  <T> PhoneNumber(T verifiableNumber) {
        new PhoneVerification(verifiableNumber, this);
    }
}
